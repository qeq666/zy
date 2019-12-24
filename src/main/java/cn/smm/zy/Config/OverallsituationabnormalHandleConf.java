package cn.smm.zy.Config;

import cn.smm.zy.Util.json_N;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Dana on 2019/12/24.
 */
@ControllerAdvice
public class OverallsituationabnormalHandleConf {
    @ExceptionHandler({Exception.class})
    public String error(Exception e){
        System.out.println(e.getMessage());
        return "freemarker/500";
    }

}
