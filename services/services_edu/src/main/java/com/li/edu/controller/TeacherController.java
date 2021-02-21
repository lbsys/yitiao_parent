package com.li.edu.controller;


import com.li.edu.entity.Teacher;
import com.li.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author yitiaoIT
 * @since 2021-02-21
 */
@RestController
@RequestMapping("/edu/teacher")
public class TeacherController {
    @Autowired
    private TeacherService TeacherService;

    @GetMapping("/findall")
    public List<Teacher> selectAll(){
        List<Teacher> list = TeacherService.list(null);
        return list;
    }

}
