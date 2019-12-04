package com.code.shiro.util;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAop {
    //在primary方法前执行
    @Before("execution(* com.jdkcb.mybatisstuday.controller.UserController.primary(..))")
    public void setDataSource2test01() {
        System.err.println("Primary业务");
        DataSourceType.setDataBaseType(DataSourceType.DataBaseType.Primary);
    }

    //在secondary方法前执行
    @Before("execution(* com.jdkcb.mybatisstuday.controller.UserController.secondary(..))")
    public void setDataSource2test02() {
        System.err.println("Secondary业务");
        DataSourceType.setDataBaseType(DataSourceType.DataBaseType.Secondary);
    }
}
