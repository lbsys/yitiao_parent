package com.li.edu.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 一条IT
 * @Date: 2021/3/1 10:10
 */
@Data
public class TeacherQuery implements Serializable {
    private String name;
    private Integer level;
    private String begin;
    private String end;
}
