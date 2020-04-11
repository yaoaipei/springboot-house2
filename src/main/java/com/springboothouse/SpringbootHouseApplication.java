package com.springboothouse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//启动类会自动扫描当前包下,及其子包下所有的Spring注解配置
//使用ComponentScan注解指定描述所在包
//@ComponentScan(value ="com.springboothouse.controller")
//添加扫描dao层配置
@MapperScan(value = "com.springboothouse.mapper")
public class SpringbootHouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHouseApplication.class, args);
    }

}
