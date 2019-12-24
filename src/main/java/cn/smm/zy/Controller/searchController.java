package cn.smm.zy.Controller;

import cn.smm.zy.Util.IKAnalyzerUtil;
import cn.smm.zy.pojo.zy_invitation;
import cn.smm.zy.service.invitationservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Dana on 2019/12/24.
 */

@Controller
public class searchController {

    @Autowired
    private cn.smm.zy.service.invitationservice invitationservice;

    
    @RequestMapping("/search")
    public String search(HttpServletRequest req){
        String title = req.getParameter("search_title");
        List<String> list= null;
        try {
            list=IKAnalyzerUtil.cut(title);
        }catch (Exception e){

        }
        System.out.println(list);
        /*List<zy_invitation> iksearchresult = invitationservice.Iksearchresult();*/
        return "";
    }



}
