package cn.smm.zy.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * Created by Dana on 2019/11/20.
 */

@Data
@TableName("zy_regisger_user")
public class zy_regisger_user {

    private String rgt_email;
    private String rgt_pwd;
    private String rgt_adess;
    private String rgt_isfrost;
    private String rgt_createtime;
    private String rgt_qq;
    private String rgt_gitee_acctoken;
    private String rgt_refs_token;
    private String rgt_GiteeId;

    public zy_regisger_user(String rgt_email, String rgt_pwd, String rgt_adess, String rgt_isfrost, String rgt_createtime, String rgt_qq,String rgt_gitee_acctoken,String rgt_refs_token,String rgt_GiteeId) {
        this.rgt_email = rgt_email;
        this.rgt_pwd = rgt_pwd;
        this.rgt_adess = rgt_adess;
        this.rgt_isfrost = rgt_isfrost;
        this.rgt_createtime = rgt_createtime;
        this.rgt_qq = rgt_qq;
        this.rgt_gitee_acctoken = rgt_gitee_acctoken;
        this.rgt_refs_token = rgt_refs_token;
        this.rgt_GiteeId = rgt_GiteeId;
    }

    public zy_regisger_user(){}

    @Override
    public String toString() {
        return "zy_regisger_user{" +
                "rgt_email='" + rgt_email + '\'' +
                ", rgt_pwd='" + rgt_pwd + '\'' +
                ", rgt_adess='" + rgt_adess + '\'' +
                ", rgt_isfrost='" + rgt_isfrost + '\'' +
                ", rgt_createtime='" + rgt_createtime + '\'' +
                ", rgt_qq='" + rgt_qq + '\'' +
                ", rgt_gitee_acctoken='" + rgt_gitee_acctoken + '\'' +
                ", rgt_refs_token='" + rgt_refs_token + '\'' +
                ", rgt_GiteeId=" + rgt_GiteeId +
                '}';
    }
}
