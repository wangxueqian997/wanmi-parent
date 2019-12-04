package com.code.shiro.service;

import com.code.shiro.bean.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    public User findById(int id){
        return new User();
    }
    public List<User>  findByIdIn(int[] ids){
        return new ArrayList<>();
    }
    public List<User> findByUser(User user){
        return findAll();
    }
    public List<User> findAll(){
        return new ArrayList<>();
    }
}
