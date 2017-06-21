package cn.yhj.controllers;

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
			@RequestParam("passWord") String passWord) {
		System.out.println("�û�����"+userName+"�����룺"+passWord);
		
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
}

