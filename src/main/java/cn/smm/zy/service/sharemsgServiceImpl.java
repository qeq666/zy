package cn.smm.zy.service;

import cn.smm.zy.Dao.sharemsgMapper;
import cn.smm.zy.pojo.sharemsg;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dana on 2019/12/25.
 */
@Service
public class sharemsgServiceImpl  {

    @Autowired
    private sharemsgMapper sharemsgmp;

    /**
     * 查询全部和共享信息
     * @return
     */
    public List<sharemsg> findall(){
        return sharemsgmp.selectList(null);
    }


    public sharemsg findbyid(Integer id){
        sharemsg sharemsg = sharemsgmp.selectById(id);
        return sharemsg;
    }

    public Integer addShrasMsg(sharemsg sharemsg){
        int insert = sharemsgmp.insert(sharemsg);
        return insert;
    }



}
