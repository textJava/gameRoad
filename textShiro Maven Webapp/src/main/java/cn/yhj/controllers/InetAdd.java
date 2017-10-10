package cn.yhj.controllers;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * InetAddress:位于java.net包下
 * 1.InetAddress用来代表IP地址。一个InetAddress的对象就代表这一个IP地址
 */
public class InetAdd {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress inet=InetAddress.getByName("www.baidu.com");
		System.out.println(inet);
		System.out.println(inet.getHostAddress());
		System.out.println(inet.getHostName());
		
	}
}
