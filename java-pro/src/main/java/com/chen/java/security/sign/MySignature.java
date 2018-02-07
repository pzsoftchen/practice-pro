package com.chen.java.security.sign;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

/**
 * Created by chenpz on 2016/9/18.
 */
public class MySignature {

    private MySignature() {}

    private static class MySignatureHolder {
        private static MySignature instance = new MySignature();
    }

    public static MySignature getInstance() {
        return MySignatureHolder.instance;
    }

    /**
     *
     * @param source
     * @param algorithm
     * @return
     * @throws Exception
     */
    public String sign(String source, PrivateKey privateKey, String algorithm) throws Exception {
        Signature signature = Signature.getInstance(algorithm);
        signature.initSign(privateKey);
        signature.update(source.getBytes());
        byte[] signBytes = signature.sign();
        return Base64.getEncoder().encodeToString(signBytes);
    }


    public boolean verify(String source, String base64Str, PublicKey publicKey, String algorithm) throws Exception {
        Signature signature = Signature.getInstance(algorithm);
        signature.initVerify(publicKey);
        signature.update(source.getBytes());
        return signature.verify(Base64.getDecoder().decode(base64Str));
    }

}
