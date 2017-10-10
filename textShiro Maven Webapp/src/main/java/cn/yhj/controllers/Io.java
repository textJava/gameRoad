package cn.yhj.controllers;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Io {

	public static void main(String[] args) throws IOException {
		final PipedOutputStream output =new PipedOutputStream();
		final PipedInputStream input=new PipedInputStream(output);
		Thread thread1=new Thread(new  Runnable() {
				public void run() {
					try {
						output.write("helloWord,yanhaijie".getBytes());
						output.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
		Thread thread2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int data;
				try {
					data = input.read();
					while(data!=-1){
						System.out.println((char)data);
						data=input.read();
					}
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		thread1.start();
		thread2.start();
	}
}
