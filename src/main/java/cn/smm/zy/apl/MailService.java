package cn.smm.zy.apl;

import javax.mail.MessagingException;

public interface MailService {
    /**
     * 发送html格式的邮件
     *
     * @param to
     * @param subject
     * @param content
     */
    void sendHtmlMail(String to, String subject, String content) throws MessagingException;

}

