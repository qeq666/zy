package cn.smm.zy.Controller;

import cn.smm.zy.Util.Mesg;
import cn.smm.zy.Util.json_N;
import cn.smm.zy.apl.SendEmail;
import cn.smm.zy.service.MailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.smm.zy.apl.SendEmail;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import cn.smm.zy.service.MailServiceImpl;
@Controller
public class EmailController {
    @Autowired
    private MailServiceImpl MailServiceImpl;

    @RequestMapping("/sendEmailurl")
    public String RegisterEmial(HttpServletRequest req) throws MessagingException {
        json_N js = null;
        if (req.getSession().getAttribute("simpleCaptcha").equals(req.getParameter("code"))) {
            String email = req.getParameter("Email");
            System.out.println("验证码正确"+email);
            /*SendEmail("zhangzhen0280@163.com","127.0.0.1/ckemail?email="+email);*/
            String content= "127.0.0.1/ckemail/"+email;
            StringBuffer str = new StringBuffer();
            str.append("尊敬的用户您好！");
            str.append("\n");
            str.append("请在三分钟之内填写注册信息-------下面是信息填写地址");
            str.append("\n");
            str.append("<a href='../"+content+"'>信息填写单击我!</a>");
            str.append("\n");
            str.append("<h3>如果蓝色字体无效请复制该地址到浏览器完成信息填写!</H3>");
            str.append("\n");
            str.append("→→→&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
            str.append("</br>");
            str.append(content);
            str.append("</br>");
            str.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;←←←");
            str.append("</br>");
            str.append("\n");
            str.append("By 众游网团队运营");
            str.append("\n");
            System.out.println(str);
            MailServiceImpl.sendHtmlMail(email, "众游网络科技-邮箱注册-信息填写", str.toString());
            js = new json_N("请注意查看邮箱","/EmailReg");
        }else{
            js = new json_N("验证码错误","/EmailReg");
        }
        req.setAttribute("view",js.getView());
        req.setAttribute("msg",js.getMsg());
       /* ;*/
        return "freemarker/zhongy/Jump";
    }


}
