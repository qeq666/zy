package cn.smm.zy.Controller;

import cn.smm.zy.Util.json_N;
import cn.smm.zy.pojo.sharemsg;
import cn.smm.zy.service.sharemsgServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Dana on 2019/12/25.
 */
@Controller
public class ShareMesController {

    @Autowired
    private cn.smm.zy.service.sharemsgServiceImpl sharemsgServiceImpl;



    /*跳转共享信息界面 输出所有共享信息*/
    @RequestMapping("/zydwa")
    public String JumpShar(HttpSession session) {
        List<sharemsg> findall = sharemsgServiceImpl.findall();
        for (sharemsg s:findall
             ) {
            System.out.println(s);
        }
        session.setAttribute("shares",findall);
        return "freemarker/zydwadess";
    }


    @RequestMapping("/Byid/{id}")
    public String findByid(@PathVariable("id") Integer id,HttpSession session){
        System.out.println(id);
        sharemsg findbyid = sharemsgServiceImpl.findbyid(id);
        json_N msg = null;
        if(findbyid!=null){
            msg = new json_N("小众众正在搜索!","/zydwa");
        }else{
            msg = new json_N("出了点问题!","/zydwa");
        }
        session.setAttribute("view",msg.getView());
        session.setAttribute("msg",msg.getMsg());
        session.setAttribute("share",findbyid);
        return "freemarker/Jump";

    }


}
