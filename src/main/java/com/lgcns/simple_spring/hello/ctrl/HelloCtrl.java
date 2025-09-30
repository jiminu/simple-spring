package com.lgcns.simple_spring.hello.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lgcns.simple_spring.hello.domain.dto.HelloResponseDTO;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("")
public class HelloCtrl {
    @GetMapping("/hello")
    public HelloResponseDTO hello() {
        String koreaTime = LocalDateTime.now() + "[Asia/Seoul]";
        String timestamp = new Timestamp(System.currentTimeMillis()).toString();
        String message = "Hello, World!";
        
        HelloResponseDTO response = HelloResponseDTO.builder()
                                                    .koreaTime(koreaTime)
                                                    .timestamp(timestamp)
                                                    .message(message)
                                                    .build();
        
        
        return response;
    }
}
