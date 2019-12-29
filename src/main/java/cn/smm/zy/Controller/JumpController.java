package cn.smm.zy.Controller;

import cn.smm.zy.Util.Mesg;
import cn.smm.zy.Util.PageAndPageNoAndPageCur;
import cn.smm.zy.Util.json_N;
import cn.smm.zy.apl.SendEmail;
import cn.smm.zy.pojo.*;
import cn.smm.zy.service.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dana on 2019/11/24.
 */
@Controller
public class JumpController {

    /**
     * 公用一页显示几条
     */
    private  Integer size = 16;
    @Autowired
    private cn.smm.zy.apl.SendEmail SendEmail;
    @Autowired
    private cn.smm.zy.service.invitationservice invitationservice;
    @Autowired
    private zy_typeService type;
    @Autowired
    private cn.smm.zy.service.zy_userService zy_userService;
    @Autowired
    private cn.smm.zy.service.zy_homepageService zy_homepageService;
    @Autowired
    private cn.smm.zy.service.loginservice loginservice;
    @Autowired
    private zy_standinnerServiceimpl zy_standinnerServiceimpl;
    @Autowired
    private cn.smm.zy.service.zy_wheelimgsidService zy_wheelimgsidService;
    @Autowired
    private cn.smm.zy.service.zy_leaveServiceImpl zy_leaveServiceImpl;

    @RequestMapping("/lyfk")
    public String Jumplyfk(HttpSession session){
        List<zy_leave> findall = zy_leaveServiceImpl.findall();
        session.setAttribute("lovese",findall);
        return "freemarker/lyfk";
    }

    @RequestMapping("/index")
    public String index(HttpServletRequest req, HttpSession session) {
        List<zy_wheelimgsid> zy_wheelimgsids = zy_wheelimgsidService.QyeryList();
        List<zy_invitation> zy_invitations = invitationservice.getzy_invitations();
        List<zy_invitation> items = new ArrayList<zy_invitation>();
        for (zy_invitation zy : zy_invitations) {
            String apls = type.eqapls(zy.getItt_type());
            zy.setType(apls);
            items.add(zy);
        }
        List<zy_homepage> zy_homepages = zy_homepageService.QueryHome();
        for (zy_homepage zyho : zy_homepages) {
            System.out.println(zyho.getHome_title());
            session.setAttribute("idxinfo", zyho);
        }
        System.out.println("Session里面" + session.getAttribute("idxinfo"));
        List<zy_type> apls = type.apls();
        req.setAttribute("itts", items);
        req.setAttribute("apls", apls);
        req.setAttribute("imgs", zy_wheelimgsids);
        return "freemarker/index";
    }

    //    404跳转
    @RequestMapping("/sls")
    public String sls() {
        return "freemarker/404";
    }

    @RequestMapping("/editItt")
    public String edit() {

        return "freemarker/public/nav";
    }

    @RequestMapping("/p_nav")
    public String p_nav() {

        return "freemarker/public/p_nav";
    }

    @RequestMapping("/p_nav_title")
    public String p_nav_title() {

        return "freemarker/public/p_nav_title";
    }

    /*跳转关于我们*/
    @RequestMapping("/Gywm")
    public String Gywm() {
        return "freemarker/Gywm";
    }

    /*跳转发帖页面*/
    @RequestMapping("/sendf")
    public String sendf(String content,HttpSession session) {
        List<zy_type> apls = type.apls();
        session.setAttribute("types",apls);
        return "freemarker/sendf";
    }

    //跳转项目展示
    @RequestMapping("/projectlist")
    public String resourceList(HttpServletRequest req) {
        List<zy_invitation> zy_invitations = invitationservice.getzy_invitations();
        req.setAttribute("zy_invitations", zy_invitations);
        req.setAttribute("zy_invitationscount", zy_invitations.size());
        return "freemarker/resource_list";
    }

    //跳转项目展示 第二版
    @RequestMapping("/projectlist01")
    public String projectlist01(HttpServletRequest req) {
        Integer pageNo = null;

        if ("".equals(req.getParameter("pageNo")) || req.getParameter("pageNo") == null) {
            pageNo = 1;
        } else {
            pageNo = Integer.parseInt(req.getParameter("pageNo"));
        }
        PageAndPageNoAndPageCur findpage = invitationservice.findpage(pageNo, size);
        req.setAttribute("pageNo", findpage.getCurrentNo());/*当前页*/
        req.setAttribute("pageTotal", findpage.getPages());/*共多少页*/
        req.setAttribute("zy_invitations", findpage.getItts());
        return "freemarker/list";
    }

    /**
     * 跳转公告详情
     * @param id
     * @return
     */
    @RequestMapping("/ggdesc/{id}")
    public String jumpggxq(@PathVariable("id") Integer id,HttpSession session){
        zy_standinner byinfo = zy_standinnerServiceimpl.findByinfo(id);
        session.setAttribute("decsg",byinfo);
        return "freemarker/ggxq";
    }


    @RequestMapping("/pageList")
    public String nextpifce(HttpServletRequest req,@RequestParam(value = "pageNo") Integer pageNo) {
        PageAndPageNoAndPageCur findpage = null;
        System.out.println("当前页"+pageNo);
        if ("".equals(pageNo) || req.getParameter("pageNo") == null) {
            pageNo = 1;
        }else{
            pageNo = Integer.parseInt(req.getParameter("pageNo"));
            findpage = invitationservice.findpage(pageNo, size);
        }
        req.setAttribute("pageNo", findpage.getCurrentNo());/*当前页*/
        req.setAttribute("pageTotal", findpage.getPages());/*共多少页*/
        req.setAttribute("zy_invitations", findpage.getItts());
        return "freemarker/list";
    }


    /*邮箱注册*/
    @RequestMapping("/EmailReg")
    public String EmailRegister() {
        return "freemarker/registerEmeail";
    }

    /*跳转后台登录页面*/
    @RequestMapping("/dana")
    public String admin() {
        return "freemarker/zhongy/index";
    }

    /*跳转管理员登录状态*/
    @RequestMapping("/adlogin")
    public String adlogin() {
        return "freemarker/zhongy/login";
    }

    @RequestMapping("/gnameOne")
    public String oneHtml() {
        return "freemarker/Gname";
    }

    @RequestMapping("/gname/{id}")
    public String gname(HttpServletRequest req, @PathVariable("id") Integer id, HttpSession session) {
        List<zy_invitation> zy_invitations = invitationservice.getzy_invitations();
        json_N js = null;
        for (zy_invitation zys : zy_invitations) {
            System.out.println(id + "TTTT" + zys.getId() + "值");
            if (id.equals(zys.getId()) || id == zys.getId()) {
                js = new json_N("我要转一圈", "/gnameOne");
                session.setAttribute("gnamecontent", zys);
                break;
            } else {
                js = new json_N("查询失败,跳转", "/index");
                continue;
            }
        }
        session.setAttribute("view", js.getView());
        session.setAttribute("msg", js.getMsg());
        return "freemarker/Jump";
    }

    @RequestMapping("/Jumpda")
    public String jump() {
        return "freemarker/Jump";
    }

    @RequestMapping("/ckemail/{data}")
    public String r(@PathVariable("data") String data, HttpSession session) {
        json_N js = null;
        session.setAttribute("id", data);

        js = new json_N("正在跳转", "/emailData");
        session.setAttribute("msg", js.getMsg());
        session.setAttribute("view", js.getView());
        System.out.println("跳转了");
        /*return "freemarker/Jump";*/
        return "freemarker/Jump";
    }

    /*跳转邮箱注册填写信息*/
    @RequestMapping("/emailData")
    public String EmailData() {
        return "freemarker/EmailinputData";
    }

    /*删除帖子*/
    @RequestMapping("/IttdeleteByd/{id}")
    public String zhangzhen(@PathVariable("id") Integer id, HttpSession session) {
        Integer integer = invitationservice.deleteByid(id);
        json_N js = null;
        if (integer > 0) {
            js = new json_N("删除成功", "/IttList");
        } else {
            js = new json_N("重试一下吧", "/IttList");
        }
        session.setAttribute("msg", js.getMsg());
        session.setAttribute("view", js.getView());
        return "freemarker/zhongy/Jump";

    }


    /*添加帖子*/
    @RequestMapping("/Ittadd")
    public String Ittadd() {
        return "freemarker/zhongy/add";
    }

    @RequestMapping("/uploadImg")
    public String Jumpuploadimg() {
        return "freemarker/public/uploadImg";
    }

    @RequestMapping("/UserData")
    public String UserData() {
        return "freemarker/public/UserData";
    }

    @RequestMapping("/realName")
    public String realName() {
        return "freemarker/public/realName";
    }

    @RequestMapping("/pwdsecurity")
    public String pwdsecurity() {
        return "freemarker/public/pwdsecurity";
    }

    @RequestMapping("/pass")
    public String Jumppass() {
        return "freemarker/zhongy/pass";
    }

    /*跳转个人设置资料介面*/
    @RequestMapping("/OnData")
    public String JumpOndata(HttpSession session) {
        String uid = (String) session.getAttribute("uid");
        zy_user findbyid = zy_userService.findbyid(uid);
        zy_regisger_user findbyid1 = loginservice.findbyid(uid);
        session.setAttribute("user", findbyid);
        session.setAttribute("regteruser", findbyid1);
        return "freemarker/OnData";
    }

    /**
     * 最新公告
     *
     * @return
     */
    @RequestMapping("/standesc")
    public String jumpnewGongg(HttpSession session) {
        List<zy_standinner> findall = zy_standinnerServiceimpl.findall();
        session.setAttribute("Notices", findall);

        return "freemarker/public/standesc";
    }

    /**
     * 联系我们tr
     *
     * @return
     */
    @RequestMapping("/lxwm")
    public String jumpgywm() {
        return "freemarker/public/lxwm";
    }
}
