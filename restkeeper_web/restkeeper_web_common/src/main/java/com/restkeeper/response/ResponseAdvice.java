package com.restkeeper.response;

import com.restkeeper.response.exception.ExceptionResponse;
import com.restkeeper.response.vo.PageVO;
import com.restkeeper.utils.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @program: RestKeeper
 * @author: zhanzhewan
 * @create: 2020-10-07 16:38
 **/

@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if(o instanceof Result){
            return o;
        }
        if (o instanceof ExceptionResponse){
            return new BaseResponse<>(400,((ExceptionResponse) o).getMsg());
        }

        if(o instanceof PageVO){
            return new BaseResponse<>(o);
        }



        return new BaseResponse<>(o);
    }
}
