package com.code.shiro.login.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.code.wanmi.entity.login.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author 谢晓峰
 * @since 2019-11-14
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 通过用户名查询对应角色集合*/
    @Select("select role from hospital_public.staffinfo s inner join hospital_public.staffinfoandrolemiddle sr on s.staid=sr.staid inner join hospital_public.role r on sr.roid=r.roid where s.staname=#{adminName}")
    Set<Role> selectRoleByAdminName(String adminName);
}
