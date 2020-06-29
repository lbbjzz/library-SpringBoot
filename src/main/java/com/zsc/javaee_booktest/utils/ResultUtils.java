package com.zsc.javaee_booktest.utils;

/**
 * @ClassName ResultUtils
 * @Description json返回体构造工具
 * @Author Kami
 * @Date 2020/6/29 16:34
 * @Version 1.0
 **/
public class ResultUtils {
    public static JsonResult success() {
        return new JsonResult(true);
    }

    public static <T> JsonResult<T> success(T data) {
        return new JsonResult(true, data);
    }

    public static JsonResult fail() {
        return new JsonResult(false);
    }

    public static JsonResult fail(ResultCode resultEnum) {
        return new JsonResult(false, resultEnum);
    }
}
