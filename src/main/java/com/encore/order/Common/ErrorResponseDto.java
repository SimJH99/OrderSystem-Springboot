package com.encore.order.Common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ErrorResponseDto {
    //에러가 발생했을 때, Controller에서 ResponseEntity형식으로 return할 수 있도록 해당 클래스에서 선언
    public static ResponseEntity<Map<String, Object>> errorResponseMessage(HttpStatus status, String message) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", Integer.toString(status.value()));
        body.put("error message", message);
        return new ResponseEntity<>(body, status);
    }
}
