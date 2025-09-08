package com.devjefiro.marketing_place.infra.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class RestErrorMessage {
    private HttpStatus httpStatus;
    private String message;
}
