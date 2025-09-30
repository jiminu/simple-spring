package com.lgcns.simple_spring.hello.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HelloResponseDTO {
    private String koreaTime;
    private String timestamp;
    private String message;
}
