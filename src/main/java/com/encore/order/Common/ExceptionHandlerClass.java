package com.encore.order.Common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerClass {
    //자주 나오는 에러를 해당클래스로 묶어서 처리
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, Object>> entityNotFoundHandler(EntityNotFoundException e){
        log.error("EntityNotFoundException message : " + e.getMessage());
        return ErrorResponseDto.errorResponseMessage(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> illegalArguHandler(IllegalArgumentException e){
        log.error("Handler IllegalArgumentException message : " + e.getMessage());
        return ErrorResponseDto.errorResponseMessage(HttpStatus.BAD_REQUEST, e.getMessage());
    }
}
