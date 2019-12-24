package cn.smm.zy.Util;


import javax.xml.crypto.Data;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.SimpleFormatter;

/**
 * Created by Dana on 2019/11/21.
 */
public class ToolUtil {

    private static final String SYMBOLS = "0123456789"; // 数字
    private static final Random RANDOM = new SecureRandom();

    /**
     * 日期格式
     * @return
     */
    public static String getDate(){
        Date date = new Date();
        SimpleDateFormat st = new SimpleDateFormat("yyyy-MM-dd");
        String format = st.format(date);
        return format;
    }

    /**
     * 获取长度为 6 的随机数字
     * @return 随机数字
     * @date  创建于 2019年12月3日10:04:11
     */
    public static String getNonce_str() {

        // 如果需要4位，那 new char[4] 即可，其他位数同理可得
        char[] nonceChars = new char[6];

        for (int index = 0; index < nonceChars.length; ++index) {
            nonceChars[index] = SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length()));
        }

        return new String(nonceChars);
    }




}
