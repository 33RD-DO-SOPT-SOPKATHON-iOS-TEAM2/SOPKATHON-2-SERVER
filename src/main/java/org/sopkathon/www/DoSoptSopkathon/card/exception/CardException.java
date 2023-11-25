package org.sopkathon.www.DoSoptSopkathon.card.exception;

import org.sopkathon.www.DoSoptSopkathon.exception.BaseCustomException;
import org.sopkathon.www.DoSoptSopkathon.exception.ExceptionType;

public class CardException extends BaseCustomException {

    public CardException(ExceptionType exceptionType) {
        super(exceptionType);
    }
}
