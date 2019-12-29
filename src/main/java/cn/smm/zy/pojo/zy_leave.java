package cn.smm.zy.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * Created by Dana on 2019/12/29.
 */
@Data
public class zy_leave {
    @TableId(type= IdType.AUTO)
    private Integer id;
    String title;

    public zy_leave() {
    }

    public zy_leave(String title, String contents, Date createtime, String isok, String contact) {
        this.title = title;
        this.contents = contents;
        this.createtime = createtime;
        this.isok = isok;
        this.contact = contact;
    }

    String contents;
    Date createtime;
    String isok;
    String contact;
}
