package com.zhao.common.base;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {
    private int status;
    private String msg;
    private T data;
}
