package aes_cbc;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES_CBC {

	public static final String RAN_TIME_STR = "1111111111111111";
	
	public static byte[] getIv(){
		byte[] iv = new byte[16];
		long time = System.currentTimeMillis();
		Random random = new Random(time);
		
		long ranTime = random.nextLong();
		String ranTimeStr = String.valueOf(ranTime)+RAN_TIME_STR;
		System.arraycopy(ranTimeStr.getBytes(), 0, iv, 0, iv.length);
		return iv;
	}
	
	 // 加密
    public static byte[] encrypt(byte[] srcData,String key) {
    	Cipher cipher;
    	if (key == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (key.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
		try {
			byte[] raw = key.getBytes("utf-8");
	    	SecretKeySpec keySpec = new SecretKeySpec(raw, "AES");
	    	//"算法/模式/补码方式"
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(getIv()));
	        byte[] encData = cipher.doFinal(srcData);
	        return encData;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
        
    }
	
	
	// 解密
    public static byte[] decrypt(byte[] encData,byte[] key) throws UnsupportedEncodingException 
    {
        Cipher cipher;
        if (key == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (key.length != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
		try {
//			byte[] raw = key.getBytes("utf-8");
	    	SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(getIv()));
	        byte[] decbbdt = cipher.doFinal(encData);
	        return decbbdt;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
        return null;
    }
}
