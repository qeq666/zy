package cn.smm.zy.Controller;

import cn.smm.zy.pojo.zy_homepage;
import cn.smm.zy.pojo.zy_invitation;
import cn.smm.zy.pojo.zy_type;
import cn.smm.zy.service.invitationservice;
import cn.smm.zy.service.zy_homepageService;
import cn.smm.zy.service.zy_typeService;
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

    @RequestMapping("/Init")
    public void Init(HttpServletRequest req, HttpServletResponse Response, HttpSession session) {
        try {
            List<zy_invitation> zy_invitations = invitationservice.getzy_invitations();
            List<zy_invitation> items = new ArrayList<zy_invitation>();
            for (zy_invitation zy : zy_invitations) {
                String apls = type.eqapls(zy.getItt_type());
                zy.setType(apls);
                items.add(zy);
            }
            List<zy_homepage> zy_homepages = zy_homepageService.QueryHome();
            for (zy_homepage zyho :zy_homepages){
                session.setAttribute("idxinfo",zyho);
            }
            List<zy_type> apls = type.apls();
            req.setAttribute("itts", items);
            req.setAttribute("apls", apls);
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
