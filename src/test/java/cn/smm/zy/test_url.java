package cn.smm.zy;

import cn.smm.zy.service.loginservice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.util.DigestUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import cn.smm.zy.service.loginservice;

/**
 * Created by Dana on 2019/11/11.
 */
public class test_url {
    @Autowired
    private loginservice loginservice;

    @Test
    public  void test_u() throws Exception {
        urlClimb("http://qun.qzone.qq.com/group");
    }


    //url抓取数据（参数URL：就是你要抓数据的地址。如：http://www.cnev.cn/）
    public static String urlClimb(String url) throws Exception{
        URL getUrl =new URL(url); //创建URl连接
        HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection(); //建立连接
        connection.connect(); //打开连接
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8")); //创建输入流并设置编码
        StringBuffer sb = new StringBuffer();
        String lines = null;
        while ((lines = reader.readLine()) != null) {
            lines = new String(lines.getBytes(), "utf-8"); //读取流的一行,设置编码
            sb = sb.append(lines + "\n");
            System.out.println(sb);
        }
        reader.close(); //关闭流
        connection.disconnect(); //销毁连接
        return sb.toString(); //返回抓取的数据(注意,这里是抓取了访问的网站的全部数据)
    }

    //授权码  QQ邮箱:   ghyaunmpgvhibahh

    @Test
    public void isMD5(){
        String pwd = "dana123";
        String md5Pass = DigestUtils.md5DigestAsHex(pwd.getBytes());
        System.out.println(md5Pass);
        if(md5Pass.equals("45b1c901aa5d4747f1d123a73f9b4482")){
            System.out.println("成功");
        }
    }

    @Test
    public void test_date(){

    }




}
