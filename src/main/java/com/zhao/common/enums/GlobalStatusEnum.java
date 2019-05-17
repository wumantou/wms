package com.zhao.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Version 1.0
 * @VersionDesc 初始版本
 * @Author: jerrywu
 * @Date: 2019/4/19 16:31
 * @description:
 */
@Getter
@AllArgsConstructor
public enum GlobalStatusEnum {
    OK(0,"ok"),
    ERROR(1,"内部错误"),
    LOGIN_REQUIRED(2,"未登录"),
    ;
    private int status;
    private String msg;
}
