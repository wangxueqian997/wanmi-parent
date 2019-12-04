package com.code.shiro.controller;

import com.code.shiro.bean.ResultModel;

import com.code.shiro.bean.User;
import com.code.shiro.login.service.IRoleService;
import com.code.shiro.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Trace on 2017-12-01.<br/>
 * Desc: 用户管理controller
 */
@SuppressWarnings("unused")
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController {

    @Autowired
    private UserService userService;




    @Autowired
    private IRoleService iRoleService;

    /**
     * 登录验证
     */
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String userLogin(Admin admin) {
//        Staffinfo roleAndUser = iRoleService.getAdminByuserName(admin.getAdminname());
//
//        System.out.println(DigestUtils.md5DigestAsHex(admin.getAdminname().getBytes()));
//        if (roleAndUser != null)
//            if (roleAndUser.getStapassword().equals(DigestUtils.md5DigestAsHex(admin.getAdminname().getBytes()))) {
//
//                return JSON.toJSONString(new ResponseBean(200, "Login success", JWTUtil.sign(admin.getAdminname(),DigestUtils.md5DigestAsHex(admin.getAdminname().getBytes()))));
//            } else {
//                // throw new UnauthorizedException();
//                return JSON.toJSONString(new ResponseBean(402, "Login fail（密码错误）"));
//            }
//        return JSON.toJSONString(new ResponseBean(403, "Login fail(无此账户)"));
//    }


    @GetMapping("/query/{id}")
    @ApiOperation("通过ID查询")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "int", paramType = "path")
    public ResultModel<User> findById(@PathVariable int id) {
        User user = userService.findById(id);
        return ResultModel.success("id查询成功", user);
    }

    @GetMapping("/query/ids")
    @ApiOperation("通过ID列表查询")
    public ResultModel<List<User>> findByIdIn(int[] ids) {
        List<User> users = userService.findByIdIn(ids);
        return ResultModel.success("in查询成功", users);
    }


    @GetMapping("/query/user")
    @ApiOperation("通过用户实体查询")
    public ResultModel<List<User>> findByUser(User user) {
        List<User> users = userService.findByUser(user);
        return ResultModel.success("通过实体查询成功", users);
    }


    @GetMapping("/query/all")
    @ApiOperation("查询所有用户")
    public ResultModel<List<User>> findAll() {
        List<User> users = userService.findAll();
        return ResultModel.success("全体查找成功", users);
    }
    @GetMapping("/test")
    public void test(){
        System.out.println("test");
    }
//
//
//    @GetMapping("/query/username")
//    @ApiOperation("通过用户名称模糊查询")
//    @ApiImplicitParam(name = "userName", value = "用户名称")
//    public ResultModel<List<User>> findByUserName(String userName) {
//        List<User> users = userService.findByUserName(userName);
//        return ResultModel.success(users);
//    }

//
//    @PostMapping("/insert")
//    @ApiOperation("新增默认用户")
//    public ResultModel<Integer> insert() {
//        User user = new User();
//        user.setUserName("zhongshiwen");
//        user.setNickName("zsw");
//        user.setRealName("钟仕文");
//        user.setPassword("zsw123456");
//        user.setGender("男");
//        Area area = new Area();
//        area.setLevel((byte) 5);
//        user.setArea(area);
//        userService.save(user);
//        return ResultModel.success("新增用户成功", user.getId());
//    }
//
//
//    @PutMapping("/update")
//    @ApiOperation("更新用户信息")
//    public ResultModel<Integer> update(User user) {
//        int row = userService.update(user);
//        return ResultModel.success(row);
//    }
//
//
//    @PutMapping("/update/status")
//    @ApiOperation("更新单个用户状态")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "用户ID", required = true),
//            @ApiImplicitParam(name = "status", value = "状态", required = true)
//    })
//    public ResultModel<User> updateStatus(int id, byte status) {
//        User user = userService.updateStatus(id, status);
//        return ResultModel.success(user);
//    }
//
//
//    @DeleteMapping("/delete")
//    @ApiOperation("删除单个用户")
//    @ApiImplicitParam(value = "用户ID", required = true)
//    public ResultModel<Integer> delete(int id) {
//        return ResultModel.success(userService.delete(id));
//    }


}
