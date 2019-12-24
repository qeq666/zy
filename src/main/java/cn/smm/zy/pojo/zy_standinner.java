package cn.smm.zy.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.omg.CORBA.IDLType;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Dana on 2019/12/23.
 */
@Data
public class zy_standinner implements Serializable {
    private static final long serialVersionUID = -8289770787953160443L;
            @TableId(type=IdType.AUTO)
            private Integer id;
            private String title;
            private Integer kind;

    public zy_standinner() {
    }

    public zy_standinner(String title, Integer kind, String comntent, Date createtime, String senduser) {
        this.title = title;
        this.kind = kind;
        this.comntent = comntent;
        this.createtime = createtime;
        this.senduser = senduser;
    }

    @Override
    public String toString() {
        return "zy_standinner{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", kind=" + kind +
                ", comntent='" + comntent + '\'' +
                ", createtime=" + createtime +
                ", isread=" +
                ", senduser=" + senduser +
                '}';
    }

    private String comntent;
            private Date createtime;
            private String senduser;
}
