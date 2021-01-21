package by.lord.of.words.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DocumentNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(DocumentNotFountException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(DocumentNotFountException ex) {
        return ex.getMessage();
    }
}
