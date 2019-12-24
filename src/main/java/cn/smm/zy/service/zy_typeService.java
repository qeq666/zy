package cn.smm.zy.service;

import cn.smm.zy.Dao.zy_typeMapper;
import cn.smm.zy.pojo.zy_type;
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
        int i = zy_typedao.updateById(zt);
        return i;
    }
}
