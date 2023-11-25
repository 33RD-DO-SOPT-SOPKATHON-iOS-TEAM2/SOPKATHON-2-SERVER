package org.sopkathon.www.DoSoptSopkathon.user.exception;

import lombok.RequiredArgsConstructor;
import org.sopkathon.www.DoSoptSopkathon.exception.ExceptionType;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum UserExceptionType implements ExceptionType {
    NOT_FOUND_USER(HttpStatus.NOT_FOUND, "존재하지 않는 유저입니다");

    private final HttpStatus httpStatus;
    private final String message;

    @Override
    public HttpStatus httpStatus() {
        return httpStatus();
    }

    @Override
    public String message() {
        return message;
    }
}
