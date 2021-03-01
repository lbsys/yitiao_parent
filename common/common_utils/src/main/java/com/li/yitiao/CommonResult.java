package com.li.yitiao;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

//统一返回结果的类
@Data
@Accessors(chain = true)
public class CommonResult {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();

    //把构造方法私有 单例模式——饿汉
    private CommonResult() {}

    //成功静态方法
    public static CommonResult ok() {
        CommonResult r = new CommonResult();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功");
        return r;
    }

    //失败静态方法
    public static CommonResult error() {
        CommonResult r = new CommonResult();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("失败");
        return r;
    }


//    链式编程
//    public CommonResult success(Boolean success){
//        this.setSuccess(success);
//        return this;
//    }
//
//    public CommonResult message(String message){
//        this.setMessage(message);
//        return this;
//    }
//
//    public CommonResult code(Integer code){
//        this.setCode(code);
//        return this;
//    }
//
//    public CommonResult data(String key, Object value){
//        this.data.put(key, value);
//        return this;
//    }
//
//    public CommonResult data(Map<String, Object> map){
//        this.setData(map);
//        return this;
//    }
}
