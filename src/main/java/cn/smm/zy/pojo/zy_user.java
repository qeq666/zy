package cn.smm.zy.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.sun.mail.imap.protocol.ID;
import lombok.Data;

/**
 * Created by Dana on 2019/11/24.
 */
@Data
public class zy_user {
            @TableId(type= IdType.AUTO)
            private Integer id;
            private String user_email;
            private String user_realname;
            private Integer isdongj;
            @TableField(exist = false)
            private String isdj;

            private String user_isautonym;
            private String user_headportrait;
            private Integer user_age;
            private String user_phone;

    public zy_user() {
    }

    public zy_user(String user_email, String user_realname, Integer isdongj, String isdj, String user_isautonym, String user_headportrait, Integer user_age, String user_phone, String user_remark, String user_sex) {
        this.user_email = user_email;
        this.user_realname = user_realname;
        this.isdongj = isdongj;
        this.isdj = isdj;
        this.user_isautonym = user_isautonym;
        this.user_headportrait = user_headportrait;
        this.user_age = user_age;
        this.user_phone = user_phone;
        this.user_remark = user_remark;
        this.user_sex = user_sex;
    }

    private String user_remark;//备注
            private String user_sex;



}
