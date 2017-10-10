package cn.yhj.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import cn.yhj.entity.UserLogin;

public class xuliehua {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//序列化对象
        ObjectOutputStream out;
		try {
			out = new ObjectOutputStream(new FileOutputStream("/usr/local/pic/4.txt"));
			  UserLogin customer = new UserLogin(1, "123456","12","12");    
		        out.writeObject("你好!");    //写入字面值常量
		        out.writeObject(new Date());    //写入匿名Date对象
		        out.writeObject(customer);    //写入customer对象
		        out.close();
		        ObjectInputStream in = new ObjectInputStream(new FileInputStream("/usr/local/pic/4.txt"));
		        try {
					System.out.println("obj1 " + (String) in.readObject());
				//读取字面值常量
		        System.out.println("obj2 " + (Date) in.readObject());    //读取匿名Date对象
		        UserLogin obj3 = (UserLogin) in.readObject();    //读取customer对象
		        System.out.println("obj3 " + obj3);
		        in.close();
		        } catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
	}

}
