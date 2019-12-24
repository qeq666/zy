package cn.smm.zy.service;

import cn.smm.zy.Dao.zy_wheelimgsidMapper;
import cn.smm.zy.pojo.zy_wheelimgsid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.smm.zy.Dao.zy_wheelimgsidMapper;

import java.util.List;

/**
 * Created by Dana on 2019/12/2.
 */
@Service
public class zy_wheelimgsidService {

    @Autowired
    private zy_wheelimgsidMapper zy_wheelimgsidMapper;

    /**
     * 查询所有轮播图
     * @return
     */
    public List<zy_wheelimgsid> QyeryList(){
        List<zy_wheelimgsid> zy_wheelimgsids = zy_wheelimgsidMapper.selectList(null);
        return zy_wheelimgsids;
    }
    public Integer InsertLb(zy_wheelimgsid zid){
        int insert = zy_wheelimgsidMapper.insert(zid);
        return insert;
    }
}
