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
		System.out.println("用户名："+userName+"，密码："+passWord);
		
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
        	// 把用户名和密码封装为 UsernamePasswordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken(userName, passWord);
            // 记住我
            //token.setRememberMe(true);
            try {
                currentUser.login(token);
            } 
            // 所有认证时异常的父类. 
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            	System.out.println("登录失败: " + ae.getMessage());
            }
        }
		return "redirect:/page/list.jsp";
	}
}

