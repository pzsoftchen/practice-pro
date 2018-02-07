package com.chen.java.security.sign;

import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Created by chenpz on 2016/9/18.
 */
public class MySignatureTest {

    private MySignature mySignature;

    @Before
    public void init() {
        mySignature = MySignature.getInstance();
    }

    @Test
    public void sign() throws Exception {
        String source = "dayhrxxxxx!";
        System.out.println(mySignature.sign(source, (PrivateKey)readKeyObj("private.key"), "MD5withRSA"));
    }



    @Test
    public void verify() throws Exception {
        String signatureStr = "JaHd3QWOar0XQHyWuLIhcPKu72XkiFUg0trzDe/AJ70LuYUm5TOxp3Vi3EiWk7pBCZRzj6Gt44lPpkaJaUcYT2VFqj2JcyAS4rGmrfQ7aIvV5HyARYHujfbiS5hgUt5ZTYrUao4C1I5si+KBaDY0+/PVtWzTJomGMC/HUMODGNI=";
        String source = "dayhrxxxxx!";
        System.out.println(mySignature.verify(source, signatureStr, (PublicKey)readKeyObj("public.key"), "MD5withRSA"));
    }


    private Object readKeyObj(String fileName) throws Exception {
        InputStream inputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Object object = objectInputStream.readObject();
        return  object;
    }

}
