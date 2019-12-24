package cn.smm.zy.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.awt.*;

/**
 * Created by Dana on 2019/12/2.
 */
@Data
public class zy_wheelimgsid {
    @TableId(type = IdType.AUTO)
    Integer id;
    String wl_img;
    String wl_describe;
}
