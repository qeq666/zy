package cn.smm.zy.service;

import cn.smm.zy.Dao.zy_homepageMapper;
import cn.smm.zy.pojo.zy_homepage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.smm.zy.Dao.zy_homepageMapper;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Dana on 2019/12/2.
 */
@Service
public class zy_homepageService {

    @Autowired
    private zy_homepageMapper zy_homepageMapper;

    /**
     * 查询操作
     * @return
     */
    public List<zy_homepage> QueryHome(){
        List<zy_homepage> zy_homepageMappers = zy_homepageMapper.selectList(null);
        return zy_homepageMappers;
    }

    /**
     * 更新操作
     * @param zyh
     * @return
     */
    public Integer HomeUpdate(zy_homepage zyh){
        int i = zy_homepageMapper.updateById(zyh);
        return i;
    }

    /*查询操作*/
    public zy_homepage selectByid(Serializable id){
        zy_homepage zy_homepage = zy_homepageMapper.selectById(1);
        System.out.println(zy_homepage+"Service查询为");
        return zy_homepage;
    }



}
