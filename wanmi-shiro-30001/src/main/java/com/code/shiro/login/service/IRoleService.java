package com.code.shiro.login.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.code.wanmi.entity.login.Role;


import java.util.Set;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author 谢晓峰
 * @since 2019-11-14
 */
public interface IRoleService extends IService<Role> {

    Set<String> getRoles(String userName);


}
