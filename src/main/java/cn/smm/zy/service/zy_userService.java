package cn.smm.zy.service;

import cn.smm.zy.Dao.zy_userMapper;
import cn.smm.zy.pojo.zy_invitation;
import cn.smm.zy.pojo.zy_user;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dana on 2019/12/2.
 */
@Service
public class zy_userService {
    @Autowired
    private zy_userMapper zy_userMapper;

    /**
     * 查询所有用户
     * @return
     */
    public List<zy_user> QueryList(){
        List<zy_user> zy_users = zy_userMapper.selectList(null);
        return zy_users;
    }
    public Integer operation(Integer id){
        List<zy_user> zy_users = this.QueryList();
        int i = 0;
        for (zy_user zyu:zy_users){
            if(id.equals(zyu.getId())||id==zyu.getId()){
                System.out.println(zyu.getIsdongj()+"冻结代码");
                System.out.println(zyu.getIsdongj().equals("0")+"条件一");
                Integer dongjIDOne = 0;
                Integer dongjIDTO = 1;

                if (zyu.getIsdongj()==dongjIDOne||zyu.getIsdongj().equals(dongjIDOne)){
                    zyu.setIsdongj(dongjIDTO);
                }else if(zyu.getIsdongj().equals(dongjIDTO)||zyu.getIsdongj()==dongjIDTO){
                    zyu.setIsdongj(dongjIDOne);
                }
                System.out.println(zyu.getIsdongj()+"冻结代码");
                 i = zy_userMapper.updateById(zyu);
                break;
            }else{
                continue;
            }
        }
        return i;
    }
    /**
     * 冻结用户
     * @return
     */
    public Integer FrozenU(zy_user zy_user ){
        boolean isFrozen = false;
        int i = zy_userMapper.updateById(zy_user);
        return i;
    }

    /**
     * 根据昵称 查询用户信息
     * @param email
     * @return
     */
    public zy_user findbyid(String email){
        QueryWrapper<zy_user> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_email",email);
        zy_user zy_user = zy_userMapper.selectOne(queryWrapper);
        return zy_user;
    }

    /*修改个人信息*/
    public Integer updateuserinfo(zy_user zy_user){
        int i = zy_userMapper.updateById(zy_user);
        return i;
    }

    /**
     * 根据id 查询用户信息
     * @param byid
     * @return
     */
    public zy_user findByid(Integer byid){
        return zy_userMapper.selectById(byid);
    }


    public String eq(String email){
        QueryWrapper<zy_user> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_email",email);
        zy_user zy_user = zy_userMapper.selectOne(queryWrapper);
        return zy_user.getUser_realname();
    }

}
