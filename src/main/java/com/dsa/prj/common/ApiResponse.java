package com.dsa.prj.common;

import com.dsa.prj.aop.CommonException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.hql.internal.ast.util.ASTPrinter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiResponse<T> {

    private static final String SUCCESS_STATUS = "success";
    private static final String FAIL_STATUS = "fail";
    private static final String ERROR_STATUS = "error";

    private int code;

    private String status;
    private T data;
    private String message;

    public static ApiResponse<?> createSuccessWithNoContent() {
        return new ApiResponse<>(200, SUCCESS_STATUS, null, null);
    }


    public static <T> ApiResponse<T> createSuccess(T data) {
        return new ApiResponse<>(200, SUCCESS_STATUS, data, null);

    }
    public static <T> ApiResponse<T> createSuccess(T data, String message) {
        return new ApiResponse<>(200, SUCCESS_STATUS, data, message);
    }

    public static ApiResponse<?> createFail(BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();

        List<ObjectError> allErrors = bindingResult.getAllErrors();
        for (ObjectError error : allErrors) {
            if (error instanceof FieldError) {
                errors.put(((FieldError) error).getField(), error.getDefaultMessage());
            } else {
                errors.put( error.getObjectName(), error.getDefaultMessage());
            }
        }
        return new ApiResponse<>(500, FAIL_STATUS, errors, null);

    }


    public  static ApiResponse<?> createError(int code, String message) {
        return new ApiResponse<>(code, ERROR_STATUS, null, message);
    }

    public  static ApiResponse<?> createError(String message) {
        return new ApiResponse<>(500, ERROR_STATUS, null, message);
    }

    public  static ApiResponse<?> createError(CommonException commonException) {
        return new ApiResponse<>(commonException.getErrorCode(),
                                ERROR_STATUS,
                                null,
                                commonException.getErrorMessage());
    }



    private ApiResponse(int code, String status, T data, String message) {
        this.code = code;
        this.status = status;
        this.data = data;
        this.message = message;
    }



}
