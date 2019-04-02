package cn._51even.efast.exception;

import cn._51even.efast.core.system.BusinessException;
import cn._51even.efast.core.system.ResponseResult;
import cn._51even.efast.core.system.SystemEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Administrator on 2018/5/21.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    //默认异常处理
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Object pageErrorHandler(Exception e) {
        String code="";
        String message="";
        Object data=null;
        if (e instanceof BindException) {    //处理对象校验异常
            BindingResult bindingResult = ((BindException) e).getBindingResult();
            if (bindingResult.hasErrors()) {
                code = SystemEnum.ErrorCode.REQUEST_PARAM_ERROR.getCode();
                message = bindingResult.getFieldError().getDefaultMessage();
            }
        }else if(e instanceof ConstraintViolationException){ //处理单个参数校验异常
            Set<ConstraintViolation<?>> constraintViolations = ((ConstraintViolationException) e).getConstraintViolations();
            Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
            while (iterator.hasNext()){
                ConstraintViolation<?> violation = iterator.next();
                code = SystemEnum.ErrorCode.REQUEST_PARAM_ERROR.getCode();
                message = violation.getMessage();
                break;
            }
        }else if (e instanceof BusinessException){  //处理自定义异常
            code = ((BusinessException) e).getCode();
            message = e.getMessage();
            data = ((BusinessException) e).getData();
        }else {
            code = SystemEnum.ErrorCode.SERVICE_ERROR.getCode();
            message = SystemEnum.ErrorCode.SERVICE_ERROR.getDesc();
        }
        e.printStackTrace();
        return ResponseResult.error(code,message,data);
    }
}
