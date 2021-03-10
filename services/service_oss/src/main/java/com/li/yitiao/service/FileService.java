package com.li.yitiao.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: 一条IT
 * @Date: 2021/3/10 12:53
 */
@Service
public interface FileService {
    /**
     * 文件上传至阿里云
     * @param file
     * @return
     */

    String upload(MultipartFile file);

}
