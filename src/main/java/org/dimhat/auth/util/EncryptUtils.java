package org.dimhat.auth.util;

import org.dimhat.auth.exception.BizException;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * 加密工具类
 * @author : zwj
 * @data : 2017/3/2
 */
public class EncryptUtils {

    private static final String MD5 = "MD5";

    /**
     * 随机生成salt字符串
     * @return 32位随机字符串
     */
    public static String generateSalt(){
        UUID uuid = UUID.randomUUID();
        String str32 = uuid.toString().replaceAll("-", "");
        return str32;
    }

    public static String md5(String str){
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance(MD5);
        } catch (NoSuchAlgorithmException e) {
            throw new BizException("不支持的加密算法："+MD5);
        }
        //16个字节，一个字节8位256进制。16进制能表示4位，1个字节=2个H进制位
        byte[] bytes = digest.digest(str.getBytes());
        //字节转化为正整数
        return new BigInteger(1,bytes).toString(16);
    }

    //将字节转化成0~255
    private int getUnsignedByte(byte data){
        return data & 0xFF;
    }

    public static void main(String[] args) {
        System.out.println(md5("123456"));//e10adc3949ba59abbe56e057f20f883e
    }
}
