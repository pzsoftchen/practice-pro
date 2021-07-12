package com.chen.java.practice.security.digest;

import com.chen.java.practice.security.Hex;
import org.junit.Test;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.DigestInputStream;
import java.security.MessageDigest;

/**
 * Created by chenpz on 2016/9/17.
 */
public class MessageDigestTest {


    @Test
    public void hex() throws Exception {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        byte[] bytes = digest.digest("admin".getBytes(Charset.forName("UTF8")));
        System.out.println(Hex.encodeHexStr(bytes));
    }

    @Test
    public void messageDigest() throws Exception {
        MessageDigest messageDigest = SelfMessageDigest.getInstance().getMessageDigest(MessageDigestAlgorithms.SHA1);
        InputStream inputStream = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\apache-tomcat-8.5.6.zip");
        byte[] buff = new byte[inputStream.available()];
        inputStream.read(buff);
        inputStream.close();
        System.out.println(Hex.encodeHexStr(messageDigest.digest(buff)));
    }

    @Test
    public void messageDigestInputStream() throws Exception {
        MessageDigest messageDigest = SelfMessageDigest.getInstance().getMD5Digest();
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\chenpz\\Downloads\\dubbo-dubbo-2.0.14.zip");
        DigestInputStream digestInputStream = new DigestInputStream(fileInputStream, messageDigest);
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        // byte[] buff = new byte[2048];

        // 不知道流有多长，该方法不保证能得到正确的结果
        byte[] buff = new byte[fileInputStream.available()];

        int len = 0;
        while((len = digestInputStream.read(buff)) != -1){
            arrayOutputStream.write(messageDigest.digest());
        }

        System.out.println(Hex.encodeHexStr(arrayOutputStream.toByteArray()));
        fileInputStream.close();
        digestInputStream.close();
        arrayOutputStream.close();
    }


    @Test
    public void macDigest() throws Exception {
        String pwd = "dayhr0207";
        PBEKeySpec pbeKeySpec = new PBEKeySpec(pwd.toCharArray());
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        SecretKey secretKey = secretKeyFactory.generateSecret(pbeKeySpec);
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(secretKey);
        String source = "hello, world!";
        byte[] destBytes = mac.doFinal(source.getBytes());
        System.out.println(Hex.encodeHexStr(destBytes));
        System.out.println(Hex.encodeHexStr(SelfMessageDigest.getInstance().getMD5Digest().digest(source.getBytes())));
    }

}
