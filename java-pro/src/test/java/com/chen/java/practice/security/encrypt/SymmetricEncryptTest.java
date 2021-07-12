package com.chen.java.practice.security.encrypt;

import org.junit.Before;
import org.junit.Test;
import sun.security.jca.ProviderList;
import sun.security.jca.Providers;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKey;
import java.io.*;
import java.security.Provider;
import java.util.Base64;
import java.util.List;
import java.util.Set;

/**
 * Created by chenpz on 2016/9/9.
 */
public class SymmetricEncryptTest {

    private static final String ALGORITHM_DES = "DES";
    private static final String ALGORITHM_AES = "AES";
    private static final String ALGORITHM_DESEDE = "DESede";
    private static final String ALGORITHM_BLOWFISH = "Blowfish";
    // 基于口令加密的算法
    private static final String ALGORITHM_PBEWITHMD5ANDDES = "PBEWithMD5AndDES";

    private SymmetricEncrypt symmetricEncrypt;
    @Before
    public void init(){
        symmetricEncrypt = SymmetricEncrypt.getInstance();
    }

    @Test
    public void test1() {
        ProviderList providerList = Providers.getProviderList();
        List<Provider> providersList = providerList.providers();
        for (Provider provider: providersList){
            System.out.println("============================"+provider.getName());
            Set<Provider.Service> serviceSet = provider.getServices();
            for (Provider.Service service:serviceSet){
                System.out.println(service.getAlgorithm());
            }
            System.out.println("============================ end");
        }
    }

    @Test
    public void getSecretKey() throws Exception {
        SecretKey secretKey = symmetricEncrypt.getSecretKey(ALGORITHM_AES);
        OutputStream outputStream = new FileOutputStream(ALGORITHM_AES+".key");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(secretKey);
        objectOutputStream.close();
        outputStream.close();
    }

    @Test
    public void encrypt() throws Exception{
        String desBase64 = symmetricEncrypt.encrypt("hello, world!", readSecretKey(), null);
        System.out.println(desBase64);
    }

    @Test
    public void decypt() throws Exception {
        String destStr_des = "3nwhflaEdf7T6+iJK8IsJA==";
        String destStr_3des = "8l4HDDrFDOD6K+QTmr6vlg==";
        String destStr_aes = "vvULvdHvHzl4E4ezzOTx8se3H8szrgpMuiygNE3RJ8o";
        String soure = symmetricEncrypt.decypt(destStr_aes, readSecretKey(), null);
        System.out.println(soure);
    }

    @Test
    public void encryptBasePBE() throws Exception {
        String passwd = "dayhr0207";
        SecretKey secretKey = symmetricEncrypt.getSecretKeyBasePwd(passwd, ALGORITHM_PBEWITHMD5ANDDES);
        String salt = "12345678";
        String desBase64 = symmetricEncrypt.encrypt("hello, world!", secretKey, salt);
        System.out.println(desBase64);
    }

    @Test
    public void decyptBasePBE() throws Exception {
        String passwd = "dayhr0208";
        SecretKey secretKey = symmetricEncrypt.getSecretKeyBasePwd(passwd, ALGORITHM_PBEWITHMD5ANDDES);
        String salt = "12345678";
        String dest_str = "W73zovlWbruBnv6MdiKk3Q==";
        String soure = symmetricEncrypt.decypt(dest_str, secretKey, salt);
        System.out.println(soure);
    }


    @Test
    public void encryptInputStream() throws Exception {

        SecretKey key = readSecretKey();
        Cipher cipher = Cipher.getInstance(ALGORITHM_AES);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        // 读取要加密的原文件aes_source.dat
        InputStream inputStream = new FileInputStream("aes_source.dat");
        CipherInputStream cipherInputStream = new CipherInputStream(inputStream, cipher);
        // 加密后的文件存放到aes_des.dat
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buff = new byte[128];
        int len = 0;
        while ((len = (cipherInputStream.read(buff))) != -1){
            byteArrayOutputStream.write(buff, 0, len);
        }

        String base64Str = new String(Base64.getEncoder().encode(byteArrayOutputStream.toByteArray()));
        System.out.println(base64Str);

        OutputStream outputStream = new FileOutputStream("aes_des.dat");
        byteArrayOutputStream.writeTo(outputStream);
        byteArrayOutputStream.flush();
        inputStream.close();
        cipherInputStream.close();
        byteArrayOutputStream.close();
        outputStream.close();
    }

    @Test
    public void decyptInputStream() throws Exception {

        SecretKey key = readSecretKey();
        Cipher cipher = Cipher.getInstance(ALGORITHM_AES);
        cipher.init(Cipher.DECRYPT_MODE, key);
        // 读取要加密的原文件aes_source.dat
        InputStream inputStream = new FileInputStream("aes_des.dat");
        CipherInputStream cipherInputStream = new CipherInputStream(inputStream, cipher);
        // 加密后的文件存放到aes_des.dat
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buff = new byte[128];
        int len = 0;
        while ((len = (cipherInputStream.read(buff))) != -1){
            byteArrayOutputStream.write(buff, 0, len);
        }
        System.out.println(new String (byteArrayOutputStream.toByteArray()));
        inputStream.close();
        cipherInputStream.close();
        byteArrayOutputStream.close();
    }

    private SecretKey readSecretKey() throws Exception {
        InputStream inputStream = new FileInputStream(ALGORITHM_AES+".key");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Object object = objectInputStream.readObject();
        SecretKey secretKey = (SecretKey)object;
        return  secretKey;
    }

}
