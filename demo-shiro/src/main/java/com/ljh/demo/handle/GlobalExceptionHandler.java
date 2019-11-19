package com.ljh.demo.handle;

import com.ljh.demo.common.entity.FebsResponse;
import com.ljh.demo.common.exception.FebsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author ljh
 * @date 2019-11-19 14:20
 */
@Slf4j
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    @ExceptionHandler(FebsException.class)
    public FebsResponse handleFebsException(FebsException e) {
        log.error("系统错误", e);
        return new FebsResponse().code(HttpStatus.INTERNAL_SERVER_ERROR).message(e.getMessage());
    }
}
