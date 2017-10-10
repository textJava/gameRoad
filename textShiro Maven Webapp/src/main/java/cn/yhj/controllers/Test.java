package cn.yhj.controllers;

import java.io.File;

public class Test {
	public static void main(String[] args) {
		String path="/usr/local/JavaTools/tomcat/t7_8080/conf";
		File f=new File(path);
		
		String[] fName=f.list();
		for(String s:fName){
			System.out.println(s);
		}
		File[] fs=f.listFiles();
		for(File ff:fs){
			System.out.println(ff.getAbsolutePath());
		}
	}
}
