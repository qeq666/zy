package cn.smm.zy.Controller;

import cn.smm.zy.Util.IKAnalyzerUtil;
import cn.smm.zy.Util.json_N;
import cn.smm.zy.pojo.zy_homepage;
import cn.smm.zy.pojo.zy_invitation;
import cn.smm.zy.pojo.zy_type;
import cn.smm.zy.service.invitationservice;
import cn.smm.zy.service.zy_homepageService;
import cn.smm.zy.service.zy_typeService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dana on 2019/12/24.
 */

@Controller
public class searchController {

    @Autowired
    private cn.smm.zy.service.invitationservice invitationservice;
    @Autowired
    private zy_typeService type;
    @Autowired
    private cn.smm.zy.service.zy_homepageService zy_homepageService;

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String search(HttpServletRequest req, HttpSession session) {
        json_N js = null;
        List<zy_invitation> items = new ArrayList<zy_invitation>();
        String title = req.getParameter("search_title");
        List<String> list = null;
        try {
            list = IKAnalyzerUtil.cut(title);
        } catch (Exception e) {

        }
        /*System.out.println("分词过后" + list);*/
        int size = list.size();
        List<zy_invitation> iksearchresult = invitationservice.Iksearchresult(size, list);

        /*List<zy_invitation> iksearchresult = invitationservice.Iksearchresult();*/
/*        String results = JSON.toJSONString(iksearchresult);*/
        /*if (results == "") {
            results = "什么也没搜到,换种方式吧!";
        }*/

        if("".equals(iksearchresult)||null==iksearchresult){
            js = new json_N("什么也没搜到,换种姿势试试吧!","index");
        }else{
            for (zy_invitation zy : iksearchresult) {
                String apls = type.eqapls(zy.getItt_type());
                zy.setType(apls);
                items.add(zy);
            }
            List<zy_homepage> zy_homepages = zy_homepageService.QueryHome();
                session.setAttribute("idxinfo", zy_homepages.get(0));
            js = new json_N("正在加载中.......","index");
        }
        List<zy_type> apls = type.apls();
        req.setAttribute("itts", items);
        req.setAttribute("apls", apls);
        session.setAttribute("msg",js.getMsg());
        session.setAttribute("view",js.getView());
        System.out.println("11111111111111111111111111111");
        return "freemarker/index";
}



}
