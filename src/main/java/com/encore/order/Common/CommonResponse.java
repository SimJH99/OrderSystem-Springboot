package com.encore.order.Common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CommonResponse {
    private HttpStatus httpStatus;
    private String message;
    private Object result;
    //정상 동작했을 때, Controller에서 ResponseEntity형식으로 return할 수 있도록 해당 클래스에서 선언
    public static ResponseEntity<Map<String, Object>> responseMessage(HttpStatus httpStatus, Object object){
        Map<String, Object> body = new HashMap<>();
        body.put("status", Integer.toString(httpStatus.value()));
        body.put("success data", object);
        return new ResponseEntity<>(body, httpStatus);
    }

}
