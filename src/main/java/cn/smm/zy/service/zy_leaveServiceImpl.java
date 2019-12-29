package cn.smm.zy.service;

import cn.smm.zy.Dao.zy_leaveMapper;
import cn.smm.zy.pojo.zy_leave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dana on 2019/12/29.
 */
@Service
public class zy_leaveServiceImpl {
    @Autowired
    private cn.smm.zy.Dao.zy_leaveMapper zy_leaveMapper;


    public List<zy_leave> findall(){
        List<zy_leave> zy_leaves = zy_leaveMapper.selectList(null);
        return zy_leaves;
    }

    public Integer add(zy_leave zy_leave){
        int insert = zy_leaveMapper.insert(zy_leave);
        return insert;
    }

    public Integer updateInof(zy_leave zy_leave){
        int i = zy_leaveMapper.updateById(zy_leave);
        return i;
    }
    public zy_leave findByid(Integer id){
        zy_leave zy_leave = zy_leaveMapper.selectById(id);
        return zy_leave;
    }

    public Integer del(Integer id){
        int i = zy_leaveMapper.deleteById(id);
        return i ;
    }


}
