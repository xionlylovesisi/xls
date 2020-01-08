package com.xlm.common.util;

import org.apache.commons.net.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.MessageDigest;

public class CrypUtil {
    private static final String AESTYPE = "AES/ECB/PKCS5Padding";

    public CrypUtil() {
    }

    public static String AES_Encrypt(String keyStr, String plainText) {
        Object var2 = null;

        try {
            Key key = populateAESKey(keyStr);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(1, key);
            byte[] encrypt = cipher.doFinal(plainText.getBytes("UTF8"));
            return Base64.encodeBase64String(encrypt);
        } catch (Exception var5) {
            throw new RuntimeException(var5);
        }
    }

    public static String AES_Decrypt(String keyStr, String encryptData) {
        Object var2 = null;

        try {
            Key key = populateAESKey(keyStr);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(2, key);
            byte[] decrypt = cipher.doFinal(Base64.decodeBase64(encryptData));
            return (new String(decrypt)).trim();
        } catch (Exception var5) {
            throw new RuntimeException(var5);
        }
    }

    private static Key populateAESKey(String key) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes("UTF8"), "AES");
        return keySpec;
    }

    public static String MD5_Encrypt(String plainText) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(plainText.getBytes("UTF8"));
            byte[] encryptByte = md5.digest();
            return bytesToHexString(encryptByte);
        } catch (Exception var4) {
            throw new RuntimeException("加密失败", var4);
        }
    }

    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src != null && src.length > 0) {
            for(int i = 0; i < src.length; ++i) {
                int v = src[i] & 255;
                String hv = Integer.toHexString(v);
                if (hv.length() < 2) {
                    stringBuilder.append(0);
                }

                stringBuilder.append(hv);
            }

            return stringBuilder.toString();
        } else {
            return null;
        }
    }

    public static byte[] stringToBytes(String content, String charset) {
        try {
            return charset != null ? content.getBytes(charset) : content.getBytes();
        } catch (Exception var3) {
            throw new RuntimeException(var3);
        }
    }
}