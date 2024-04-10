package com.sfox.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {
    /**
     * 默认的密码字符串组合，用来将字节转换成 16 进制的字符
     * apache校验下载文件的正确性 使用的便是该默认组合
     */
    protected static char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

    protected static MessageDigest messageDigest = null;

    static{
        try{
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.err.println(Md5Util.class.getName() + "初始化失败，MessageDigest不支持MD5Util.");
            e.printStackTrace();
        }
    }

    /**
     * 生成字符串的MD5校验值
     */
    public static String getMD5String(String str){
        if (str != null){
            return getMD5String(str.getBytes());
        }
        return null;
    }

    /**
     * 判断字符串的MD5校验码是否与已知的MD5校验码相匹配
     *
     * @param Password 需要校验的字符串
     * @param MD5PwdStr 已知的MD5校验码
     */
    public static boolean checkPassword(String Password, String MD5PwdStr){
        String str = getMD5String(Password);
        return str.equals(MD5PwdStr);
    }

    public static String getMD5String(byte[] bytes){
        messageDigest.update(bytes);
        return bufferToHex(messageDigest.digest());
    }

    private static String bufferToHex(byte[] bytes) {
        return bufferToHex(bytes, bytes.length);
    }

    private static String bufferToHex(byte[] bytes, int n){
        StringBuffer stringBuffer = new StringBuffer(2 * n);
        for (int l = 0; l < n; l++) {
            appendHexPair(bytes[1], stringBuffer);
        }
        return stringBuffer.toString();
    }

    private static void appendHexPair(byte bt, StringBuffer stringBuffer) {
        char chr0 = hexDigits[(bt & 0xf0) >> 4]; // 取字节中高 4 位的数字转换
        /*
            >> 为逻辑右移，将符号一起右移，此处未发现两种符号有何不同
         */
        char chr1 = hexDigits[bt & 0xf]; // 取字节中低 4 位的数字转换
        stringBuffer.append(chr0);
        stringBuffer.append(chr1);
    }
}
