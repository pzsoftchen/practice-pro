package com.chen.java.practice.security.encrypt;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.nio.charset.Charset;
import java.util.Base64;

/**
 * Created by chenpz on 2016/9/9.
 */
public class SymmetricEncrypt {

    private static final String CHARSET_UTF8 = "UTF-8";

    private SymmetricEncrypt(){}

    private static class SymmetricEncryptHolder {
        private static SymmetricEncrypt instance = new SymmetricEncrypt();
    }

    public static SymmetricEncrypt getInstance(){
        return SymmetricEncryptHolder.instance;
    }
    /**
     * 1. 产生密钥
     * 2. 使用密钥加密
     */
    public SecretKey getSecretKey(String algorithm) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
        return keyGenerator.generateKey();
    }

    /**
     * 基于口令的加密密钥获取
     * @param pwd
     * @param algorithm
     * @return
     * @throws Exception
     */
    public SecretKey getSecretKeyBasePwd(String pwd, String algorithm) throws Exception{
        PBEKeySpec pbeKeySpec = new PBEKeySpec(pwd.toCharArray());
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(algorithm);
        return  secretKeyFactory.generateSecret(pbeKeySpec);
    }

    public String encrypt(String source, SecretKey secretKey, String salt) throws Exception {

        Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
        if (salt != null){
            PBEParameterSpec ps = new PBEParameterSpec(salt.getBytes(), 1000);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ps);
        }else{
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        }
        byte[] sourceBytes = source.getBytes(Charset.forName(CHARSET_UTF8));
        return Base64.getEncoder().encodeToString(cipher.doFinal(sourceBytes));
    }

    public String decypt(String destStr, SecretKey secretKey, String salt) throws Exception {
        Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
        if (salt != null){
            PBEParameterSpec ps = new PBEParameterSpec(salt.getBytes(), 1000);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ps);
        }else{
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
        }
        byte[] sourceBytes = cipher.doFinal(Base64.getDecoder().decode(destStr));
        return new String(sourceBytes);
    }


}
