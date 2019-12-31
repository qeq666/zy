package cn.smm.zy.Controller;
import cn.smm.zy.Util.ToolUtil;
import cn.smm.zy.Util.json_N;
import cn.smm.zy.pojo.zy_invitation;
import cn.smm.zy.pojo.zy_user;
import cn.smm.zy.service.invitationservice;
import cn.smm.zy.service.zy_userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Dana on 2019/11/10.
 */
@Controller
public class userController {

    @Autowired
    private invitationservice invitationservice;
    @Autowired
    private cn.smm.zy.service.zy_userService zy_userService;

    /**senditt
     * 注销用户
     * @param req
     * @param session
     * @return
     */
    @RequestMapping("/Cancellation")
   public String Cancellation(HttpServletRequest req, HttpSession session){
        session.removeAttribute("uid");
        return "index";
   }
   @ResponseBody
    @RequestMapping("/testcontent")
    public String testcontent(HttpServletRequest req, HttpSession session){
        String edit = req.getParameter("edit");
        return edit;
    }


    // 项目根路径下的目录  -- SpringBoot static 目录相当于是根路径下（SpringBoot 默认）
    public final static String UPLOAD_PATH_PREFIX = "static/uploadFile/";
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile uploadFile, HttpServletRequest req,HttpSession session){
        json_N json = null;
        if(uploadFile.isEmpty()){
            //返回选择文件提示
            json = new json_N("上传失败，因为文件是空的", "/sendf");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
        //构建文件上传所要保存的"文件夹路径"--这里是相对路径，保存到项目根路径的文件夹下
        String realPath = new String("src/main/resources/" + UPLOAD_PATH_PREFIX);
        System.out.println("-----------上传文件保存的路径【"+ realPath +"】-----------");
        String format = sdf.format(new Date());
        //存放上传文件的文件夹
        File file = new File(realPath + format);
        System.out.println("-----------存放上传文件的文件夹【"+ file +"】-----------");
        System.out.println("-----------输出文件夹绝对路径 -- 这里的绝对路径是相当于当前项目的路径而不是“容器”路径【"+ file.getAbsolutePath() +"】-----------");
        if(!file.isDirectory()){
            //递归生成文件夹
            file.mkdirs();
        }
        //获取原始的名字  original:最初的，起始的  方法是得到原来的文件名在客户机的文件系统名称
        String oldName = uploadFile.getOriginalFilename();
        System.out.println("-----------文件原始的名字【"+ oldName +"】-----------");
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."),oldName.length());
        System.out.println("-----------文件要保存后的新名字【"+ newName +"】-----------");
        try {
            //构建真实的文件路径
            File newFile = new File(file.getAbsolutePath() + File.separator + newName);
            //转存文件到指定路径，如果文件名重复的话，将会覆盖掉之前的文件,这里是把文件上传到 “绝对路径”
            uploadFile.transferTo(newFile);
            String filePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/uploadFile/" + format + newName;
             /*文件全路径*/
            String create = req.getSession().getAttribute("uid").toString();
            String downurl = req.getParameter("downurl");
            if(downurl==null||"".equals(downurl)){
                downurl = "暂无下载地址";
            }
            Object addinvitation = invitationservice.addinvitation(
                    new zy_invitation(req.getParameter("title"), req.getParameter("edit"),
                            new Date(), create,
                            0, 0, Integer.parseInt(req.getParameter("type")), filePath,downurl,
                    1,0));
            json = new json_N("上传成功", "/projectlist01");
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.setAttribute("msg", json.getMsg());
        session.setAttribute("view", json.getView());
        return "freemarker/zhongy/Jump";
    }

    @ResponseBody
    @RequestMapping("/QueryLisyts")
    public String QueryLists(){
        List<zy_invitation> zy_invitations = invitationservice.getzy_invitations();
        StringBuffer str = new StringBuffer();
        for (zy_invitation zy:zy_invitations) {
            str.append(zy.getItt_title());
            str.append(zy.getItt_content());
            str.append(zy.getItt_img01());
        }
        return str.toString();
    }

    @RequestMapping("/updateinfoByid/{byid}")
    public String updateUserInfo(@PathVariable("byid")Integer byid,HttpServletRequest request,HttpSession session){
        json_N json = null;
        zy_user zy_user = zy_userService.findByid(byid);
        String boydata = request.getParameter("boydata");
        String type = request.getParameter("type");
        String title = request.getParameter("title");
        zy_user.setUser_remark(type);
        zy_user.setUser_realname(title);
        Integer updateuserinfo = zy_userService.updateuserinfo(zy_user);
        if(updateuserinfo>0){
            json = new json_N("修改成功","/index");
        }else{
            json = new json_N("点击的有点快了歇一会","/index");
        }
        session.setAttribute("msg", json.getMsg());
        session.setAttribute("view", json.getView());
        return "freemarker/Jump";
    }







}
