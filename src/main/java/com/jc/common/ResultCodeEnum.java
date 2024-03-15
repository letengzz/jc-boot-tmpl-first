package com.jc.common;

import lombok.Getter;

/**
 * 统一返回结果状态信息类
 * @author hjc
 */
@Getter
public enum ResultCodeEnum {
    SUCCESS(200,"操作成功"),
    FAIL(201,"操作失败"),
    SERVICE_ERROR(9999,"服务异常"),
    DATA_ERROR(204,"数据异常"),
    ILLEGAL_REQUEST(205, "非法请求"),
    REPEAT_SUBMIT(206, "重复提交"),
    ARGUMENT_VALID_ERROR(210, "参数校验异常"),
    LOGIN_AUTH(208, "未登陆"),
    ACCOUNT_ERROR(214, "账号不正确"),
    PASSWORD_ERROR(215, "密码不正确"),
    LOGIN_ERROR( 216, "账号不正确"),
    ACCOUNT_STOP( 217, "账号已停用"),
    NODE_ERROR( 218, "该节点下有子节点，不可以删除"),
    UNAUTHORIZED(401, "没有权限"),
    FORBIDDEN( 403, "禁止访问"),;

    //返回码
    private final Integer code;
    //返回信息
    private final String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
