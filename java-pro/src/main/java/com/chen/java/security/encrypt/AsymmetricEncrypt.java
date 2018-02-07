package com.chen.java.security.encrypt;

import javax.crypto.Cipher;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Base64;

/**
 * Created by chenpz on 2016/9/9.
 */
public class AsymmetricEncrypt {

    private static final String CHARSET_UTF8 = "UTF-8";


    private AsymmetricEncrypt() {}

    private static class AsymmetricEncryptHolder {
        private static AsymmetricEncrypt instance = new AsymmetricEncrypt();

    }

    public static AsymmetricEncrypt getInstance(){
        return AsymmetricEncryptHolder.instance;
    }

    /**
     * 根据所传入的算法生成密钥对(公私钥)
     * @param algorithm
     * @return
     * @throws Exception
     */
    public KeyPair getKeyPair(String algorithm) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        // 密钥长度
        keyPairGenerator.initialize(1024);
        return keyPairGenerator.generateKeyPair();
    }

    public String encrypt(String source, Key key) throws Exception {

        Cipher cipher = Cipher.getInstance(key.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] sourceBytes = source.getBytes(Charset.forName(CHARSET_UTF8));
        return Base64.getEncoder().encodeToString(cipher.doFinal(sourceBytes));
    }

    public String decypt(String destStr, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance(key.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] sourceBytes = cipher.doFinal(Base64.getDecoder().decode(destStr));
        return new String(sourceBytes);
    }
}
