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
public enum BranchExceptionEnum implements AbstractServiceException {

    BRANCH_NAME_NULL(201, "品牌名不能为空"),
    BRANCH_ID_NULL(202, "品牌id不能为空"),

    ;

    private Integer status;
    private String msg;
}
