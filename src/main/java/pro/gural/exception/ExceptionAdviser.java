package pro.gural.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pro.gural.exception.template.RestException;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author Vladyslav Gural
 * @version 2024-07-31
 */
@ControllerAdvice
public class ExceptionAdviser {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionAdviser.class);

    private MessageSource messageSource;

    public ExceptionAdviser() {
    }

    @ExceptionHandler(RestException.class)
    public ResponseEntity<ExceptionResponse> handleRestExceptions(RestException ex) {
        String msg = getSourceMessage(ex);
        ExceptionResponse exceptionResponse = new ExceptionResponse()
                .setCode(ex.getCode())
                .setMessage(msg);
        logger.warn("Check rest exception: {}", exceptionResponse.toString(), ex);
        return new ResponseEntity<>(exceptionResponse, ex.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleException(Exception ex) {
        Map<String, Object> errorInfo = new HashMap<>();
        errorInfo.put("message", ex.getMessage());
        errorInfo.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
        errorInfo.put("status_code", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private String getSourceMessage(RestException ex) {
        if (messageSource == null) {
            return ex.getMessage();
        }
        try {
            return messageSource.getMessage(ex.getCode(), ex.getParameters(), Locale.getDefault());
        } catch (Exception e) {
            logger.warn(e.getMessage());
            return ex.getMessage();
        }
    }

    @Autowired
    public ExceptionAdviser setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
        return this;
    }

}
