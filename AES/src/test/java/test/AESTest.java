package test;


import entity.bytes.*;
import util.BinaryAndHexUtil;

public class AESTest {
	public static void main(String[] args) {
		String content = "testtesttesttest";  
		String password = "12345678";  
		//加密  
		System.out.println("加密前：" + content);  
		byte[] encryptResult = AESencrypt.encrypt(content.getBytes(), password);
		//加密后
		System.out.println("加密后:"+new String(encryptResult).length());
		//编译成ASCII码
		String encryptStr = BinaryAndHexUtil.parseByte2HexStr(encryptResult);
		//转换后
		System.out.println("byte转换ASCII后:"+encryptStr);
		
		//解密 
		//先将ASCII码转换成byte数组
		byte[] decrypt = BinaryAndHexUtil.parseHexStr2Byte(encryptStr);
		//转换后
		System.out.println("ASCII转换byte后:"+new String(decrypt));
		byte[] decryptResult = AESdecrypt.decrypt(decrypt,password);  
		System.out.println("解密后：" + new String(decryptResult));  
		
		System.out.println((System.currentTimeMillis()+"").length());
	}
}
