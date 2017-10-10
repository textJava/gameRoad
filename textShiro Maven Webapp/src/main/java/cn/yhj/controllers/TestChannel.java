package cn.yhj.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestChannel {
	public static void main(String[] args) {
		try {
			File f=new File("/usr/local/pic/9.txt");
			RandomAccessFile aFile=new RandomAccessFile(f, "rw");
			FileChannel fc=aFile.getChannel();
			ByteBuffer bb=ByteBuffer.allocate(2);
			int bytesRead;
			try {
				bytesRead = fc.read(bb);
				while(bytesRead != -1){
					bb.flip();
					while(bb.hasRemaining()){
						System.out.println((char)bb.get());
					}
					bb.clear();
					bytesRead=fc.read(bb);
				}
				aFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
