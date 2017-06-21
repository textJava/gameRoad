package cn.yhj.tool;

import java.util.LinkedHashMap;


public class FilterChainDefinitionMapBuilder {

	public LinkedHashMap<String, String> buildFilterChainDefinitionMap(){
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		
		map.put("/index.jsp", "anon");
		map.put("/userLogin/login", "anon");
		map.put("/page/user.jsp", "authc,roles[user]");
		map.put("/page/admin.jsp", "authc,roles[admin]");
		map.put("/page/userLogin/logout", "logout");
		map.put("/list.jsp", "user");
		
		map.put("/**", "authc");
		return map;
	}
	
}
