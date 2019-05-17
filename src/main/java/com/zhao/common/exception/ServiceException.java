package com.zhao.common.exception;

import lombok.Data;

@Data
public class ServiceException extends RuntimeException {
    private Integer code;
    private String errorMessage;

    /**
     * <p>
     * Description: 构造函数
     * </p>
     *
     * @param cause 堆栈
     */
    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(Integer code, String errorMessage) {
        super(errorMessage);
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public ServiceException(AbstractServiceException exception) {
        super(exception.getMsg());
        this.code = exception.getStatus();
        this.errorMessage = exception.getMsg();
    }

}
