package com.zclcs.erp.handler;

import cn.hutool.core.util.StrUtil;
import com.zclcs.erp.core.base.BaseRsp;
import com.zclcs.erp.core.constant.Strings;
import com.zclcs.erp.exception.FieldException;
import com.zclcs.erp.exception.FileDownloadException;
import com.zclcs.erp.exception.MyException;
import com.zclcs.erp.utils.RspUtil;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Set;

/**
 * 全局异常处理器
 *
 * @author zclcs
 */
@Slf4j
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class BaseExceptionHandler {

    /**
     * 全局异常.
     *
     * @param e the e
     * @return R
     */
    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseRsp<String> handleGlobalException(Exception e) {
        log.error("全局异常信息 ex={}", e.getMessage(), e);
        return RspUtil.error(500, "系统异常");
    }

    @ExceptionHandler(value = MyException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseRsp<Object> handleMyException(MyException e) {
        log.error("系统业务异常 ex={}", e.getMessage(), e);
        return RspUtil.error(500, e.getMessage());
    }

    @ExceptionHandler(value = FieldException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseRsp<Object> handleFieldException(FieldException e) {
        return RspUtil.error(500, e.getMessage());
    }

    /**
     * 统一处理请求参数校验(实体对象传参)
     *
     * @param e BindException
     * @return Response
     */
    @ExceptionHandler(BindException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseRsp<Object> handleBindException(BindException e) {
        StringBuilder message = new StringBuilder();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        for (FieldError error : fieldErrors) {
            message.append(error.getField()).append(error.getDefaultMessage()).append(Strings.COMMA);
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        log.error(message.toString());
        return RspUtil.error(500, message.toString());
    }

    /**
     * 统一处理请求参数校验(普通传参)
     *
     * @param e ConstraintViolationException
     * @return Response
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseRsp<Object> handleConstraintViolationException(ConstraintViolationException e) {
        StringBuilder message = new StringBuilder();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            Path path = violation.getPropertyPath();
            String s = StrUtil.subAfter(path.toString(), ".", true);
            message.append(s).append(violation.getMessage()).append(Strings.COMMA);
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        log.error(message.toString());
        return RspUtil.error(500, message.toString());
    }

    /**
     * 统一处理请求参数校验(json)
     *
     * @param e ConstraintViolationException
     * @return Response
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseRsp<Object> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        StringBuilder message = new StringBuilder();
        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            message.append(error.getField()).append(error.getDefaultMessage()).append(Strings.COMMA);
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        log.error(message.toString());
        return RspUtil.error(500, message.toString());
    }

    @ExceptionHandler(value = FileDownloadException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseRsp<Object> handleFileDownloadException(FileDownloadException e) {
        log.error("FileDownloadException", e);
        return RspUtil.error(500, e.getMessage());
    }

    @ExceptionHandler(value = FileUploadException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseRsp<Object> handleFileUploadException(FileUploadException e) {
        log.error("FileUploadException", e);
        return RspUtil.error(500, e.getMessage());
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseRsp<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        String message = e.getMessage();
        log.error(message, e);
        if (StrUtil.containsIgnoreCase(message, "java.time.LocalDate")) {
            message = "请传入正确的日期格式, 例：2000-02-12";
        } else if (StrUtil.containsIgnoreCase(message, "java.time.LocalDateTime")) {
            message = "请传入正确的日期格式, 例：2000-02-12 10:00:00";
        } else {
            log.error(message, e);
        }
        return RspUtil.error(500, message);
    }

    @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseRsp<Object> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        String message = "该方法不支持" + e.getContentType() + "媒体类型";
        log.error(message);
        return RspUtil.error(500, message);
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseRsp<Object> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        String message = "该方法不支持" + e.getMethod() + "请求方法";
        log.error(message);
        return RspUtil.error(500, message);
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public BaseRsp<Object> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        String message = e.getMessage();
        String parameterName = e.getParameterName();
        log.error(message);
        return RspUtil.error(500, message);
    }

}
