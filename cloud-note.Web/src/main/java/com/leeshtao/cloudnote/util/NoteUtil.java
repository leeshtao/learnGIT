package com.leeshtao.cloudnote.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import asn.utils.BinaryAndHexUtil;

public class NoteUtil {
	public static String md5(String src){
		try {
			//获取MD5对象
			
			MessageDigest md=MessageDigest.getInstance("MD5");
			//加密处理
			byte[] output = md.digest(src.getBytes());
			String ret = BinaryAndHexUtil.bytesToHexString(output, false);
			return ret;
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		return src;
	}
	
	//利用UUID生成主键值
	public static String createId(){
		String id=UUID.randomUUID().toString();
		return id;	
	}
	
	public static void main(String[] args){
		
		String ret = md5("123456");
		System.out.println(ret);
		System.out.println(md5("123456"));
	}
}
