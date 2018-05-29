package com.zhang.commons;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * Created by Administrator on 2018/5/17.
 */
public class MD5 {
    /**
     * 验证码生成工具
     *
     * @return
     */
    public static String getCode() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    /**
     * MD5概要算法加密
     *
     * @param data
     * @return
     */
    public static String MD5Digest(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] bt = digest.digest(data.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            String str = encoder.encode(bt);
            return str;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
