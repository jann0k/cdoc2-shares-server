package ee.cyber.cdoc2.server;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * Global exception handler
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handle ConstraintViolationException as HTTP 400.  ConstraintViolationException is thrown
     * when constraints in OpenAPI spec are violated (example length is wrong).
     * <pre>
     * GET "/key-shares/fc774ed55"
     * jakarta.validation.ConstraintViolationException:
     * getKeyShareByShareId.shareId: size must be between 18 and 34
     * </pre>
     */
    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
