package cn.smm.zy.Controller;

import cn.smm.zy.Util.IKAnalyzerUtil;
import cn.smm.zy.pojo.zy_invitation;
import cn.smm.zy.service.invitationservice;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Dana on 2019/12/24.
 */

@Controller
public class searchController {

    @Autowired
    private cn.smm.zy.service.invitationservice invitationservice;


    @ResponseBody
    @RequestMapping(value = "search",method = RequestMethod.POST)
    public String search(HttpServletRequest req){
        String title = req.getParameter("search_title");
        List<String> list= null;
        try {
            list=IKAnalyzerUtil.cut(title);
        }catch (Exception e){

        }
        System.out.println("分词过后"+list);
        int size = list.size();
        List<zy_invitation> iksearchresult = invitationservice.Iksearchresult(size,list);

        /*List<zy_invitation> iksearchresult = invitationservice.Iksearchresult();*/
        String results = JSON.toJSONString(iksearchresult);
        if(results==""){
            results = "什么也没搜到,换种方式吧!";
        }
        return results;
    }



}
