package lt.viko.eif.o.sharapova.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Controller advice that describes how the controller should handle the situation
 * in the case of {@link LibraryNotFoundException} is thrown.
 */
@ControllerAdvice
public class LibraryNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(LibraryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(LibraryNotFoundException ex) {
        return ex.getMessage();
    }

}
