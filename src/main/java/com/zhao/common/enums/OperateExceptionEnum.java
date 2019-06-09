package com.zhao.common.enums;

import com.zhao.common.exception.AbstractServiceException;
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
public enum OperateExceptionEnum implements AbstractServiceException {
    PRODUCT_ID_NULL(401, "商品id不能为空"),
    ;

    private Integer status;
    private String msg;
}
