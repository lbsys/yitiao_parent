package com.li.yitiao.controller;

import com.li.yitiao.result.CommonResult;
import com.li.yitiao.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

/**
 * @Author: 一条IT
 * @Date: 2021/3/10 12:57
 */
@RestController
@RequestMapping("/oss")
@CrossOrigin
public class FileUploadController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public CommonResult upload(@RequestParam("file") MultipartFile file){
        String url = fileService.upload(file);
        HashMap<String, Object> map = new HashMap<>();
        map.put("url",url);
        return CommonResult.ok().setMessage("文件上传成功").setData(map);
    }
}
