package cn.smm.zy.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Date;

/**
 * Created by Dana on 2019/11/22.
 */
/*帖子*/
@Data
public class zy_invitation implements Serializable {
        private static final long serialVersionUID = -8289770787953160443L;
    @TableId(type=IdType.AUTO)
            Integer id;
            String itt_title;
            String itt_content;
            String itt_createtime;
            String itt_createid;
            Integer itt_audittype;
            Integer itt_isdelete;
            Integer itt_type;
            String itt_img01;
            Integer itt_kind;
            @TableField(exist = false)
            String type;
            String itt_downurl;
    public zy_invitation(){}

        public zy_invitation(String itt_title, String itt_content, String itt_createtime, String itt_createid, Integer itt_audittype, Integer itt_isdelete, Integer itt_type, String itt_img01,String itt_downurl,Integer itt_kind) {
                this.itt_title = itt_title;
                this.itt_content = itt_content;
                this.itt_createtime = itt_createtime;
                this.itt_createid = itt_createid;
                this.itt_audittype = itt_audittype;
                this.itt_isdelete = itt_isdelete;
                this.itt_type = itt_type;
                this.itt_img01 = itt_img01;
                this.itt_downurl = itt_downurl;
                this.itt_kind =itt_kind;
        }
}