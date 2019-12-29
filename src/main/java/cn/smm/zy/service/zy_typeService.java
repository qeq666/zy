package cn.smm.zy.service;

import cn.smm.zy.Dao.zy_typeMapper;
import cn.smm.zy.pojo.zy_type;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dana on 2019/12/1.
 */
@Service
public class zy_typeService {
   @Autowired
    private zy_typeMapper zy_typedao;
    /**
     * 插入
     * @param zy
     * @return
     */
   public Integer insertType(zy_type zy){
       int insert = zy_typedao.insert(zy);
       return insert;
   }
    /**
     * 比较
     * @return
     */
    public String eqapls(Integer id){
        List<zy_type> zy_types = zy_typedao.selectList(null);
        for (zy_type zy:zy_types) {
            if(id.equals(zy.getT_id())||id==zy.getT_id()){
                return zy.getT_type();
            }
        }
        return "其他";
    }
    /**
     * 分类
     * @return
     */
    public List<zy_type> apls(){
        List<zy_type> zy_types = zy_typedao.selectList(null);
        return zy_types;
    }
    /**
     * 更新
     * @param zt
     * @return
     */
    public Integer tupdate(zy_type zt){
        QueryWrapper<zy_type> q = new QueryWrapper<>();
        q.eq("t_id",zt.getT_id());
        int update = zy_typedao.update(zt, q);
        return update;
    }
    public zy_type findByid(Integer id){
        QueryWrapper<zy_type> q = new QueryWrapper<>();
        q.eq("t_id",id);
        zy_type zy_type = zy_typedao.selectOne(q);
        return zy_type;
    }

    public Integer del(Integer tid){
        QueryWrapper<zy_type> q = new QueryWrapper<>();
        q.eq("t_id",tid);
        return zy_typedao.delete(q);
    }


}
