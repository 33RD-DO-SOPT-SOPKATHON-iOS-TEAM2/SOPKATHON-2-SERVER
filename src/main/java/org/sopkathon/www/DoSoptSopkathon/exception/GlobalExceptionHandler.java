package org.sopkathon.www.DoSoptSopkathon.exception;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String LOG_FORMAT = "%s";
    private static final String SERVER_ERROR_MESSAGE = "서버 오류가 발생하였습니다.";
    private static final String BAD_REQUEST_MESSAGE = "잘못된 요청입니다.";

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionResponse> handleNotReadableException(HttpMessageNotReadableException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ExceptionResponse.of(HttpStatus.BAD_REQUEST.name(), BAD_REQUEST_MESSAGE));
    }

    @ExceptionHandler(BaseCustomException.class)
    public ResponseEntity<ExceptionResponse> handleBaseException(BaseCustomException e) {
        ExceptionType exceptionType = e.getExceptionType();
        log.info(String.format(LOG_FORMAT, e.getMessage()), e);
        return ResponseEntity.status(exceptionType.httpStatus())
                .body(ExceptionResponse.of(exceptionType.name(), exceptionType.message()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception e) {
        HttpStatus httpStatus = INTERNAL_SERVER_ERROR;
        log.error(String.format(LOG_FORMAT, e.getMessage()), e);
        return ResponseEntity.status(httpStatus)
                .body(ExceptionResponse.of(httpStatus.name(), SERVER_ERROR_MESSAGE));
    }
}
