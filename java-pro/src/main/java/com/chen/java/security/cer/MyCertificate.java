package com.chen.java.security.cer;


import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

/**
 * MyCertificateHandler
 *
 * @author Chenpz
 * @package com.chen.java.security.cer
 * @date 2016/10/12/16:43
 */
public class MyCertificate {

    private MyCertificate() {}

    private static class MyCertificateHolder {
        private static MyCertificate instance = new MyCertificate();
    }

    public static MyCertificate getInstance() {
        return MyCertificateHolder.instance;
    }


    public Certificate getCerKeyStore(String keystorePath, String keyStorePasswd, String cerName) throws Exception{

        KeyStore keyStore = KeyStore.getInstance("jks");
        FileInputStream fis = new FileInputStream(keystorePath);
        keyStore.load(fis, keyStorePasswd.toCharArray());
        fis.close();
        return  keyStore.getCertificate(cerName);
    }

    public Certificate getCerFile(String cerFile) throws Exception{
        CertificateFactory factory = CertificateFactory.getInstance("X.509");
        FileInputStream fis = new FileInputStream(cerFile);
        Certificate cert = factory.generateCertificate(fis);
        fis.close();
        return cert;
    }

}
