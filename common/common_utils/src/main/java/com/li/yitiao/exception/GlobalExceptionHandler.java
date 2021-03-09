package com.li.yitiao.exception;

import com.li.yitiao.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 一条IT
 * @Date: 2021/3/1 17:20
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public CommonResult error(Exception e){
        e.printStackTrace();
        log.error(e.getMessage());
        return CommonResult.error().setMessage("全局异常");
    }

    @ResponseBody
    @ExceptionHandler(ArithmeticException.class)
    public CommonResult error(ArithmeticException e){
        e.printStackTrace();
        log.error(e.getMessage());
        return CommonResult.error().setMessage("算术异常");
    }

    @ResponseBody
    @ExceptionHandler(CustomException.class)
    public CommonResult error(CustomException e){
        e.printStackTrace();
        log.error(e.getMessage());
        return CommonResult.error().setMessage(e.getMsg()).setCode(e.getCode());
    }
}
