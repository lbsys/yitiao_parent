package com.li.edu.controller;

import com.li.yitiao.result.CommonResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 一条IT
 * @Date: 2021/3/3 20:54
 */
@RestController()
@RequestMapping("/user")
@CrossOrigin
public class LoginController {
   Map map=new HashMap();
    @PostMapping("/login")
    public CommonResult login(){
        map.put("token","login");
        return  CommonResult.ok().setData(map);
    }

    @GetMapping("/info")
    public CommonResult info(){
        map.put("roles","admin");
        map.put("name","li");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return CommonResult.ok().setData(map);
    }
}
