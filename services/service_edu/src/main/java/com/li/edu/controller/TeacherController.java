package com.li.edu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.li.edu.entity.Teacher;
import com.li.edu.entity.TeacherQuery;
import com.li.edu.service.TeacherService;
import com.li.yitiao.exception.CustomException;
import com.li.yitiao.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
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
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherController {
    @Autowired
    private TeacherService TeacherService;

//   查询讲师列表
    @GetMapping("/findall")
    public CommonResult selectAll(){
        List<Teacher> list = TeacherService.list(null);
        HashMap<String, Object> map = new HashMap();
        map.put("items",list);
        return CommonResult.ok().setData(map);
    }

//    id查询
    @GetMapping("/findid{id}")
    public CommonResult selectById(@PathVariable String id){
//      异常测试
        try {
            int i=10/0;
        }catch (Exception e){
            throw new CustomException(20001,"自定义异常");
        }

        Teacher teacher = TeacherService.getById(id);
        HashMap<String, Object> map = new HashMap<>();
        map.put("items",teacher);
        return CommonResult.ok().setData(map);
    }


//    分页查询讲师
    @GetMapping("/findallpage/{c}/{l}")
    public CommonResult selectPageAll(@PathVariable Long c,@PathVariable Long l){
//        new page对象 并传给mapper接口
        Page<Teacher> page = new Page<>(c,l);
        TeacherService.page(page, null);
//      通过page对象查询所有数据的总条数
        long total = page.getTotal();
        List<Teacher> records = page.getRecords();
//      封装进map返回
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("list",records);

        return CommonResult.ok().setData(map);
    }

//    分页条件查询
    @PostMapping ("findifpage/{c}/{l}")
    public CommonResult pageQuery(@PathVariable Long c, @PathVariable Long l,
                                  @RequestBody(required = false) TeacherQuery TeacherQuery) {

        Page<Teacher> page = new Page<>(c, l);
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        String name = TeacherQuery.getName();
        Integer level = TeacherQuery.getLevel();
        String begin = TeacherQuery.getBegin();
        String end = TeacherQuery.getEnd();
        if (!StringUtils.isEmpty(name)) {
            wrapper.like("name", name);
        }
        if (!StringUtils.isEmpty(level)) {
            wrapper.eq("level", level);
        }
        if (!StringUtils.isEmpty(begin)) {
            wrapper.ge("gmt_create", begin);
        }
        if (!StringUtils.isEmpty(end)) {
            wrapper.le("gmt_modified", end);
        }
        TeacherService.page(page, wrapper);
        long total = page.getTotal();
        List<Teacher> records = page.getRecords();
//         封装进map返回
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("list", records);
        return CommonResult.ok().setData(map);
    }

//  删除讲师
    @DeleteMapping("/delete/{id}")
    public CommonResult deleteById(@PathVariable String id){
        boolean b = TeacherService.removeById(id);
        if (b) {
            return CommonResult.ok();
        }
        else {
            return CommonResult.error();
        }

    }
//  新增讲师
    @PostMapping("/add")
    public CommonResult addTeacher(@RequestBody Teacher Teacher){

        return TeacherService.save(Teacher)? CommonResult.ok(): CommonResult.error();

    }

//    修改讲师
    @PutMapping("/update/{id}")
    public CommonResult updateById(@PathVariable String id,@RequestBody Teacher teacher){
        teacher.setId(id);

        boolean b = TeacherService.updateById(teacher);

        return b?CommonResult.ok():CommonResult.error();

    }
//    @PutMapping
//    @PostMapping


}

