package com.zhao.common.base;

import com.zhao.common.enums.GlobalStatusEnum;

/**
 * @Version 1.0
 * @VersionDesc 初始版本
 * @Author: jerrywu
 * @Date: 2019/5/13 20:27
 * @description:
 */
public class BaseController {
    protected Result ok() {
        return new Result<>(GlobalStatusEnum.OK.getStatus(), GlobalStatusEnum.OK.getMsg(), null);
    }

    protected <T> Result<T> ok(T data) {
        return new Result<>(GlobalStatusEnum.OK.getStatus(), GlobalStatusEnum.OK.getMsg(), data);
    }

    protected Result error(GlobalStatusEnum globalStatusEnum) {
        return new Result<>(globalStatusEnum.getStatus(), globalStatusEnum.getMsg(), null);
    }
}
