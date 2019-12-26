package cn.smm.zy.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Dana on 2019/12/25.
 */
@Data
public class sharemsg  implements Serializable {
    private static final long serialVersionUID = -8289770787953160443L;
    @TableId(type= IdType.AUTO)
    private Integer id;
    private String title;
    private String content;

    public sharemsg() {
    }

    public sharemsg(String title, String content, Date createtime, String img, String danadw, String latitude) {
        this.title = title;
        this.content = content;
        this.createtime = createtime;
        this.img = img;
        this.danadw = danadw;
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "sharemsg{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createtime=" + createtime +
                ", img='" + img + '\'' +
                ", danadw='" + danadw + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }

    private Date createtime;
    private String img;
    private String danadw;
    private String latitude;
}
