package com.chen.java.practice.security.cer;

import org.junit.Before;
import org.junit.Test;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

/**
 * CertificateTest
 *
 * @author Chenpz
 * @package com.chen.java.security.cer
 * @date 2016/10/12/16:55
 */
public class CertificateTest {

    private MyCertificate myCertificate;

    @Before
    public void init() {
        myCertificate = MyCertificate.getInstance();
    }

    @Test
    public void getCerKeyStore () throws Exception{
        Certificate certificate = myCertificate.getCerKeyStore("C:\\Users\\Lenovo\\.keystore","123456","dayhr");
        printDetail(certificate);
    }

    @Test
    public void getCerFile() throws Exception {
        Certificate certificate = myCertificate.getCerFile("dayhr.cer");
//        printDetail(certificate);
    }

    @Test
    public void sign(){

    }

    private void printDetail(Certificate certificate) throws Exception {
        X509Certificate x509cert = (X509Certificate)certificate;
        x509cert.checkValidity();
        System.out.println("版本：" +  x509cert.getVersion());
        System.out.println("公钥：" + x509cert.getPublicKey());
        System.out.println("签名：" + x509cert.getSignature());
        System.out.println("签名算法：" + x509cert.getSigAlgName());
        System.out.println("类型：" + x509cert.getType());
        System.out.println("证书所有者：" + x509cert.getSubjectDN());
        System.out.println("证书发布者：" + x509cert.getIssuerDN());
        System.out.println("证书起始有效日期：" + x509cert.getNotBefore());
        System.out.println("证书终止有效日期：" + x509cert.getNotAfter());
    }





}
