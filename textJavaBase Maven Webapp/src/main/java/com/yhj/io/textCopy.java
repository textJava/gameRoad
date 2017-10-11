package com.yhj.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class textCopy {

	public static void main(String[] args) {
		//普通IO复制
//		String oldUrl="E:\\JavaTools\\myeclipse\\q.exe";
//		String newUrl="C:\\Users\\Administrator\\Desktop\\1.exe";
//		long start=System.currentTimeMillis();
//		String result=fileCopy(oldUrl,newUrl);
//		long end=System.currentTimeMillis();
//		System.out.println("复制共用时间："+(end-start)+"结果："+result);
		//缓冲IO复制
//		String bufOldUrl="E:\\JavaTools\\myeclipse\\q.exe";
//		String bufNewUrl="C:\\Users\\Administrator\\Desktop\\2.exe";
//		long bufStart=System.currentTimeMillis();
//		String bufResult=bufFileCopy(bufOldUrl, bufNewUrl);
//		long bufEnd=System.currentTimeMillis();
//		System.out.println("缓冲IO复制共用时间："+(bufEnd-bufStart)+"结果："+bufResult);
		//NIO复制
		String NioOldUrl="E:\\JavaTools\\myeclipse\\q.exe";
		String NioNewUrl="C:\\Users\\Administrator\\Desktop\\3.exe";
		long NioStart=System.currentTimeMillis();
		String NioResult=newFileCopy(NioOldUrl, NioNewUrl);
		long NioEnd=System.currentTimeMillis();
		System.out.println("NIO复制共用时间："+(NioEnd-NioStart)+"结果："+NioResult);
	}
	/**
	 * NIO复制
	 */
	public static String newFileCopy(String oldUrl,String newUrl){
		if(verifyParam(oldUrl,newUrl) == 1){
			return "失败";
		}
		FileInputStream fis=null;
		FileOutputStream fos=null;
		FileChannel fcis=null;
		FileChannel fcos=null;
		try {
			fis=new FileInputStream(oldUrl);
			fos=new FileOutputStream(newUrl);
			fcis=fis.getChannel();
			fcos=fos.getChannel();
			ByteBuffer bb=ByteBuffer.allocate(1024);
			while(fcis.read(bb) != -1){
				bb.flip();
				fcos.write(bb);
				bb.clear();
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fcos != null){
				try {
					fcos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fcos != null) {
				try {
					fcis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fcos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fcos != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "NIO复制成功！";
	}
	/**
	 * 缓冲IO复制
	 */
	public static String bufFileCopy(String oldUrl,String newUrl){
		if(verifyParam(oldUrl,newUrl) == 1){
			return "失败";
		}
		InputStream is=null;
		OutputStream os=null;
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		try {
			is=new FileInputStream(oldUrl);
			os=new FileOutputStream(newUrl);
			bis=new BufferedInputStream(is);
			bos=new BufferedOutputStream(os);
			byte[] b=new byte[1024];
			int len;
			while((len = bis.read(b)) != -1){
				bos.write(b,0,len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "缓冲IO复制成功！";
	}
	/**
	 * 普通IO复制 
	 */
	public static String fileCopy(String oldUrl,String newUrl){
		if(verifyParam(oldUrl,newUrl) == 1){
			return "失败";
		}
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			fis=new FileInputStream(oldUrl);
			fos=new FileOutputStream(newUrl);
			byte[] b=new byte[1024];
			int len;
			while((len = fis.read(b)) != -1){
				fos.write(b,0,len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "普通IO复制成功！";
	}
	private static int verifyParam(String oldUrl,String newUrl){
		int result=0;
		if(oldUrl.length() == 0 || newUrl.length() == 0){
			System.out.println("参数错误");
			result=1;
			return result;
		}
		File file=new File(oldUrl);
		if(file.exists() == false){
			System.out.println("复制文件不存在");
			result=1;
			return result;
		}
		return result;
	}
}