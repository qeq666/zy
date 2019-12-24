package cn.smm.zy.apl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmail {
    /**
     * 注入发送邮件的接口
     */
    @Autowired
    private JavaMailSender mailSender;


}
