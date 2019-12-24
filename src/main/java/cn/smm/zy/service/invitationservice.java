package cn.smm.zy.service;

import cn.smm.zy.Dao.invitationMapper;
import cn.smm.zy.Util.Mesg;
import cn.smm.zy.pojo.zy_invitation;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Select;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        if(zy_invitations==null||zy_invitations.equals("")){
            List<zy_invitation> itts = invitation.selectList(new QueryWrapper<zy_invitation>().orderByDesc("itt_kind"));
            redisTemplate.opsForValue().set(key,itts);
            System.out.println("Redis缓存不存在该数据,数据库查询中");
            System.out.println("数据查询成功,放入缓存,未设置失效时间");
            zy_invitations = (List<zy_invitation>) redisTemplate.opsForValue().get(key);
        }else{
            System.out.println("Redis缓存已有数据,无需数据库查询。");
            zy_invitations = (List<zy_invitation>) redisTemplate.opsForValue().get(key);
        }
        for (zy_invitation zs:zy_invitations) {
            System.out.println(zs.getItt_kind());
        }
        return zy_invitations;
    }


    public Integer deleteByid(Integer id) {
        QueryWrapper<zy_invitation> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(zy_invitation::getId, id);
        int delete = invitation.delete(queryWrapper);
        return delete;
    }

    public List<zy_invitation> queryByid(Integer id) {
        QueryWrapper<zy_invitation> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(zy_invitation::getId, id);
        List<zy_invitation> zy_invitations = invitation.selectList(queryWrapper);
        return zy_invitations;
    }


    public List<zy_invitation> Iksearchresult (List<String> items){
        QueryWrapper<zy_invitation> queryWrapper = new QueryWrapper<>();
        List<zy_invitation> zy_invitations = null;
        String s0 = items.get(0);
        String s1 = items.get(1);
        String s2 = items.get(2);
        String colum = "itt_title";
        QueryWrapper<zy_invitation>  tjany = null;/*条件构造器*/

        if(!"".equals(s0) && !"".equals(s1) && !"".equals(s2)){
            tjany = queryWrapper.like("itt_title", s0).or().like("itt_title", s1).or().like("itt_title", s2);
            zy_invitations = invitation.selectList(tjany);
            System.out.println("关键字都不为空都附加");
        }else if("".equals(s0) && "".equals(s1) && "".equals(s2)){
            zy_invitations= invitation.selectList(null);
            zy_invitations = invitation.selectList(tjany);
            System.out.println("关键字为空,查询全部");
        }else if(!"".equals(s0) && "".equals(s1) && "".equals(s2)){
            tjany = queryWrapper.like("itt_title", s0);
            System.out.println("第一个关键字存在其他两个不存在");
            zy_invitations = invitation.selectList(tjany);
        }else if("".equals(s0) && !"".equals(s1) && "".equals(s2)){
            tjany = queryWrapper.like("itt_title", s1);
            System.out.println("第二个关键字存在其他两个不存在");
            zy_invitations = invitation.selectList(tjany);
        }else if("".equals(s0) && "".equals(s1) && !"".equals(s2)){
            tjany = queryWrapper.like("itt_title", s2);
            zy_invitations = invitation.selectList(tjany);
            System.out.println("第三个关键字存在其他两个不存在");
        }else{
            zy_invitations= invitation.selectList(null);
            System.out.println("最后执行的关键字为空,查询全部");
        }
        return zy_invitations;
    }




}
