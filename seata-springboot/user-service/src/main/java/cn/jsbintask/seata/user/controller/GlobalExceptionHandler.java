package cn.jsbintask.seata.user.controller;

import cn.jsbintask.seata.user.exception.SeataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author jsbintask@gmail.com
 * @date 2019/8/16 15:21
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity exceptionHandler(Exception e) {
        System.out.println("resolved exception: ");
        e.printStackTrace();
        Map<String, Object> body = new HashMap<>();
        body.put("code", 1000);
        body.put("msg", e.getMessage());
        body.put("sub_code", "ER10000");

        return ResponseEntity.of(Optional.of(body));
    }


    @ExceptionHandler(SeataException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity exceptionHandler(SeataException e) {
        System.out.println("resolved seata exception: " + e.getMessage());
        e.printStackTrace();
        Map<String, Object> body = new HashMap<>();
        body.put("code", 5000);
        body.put("msg", e.getMessage());
        body.put("sub_code", "ER50000");
        return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON_UTF8).body(body);
    }
}
