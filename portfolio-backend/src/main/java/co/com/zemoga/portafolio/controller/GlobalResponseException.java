package co.com.zemoga.portafolio.controller;

import co.com.zemoga.portafolio.dto.MessageOutDto;
import co.com.zemoga.portafolio.util.ElementNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class GlobalResponseException {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalResponseException.class);

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<MessageOutDto> handleExceptionNotFound(ElementNotFoundException ex){
        log.info("Global Exception NOT_FLOUND: " + ex.getMessage());
        MessageOutDto messageOutDto = new MessageOutDto();
        messageOutDto.setError(true);
        messageOutDto.setAnswerDescription(ex.getMessage());
        return new ResponseEntity<>(messageOutDto, HttpStatus.NOT_FOUND);
    }
}
