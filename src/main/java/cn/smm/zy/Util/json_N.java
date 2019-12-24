package cn.smm.zy.Util;

import lombok.Data;

/**
 * Created by Dana on 2019/12/2.
 */
@Data
public class json_N {
    String msg ;
    String view;

    public json_N(String msg, String view) {
        this.msg = msg;
        this.view = view;
    }
}
