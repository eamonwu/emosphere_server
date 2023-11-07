package com.emosphere.emosphere.controller;

import com.emosphere.emosphere.utils.BizErrorCodeEnum;
import com.emosphere.emosphere.utils.BizException;
import com.emosphere.emosphere.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class BizExceptionController {
    @ExceptionHandler
    public R bizHandler(BizException e) {
        BizErrorCodeEnum errorCode = e.getErrorCode();
        return R.error(errorCode.getCode(), errorCode.getDescription());
    }

    @ExceptionHandler
    public R illegalArgumentExceptionHandler(IllegalArgumentException e) {
        log.error(e.toString());
        log.error(e.getMessage());
        return R.error(400, e.getMessage());
    }

    /**
     * springboot validation遇到非法值抛出的异常为 MethodArgumentNotValidException
     * @param ex
     * @return
     */
    @ExceptionHandler
    public R validationExceptionHandler(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        StringBuilder errorMsg = new StringBuilder();
        result.getFieldErrors().forEach(fieldError ->
                errorMsg.append(fieldError.getDefaultMessage()).append(". ")
        );
        return R.error(400,errorMsg.toString());
    }

}
