package com.zhao.common.base;

import lombok.Data;

import java.util.List;

/**
 * @Version 1.0
 * @VersionDesc 初始版本
 * @Author: jerrywu
 * @Date: 2019/5/14 20:34
 * @description:
 */
@Data
public class Page<T> {
    private Integer page = 1;
    private Integer size = 10;
    private List<T> data;
}
