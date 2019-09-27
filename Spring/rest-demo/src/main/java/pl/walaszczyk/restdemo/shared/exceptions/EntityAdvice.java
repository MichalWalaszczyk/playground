package pl.walaszczyk.restdemo.shared.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EntityAdvice {

    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseEntity entityNotFoundHandler(EntityNotFoundException ex) {
        ex.printStackTrace();
        return ResponseEntity.notFound().build();
    }

    @ResponseBody
    @ExceptionHandler(EntityAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    ResponseEntity entityAlreadyExistsException(EntityAlreadyExistsException ex) {
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}
