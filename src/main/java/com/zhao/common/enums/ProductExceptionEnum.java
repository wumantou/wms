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
public enum ProductExceptionEnum implements AbstractServiceException {

    PRODUCT_NAME_NULL(301, "商品名不能为空"),
    PRODUCT_COUNT_NULL(302, "商品数量不能为空"),
    PRODUCT_STOCK_NULL(303, "库存数量不能为空"),
    PRODUCT_BRANCH_NULL(304, "所属品牌必须选择"),
    PRODUCT_ID_NULL(305, "商品标识不能为空"),
    PRODUCT_ADD_ERROR(306, "增加数量必须大于0"),
    PRODUCT_REDUCE_ERROR(307, "减少数量必须大于0"),
    ;

    private Integer status;
    private String msg;
}
