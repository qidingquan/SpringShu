package com.ys.qdq.springshu.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2017/11/21.
 * MD5加密工具类
 */

public class MD5Util {
    /**
     * 对字符串md5加密(大写+数字)
     *
     * @param str 传入要加密的字符串
     * @return MD5加密后的字符串
     */

    public static String MD5(String str) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md5.digest(str.getBytes());
            StringBuffer hexValue = new StringBuffer();
            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16)
                    hexValue.append("0");
                hexValue.append(Integer.toHexString(val));
            }
            str = hexValue.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return str;
    }

}
