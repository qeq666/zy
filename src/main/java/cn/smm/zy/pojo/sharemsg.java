package cn.smm.zy.pojo;

import lombok.Data;

import java.util.Date;

/**
 * Created by Dana on 2019/12/25.
 */
@Data
public class sharemsg {
    private Integer id;
    private String title;
    private String content;

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
