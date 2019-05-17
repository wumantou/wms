package com.zhao.common.exception;

/**
 * 
 * ClassName: AbstractServiceException.java
 * @Description: 异常规范
 *
 * @author Ryan.Bian
 * @2018年11月10日 下午2:50:51
 */
public interface AbstractServiceException {

    /**
     * 获取异常的状态码
     */
    Integer getStatus();

    /**
     * 获取异常的提示信息
     */
    String getMsg();
}
