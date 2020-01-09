package cn.smm.zy.Util;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 华为 on 2020/1/3.
 */
public class GiteeUtils {

    /**
     * 获取用户的acctoken
     *
     * @param code
     * @return
     */
    public static JSONObject HqToken(String code) {
        JSONObject object = null;
        CloseableHttpClient client = null;
        HttpResponse httpResponse = null;
        try {
            String url = "https://gitee.com/oauth/token";
            HttpPost httpPost = new HttpPost(url);
            client = HttpClients.createDefault();
            String respContent = null;
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("grant_type", "authorization_code");
            jsonObject.put("code", code);
            jsonObject.put("client_id", "4b53e55ddbbe31027ed50a2ea8facef64e73ac6e14d8a54fd864a6a9c139909f");
            jsonObject.put("redirect_uri", "http://127.0.0.1:80/ht");
            jsonObject.put("client_secret", "d236d392829b611bb9326e844bd4b2708d9f27b1154288bb750f7e6a99ff38fa");
            StringEntity entity = new StringEntity(jsonObject.toString(), "utf-8");
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            //设置User-Agent,否则请求码403
            httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
            httpPost.setEntity(entity);
            System.out.println("into_______GiteeOauth");
            httpResponse = client.execute(httpPost);
            int resultCode = httpResponse.getStatusLine().getStatusCode();
            System.out.println("resultCode:" + resultCode);
            if (resultCode == 200) {
                HttpEntity entity2 = httpResponse.getEntity();
                String result = EntityUtils.toString(entity2);
                System.out.println("响应:" + result);
                object = JSONObject.parseObject(result);
                System.out.println("access_token:" + object.get("access_token"));
                System.out.println("refresh_token:" + object.get("refresh_token"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    /**
     * 根据token换取用户信息
     * @param token
     * @return
     */
    public static JSONObject tokenOninfos(String token) {
        JSONObject object = null;
        CloseableHttpClient client = null;
        HttpResponse httpResponse = null;
        try {
            String url = "https://gitee.com/api/v5/user?access_token="+token;
            System.out.println(url+"阿斯顿撒大所大所大撒");
            HttpGet httpGet = new HttpGet(url);
            client = HttpClients.createDefault();
            String respContent = null;
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("grant_type", "authorization_code");
            StringEntity entity = new StringEntity(jsonObject.toString(), "utf-8");
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            //设置User-Agent,否则请求码403
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
            System.out.println("into_______GiteeOauth");
            httpResponse = client.execute(httpGet);
            int resultCode = httpResponse.getStatusLine().getStatusCode();
            System.out.println("resultCode:" + resultCode);
            if (resultCode == 200) {
                HttpEntity entity2 = httpResponse.getEntity();
                String result = EntityUtils.toString(entity2);
                object = JSONObject.parseObject(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }
}