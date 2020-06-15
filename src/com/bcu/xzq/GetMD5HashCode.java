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
		  			//�õ�һ��MD5ת����,�����ʹ��SHA-1��SHA-256������SHA-1,SHA-256  
		  			MessageDigest md = MessageDigest.getInstance("MD5");
		  			
		  			//�ֶ�ν�һ���ļ����룬���ڴ����ļ����ԣ��Ƚ��Ƽ����ַ�ʽ��ռ���ڴ�Ƚ��١�
		  			byte[] buffer = new byte[1024];
		  			int length = -1;
		  			while ((length = fis.read(buffer, 0, 1024)) != -1) {
		  				md.update(buffer, 0, length);
		  			}
		  			fis.close();
		  			
		  			//ת�������ذ���16��Ԫ���ֽ�����,������ֵ��ΧΪ-128��127
		  			byte[] md5Bytes  = md.digest();
		  			StringBuffer hexValue = new StringBuffer();
		  			for (int i = 0; i < md5Bytes.length; i++) {
		  				int val = ((int) md5Bytes[i]) & 0xff;//���Ͳμ����·�
		  				if (val < 16) {
		  					/**
		  					 * ���С��16����ôvalֵ��16������ʽ��ȻΪһλ��
		  					 * ��Ϊʮ����0,1...9,10,11,12,13,14,15 ��Ӧ�� 16����Ϊ 0,1...9,a,b,c,d,e,f;
		  					 * �˴���λ��0��
		  					 */
		  					hexValue.append("0");
		  				}
		  				//���������Integer��ķ���ʵ��16���Ƶ�ת�� 
		  				hexValue.append(Integer.toHexString(val));
		  			}
		  			return hexValue.toString();
		  		} catch (Exception e) {
		  			e.printStackTrace();
		  			return "";
		  		}
		  	}
}
