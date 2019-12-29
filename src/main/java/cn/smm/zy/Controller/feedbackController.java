package cn.smm.zy.Controller;

import cn.smm.zy.Util.json_N;
import cn.smm.zy.pojo.zy_leave;
import cn.smm.zy.service.zy_leaveServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by Dana on 2019/12/29.
 */
@Controller
public class feedbackController {

    @Autowired
    private cn.smm.zy.service.zy_leaveServiceImpl zy_leaveServiceImpl;

    @RequestMapping("/addfeedb")
    public String add(HttpSession session,HttpServletRequest req){
        json_N json = null;
        Object cko = session.getAttribute("simpleCaptcha");/*验证码*/
        if(req.getParameter("code").equals(cko)){
            zy_leave zye = new zy_leave(req.getParameter("title"),req.getParameter("desc"),new Date(),"未解决",req.getParameter("lxfs"));
            Integer add = zy_leaveServiceImpl.add(zye);
            if(add>0){
                json = new json_N("反馈成功","/lyfk");
            }else{
                json = new json_N("点击的有点快了歇一会","/lyfk");
            }
        }else{
            json = new json_N("验证码错误!","/lyfk");
        }

        session.setAttribute("msg", json.getMsg());
        session.setAttribute("view", json.getView());
        return "freemarker/zhongy/Jump";
    }
    @ResponseBody
    @RequestMapping("/delfeedb/{id}")
    public String del(@PathVariable("id") Integer id,HttpSession session){
        Integer del = zy_leaveServiceImpl.del(id);
        json_N json = null;
        if(del>0){
            json = new json_N("删除成功","/lyfk");
        }else{
            json = new json_N("点击的有点快了歇一会","/lyfk");
        }

        return json.getMsg();
    }
    @RequestMapping("/upfeedb/{id}")
    public String update(@PathVariable("id") Integer id,HttpServletRequest request,HttpSession session){
        zy_leave reeresult = zy_leaveServiceImpl.findByid(id);
        reeresult.setIsok("已解决,谢谢您的反馈!");
        Integer integer = zy_leaveServiceImpl.updateInof(reeresult);
        json_N json = null;
        if(integer>0){
            json = new json_N("更新成功","/lyfk");
        }else{
            json = new json_N("点击的有点快了歇一会","/lyfk");
        }
        session.setAttribute("msg", json.getMsg());
        session.setAttribute("view", json.getView());
        return "freemarker/zhongy/Jump";
    }


}
