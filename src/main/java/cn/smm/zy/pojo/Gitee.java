package cn.smm.zy.pojo;

import lombok.Data;

/**
 * Created by Dana on 2020/1/2.
 */
@Data
public class Gitee {
    private String id;
    private String login;
    private String name;
    private String access_token;
    private String refresh_token;
    private String avatar_url ;
    public Gitee() {
    }



    public Gitee(String id, String login, String name, String access_token, String refresh_token,String avatar_url) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.access_token = access_token;
        this.refresh_token = refresh_token;
        this.avatar_url= avatar_url;
    }
}
