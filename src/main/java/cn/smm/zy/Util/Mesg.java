package cn.smm.zy.Util;

/**
 * Created by Dana on 2019/11/26.
 */
public class Mesg {
        //0表示成功;-1表示失败
        int status;
        //向前端返回的内容
        String masage;
        public Mesg(){}
        public Mesg(int status, String massage) {
            this.status = status;
            this.masage = massage;
        }
        //get/set方法
    }

