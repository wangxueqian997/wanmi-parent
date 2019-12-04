package com.code.shiro.bean;

import lombok.Data;
//import com.trace.mapper.base.NotPersistent;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Trace on 2017-12-01.<br/>
 * Desc: 用户表tb_user
 */
@SuppressWarnings("unused")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel

public class User {
    @ApiModelProperty("用户ID") private Integer id;
    @ApiModelProperty("账户名") private String userName;
    @ApiModelProperty("用户昵称") private String nickName;
    @ApiModelProperty("真实姓名") private String realName;
    @ApiModelProperty("身份证号码") private String identityCard;
    @ApiModelProperty("性别") private String gender;
    @ApiModelProperty("出生日期") private LocalDate birth;
    @ApiModelProperty("手机号码") private String phone;
    @ApiModelProperty("邮箱") private String email;
    @ApiModelProperty("密码") private String password;
    @ApiModelProperty("用户头像地址") private String logo;
    @ApiModelProperty("账户状态 0:正常; 1:冻结; 2:注销") private Byte status;
    @ApiModelProperty("个性签名") private String summary;
    @ApiModelProperty("用户所在区域码") private String areaCode;
    @ApiModelProperty("注册时间") private LocalDateTime registerTime;
    @ApiModelProperty("最近登录时间") private LocalDateTime lastLoginTime;

//    @NotPersistent @ApiModelProperty(hidden = true)
//    private transient Area area; //用户所在地区
//
//    @NotPersistent @ApiModelProperty(hidden = true)
//    private transient List<Role> roles; //用户角色列表

}
