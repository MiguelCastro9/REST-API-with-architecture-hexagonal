package com.api.adapter.exception;

import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author Miguel Castro
 */
@ControllerAdvice
public class ExceptionHandlerCustom extends ResponseEntityExceptionHandler {

    private List<MessageException> generateListToMessages(BindingResult bindingResult) {

        List<MessageException> mensagem = new ArrayList<>();

        bindingResult.getFieldErrors().forEach(err -> {
            String messageUser = err.getDefaultMessage();
            String messageDeveloper = err.toString();
            mensagem.add(new MessageException(messageUser, messageDeveloper));
        });
        return mensagem;
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
        String messageUser = "Product not found.";
        String messageDeveloper = ex.getMessage();
        List<MessageException> messages = new ArrayList<>();
        messages.add(new MessageException(messageUser, messageDeveloper));
        return handleExceptionInternal(ex, messages, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
