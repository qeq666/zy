package cn.smm.zy.Controller;

import cn.smm.zy.pojo.*;
import cn.smm.zy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dana on 2019/11/26.
 */
@Controller
public class InitController {

    @Autowired
    private invitationservice invitationservice;
    @Autowired
    private zy_homepageService zy_homepageService;
    @Autowired
    private zy_typeService type;
    @Autowired
    private cn.smm.zy.service.zy_userService zy_userService;
    @Autowired
    private cn.smm.zy.service.zy_wheelimgsidService zy_wheelimgsidService;


    @RequestMapping("/Init")
    public void Init(HttpServletRequest req, HttpServletResponse Response, HttpSession session) {
        List<zy_wheelimgsid> zy_wheelimgsids = zy_wheelimgsidService.QyeryList();
        for (zy_wheelimgsid z:zy_wheelimgsids){
            System.out.println("轮播图游"+z);
        }
        try {
            List<zy_invitation> zy_invitations = invitationservice.getzy_invitations();
            List<zy_invitation> items = new ArrayList<zy_invitation>();
            for (zy_invitation zy : zy_invitations) {
                String apls = type.eqapls(zy.getItt_type());
                zy.setType(apls);
                zy.setCreateInfo(zy_userService.eq(zy.getItt_createid()));
                items.add(zy);
            }
            System.out.println("发表人"+items.get(0).getCreateInfo());
            System.out.println("发表人"+items.get(1).getCreateInfo());
            System.out.println("发表人"+items.get(2).getCreateInfo());
            List<zy_homepage> zy_homepages = zy_homepageService.QueryHome();
            for (zy_homepage zyho :zy_homepages){
                session.setAttribute("idxinfo",zyho);
            }
            List<zy_type> apls = type.apls();
            req.setAttribute("itts", items);
            req.setAttribute("apls", apls);
            req.setAttribute("imgs", zy_wheelimgsids);
            req.getRequestDispatcher("index").
                    forward(req, Response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "/queryid")
    @ResponseBody
    public String add(HttpServletRequest req) {
        List<zy_homepage> zy_homepages = zy_homepageService.QueryHome();
        for (zy_homepage zy : zy_homepages) {
            System.out.println(zy.getHome_title());
        }
        return "null";
    }


}
