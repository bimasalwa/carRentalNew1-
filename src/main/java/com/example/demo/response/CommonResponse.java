package com.example.demo.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

public class CommonResponse {
    public static ResponseEntity<Object> common(String message, HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseObj);

        return new ResponseEntity<Object>(map, status);
    }

    public static ResponseEntity<Object> success(String message) {
        String msg = message == null ? "OK" : message;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", msg);
        map.put("status", HttpStatus.OK.value());
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }


    public static ResponseEntity<Object> fail(String message) {
        String msg = message == null ? "failed" : message;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", msg);
        map.put("status", HttpStatus.MULTI_STATUS.value());
        return new ResponseEntity<Object>(map, HttpStatus.MULTI_STATUS);
    }
}
