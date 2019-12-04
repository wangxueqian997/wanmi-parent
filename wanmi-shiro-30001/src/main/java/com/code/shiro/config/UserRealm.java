package com.code.shiro.config;

import com.code.shiro.login.service.IRoleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    private static final Logger LOGGER = LogManager.getLogger(UserRealm.class);

    @Autowired
    private IRoleService iRoleService;
    /**
     * 大坑！，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权方法");
        //获取用户登录username
       String username = JWTUtil.getUsername(principalCollection.toString());
        System.out.println(username);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        System.out.println(iRoleService.getRoles(username));
        //设置用户角色(从数据库查询角色)
        info.setRoles(iRoleService.getRoles(username));

        //可拿到认证拦截器传递的admin对象
//        Subject subject = SecurityUtils.getSubject();
//        Admin admin = (Admin)subject.getPrincipal();
        //添加权限
//        Set<String> permission = new HashSet<>(Arrays.asList(user.getPermission().split(",")));
//        info.addStringPermissions(permission);

        return info;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了认证方法");
        //用户名密码去数据库中取
//        String username = "root";
//        String password = "root";
//        Admin admin = new Admin();
//        admin.setAdminname(username);
//        admin.setPassword(password);
        //获取login时的UsernamePasswordToken对象，该对象是全局的
//        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
//        System.out.println(usernamePasswordToken.getUsername());
//        Staffinfo staffinfo = staffinfoMapper.selectStaffinfoByUserName(usernamePasswordToken.getUsername());
//        if(staffinfo==null) {
//            return null;//shiro会自动抛出异常UnknownAccountException
//        }
        //密码认证shiro会自动完成（涉及了安全认证）
//        return new SimpleAuthenticationInfo(staffinfo,staffinfo.getStapassword(),"");
        String token = (String) authenticationToken.getCredentials();

        // 解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUsername(token);
        System.out.println(username);
        if (username == null) {
            throw new AuthenticationException("token invalid");
        }

//        Staffinfo adminByuserName = iRoleService.getAdminByuserName(username);
//        System.out.println(adminByuserName);
//        if (adminByuserName == null) {
//            throw new AuthenticationException("User didn't existed!");
//        }
//
//        if (! JWTUtil.verify(token, username, adminByuserName.getStapassword())) {
//            throw new AuthenticationException("Username or password error");
//        }
//
//        return new SimpleAuthenticationInfo(token, token, adminByuserName.getStaname());
        return null;
    }


}
