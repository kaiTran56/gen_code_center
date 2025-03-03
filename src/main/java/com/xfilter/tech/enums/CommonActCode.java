package com.xfilter.tech.enums;

import lombok.Getter;

@Getter
public enum CommonActCode {
    CALL_REQUEST_SUCCESS("REQ00000001", "call request success"),
    CALL_HELLO_WORLD("HELLO000000001", "Hello World");
    CommonActCode(String code, String message){
        this.code = code;
        this.message = message;
    }
    private String code;
    private String message;
}
