package cn.smm.zy.Controller;

import cn.smm.zy.Util.json_N;
import cn.smm.zy.pojo.Imgs;
import cn.smm.zy.pojo.sharemsg;
import cn.smm.zy.service.ImgsServiceImpl;
import cn.smm.zy.service.sharemsgServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import cn.smm.zy.service.sharemsgServiceImpl;
import cn.smm.zy.service.ImgsServiceImpl;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Dana on 2019/12/25.
 */
@Controller
public class ShareMesController {

    @Autowired
    private sharemsgServiceImpl sharemsgServiceImpl;
    @Autowired
    private ImgsServiceImpl ImgsServiceImpl;



    /*跳转共享信息界面 输出所有共享信息*/
    @RequestMapping("/zydwa")
    public String JumpShar(HttpSession session) {
        List<sharemsg> findall = sharemsgServiceImpl.findall();
        for (sharemsg s:findall
             ) {
            System.out.println(s.getDanadw());
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

    @RequestMapping("/addShars/{title}/{content}/{img_site}/{danadw}/{latitude}")
    public String addShareMsg(HttpServletResponse Response,HttpServletRequest req, HttpSession session
                              , @PathVariable("title") String title, @PathVariable("content") String content
            , @PathVariable("img_site") Integer img_site, @PathVariable("danadw") String danadw
            , @PathVariable("latitude") String latitude){
        System.out.println(title+">"+content+">"+">"+img_site+">"+danadw+">"+latitude);
        json_N msg = null;
        Imgs byid = ImgsServiceImpl.findByid(img_site);
        sharemsg shg = new sharemsg(title,content,new Date()
                ,byid.getImgurl(),danadw,latitude);
        Integer integer = sharemsgServiceImpl.addShrasMsg(shg);
        if(integer>0){
            msg = new json_N("发送成功","/zydwa");
            System.out.println("发送成功");

        }else{
            msg = new json_N("发送失败!","/zydwa");
            System.out.println("发送失败");
        }
        session.setAttribute("view",msg.getView());
        session.setAttribute("msg",msg.getMsg());
        return "freemarker/Jump";
    }

    @RequestMapping("/JumpShares")
    public String JumpShares(HttpSession session){
        List<Imgs> findall = ImgsServiceImpl.findall();
        session.setAttribute("imgs",findall);
        return "freemarker/SharMsg";
    }






}
