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
            private String user_remark;//备注
            private String user_sex;



}
