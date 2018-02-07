package com.chen.java.security.encrypt;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.security.Key;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Created by chenpz on 2016/9/17.
 */
public class AsymmetricEncryptTest {

    private static final String ALGORITHM_RSA = "RSA";


    private AsymmetricEncrypt asymmetricEncrypt;
    @Before
    public void init(){
        asymmetricEncrypt = AsymmetricEncrypt.getInstance();
    }

    @Test
    public void getKeyPair() throws Exception {
        KeyPair keyPair = asymmetricEncrypt.getKeyPair(ALGORITHM_RSA);
        // 获取公钥
        PublicKey publicKey = keyPair.getPublic();
        saveKey("public.key", publicKey);
        // 获取私钥
        PrivateKey privateKey = keyPair.getPrivate();
        saveKey("private.key", privateKey);
    }


    @Test
    public void encrypt() throws Exception {
        //String desBase64 = asymmetricEncrypt.encrypt("hello, world!", (PublicKey)readKeyObj("public.key"));
        String desBase64 = asymmetricEncrypt.encrypt("hello, world!", (PrivateKey)readKeyObj("private.key"));
        System.out.println(desBase64);
    }


    @Test
    public void decypt() throws Exception {
        String destStr_rsa_pb = "G8Ydfm5B1jaSjFaVXmwdUfyGIdqeYi11OwCBx9XF0O4jIfW5h/S0BMMmWOrnkOWrTG4DQrHVsuOJmnRMY0xcpY58unBKwsZ9UruwQ9spSByXyFz2FJ4TcP20ZL7wqggYQ5QloENIggnsZ3m/rmvB9pFMavozW2ZVv3xY2wb2SoE=";
        String destStr_rsa_pr = "CoMVqN2PsAZhsxI2z3tGo6V1uOlnEYRA9LyfzE74+CdXUa52BLxuFrQ5KHEOk5WbPV1kuXq754ewhbffZ4Y/J89PalK3JFVdEMQm/XHNROFtmiDcszjDLKQiZuen1SW7oQ3QYUNKR3cXfe8uuYVog/7LM97gA8mJBoiSYkqXXLk=";
        //String soure = asymmetricEncrypt.decypt(destStr_rsa_pb, (PrivateKey)readKeyObj("private.key"));
        String soure = asymmetricEncrypt.decypt(destStr_rsa_pr, (PublicKey)readKeyObj("public.key"));
        System.out.println(soure);
    }


    private void saveKey(String fileName, Key key) throws Exception {
        OutputStream outputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(key);
        objectOutputStream.close();
        outputStream.close();
    }

    private Object readKeyObj(String fileName) throws Exception {
        InputStream inputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Object object = objectInputStream.readObject();
        return  object;
    }

}
