package com.li.yitiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: 一条IT
 * @Date: 2021/3/10 12:31
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan({"com.li"})
@EnableSwagger2
public class OssMain {
    public static void main(String[] args) {
        SpringApplication.run(OssMain.class,args);
    }
}
