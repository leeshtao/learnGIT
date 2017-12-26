package test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import javax.crypto.spec.IvParameterSpec;

import aes_cbc.AES_cbc_decrypt;
import aes_cbc.AES_cbc_encrypt;
import util.BinaryAndHexUtil;

public class AESCBCTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
	        
	        String key= "1234567812345678";
	        byte[] iv = new byte[16];
	                
	        String srcStr = "This is java default pkcs5padding PKCS5 TEST";
	        System.out.println("srcStrLength:"+srcStr.length());
	        System.out.println("加密前:"+srcStr);
	
	        //设置iv，全1，这里测试用
            for (int i = 0; i <16; i++) {
	            	iv[i] = 1;
	        }
	
            // 加密
            System.out.println("********加密********");
	        byte[] encbt = AES_cbc_encrypt.encrypt(srcStr.getBytes(),key,iv);
	        System.out.println("加密后的长度:"+encbt.length);
	        System.out.println("加密后"+Arrays.toString(encbt));
	        // 转换成ASCII码
	        String encbtStr = BinaryAndHexUtil.parseByte2HexStr(encbt);
	        System.out.println("转换ASCII码:"+encbtStr);
	        System.out.println("转换ASCII码后的长度:"+encbtStr.length());
	        
	        // 解密
	        System.out.println("********解密********");
	        // 转换成byte数组
	        byte[] decbtFrom = BinaryAndHexUtil.parseHexStr2Byte(encbtStr);
	        System.out.println("转换byte数组:"+Arrays.toString(decbtFrom));
	        
	        byte[] decbt = AES_cbc_decrypt.decrypt(decbtFrom,key.getBytes(),new IvParameterSpec(iv));
	        String decStr = new String(decbt);
	        System.out.println("解密后:"+decStr);
	        
	        if(srcStr.equals(decStr))
	        {
	            System.out.println("TEST PASS");
	        }else
	        {
	            System.out.println("TEST NO PASS");
	        }
	
    }
}
