package com.code.shiro.login.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.code.shiro.login.mapper.RoleMapper;
import com.code.shiro.login.service.IRoleService;
import com.code.wanmi.entity.login.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author 谢晓峰
 * @since 2019-11-14
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;


    /**
     * 根据登录账户获取用户角色*/
    public Set<String> getRoles(String userName) {
        Set<Role> roles = roleMapper.selectRoleByAdminName(userName);
        Set<String> roles1 = new HashSet<>();
        for (Role role : roles) {
            roles1.add(role.getRole());
        }
        return roles1;
    }

}
