package com.JoaoDev.ListaContados.Validacao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ControllerException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity exception(Exception e){
        MensagerError error= new MensagerError(HttpStatus.BAD_GATEWAY.value(),e.getMessage());
        return new ResponseEntity(error,HttpStatus.BAD_GATEWAY);
    }
}
