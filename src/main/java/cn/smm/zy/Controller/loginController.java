package cn.smm.zy.Controller;

import cn.smm.zy.Dao.LoginMapper;
import cn.smm.zy.Util.json_N;
import cn.smm.zy.pojo.zy_regisger_user;
import cn.smm.zy.service.loginservice;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cn.smm.zy.service.loginservice;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Dana on 2019/11/7.
 */
@Controller
public class loginController {

    @Autowired
    private loginservice loginservice;

    /**
     *
     * @param req
     * @param session
     * @return
     */
    @RequestMapping("/register")
    public String Rtc(HttpServletRequest req, HttpSession session){
        json_N js= null;
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd" );/*日期格式*/
        String msg = null;
        Object cko = session.getAttribute("simpleCaptcha");
        System.out.println(req.getParameter("code")+"验证码"+">>>>>>>>>>"+cko);
        if(req.getParameter("code").equals(cko)){
            boolean b = loginservice.selectList(req.getParameter("name"));
            if(!b){
                String uname = req.getParameter("name");
                String upwd = req.getParameter("pwd");
                StringBuffer str = new StringBuffer();
                str.append(req.getParameter("s_province"));
                str.append("-");
                str.append(req.getParameter("s_city"));
                str.append("-");
                str.append(req.getParameter("s_county"));
                Date d= new Date();
                String defadate = sdf.format(d);
                zy_regisger_user zy = new zy_regisger_user(uname,upwd,str.toString(),"0",defadate,null);
                boolean registerzy = loginservice.registerzy(zy);
                if (registerzy){
                    js = new json_N("注册成功:200","/index");
                }else{
                    js = new json_N("注册失败:500!","/index");
                }
            }else{
                js = new json_N("该账号已注册过","/index");
            }
        }else{
            js = new json_N("验证码错误","/index");
        }
        System.out.printf(js.getView()+js.getMsg());
        session.setAttribute("view",js.getView());
        session.setAttribute("msg",js.getMsg());
        return "freemarker/Jump";
    }
    @RequestMapping("/login")
    public String login(HttpServletRequest req,HttpSession session){
        return "freemarker/login";
    }
    @RequestMapping("/rgt")
    public String register(HttpServletRequest req,HttpSession session){
        return "freemarker/register";
    }
    @ResponseBody
    @RequestMapping("/ckemail")
    public String chekemail(String email){
        String msg = null;
        boolean b = loginservice.selectList(email);
        if(b){
            msg="1";
        }else{
            msg="0";
        }
        return msg;
    }

    @RequestMapping("/zylogin")
    public String login(HttpSession session, HttpServletRequest req) {
        json_N json_n = null;
        Object cko = session.getAttribute("simpleCaptcha");
        System.out.println("登录中....................");
        System.out.println(req.getParameter("email"));
        if(req.getParameter("code").equals(cko)){
            zy_regisger_user user = loginservice.zyLogin(req.getParameter("email"), req.getParameter("pwd"));
            if (user==null){
                json_n = new json_N("密码错误,请重新登录!","/login");
            }else{
               if (user.getRgt_isfrost()=="0"||"0".equals(user.getRgt_isfrost())){
                   System.out.println("成功");
                   session.setAttribute("uid",user.getRgt_email());
                   json_n = new json_N("登录成功","/index");
                }else if(user.getRgt_isfrost()=="1"||"1".equals(user.getRgt_isfrost())){
                    json_n = new json_N("该账号已被冻结","/login");
                    System.out.println("账号已被冻结,无法登陆");
                }
            }
        }else{
            json_n = new json_N("验证码错误","/login");
        }
        System.out.println(json_n.getView()+json_n.getMsg());
        session.setAttribute("view",json_n.getView());
        session.setAttribute("msg",json_n.getMsg());
        return "freemarker/Jump";
    }









}
