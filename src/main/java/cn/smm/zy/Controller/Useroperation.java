package cn.smm.zy.Controller;

import cn.smm.zy.Util.Mesg;
import cn.smm.zy.Util.ToolUtil;
import cn.smm.zy.pojo.zy_invitation;
import cn.smm.zy.service.invitationservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.UUID;
import cn.smm.zy.service.invitationservice;

/**
 * Created by Dana on 2019/11/21.
 * 用户登陆之后操作
 */
@Controller
public class Useroperation {

    @Autowired
    private invitationservice invitationservice;



    /*发帖*/
    @ResponseBody
    @PostMapping("/upload1111111111111")
    public Object upload(HttpServletRequest req, @RequestParam("file") MultipartFile file, Model model) {
        if(req.getParameter("title").equals("")||req.getParameter("title").equals(null)){
            return "上传失败，标题为空.<a href='sendf'>继续发帖</a><a href='index'>=返回首页</a>";
        }else{
            if (!file.isEmpty()) {
                //获取文件名
                String fileName = file.getOriginalFilename();
                //获取文件后缀名
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                //重新生成文件名
                fileName = UUID.randomUUID()+suffixName;
                //指定本地文件夹存储图片
                /*String filePath = "D:";*/
                String filePath = "D:/DAN/";
                try {
                    //将图片保存到static文件夹里
                    String create = req.getSession().getAttribute("uid").toString();
                    file.transferTo(new File(filePath+fileName));
                    System.out.println("title"+req.getParameter("title")+"Data"+req.getParameter("edit")
                            +"sj"+ToolUtil.getDate()+"create="+create+"000"+"img"+filePath + fileName.toString()
                    );
                    Object addinvitation = invitationservice.addinvitation(
                            new zy_invitation(req.getParameter("title"), req.getParameter("edit"),
                            new Date(), create,
                            0, 0, 0, filePath + fileName.toString(),null,1
                    ,0));

                    return "上传成功，"+addinvitation+".<a href='sendf'>继续发帖</a><a href='index'>=返回首页</a>";
                } catch (Exception e) {
                    e.printStackTrace();
                    return new Mesg(-1,"上传失败");
                }
            } else {
                return "上传失败，因为文件是空的.<a href='sendf'>继续发帖</a><a href='index'>=返回首页</a>";
            }
        }






    }



}
