package co.com.zemoga.portafolio.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        code = HttpStatus.NOT_FOUND
)
public class ElementNotFoundException extends Exception{

    public ElementNotFoundException(String message) {
        super(message);
    }
}
