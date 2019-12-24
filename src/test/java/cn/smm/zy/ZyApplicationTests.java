package cn.smm.zy;

import cn.smm.zy.pojo.zy_user;
import cn.smm.zy.service.zy_userService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ZyApplicationTests {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;
    @Autowired
    private cn.smm.zy.service.zy_userService zy_userService;


    @Test
    void contextLoads() {
        /*SimpleMailMessage smm = new SimpleMailMessage();
        smm.setFrom(from);
        smm.setTo("zhangzhen0280@163.com");
        smm.setSubject("众游网用户验证");
        StringBuffer str = new StringBuffer();
        str.append("尊敬的用户您好！");
        str.append("\n");
        str.append("您正在注册众游网,您的验证码位:6666,请在一分钟之内完整注册,过期则需要重新验证。");
        str.append("\n");
        str.append("By 众游网团队运营");
        str.append("\n");
        str.append("2019年11月11日22:04:47");
        smm.setText(str.toString());
        mailSender.send(smm);*/
        /*zy_user findbyid = zy_userService.findbyid("944358609@qq.com");
        System.out.println(findbyid);*/



     }
    }



