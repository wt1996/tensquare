package com.tensquare.exception;

import com.tensquare.entity.HttpResult;
import com.tensquare.entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName BaseExceptionHandler
 * @Auth 桃子
 * @Date 2019-8-19 17:52
 * @Version 1.0
 * @Description 全局异常处理类
 **/
@ControllerAdvice
public class BaseExceptionHandler {

        @ExceptionHandler(value = Exception.class)
        @ResponseBody
        public HttpResult error(Exception e) {
            e.printStackTrace();
            return new HttpResult(false, StatusCode.ERROR, e.getMessage(),null);
        }
}
