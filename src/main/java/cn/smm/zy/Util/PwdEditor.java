package cn.smm.zy.Util;

import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PwdEditor {
    public static String encodeByMd5(String string)  {
        String dana123;
        dana123 = DigestUtils.md5DigestAsHex("dana123".getBytes());
        return dana123;
    }

    public static void main(String[] args) {
        String dana123 = PwdEditor.encodeByMd5("dana123");
        System.out.println(dana123);
    }
}
