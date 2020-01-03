package cn.smm.zy;

import cn.smm.zy.pojo.zy_invitation;
import cn.smm.zy.pojo.zy_type;
import cn.smm.zy.pojo.zy_user;
import cn.smm.zy.service.invitationservice;
import cn.smm.zy.service.zy_typeService;
import cn.smm.zy.service.zy_userService;
import com.sun.deploy.net.HttpUtils;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
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
    @Autowired
    private cn.smm.zy.service.invitationservice invitationservice;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private cn.smm.zy.service.zy_typeService zy_typeService;

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
        /*List<zy_invitation> findpage = invitationservice.findpage(1, 2);*/
        /*redisTemplate.opsForValue().set("keyNo","1");
        redisTemplate.opsForValue().set("keyToocount","2");*/
        /*System.out.println(redisTemplate.opsForValue().get("keyNo"));*/
        zy_type byid = zy_typeService.findByid(4);
        System.out.println(byid);


       /* List<zy_invitation> zy_invitations = invitationservice.getzy_invitations();
        for (zy_invitation item : zy_invitations){
            zy_user findbyid = zy_userService.findbyid(item.getItt_createid());
            item.setCreateInfo(findbyid.getUser_realname());
            System.out.println("发表人"+item.getCreateInfo());
        }*/
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建Get请求
        HttpGet post = new HttpGet("https://gitee.com/oauth/authorize?client_id=4b53e55ddbbe31027ed50a2ea8facef64e73ac6e14d8a54fd864a6a9c139909f&redirect_uri=http%3A%2F%2F127.0.0.1%3A80%2Findex&response_type=code");
        System.out.println("https://gitee.com/oauth/authorize?client_id=4b53e55ddbbe31027ed50a2ea8facef64e73ac6e14d8a54fd864a6a9c139909f&redirect_uri=http%3A%2F%2F127.0.0.1%3A80%2Findex&response_type=code");
        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Get请求
            response = httpClient.execute(post);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}



