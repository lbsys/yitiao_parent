package com.li.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: 一条IT
 * @Date: 2021/2/21 19:35
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.li"})
@EnableSwagger2
public class TeacherMain {

    public static void main(String[] args) {
        SpringApplication.run(TeacherMain.class,args);
    }
}
