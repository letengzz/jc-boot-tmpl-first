package com.jc.common;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;

/**
 * 返回响应类
 *
 * @param code    状态码
 * @param message 状态信息
 * @param data    返回数据
 * @param <T>     返回数据类型
 */
public record RespResult<T>(int code, String message, T data) {

    /**
     * 成功响应
     *
     * @param data 返回数据
     * @param <T>  返回数据类型
     * @return RespBean
     */
    public static <T> RespResult<T> success(T data) {
        return new RespResult<>(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMessage(), data);
    }


    /**
     * 成功响应(不返回数据)
     *
     * @param <T> 数据类型
     * @return RespBean
     */
    public static <T> RespResult<T> success() {
        return success(null);
    }

    /**
     * 失败响应
     *
     * @param code 响应码
     * @param message 响应信息
     * @param <T> 数据类型
     * @return RespBean
     */
    public static <T> RespResult<T> failure(int code, String message) {
        return new RespResult<>(code, message, null);
    }

    /**
     * 失败响应
     * @param resultCodeEnum 统一信息枚举类
     * @return  RespBean
     * @param <T> 数据类型
     */
    public static <T> RespResult<T> failure(ResultCodeEnum resultCodeEnum) {
        return failure(resultCodeEnum.getCode(), resultCodeEnum.getMessage());
    }

    /**
     *  禁止访问
     * @param message 响应信息
     * @return RespBean
     * @param <T> 数据类型
     */
    public static <T> RespResult<T> forbidden(String message) {
        return failure(ResultCodeEnum.FORBIDDEN.getCode(), message);
    }

    /**
     * 未经授权
     * @param message 响应消息
     * @return RespBean
     * @param <T> 数据类型
     */
    public static <T> RespResult<T> unauthorized(String message) {
        return failure(ResultCodeEnum.UNAUTHORIZED.getCode(), message);
    }

    /**
     * 装换为JSON字符串
     * @return JSON字符串
     */
    public String asJsonString(){
        return JSON.toJSONString(this, JSONWriter.Feature.WriteNulls);
    }
}
