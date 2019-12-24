package cn.smm.zy.pojo;

import lombok.Data;

import java.util.Date;

/**
 * Created by Dana on 2019/12/19.
 */
@Data
public class zy_detail {;
    private Integer id;
    private String detail_title;
    private String detail_content;
    private Integer detail_createid;
    private Date detail_createtime;
    private Integer detail_zhanshicreate;
}
