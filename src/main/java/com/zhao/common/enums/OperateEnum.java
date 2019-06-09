package com.zhao.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OperateEnum {
    REDUCE_STOCK("0", "出库"),
    ADD_COUNT("1", "进货"),
    ;
    private String operate;
    private String desc;
}
