package com.chen.java.security;

/**
 * Created by chenpz on 2016/9/17.
 */
public class Hex {

    public static String encodeHexStr(byte[] bytes){

        if (bytes == null || bytes.length == 0)
            return null;

        String result="";
        for (int i = 0; i < bytes.length; i++){
            result += Integer.toHexString((0x000000ff & bytes[i]) | 0xffffff00).substring(6);
        }
        return result;
    }

    public static byte[] hexToBytes(String hexStr) {

        //hexString的长度对2取整，作为bytes的长度
        int len = hexStr.length() / 2;
        byte[] bytes = new byte[len];
        byte high = 0;//字节高四位
        byte low = 0;//字节低四位

        for(int i = 0; i < len; i ++){
            //右移四位得到高位
            high = (byte)((hexStr.indexOf(hexStr.charAt(2*i)))<<4);
            low = (byte)hexStr.indexOf(hexStr.charAt(2*i+1));
            bytes[i] = (byte) (high|low);//高地位做或运算
        }
        return bytes;
    }


}
