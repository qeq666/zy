package cn.smm.zy.service;

import cn.smm.zy.Dao.invitationMapper;
import cn.smm.zy.Util.Mesg;
import cn.smm.zy.Util.PageAndPageNoAndPageCur;
import cn.smm.zy.pojo.zy_invitation;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dana on 2019/11/22.
 */
@Service
public class invitationservice {
    @Autowired
    invitationMapper invitation;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public Object addinvitation(zy_invitation zyi) {
        String key = "news";
        int insert = invitation.insert(zyi);
        if (insert > 0) {
            redisTemplate.delete(key);
            return new Mesg(200, "发表成功");
        } else {
            return new Mesg(201, "发表失败");
        }
    }


    /**
     * 查询所有帖子
     *
     * @return
     */
    @Select("SELECT id,itt_title,itt_content,itt_createtime,itt_createid,itt_audittype,itt_isdelete,itt_img01,(SELECT zy_type.`T_type` FROM zy_type WHERE zy_type.`T_id`= zy_invitation.`itt_type`)AS itt_typeFROM zy_invitation")
    public List<zy_invitation> getzy_invitations() {
        String key = "news";
        List<zy_invitation> zy_invitations = (List<zy_invitation>) redisTemplate.opsForValue().get(key);
        if (zy_invitations == null || zy_invitations.equals("")) {
            List<zy_invitation> itts = invitation.selectList(new QueryWrapper<zy_invitation>().orderByDesc("itt_kind"));
            redisTemplate.opsForValue().set(key, itts);
            System.out.println("Redis缓存不存在该数据,数据库查询中");
            System.out.println("数据查询成功,放入缓存,未设置失效时间");
            zy_invitations = (List<zy_invitation>) redisTemplate.opsForValue().get(key);
        } else {
            System.out.println("Redis缓存已有数据,无需数据库查询。");
            zy_invitations = (List<zy_invitation>) redisTemplate.opsForValue().get(key);
        }
        for (zy_invitation zs : zy_invitations) {
            System.out.println(zs.getItt_kind());
        }
        return zy_invitations;
    }


    public Integer deleteByid(Integer id) {

        int delete = invitation.deleteById(id);
        return delete;
    }

    public zy_invitation queryByid(Integer id) {
        /*QueryWrapper<zy_invitation> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(zy_invitation::getId, id);
        List<zy_invitation> zy_invitations = invitation.selectList(queryWrapper);*/
        String key = "news";
        redisTemplate.delete(key);
        zy_invitation zy_invitation = invitation.selectById(id);
        return zy_invitation;
    }


    /**
     * ik  分词器+redis缓存查询数据  构成搜索
     * @param size
     * @param items
     * @return
     */
    public List<zy_invitation> Iksearchresult(Integer size ,List<String> items) {
        QueryWrapper<zy_invitation> queryWrapper = new QueryWrapper<>();
        List<zy_invitation> zy_invitations = null;
        String s0 = null;
        String s1 = null;
        String s2 = null;
        if(size>2){
            s0 = items.get(0);
            s1 = items.get(1);
            s2 = items.get(2);
        }else if(size>1){
            s0 = items.get(0);
            s1 = items.get(1);
        }else if(size>0){
            s0 = items.get(0);
        }else{
            s0 = "";
            s1 = "";
            s2 = "";
        }
        System.out.println();
        String colum = "itt_title";
        QueryWrapper<zy_invitation> tjany = null;/*条件构造器*/

        if (!"".equals(s0) && !"".equals(s1) && !"".equals(s2)) {
            tjany = queryWrapper.like("itt_title", s0).or().like("itt_title", s1).or().like("itt_title", s2);
            zy_invitations = invitation.selectList(tjany);
            System.out.println("关键字都不为空都附加");
        } else if ("".equals(s0) && "".equals(s1) && "".equals(s2)) {
            zy_invitations = invitation.selectList(null);
            zy_invitations = invitation.selectList(tjany);
            System.out.println("关键字为空,查询全部");
        } else if (!"".equals(s0) && "".equals(s1) && "".equals(s2)) {
            tjany = queryWrapper.like("itt_title", s0);
            System.out.println("第一个关键字存在其他两个不存在");
            zy_invitations = invitation.selectList(tjany);
        } else if ("".equals(s0) && !"".equals(s1) && "".equals(s2)) {
            tjany = queryWrapper.like("itt_title", s1);
            System.out.println("第二个关键字存在其他两个不存在");
            zy_invitations = invitation.selectList(tjany);
        } else if ("".equals(s0) && "".equals(s1) && !"".equals(s2)) {
            tjany = queryWrapper.like("itt_title", s2);
            zy_invitations = invitation.selectList(tjany);
            System.out.println("第三个关键字存在其他两个不存在");
        } else {
            zy_invitations = invitation.selectList(null);
            System.out.println("最后执行的关键字为空,查询全部");
        }
        return zy_invitations;
    }


    public PageAndPageNoAndPageCur findpage(Integer pageNo, Integer size){
        /*System.out.println("总页数"+zy_invitationIPage.getPages());
        System.out.println("总记录数"+zy_invitationIPage.getTotal());*/
        /**
         * 储存要返回的分页数据
         */
        PageAndPageNoAndPageCur array = null;
        List<zy_invitation> ittpages = null;
        IPage<zy_invitation> zy_invitationIPage = null;
        String Pastkey = "pagekey";
        String keyNo = "pageNo";
        String Pages = "tolcount";
        redisTemplate.delete(Pastkey);
        List<zy_invitation> keys = (List<zy_invitation>) redisTemplate.opsForValue().get(Pastkey);
        if(keys==null||"".equals(keys)){
            Page<zy_invitation> pages = new Page<>(pageNo,size);
            QueryWrapper<zy_invitation> waper = new QueryWrapper<>();
            zy_invitationIPage= invitation.selectPage(pages,waper);
            List<zy_invitation> records = zy_invitationIPage.getRecords();
            redisTemplate.opsForValue().set(Pastkey,records);/*查出来放Redis*/
            ittpages = (List<zy_invitation>) redisTemplate.opsForValue().get(Pastkey);/*放进去再从redis查出来返回出去*/
            /*System.out.println("当前第"+zy_invitationIPage.getCurrent()+"页"+"共"+zy_invitationIPage.getTotal()+"页");*/
            /*本来想的把当前页下一页方redis
            redisTemplate.opsForValue().set(keyNo,zy_invitationIPage.getCurrent());
            redisTemplate.opsForValue().set(tolcount,zy_invitationIPage.getTotal());*/
            System.out.println("分页数据来自M");
            redisTemplate.opsForValue().set(keyNo,zy_invitationIPage.getCurrent());
            redisTemplate.opsForValue().set(Pages,zy_invitationIPage.getPages());
        }else{
            System.out.println("分页数据来自R");
            /*redis有数据*/
            ittpages = (List<zy_invitation>) redisTemplate.opsForValue().get(Pastkey);/*放进去再从redis查出来返回出去*/
        }
        Long getpageNos = (Long) redisTemplate.opsForValue().get(keyNo);
        Long getPages = (Long) redisTemplate.opsForValue().get(Pages);
        array = new PageAndPageNoAndPageCur(getpageNos,getPages,ittpages);
        return array;
    }


    /**
     * 置顶帖子
     * @param zy_invitation
     * @return
     */
    public Integer updateTop(zy_invitation zy_invitation){
        String key = "news";
        redisTemplate.delete(key);
        int top = invitation.updateById(zy_invitation);
        return top;
    }


    /**
     * 条件查询分页
     * @param pageNo
     * @param size
     * @param title
     * @return
     */
    public PageAndPageNoAndPageCur pageQwarList(Integer pageNo, Integer size,String title,Integer type){
        PageAndPageNoAndPageCur array = null;
        IPage<zy_invitation> zy_invitationIPage = null;
        List<zy_invitation> ittpages = null;
        String Pastkey = "pagekey";
        String keyNo = "pageNo";
        String Pages = "tolcount";
        redisTemplate.delete(Pastkey);
        List<zy_invitation> keys = (List<zy_invitation>) redisTemplate.opsForValue().get(Pastkey);
        if(type==null||type==0){
            type = 0;
        }
        if(keys==null||"".equals(keys)){
            Page<zy_invitation> pages = new Page<>(pageNo,size);
            QueryWrapper<zy_invitation> waper = new QueryWrapper<>();
            waper.like("itt_title",title).or().eq("itt_type",type);
            zy_invitationIPage= invitation.selectPage(pages,waper);
            List<zy_invitation> records = zy_invitationIPage.getRecords();
            redisTemplate.opsForValue().set(Pastkey,records);/*查出来放Redis*/
            ittpages = (List<zy_invitation>) redisTemplate.opsForValue().get(Pastkey);/*放进去再从redis查出来返回出去*/
            System.out.println("分页数据来自M");
            redisTemplate.opsForValue().set(keyNo,zy_invitationIPage.getCurrent());
            redisTemplate.opsForValue().set(Pages,zy_invitationIPage.getPages());
        }else{
            System.out.println("分页数据来自R");
            /*redis有数据*/
            ittpages = (List<zy_invitation>) redisTemplate.opsForValue().get(Pastkey);/*放进去再从redis查出来返回出去*/
        }
        Long getpageNos = (Long) redisTemplate.opsForValue().get(keyNo);
        Long getPages = (Long) redisTemplate.opsForValue().get(Pages);
        array = new PageAndPageNoAndPageCur(getpageNos,getPages,ittpages);
        return array;
    }





}
