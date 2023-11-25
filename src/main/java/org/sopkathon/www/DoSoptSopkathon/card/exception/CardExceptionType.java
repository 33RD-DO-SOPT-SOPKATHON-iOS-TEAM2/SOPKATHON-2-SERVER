package org.sopkathon.www.DoSoptSopkathon.card.exception;

import lombok.RequiredArgsConstructor;
import org.sopkathon.www.DoSoptSopkathon.exception.ExceptionType;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum CardExceptionType implements ExceptionType {
    NOT_FOUND_CARD(HttpStatus.NOT_FOUND, "증서가 존재하지 않습니다"),
    ALREADY_CREATED_CARD(HttpStatus.CONFLICT, "이미 증서를 등록했습니다");

    private final HttpStatus httpStatus;
    private final String message;

    @Override
    public HttpStatus httpStatus() {
        return httpStatus;
    }

    @Override
    public String message() {
        return message;
    }
}
