package com.code.wanmi.entity.login;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author 谢晓峰
 * @since 2019-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @TableId(value = "roid", type = IdType.AUTO)
    private Integer roid;

    /**
     * 角色
     */
    private String role;

    /**
     * 数据库
     */
    private String rodbsource;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getRoid() {
        return roid;
    }

    public void setRoid(Integer roid) {
        this.roid = roid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRodbsource() {
        return rodbsource;
    }

    public void setRodbsource(String rodbsource) {
        this.rodbsource = rodbsource;
    }
}
