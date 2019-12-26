package cn.smm.zy.service;

import cn.smm.zy.Dao.ImgsMapper;
import cn.smm.zy.pojo.Imgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dana on 2019/12/25.
 */
@Service
public class ImgsServiceImpl {

    @Autowired
    private ImgsMapper ImgsMp;

    public List<Imgs> findall(){
        List<Imgs> imgs = ImgsMp.selectList(null);
        return imgs;
    }

    public Imgs findByid(Integer id){
        Imgs imgs = ImgsMp.selectById(id);
        return imgs;
    }



}
