package org.sopkathon.www.DoSoptSopkathon.user.exception;

import org.sopkathon.www.DoSoptSopkathon.exception.BaseCustomException;
import org.sopkathon.www.DoSoptSopkathon.exception.ExceptionType;

public class UserException extends BaseCustomException {
    public UserException(ExceptionType exceptionType) {
        super(exceptionType);
    }
}
