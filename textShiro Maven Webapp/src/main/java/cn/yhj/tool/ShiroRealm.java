package cn.yhj.tool;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yhj.entity.UserLogin;
import cn.yhj.entity.UserRoles;
import cn.yhj.service.UserLoginService;
import cn.yhj.service.UserRolesService;
@Service
public class ShiroRealm extends AuthorizingRealm {

	@Autowired
	private UserLoginService userLoginService;
	
	@Autowired
	private UserRolesService userRolesService;
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		System.out.println("[FirstRealm] doGetAuthenticationInfo");
		
		//1. �� AuthenticationToken ת��Ϊ UsernamePasswordToken 
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		
		//2. �� UsernamePasswordToken ������ȡ username
		String userName = upToken.getUsername();
		//����
		Object credentials = null;
		//3. �������ݿ�ķ���, �����ݿ��в�ѯ username ��Ӧ���û���¼
		UserLogin ul=new UserLogin();
		ul.setUserName(userName);
		ul.setPassWord( String.valueOf(upToken.getPassword()));
		UserLogin userlogin=userLoginService.selectUser(ul);
		if(userlogin != null){
			credentials=userlogin.getPassWord();
			System.out.println("��¼�ɹ�");
		}else{
			throw new UnknownAccountException("�û����������������!");
		}
		
		//4. ���û�������, ������׳� UnknownAccountException �쳣
//		if("unknown".equals(username)){
//			
//		}
		//5. �����û���Ϣ�����, �����Ƿ���Ҫ�׳������� AuthenticationException �쳣. 
//		if("monster".equals(username)){
//			throw new LockedAccountException("�û�������");
//		}
		//6. �����û������, ������ AuthenticationInfo ���󲢷���. ͨ��ʹ�õ�ʵ����Ϊ: SimpleAuthenticationInfo
		//������Ϣ�Ǵ����ݿ��л�ȡ��.
		//1). principal: ��֤��ʵ����Ϣ. ������ username, Ҳ���������ݱ��Ӧ���û���ʵ�������. 
		Object principal = userName;
//		//2). credentials: ����. 
//		Object credentials = null; //"fc1709d0a95a6be30bc5926fdb7f22f4";
//		if("admin".equals(userName)){
//			credentials = "038bdaf98f2037b31f1e75b5b4c9b26e";
//		}else if("user".equals(userName)){
//			credentials = "098d2c478e9c11555ce2823231e02ec1";
//		}
		
		//3). realmName: ��ǰ realm ����� name. ���ø���� getName() ��������
		String realmName = getName();
		//4). ��ֵ. 
		//ByteSource credentialsSalt = ByteSource.Util.bytes(username);
		
		SimpleAuthenticationInfo info = null; //new SimpleAuthenticationInfo(principal, credentials, realmName);
		info = new SimpleAuthenticationInfo(principal, credentials, realmName);
		return info;
	}

	public static void main(String[] args) {
		String hashAlgorithmName = "MD5";
		Object credentials = "123456";
		Object salt = ByteSource.Util.bytes("user");;
		int hashIterations = 1024;
		
		Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
		System.out.println(result);
	}

//	��Ȩ�ᱻ shiro �ص��ķ���
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
//		//1. �� PrincipalCollection ������ȡ��¼�û�����Ϣ
		String principal = principals.getPrimaryPrincipal().toString();
		
//		//2. ���õ�¼���û�����Ϣ���û���ǰ�û��Ľ�ɫ��Ȩ��(������Ҫ��ѯ���ݿ�)
		Set<String> roles = new HashSet<>();
		
		List<UserRoles> list=new ArrayList<UserRoles>();
		UserLogin userLogin=new UserLogin();
		userLogin.setUserName(principal);
		UserLogin ul=userLoginService.selectUser(userLogin);
		list=userRolesService.selectAllRoles(ul.getUserCode());
		if(null != list){
			for(UserRoles ur:list){
				roles.add(ur.getUserRols());
				System.out.println("��ɫ��"+ur.getUserRols());
			}
		}
//		//3. ���� SimpleAuthorizationInfo, �������� reles ����.
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		
		//4. ���� SimpleAuthorizationInfo ����. 
		return info;
	}
}
