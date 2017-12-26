package test;

import java.io.UnsupportedEncodingException;

import javax.crypto.spec.IvParameterSpec;

import aes_cbc.AES_cbc_decrypt;

public class Test {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String source = "5249f06e1a7cfea9b7288e8590e9a15a054ea80407bd5d5d9db6f39774de1f574b9778607d8ecfdcc4743cd69c3bfaa39e3e56be7b8f312cd8075b3053c2b2bbb516d362bf601c8ee591aee1972b41c8";
		byte[] key = new byte[]{1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6};
		IvParameterSpec iv = new IvParameterSpec(key);
		byte[] result = AES_cbc_decrypt.decrypt(source.getBytes(), key, iv);
		System.out.println(new String(result));
	}
}
