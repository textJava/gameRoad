package cn.yhj.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TestTCP {
	public static void main(String[] args) {
		client();
	}
	public static void client(){
		Socket s=null;
		OutputStream os=null;
		InputStream is=null;
		try {
			s = new Socket(InetAddress.getByName("192.168.1.101"), 12345);
			os = s.getOutputStream();
			os.write("qwer".getBytes());
			s.shutdownOutput();
			is=s.getInputStream();
			byte[] b=new byte[20];
			int len;
			while((len=is.read(b)) != -1){
				String str=new String(b,0,len);
				System.out.println(str);
			}
			
		} catch (Exception e) {
		}finally{
			if(os != null){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(s != null){
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
