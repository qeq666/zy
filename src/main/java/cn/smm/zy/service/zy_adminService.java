package cn.smm.zy.service;

import cn.smm.zy.Dao.zy_adminMapper;
import cn.smm.zy.pojo.zy_admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import cn.smm.zy.Dao.zy_adminMapper;
/**
 * Created by Dana on 2019/12/2.
 */
@Service
public class zy_adminService {

    @Autowired
    private zy_adminMapper zy_adminMapper;

    /**
     * 查询所有管理员
     * @return
     */
    public List<zy_admin> QyeryList(){
        List<zy_admin> zy_admins = zy_adminMapper.selectList(null);
        return zy_admins;
    }


    /**
     * 修改管理员密码
     * @param zy_admin
     * @return
     */
    public Integer UpdatePwd(zy_admin zy_admin){
        int i = zy_adminMapper.updateById(zy_admin);
        return i;
    }

}
