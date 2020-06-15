package com.bcu.xzq;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.MessageDigest;
@Deprecated
public class GetMD5HashCode {

		private GetMD5HashCode() {
			// TODO Auto-generated constructor stub
		}
		
		 public static String md5HashCode32(String filePath) throws FileNotFoundException{  
		    	FileInputStream fis = new FileInputStream(filePath);  
		    	return calMd5HashCode32(fis);  
		    } 
		 
		 public static String calMd5HashCode32(InputStream fis) {
		  		try {
		  			//拿到一个MD5转换器,如果想使用SHA-1或SHA-256，则传入SHA-1,SHA-256  
		  			MessageDigest md = MessageDigest.getInstance("MD5");
		  			
		  			//分多次将一个文件读入，对于大型文件而言，比较推荐这种方式，占用内存比较少。
		  			byte[] buffer = new byte[1024];
		  			int length = -1;
		  			while ((length = fis.read(buffer, 0, 1024)) != -1) {
		  				md.update(buffer, 0, length);
		  			}
		  			fis.close();
		  			
		  			//转换并返回包含16个元素字节数组,返回数值范围为-128到127
		  			byte[] md5Bytes  = md.digest();
		  			StringBuffer hexValue = new StringBuffer();
		  			for (int i = 0; i < md5Bytes.length; i++) {
		  				int val = ((int) md5Bytes[i]) & 0xff;//解释参见最下方
		  				if (val < 16) {
		  					/**
		  					 * 如果小于16，那么val值的16进制形式必然为一位，
		  					 * 因为十进制0,1...9,10,11,12,13,14,15 对应的 16进制为 0,1...9,a,b,c,d,e,f;
		  					 * 此处高位补0。
		  					 */
		  					hexValue.append("0");
		  				}
		  				//这里借助了Integer类的方法实现16进制的转换 
		  				hexValue.append(Integer.toHexString(val));
		  			}
		  			return hexValue.toString();
		  		} catch (Exception e) {
		  			e.printStackTrace();
		  			return "";
		  		}
		  	}
}
