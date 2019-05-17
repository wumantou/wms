package com.zhao.common.enums;

import com.zhao.common.exception.AbstractServiceException;
import com.zhao.common.exception.ServiceException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Version 1.0
 * @VersionDesc 初始版本
 * @Author: jerrywu
 * @Date: 2019/5/13 21:51
 * @description:
 */
@Getter
@AllArgsConstructor
public enum UserExceptionEnum implements AbstractServiceException {

    USER_LOGIN_NAME_NULL(101, "账号不能为空"),
    USER_PASSWORD_NULL(102, "密码不能为空"),
    USER_PASSWORD_ERROR(103, "密码错误"),

    ;

    private Integer status;
    private String msg;
}
