package security;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


/**
 * javaʵ��AES256���ܽ���
 * ����˵����
 * bcprov-jdk15-133.jar��PKCS7Padding
 * javabase64-1.3.1.jar��base64
 * local_policy.jar �� US_export_policy.jar����ӵ�%JAVE_HOME%\jre\lib\security�У�lib�а汾�ʺ�jdk1.7��
 */

public class AES256{
	
	

    public static String encrypt(String content, String password) {
        try {
            //"AES"���������Կ�㷨�ı�׼����
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            //256����Կ���ɲ�����securerandom����Կ�����������Դ
            SecureRandom securerandom = new SecureRandom(tohash256Deal(password));
            kgen.init(256, securerandom);
            //�������ܣ��Գƣ���Կ
            SecretKey secretKey = kgen.generateKey();
            //���ػ��������ʽ����Կ
            byte[] enCodeFormat = secretKey.getEncoded();
            //���ݸ������ֽ����鹹��һ����Կ��enCodeFormat����Կ���ݣ�"AES"�����������Կ�������������Կ�㷨������
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            //���ṩ������ӵ���һ������λ��
            Security.addProvider(new BouncyCastleProvider());
            //����һ��ʵ��ָ��ת���� Cipher���󣬸�ת����ָ�����ṩ�����ṩ��
            //"AES/ECB/PKCS7Padding"��ת�������ƣ�"BC"���ṩ���������
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");

            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] byteContent = content.getBytes("utf-8");
            byte[] cryptograph = cipher.doFinal(byteContent);
            Base64 base64 = new Base64();
            return base64.encodeAsString(cryptograph);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    
    
    
    public static String decrypt(byte[] cryptograph, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom securerandom = new SecureRandom(tohash256Deal(password));
            kgen.init(256, securerandom);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");

            cipher.init(Cipher.DECRYPT_MODE, key);
            Base64 base64 = new Base64();
            byte[] content = cipher.doFinal(base64.decode(cryptograph));
            return new String(content);
        } catch (Exception e) {
                    e.printStackTrace();
        }
        return null;
    }

    
    
    private static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /*private static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length()/2];
        for (int i = 0;i< hexStr.length()/2; i++) {
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }*/

    private static byte[] tohash256Deal(String datastr) {
        try {
            MessageDigest digester = MessageDigest.getInstance("SHA-256");
            digester.update(datastr.getBytes());
            byte[] hex = digester.digest();
            return hex;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

   
}