package cn.smm.zy.Controller;

import cn.smm.zy.Dao.zy_homepageMapper;
import cn.smm.zy.Util.PageAndPageNoAndPageCur;
import cn.smm.zy.Util.PwdEditor;
import cn.smm.zy.Util.ToolUtil;
import cn.smm.zy.Util.json_N;
import cn.smm.zy.pojo.*;
import cn.smm.zy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import cn.smm.zy.service.zy_userService;
import cn.smm.zy.service.zy_wheelimgsidService;

/**
 * Created by Dana on 2019/12/2.
 */
@Controller
public class adController {
    private  Integer size = 4;
    @Autowired
    private invitationservice invitationservice;
    @Autowired
    private zy_homepageService zy_homepageService;
    @Autowired
    private zy_typeService zy_types;
    @Autowired
    private zy_userService zy_userService;
    @Autowired
    private zy_wheelimgsidService zy_wheelimgsidService;
    @Autowired
    private zy_typeService type;
    @Autowired
    private zy_adminService zy_adminService;
    @Autowired
    private loginservice loginservice;
    @Autowired
    private zy_standinnerServiceimpl zy_standinnerServiceimpl;
    @Autowired
    private zy_leaveServiceImpl zy_leaveServiceImpl;
    // 项目根路径下的目录  -- SpringBoot static 目录相当于是根路径下（SpringBoot 默认）
    public final static String UPLOAD_PATH_PREFIX = "static/uploadFile/";
    /**
     * 上传Logo
     *
     * @param uploadFile
     * @param req
     * @return
     */
    @ResponseBody
    @PostMapping("/uploadLogo")
    public String upload(@RequestParam("file") MultipartFile uploadFile, HttpServletRequest req) {
        if (uploadFile.isEmpty()) {
            //返回选择文件提示
            return "上传失败，因为文件是空的<a href='Init'>=返回首页</a>";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
        //构建文件上传所要保存的"文件夹路径"--这里是相对路径，保存到项目根路径的文件夹下
        String realPath = new String("src/main/resources/" + UPLOAD_PATH_PREFIX);
        System.out.println("-----------上传文件保存的路径【" + realPath + "】-----------");
        String format = sdf.format(new Date());
        //存放上传文件的文件夹
        File file = new File(realPath + format);
        System.out.println("-----------存放上传文件的文件夹【" + file + "】-----------");
        System.out.println("-----------输出文件夹绝对路径 -- 这里的绝对路径是相当于当前项目的路径而不是“容器”路径【" + file.getAbsolutePath() + "】-----------");
        if (!file.isDirectory()) {
            //递归生成文件夹
            file.mkdirs();
        }
        //获取原始的名字  original:最初的，起始的  方法是得到原来的文件名在客户机的文件系统名称
        String oldName = uploadFile.getOriginalFilename();
        System.out.println("-----------文件原始的名字【" + oldName + "】-----------");
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."), oldName.length());
        System.out.println("-----------文件要保存后的新名字【" + newName + "】-----------");
        try {
            //构建真实的文件路径
            File newFile = new File(file.getAbsolutePath() + File.separator + newName);
            //转存文件到指定路径，如果文件名重复的话，将会覆盖掉之前的文件,这里是把文件上传到 “绝对路径”
            uploadFile.transferTo(newFile);
            String filePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/uploadFile/" + format + newName;
            /*文件全路径*/

            return "更新成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "上传失败，参数错误.<a href='/sendf'>继续发帖</a><a href='/Init'>=返回首页</a>";
    }
    /**
     * 跳转网站信息
     *
     * @param req
     * @return
     */
    @RequestMapping("/info")
    public String info(HttpServletRequest req) {
        List<zy_homepage> zy_homepageMappers = zy_homepageService.QueryHome();
        for (zy_homepage zy : zy_homepageMappers) {
            System.out.println(zy.getHome_title() + zy.getHome_link());
        }
        req.setAttribute("infos", zy_homepageMappers);
        return "freemarker/zhongy/info";
    }
    /**
     * 跳转分类页面
     *
     * @param req
     * @return
     */
    @RequestMapping("/cate")
    public String cate(HttpServletRequest req) {
        List<zy_type> apls = zy_types.apls();
        req.setAttribute("cates", apls);
        return "freemarker/zhongy/cate";
    }
    /**
     * 用户列表冻结
     *
     * @param req
     * @return
     */
    @RequestMapping("/ulists")
    public String UserList(HttpServletRequest req) {
        List<zy_user> zy_users = zy_userService.QueryList();
        List<zy_user> zys = new ArrayList<>();
        for (zy_user zy : zy_users) {

            System.out.println(zy.getIsdongj() + zy.getUser_realname());
            if (zy.getIsdongj().equals(0) || zy.getIsdongj() == 0) {
                zy.setIsdj("否");
                System.out.println(zy.getUser_remark());

            } else {
                zy.setIsdj("是");
                System.out.println("冻结");
            }
            zys.add(zy);
        }
        req.setAttribute("ulists", zys);
        return "freemarker/zhongy/userList";
    }
    /**
     * 上传；轮播图
     *
     * @param uploadFile
     * @param req
     * @return
     */
    @PostMapping("/Rotationchart")
    /*Rotationchart 旋转图标的意思--轮播图*/
    public String Rotationchart(@RequestParam("file") MultipartFile uploadFile, HttpServletRequest req,HttpSession session) {
        json_N json = null;
        if (uploadFile.isEmpty()) {
            //返回选择文件提示
            return "上传失败，因为文件是空的<a href='Init'>=返回首页</a>";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
        //构建文件上传所要保存的"文件夹路径"--这里是相对路径，保存到项目根路径的文件夹下
        String realPath = new String("src/main/resources/" + UPLOAD_PATH_PREFIX);
        System.out.println("-----------上传文件保存的路径【" + realPath + "】-----------");
        String format = sdf.format(new Date());
        //存放上传文件的文件夹
        File file = new File(realPath + format);
        System.out.println("-----------存放上传文件的文件夹【" + file + "】-----------");
        System.out.println("-----------输出文件夹绝对路径 -- 这里的绝对路径是相当于当前项目的路径而不是“容器”路径【" + file.getAbsolutePath() + "】-----------");
        if (!file.isDirectory()) {
            //递归生成文件夹
            file.mkdirs();
        }
        //获取原始的名字  original:最初的，起始的  方法是得到原来的文件名在客户机的文件系统名称
        String oldName = uploadFile.getOriginalFilename();
        System.out.println("-----------文件原始的名字【" + oldName + "】-----------");
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."), oldName.length());
        System.out.println("-----------文件要保存后的新名字【" + newName + "】-----------");
        try {
            //构建真实的文件路径
            File newFile = new File(file.getAbsolutePath() + File.separator + newName);
            //转存文件到指定路径，如果文件名重复的话，将会覆盖掉之前的文件,这里是把文件上传到 “绝对路径”
            uploadFile.transferTo(newFile);
            String filePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/uploadFile/" + format + newName;
            /*文件全路径*/
            System.out.println("查看八路军" + filePath);
            zy_wheelimgsid zyw = new zy_wheelimgsid();
            zyw.setWl_img(filePath);
            zyw.setWl_describe(req.getParameter("note"));
            Integer integer = zy_wheelimgsidService.InsertLb(zyw);
            String msg = null;
            if (integer > 0) {
                json = new json_N("上传成功","advs");
            } else {
                json = new json_N("点击次数太快了","advs");
            }
            session.setAttribute("msg", json.getMsg());
            session.setAttribute("view", json.getView());
            return "freemarker/zhongy/Jump";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "上传失败，参数错误.<a href='/sendf'>继续发帖</a><a href='/Init'>=返回首页</a>";
    }
    /**
     * 查询所有轮播图
     *
     * @param req
     * @return
     */
    @RequestMapping("/advs")
    public String chartList(HttpServletRequest req) {
        List<zy_wheelimgsid> zy_wheelimgsids = zy_wheelimgsidService.QyeryList();
        req.setAttribute("advs", zy_wheelimgsids);
        return "freemarker/zhongy/adv";
    }
    /**
     * 中转
     *
     * @return
     */
    @RequestMapping("/Jump")
    public String Jump() {
        return "freemarker/zhongy/Jump";
    }
    /*帖子列表*/
    @RequestMapping("/IttList")
    public Object IttList(HttpServletRequest req, HttpServletResponse Response) {
        List<zy_type> apls1 = zy_types.apls();
        Integer pageNo = null;
        if ("".equals(req.getParameter("pageNo")) || req.getParameter("pageNo") == null) {
            pageNo = 1;
        } else {
            pageNo = Integer.parseInt(req.getParameter("pageNo"));
        }
        PageAndPageNoAndPageCur findpage = invitationservice.findpage(pageNo, size);
        List<zy_invitation> items = new ArrayList<zy_invitation>();
        for (zy_invitation zy : findpage.getItts()) {
            String apls = type.eqapls(zy.getItt_type());
            zy.setType(apls);
            items.add(zy);
        }
        req.setAttribute("Itts", items);
        req.setAttribute("pageNo", pageNo);
        req.setAttribute("apls1", apls1);
        return "freemarker/zhongy/list";
    }
    /**
     * 管理员验证
     *
     * @return
     */
    @RequestMapping("/loginck")
    public String adLogin(HttpServletRequest req,HttpSession session) {
        json_N json = null;
        List<zy_admin> zy_admins = zy_adminService.QyeryList();
        if (req.getSession().getAttribute("simpleCaptcha").equals(req.getParameter("code"))) {
            for (zy_admin zya : zy_admins) {/*md5加密*/
                if (req.getParameter("name").equals(zya.getZuid()) && req.getParameter("password").equals(zya.getZpwd())) {
                    req.getSession().setAttribute("admin", zya);
                    json = new json_N("登陆成功", "/dana");
                    break;
                } else {
                    json = new json_N("验证码错误或密码错误", "/dana");
                    continue;
                }
            }
        } else {
            json = new json_N("验证码错误或密码错误", "/dana");
        }
        session.setAttribute("msg", json.getMsg());
        session.setAttribute("view", json.getView());
        return "freemarker/zhongy/Jump";
    }
    /*更新网页基本信息*/
    @RequestMapping("/updattHome")
    public String UpdateHome(HttpServletRequest req){
        /*网页茶餐过来的信息*/
        String stitle = req.getParameter("stitle");
        String skeywords = req.getParameter("skeywords");
        String sdescription = req.getParameter("sdescription");
        String scopyright = req.getParameter("scopyright");
        Integer id = Integer.parseInt(req.getParameter("id"));
        /*下面是新更新信息*/
        /*下面是修改信息*/
        List<cn.smm.zy.pojo.zy_homepage> zy_homepages = zy_homepageService.QueryHome();
        zy_homepage nupag = null;//新更新的
        for (zy_homepage z :zy_homepages){
            if(id.equals(z.getHomeid())||id==z.getHomeid()){
                z.setHome_Keyword(skeywords);
                z.setHome_link(z.getHome_link());
                z.setHome_title(stitle);
                z.setHome_briefintroduction(sdescription);
                z.setHome_desion(sdescription);
                z.setHome_detailsid(0);
                z.setHome_topinfo(scopyright);
                nupag = z;
                break;
            }else{
                System.out.println("无信息");
            }
        }
        Integer integer = zy_homepageService.HomeUpdate(nupag);
        json_N js = null;
        if (integer>0){
            js = new json_N("修改成功","/info");
        }else{
            js = new json_N("修改失败,请清除缓存后重试","/info");
        }
        req.setAttribute("view",js.getView());
        req.setAttribute("msg",js.getMsg());
        /*return "freemarker/zhongy/Jump";*/
        return "freemarker/zhongy/Jump";
    }
    /*更新帖子*/
    @ResponseBody
    @RequestMapping("/zhangzhen/{id}")
    public Object zhangzhen(@PathVariable("id") Integer id) {
        String msg = null;
        List<cn.smm.zy.pojo.zy_homepage> zy_homepages = zy_homepageService.QueryHome();
        for (zy_homepage z :zy_homepages){
            if(id.equals(z.getHomeid())||id==z.getHomeid()){
                System.out.println("又该信息");
            }else{
                System.out.println("无信息");
            }
        }
        return msg;
    }
    /*管理员退出out*/
    @RequestMapping("/adminout")
    public String outAdmin(HttpSession session){
        session.removeAttribute("admin");
        json_N js = new json_N("谢谢使用!","/dana");;
        session.setAttribute("msg",js.getMsg());
        session.setAttribute("view",js.getView());
        return "freemarker/zhongy/Jump";
    }
    /*解冻*/
    @RequestMapping("/Thaw/{id}")
    public String Thaw(@PathVariable("id") Integer id,HttpServletRequest req,HttpSession session){
        Integer operation = zy_userService.operation(id);
        json_N js = null;
        if (operation>0){
            js = new json_N("解冻成功,可以登录","/ulists");
        }else{
            js = new json_N("重新操作一下试试!","/ulists");
        }
        session.setAttribute("msg", js.getMsg());
        session.setAttribute("view", js.getView());
        return "freemarker/zhongy/Jump";
    }
    /*冻结*/
    @RequestMapping("/Frozen/{id}")
    public String Frozen(@PathVariable("id") Integer id,HttpServletRequest req,HttpSession session){
        Integer operation = zy_userService.operation(id);
        json_N js = null;
        System.out.println(operation);
        if (operation>0){
            js = new json_N("冻结成功,不可以登录","/ulists");
        }else{
            js = new json_N("重新操作一下试试!","/ulists");
        }
        session.setAttribute("msg", js.getMsg());
        session.setAttribute("view", js.getView());
        return "freemarker/zhongy/Jump";
    }
    @RequestMapping("/UserFrozen/{email}")
    @ResponseBody
    public String Fikt(@PathVariable("email") String email,HttpSession session){
        json_N js = null;
        List<zy_regisger_user> querys = loginservice.Querys();
        zy_regisger_user dong = null;
        json_N json_n=  null;
        for (zy_regisger_user zyu : querys){
            if (email.equals(zyu.getRgt_email()) || email==zyu.getRgt_email()){
                if ("0".equals(zyu.getRgt_isfrost())){
                    zyu.setRgt_isfrost("1");
                    System.out.println("未冻结可以冻结");
                    json_n = new json_N("未冻结可以冻结","/index");
                    Integer frozen = loginservice.Frozen(zyu);
                    System.out.println(frozen);
                }else if("1".equals(zyu.getRgt_isfrost())){
                    zyu.setRgt_isfrost("0");
                    System.out.println("冻结可以接触结");
                    json_n = new json_N("冻结可以接触结","/index");
                    Integer frozen = loginservice.Frozen(zyu);
                    System.out.println(frozen);
                }
                break;
            }else{
                continue;
            }
        }
        session.setAttribute("msg", json_n.getMsg());
        session.setAttribute("view", json_n.getView());
        return "freemarker/zhongy/Jump";
    }


    @RequestMapping("/update")
    public String updateadmin(HttpSession session,HttpServletRequest req){
        json_N json = null;
        String parameter = req.getParameter("pwd");
        zy_admin admin = (zy_admin) session.getAttribute("admin");
        System.out.println(admin.getZpwd()+">>>>>>>>>>>>>>>>>>>>>"+"新密码"+parameter);
        if(parameter.equals(admin.getZpwd())){
            String newpwd = req.getParameter("newpwd");
            admin.setZpwd(newpwd);
            Integer integer = zy_adminService.UpdatePwd(admin);
            if(integer>0){
                json = new json_N("修改成功","adminout");
            }else{
                json = new json_N("检查网络重试!","pass");
            }
        }else{
            json = new json_N("旧密码错误!","pass");
        }
        session.setAttribute("msg", json.getMsg());
        session.setAttribute("view", json.getView());
        return "freemarker/zhongy/Jump";
    }


    @RequestMapping("/addtice")
    public String addNotice(HttpServletRequest req,HttpSession session){
        json_N json = null;
        String title = req.getParameter("title");
        String edit = req.getParameter("edit");
        String uname = req.getParameter("uname");
        String istop = null;
        if(req.getParameter("ittop")==null || req.getParameter("ittop").equals("")){
            istop= "1";
        }else{
            istop= "2";
        }
        zy_standinner zynner = new zy_standinner(title,Integer.parseInt(istop),edit,new Date(),uname);
        Integer integer = zy_standinnerServiceimpl.addNotice(zynner);
        if(integer>0){
            json = new json_N("添加成功","Ittadd");
        }else{
            json = new json_N("添加失败,检验网络","Ittadd");
        }
        session.setAttribute("msg", json.getMsg());
        session.setAttribute("view", json.getView());
        return "freemarker/zhongy/Jump";
    }


    @RequestMapping("/NewticsList")
    public String jumpNewTics(HttpSession session){
        List<zy_standinner> findall = zy_standinnerServiceimpl.findall();
        session.setAttribute("NewsList",findall);
        return "freemarker/zhongy/Notices";
    }


    @RequestMapping("/jisuan")
    public String jisuan(){
        int i = 1/0;
        return "freemarker/index";
    }

    /*跳转修改项目置顶页面参数为帖子ID*/
    @RequestMapping("/updateinfo/{id}")
    public String JumpUpdateinfo(@PathVariable("id") Integer id,HttpSession session){
        zy_invitation zy_invitation = invitationservice.queryByid(id);
        session.setAttribute("userone",zy_invitation);
        return "freemarker/zhongy/updateinfo";
    }


    /**
     * 修改一条信息置顶
     * @return
     */
    @RequestMapping("/updatetopOne")
    public String shenrTop(HttpServletRequest req,HttpSession session){
        json_N json = null;
        String istop = null;
        if(req.getParameter("ittop")==null || req.getParameter("ittop").equals("")||req.getParameter("ittop").equals("1")){
            istop= "2";
        }else{
            istop= "2";
        }
        zy_invitation newittion = invitationservice.queryByid(Integer.parseInt(req.getParameter("iid")));
        newittion.setItt_title(req.getParameter("title"));
        newittion.setItt_kind(Integer.parseInt(istop));
        Integer integer = invitationservice.updateTop(newittion);
        if(integer>0){
            json = new json_N("修改成功","IttList");
        }else{
            json = new json_N("网络异常","IttList");
        }
        session.setAttribute("msg", json.getMsg());
        session.setAttribute("view", json.getView());
        return "freemarker/zhongy/Jump";
    }

    /**
     * 置顶一条公告
     * @return
     */
    @RequestMapping("/topdesc/{byid}")
    public String updadesc(@PathVariable("byid") Integer byid,HttpSession session){
        json_N json = null;
        zy_standinner byinfo = zy_standinnerServiceimpl.findByinfo(byid);
        Integer kind = byinfo.getKind();
        if(kind==1){
            byinfo.setKind(2);
        }else{
            byinfo.setKind(2);
        }
        Integer integer = zy_standinnerServiceimpl.updateTop(byinfo);
        if(integer>0){
            json = new json_N("置顶成功","/NewticsList");
        }else{
            json = new json_N("点击的有点快了歇一会","/NewticsList");
        }
        session.setAttribute("msg", json.getMsg());
        session.setAttribute("view", json.getView());
        return "freemarker/zhongy/Jump";
    }
    /**
     * 置顶一条公告
     * @return
     */
    @RequestMapping("/Notop/{byid}")
    public String updadescNotop(@PathVariable("byid") Integer byid,HttpSession session){
        json_N json = null;
        zy_standinner byinfo = zy_standinnerServiceimpl.findByinfo(byid);
        Integer kind = byinfo.getKind();
        if(kind==2){
            byinfo.setKind(1);
        }else{
            byinfo.setKind(1);
        }
        Integer integer = zy_standinnerServiceimpl.updateTop(byinfo);
        if(integer>0){
            json = new json_N("取消置顶成功","/NewticsList");
        }else{
            json = new json_N("点击的有点快了歇一会","/NewticsList");
        }
        session.setAttribute("msg", json.getMsg());
        session.setAttribute("view", json.getView());
        return "freemarker/zhongy/Jump";
    }


    /**
     * 删除公告
     * @param byid
     * @return
     */
    @RequestMapping("/del/{byid}")
    public String deledesc(@PathVariable("byid")Integer byid,HttpSession session){
        json_N json = null;
        Integer deledesc = zy_standinnerServiceimpl.deledesc(byid);
        if(deledesc>0){
            json = new json_N("删除成功","/NewticsList");
        }else{
            json = new json_N("点击的有点快了歇一会","/NewticsList");
        }
        session.setAttribute("msg", json.getMsg());
        session.setAttribute("view", json.getView());
        return "freemarker/zhongy/Jump";
    }

    /**
     * 删除一个轮播图
     * @param id
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/delByid/{id}")
    public String delByid(@PathVariable("id") Integer id,HttpSession session){
        String msg = null;
        Integer integer = zy_wheelimgsidService.delByid(id);
        if(integer>0){
            msg = "删除成功";
        }else{
            msg = "删除失败";
        }
        return msg;
    }


    @RequestMapping("/swchList")
    public String swchListPageQwr(HttpServletRequest req){
        System.out.println("分类为:"+Integer.parseInt(req.getParameter("sechtype")));
        Integer pageNo = null;
        if ("".equals(req.getParameter("pageNo")) || req.getParameter("pageNo") == null) {
            pageNo = 1;
        } else {
            pageNo = Integer.parseInt(req.getParameter("pageNo"));
        }
        PageAndPageNoAndPageCur pageListQwresult = invitationservice.pageQwarList(pageNo, size, req.getParameter("title"),Integer.parseInt(req.getParameter("sechtype")));
        List<zy_type> apls1 = zy_types.apls();

        List<zy_invitation> items = new ArrayList<zy_invitation>();
        for (zy_invitation zy : pageListQwresult.getItts()) {
            String apls = type.eqapls(zy.getItt_type());
            zy.setType(apls);
            items.add(zy);
        }
        req.setAttribute("Itts", items);
        req.setAttribute("pageNo", pageNo);
        req.setAttribute("apls1", apls1);
        return "freemarker/zhongy/list";
    }

    /**
     * 添加一个分类
     * @param req
     * @return
     */
    @ResponseBody
    @RequestMapping("/addType")
    public String addType(HttpServletRequest req,HttpSession session){
        zy_type zyt = new zy_type(req.getParameter("title"),req.getParameter("s_desc"));
        Integer integer = type.insertType(zyt);
        json_N json = null;
        if(integer>0){
            json = new json_N("添加成功","/cate");
        }else{
            json = new json_N("再试一次吧","/cate");
        }
        session.setAttribute("msg", json.getMsg());
        session.setAttribute("view", json.getView());
        return "freemarker/zhongy/Jump";
    }

    /**
     * 删除一个分类
     * @param tid
     * @return
     */
    @ResponseBody
    @RequestMapping("/delType/{tid}")
    public String delType(@PathVariable("tid") Integer tid){
        Integer del = type.del(tid);
        String msg = null;
        if(del>0){
            msg = "删除成功";
        }else{
            msg = "删除失败";
        }
        return msg;
    }

    @RequestMapping("/tinfo/{id}")
    public String jumptinfo(@PathVariable("id") Integer id,HttpServletRequest req){
        zy_type byid = type.findByid(id);
        System.out.println(byid);
        req.setAttribute("ts",byid);
        return "freemarker/zhongy/typeinfo";
    }

    @RequestMapping("/updatrType")
    public String updatType(HttpServletRequest req,HttpSession session){
        zy_type result = type.findByid(Integer.parseInt(req.getParameter("tid")));
        result.setT_type(req.getParameter("title"));
        result.setT_back(req.getParameter("desc"));
        Integer tupdate = type.tupdate(result);
        json_N json = null;
        if(tupdate>0){
            json = new json_N("更新成功","/cate");
        }else{
            json = new json_N("点击的有点快了歇一会","/cate");
        }
        session.setAttribute("msg", json.getMsg());
        session.setAttribute("view", json.getView());
        return "freemarker/zhongy/Jump";
    }

    @RequestMapping("/lyfkList")
    public String JumpLYFKS(HttpSession session){
        List<zy_leave> findall = zy_leaveServiceImpl.findall();
        session.setAttribute("fkmsgs",findall);
        return "freemarker/zhongy/lyfks";
    }







}
