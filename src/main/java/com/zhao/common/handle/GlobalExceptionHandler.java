package com.zhao.common.handle;

import com.zhao.common.base.Result;
import com.zhao.common.enums.GlobalStatusEnum;
import com.zhao.common.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理所有不可知的异常
     *
     * @param e the e
     * @return R
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Result exception(Exception e) {
        log.error("系统异常信息 ex={}", e.getMessage(), e);
        return new Result<>(GlobalStatusEnum.ERROR.getStatus(), GlobalStatusEnum.ERROR.getMsg(), null);
    }

    /**
     * 运行时异常
     *
     * @param runtimeException
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Result runtimeExceptionHandler(RuntimeException runtimeException) {
        log.error("系统异常信息 ex={}", runtimeException.getLocalizedMessage(), runtimeException);
        return new Result<>(GlobalStatusEnum.ERROR.getStatus(), GlobalStatusEnum.ERROR.getMsg(), null);
    }

    /**
     * 处理所有业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public Result handleServiceException(ServiceException e) {
        //业务异常记录为info级别，不记录为error级别
        log.info("业务异常信息 ex={}", e.getMessage(), e);
        return new Result<>(e.getCode(), e.getErrorMessage(), null);
    }


}
