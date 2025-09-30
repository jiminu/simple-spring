package com.lgcns.simple_spring.hello.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lgcns.simple_spring.hello.domain.dto.HelloResponseDTO;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("")
public class HelloCtrl {
    @GetMapping("/hello")
    public HelloResponseDTO hello() {
        String koreaTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul")).toString();
        String timestamp = String.valueOf(System.currentTimeMillis());
        String message = "Hello, World!";
        
        HelloResponseDTO response = HelloResponseDTO.builder()
                                                    .koreaTime(koreaTime)
                                                    .timestamp(timestamp)
                                                    .message(message)
                                                    .build();
        
        
        return response;
    }
}
