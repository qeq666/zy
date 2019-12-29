package cn.smm.zy.pojo;

import lombok.Data;

/**
 * Created by Dana on 2019/12/1.
 */
@Data
public class zy_type {

    private Integer t_id;
    private String t_type;
    private String t_back;

    public zy_type() {
    }

    public zy_type(String t_type, String t_back) {
        this.t_type = t_type;
        this.t_back = t_back;
    }
}
