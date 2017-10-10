package cn.yhj.controllers;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller

@RequestMapping("/userLogin")
public class UserLoginController {

	@RequestMapping("/login")
	public String login(@RequestParam("userName") String userName,
			@RequestParam("passWord") String passWord,HttpServletRequest request) {
		System.out.println("用户名"+userName+"密码"+passWord);
		//字符集好费劲
		
		String a=request.getHeader("version");
		System.out.println(a);
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
        	// ���û����������װΪ UsernamePasswordToken ����
            UsernamePasswordToken token = new UsernamePasswordToken(userName, passWord);
            // ��ס��
            //token.setRememberMe(true);
            try {
                currentUser.login(token);
            } 
            // ������֤ʱ�쳣�ĸ���. 
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            	System.out.println("��¼ʧ��: " + ae.getMessage());
            }
        }
		return "redirect:/page/list.jsp";
	}
//	
	public static void main(String[] args) {
		String cmsCode=null;
		Random rm = new Random();  
	    double pross = (1 + rm.nextDouble()) * Math.pow(10, 4);  
	    String fixLenthString = String.valueOf(pross);  
	    cmsCode= fixLenthString.substring(1, 4 + 1);
	    System.out.println(cmsCode);
	}
}

