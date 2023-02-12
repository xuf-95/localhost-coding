package com.funcation.udf;


import org.apache.commons.codec.binary.Base64;
import org.apache.hadoop.hive.ql.exec.UDF;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;



/**
 * @ClassName: AesEncrypt
 * @Description: TODO:
 * @Version: 1.0
 * @User: dandypeng
 * @Date: 2023/2/8 23:48
 * @E-Mail: pfux163@163.com
 **/
public class AesEncrypt extends UDF {
    /*
     * 加密用的Key 可以用26个字母和数字组成 使用AES-128-CBC加密模式，key需要为16位。
     */
    private static final String iv = "NIfb&95GUY86Gfgh";

    public String evaluate(String data, String key) throws Exception {
        try {
            if (data == null || data.length() == 0) {
                return null;
            }

            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();
            byte[] dataBytes = data.getBytes();
            int plaintextLength = dataBytes.length;

            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }

            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);

            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            // CBC模式，需要一个向量iv，可增加加密算法的强度
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());

            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);
            // BASE64做转码。
            return AesEncrypt.encode(encrypted).trim();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decryptAES(String data, String key) throws Exception {
        try
        {
            //先用base64解密
            byte[] encrypted1 = AesEncrypt.decode(data);

            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());

            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);

            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            return originalString.trim();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] decode(String base64EncodedString) {
        return new Base64().decode(base64EncodedString);
    }

    private static String encode(byte[] byteArray) {
        return new String(new Base64().encode(byteArray));
    }


    public static void main(String[] args) {

    }
}
