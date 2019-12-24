package cn.smm.zy.service;

import cn.smm.zy.Dao.LoginMapper;
import cn.smm.zy.Util.Mesg;
import cn.smm.zy.pojo.zy_regisger_user;
import cn.smm.zy.pojo.zy_user;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dana on 2019/11/20.
 */
@Service
public class loginservice {

    @Autowired
    LoginMapper lm;


    /**
     * 注册
     * @param zru
     * @return
     */
    public boolean registerzy(zy_regisger_user zru){
        int insert = lm.insert(zru);
        if(insert>0){
            return true;
        }
        return false;
    }


    public boolean selectList(String email){
        boolean isok = false;
        List<zy_regisger_user> zy_regisger_users = lm.selectList(null);
        for (zy_regisger_user z:zy_regisger_users){
            System.out.println(z.getRgt_email()+email);
            if(email.equals(z.getRgt_email().toString())){
                isok = true;
                break;
            }else{
                isok=false;
            }
        }
        return isok;
    }


    /*登录*/
    public zy_regisger_user zyLogin(String email,String pwd){
        zy_regisger_user user = null;
        List<zy_regisger_user> zy_regisger_users = lm.selectList(null);
        for (zy_regisger_user zrr:zy_regisger_users) {
            System.out.println(email+pwd+"\n"+zrr.getRgt_email()+zrr.getRgt_pwd());
            if(email.equals(zrr.getRgt_email().toString()) && pwd.equals(zrr.getRgt_pwd().toString())){
                user= zrr;
                break;
            }else{
                continue;
            }

        }
        return user;
    }

    /*查询全部*/
    public List<zy_regisger_user> Querys( ){
        List<zy_regisger_user> zy_regisger_users = lm.selectList(null);
        return zy_regisger_users;
    }

    public Integer Frozen(zy_regisger_user zu){
        int i = lm.updateById(zu);
        System.out.println("成功");
        return  i;
    }

    public zy_regisger_user findbyid(String email){
        QueryWrapper<zy_regisger_user> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("rgt_email",email);
        zy_regisger_user zy_regisger_user = lm.selectOne(queryWrapper);
        return zy_regisger_user;
    }




}
