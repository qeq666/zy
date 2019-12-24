package cn.smm.zy.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * Created by Dana on 2019/12/2.
 */
@Data
public class zy_homepage {
    @TableId
    Integer homeid;
    String home_title;
    Integer home_detailsid;
    String home_logo;
    String home_briefintroduction;
    Integer home_link;

    public zy_homepage(String home_title, Integer home_detailsid, String home_logo, String home_briefintroduction, Integer home_link, String home_Keyword, String home_topinfo, String home_desion) {
        this.home_title = home_title;
        this.home_detailsid = home_detailsid;
        this.home_logo = home_logo;
        this.home_briefintroduction = home_briefintroduction;
        this.home_link = home_link;
        this.home_Keyword = home_Keyword;
        this.home_topinfo = home_topinfo;
        this.home_desion = home_desion;
    }

    String home_Keyword;
    String home_topinfo;

    public zy_homepage(Integer homeid, String home_title, Integer home_detailsid, String home_logo, String home_briefintroduction, Integer home_link, String home_Keyword, String home_topinfo, String home_desion) {
        this.homeid = homeid;
        this.home_title = home_title;
        this.home_detailsid = home_detailsid;
        this.home_logo = home_logo;
        this.home_briefintroduction = home_briefintroduction;
        this.home_link = home_link;
        this.home_Keyword = home_Keyword;
        this.home_topinfo = home_topinfo;
        this.home_desion = home_desion;
    }

    public zy_homepage(){}
    String home_desion;
}
