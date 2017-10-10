package cn.yhj.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UpLoadPic {
	public static void main(String[] args) {
		
		File file=new File("/usr/local/pic/3.txt");
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			fis = new FileInputStream(file);
			fos = new FileOutputStream("/usr/local/pic/9.txt");
			byte[] b=new byte[1024];
			int len;
			while((len=fis.read()) !=-1){
				String s=new String(b, 0, len);
				System.out.println(s);
				fos.write(b, 0, len);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void UploadPic(byte[] pic){
	}
}
