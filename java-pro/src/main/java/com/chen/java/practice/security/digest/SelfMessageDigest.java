package com.chen.java.practice.security.digest;

import com.chen.java.practice.security.Hex;

import java.security.MessageDigest;

/**
 * Created by chenpz on 2016/9/17.
 */
public class SelfMessageDigest {


    private SelfMessageDigest(){}

    private static class MessageDigestHolder {
        private static SelfMessageDigest instance = new SelfMessageDigest();
    }

    public static SelfMessageDigest getInstance(){
        return MessageDigestHolder.instance;
    }

    public MessageDigest getMessageDigest(String algorithm) throws Exception{
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        return messageDigest;
    }

    public MessageDigest getMD2Digest() throws Exception{
        return getMessageDigest(MessageDigestAlgorithms.MD2);
    }

    public MessageDigest getMD5Digest() throws Exception{
        return getMessageDigest(MessageDigestAlgorithms.MD5);
    }

    public MessageDigest getSHA1Digest() throws Exception{
        return getMessageDigest(MessageDigestAlgorithms.SHA1);
    }

    public MessageDigest getSHA224Digest() throws Exception{
        return getMessageDigest(MessageDigestAlgorithms.SHA224);
    }

    public MessageDigest getSHA256Digest() throws Exception{
        return getMessageDigest(MessageDigestAlgorithms.SHA256);
    }

    public MessageDigest getSHA384Digest() throws Exception{
        return getMessageDigest(MessageDigestAlgorithms.SHA384);
    }

    public MessageDigest getSHA512Digest() throws Exception{
        return getMessageDigest(MessageDigestAlgorithms.SHA512);
    }

    public String getMessageDigestEncodeHex(byte[] sourceBytes, String algorithm) throws Exception {
        return Hex.encodeHexStr(getMessageDigest(algorithm).digest(sourceBytes));
    }

    public String md5ToHex(byte[] sourceBytes) throws Exception {
        return Hex.encodeHexStr(getMD5Digest().digest(sourceBytes));
    }

    public String sha1ToHex(byte[] sourceBytes) throws Exception {
        return Hex.encodeHexStr(getSHA1Digest().digest(sourceBytes));
    }

    public String sha256ToHex(byte[] sourceBytes) throws Exception {
        return Hex.encodeHexStr(getSHA256Digest().digest(sourceBytes));
    }
}
