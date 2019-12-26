package cn.smm.zy.Util;

import cn.smm.zy.pojo.zy_invitation;
import lombok.Data;

import java.util.List;

/**
 * Created by Dana on 2019/12/26.
 */
@Data
public class PageAndPageNoAndPageCur {
    /*总页数*/
    private Long pages;
    /*当前第几页*/
    private Long currentNo;
    private  List<zy_invitation> itts;

    public PageAndPageNoAndPageCur(Long currentNo,Long pages , List<zy_invitation> itts) {
        this.pages = pages;
        this.currentNo = currentNo;
        this.itts = itts;
    }

    public PageAndPageNoAndPageCur() {
    }


}
