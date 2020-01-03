package cn.smm.zy.Controller;

import cn.smm.zy.Util.GiteeUtils;
import cn.smm.zy.Util.json_N;
import cn.smm.zy.pojo.Gitee;
import cn.smm.zy.pojo.zy_regisger_user;
import cn.smm.zy.service.loginservice;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Dana on 2020/1/2.
 */
@Controller
public class GiteeController {

    @Autowired
    private cn.smm.zy.service.loginservice loginservice;
@Autowired
    private cn.smm.zy.service.zy_userService zy_userService;

    /**
     * gitee  码云第三封登录
     * 2020年1月2日19:53:36
     *
     * @param request
     * @return
     */
    @RequestMapping("/ht")
    public String ht(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
        String code = request.getParameter("code");
        json_N js= null;
        System.out.println("code:" + code);
        JSONObject jsonObject = GiteeUtils.HqToken(code);
        String access_token = (String) jsonObject.get("access_token");
        String refresh_token = (String) jsonObject.get("refresh_token");
        System.out.println(access_token + ">>>>>>>>>>>>>" + refresh_token);
        JSONObject gitee = GiteeUtils.tokenOninfos(code);
        Object id = gitee.get("id");
        Object login = gitee.get("login");
        Object name = gitee.get("name");
        Object avatar_url = gitee.get("avatar_url");
        System.out.println(id + ">>>" + login + ">>>" + name + ">>>");
        String view = null;
        List<zy_regisger_user> querys = loginservice.Querys();
        for (zy_regisger_user zy_item : querys) {
            System.out.println(zy_item.getRgt_GiteeId() + "这是数据库的id" + id + "这是码云的id");
            if (id.toString().trim().equals(zy_item.getRgt_GiteeId())) {
                js = new json_N("该码云账号已被关联了","/index");
                zy_regisger_user zy_regisger_user = loginservice.tokenLogin(id.toString());
                session.setAttribute("uid",zy_regisger_user.getRgt_email());
                break;
                /*过期*/
            }else{
                /*如果进来此方法就说明该码云账号没有关联*/
                System.out.println("账号没有关联");
                Gitee gie = new Gitee(id.toString(), login.toString(), name.toString(), access_token.toString(), refresh_token.toString(),avatar_url.toString());
                session.setAttribute("gie", gie);
                js = new json_N("账号没有关联","/rgt");
                continue;
            }
        }
        session.setAttribute("view",js.getView());
        session.setAttribute("msg",js.getMsg());
        return "freemarker/Jump";
    }


}
