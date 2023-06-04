package com.sysbarbearia.api.algorithms.utils.error;

import com.sysbarbearia.api.services.exceptions.BusinessRuleException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
@RestControllerAdvice
public class BussinesExceptionRuleRecomendationHandler {
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BusinessRuleException.class)
    public String handle(Exception exception) {
        return exception.getMessage();
    }
}
