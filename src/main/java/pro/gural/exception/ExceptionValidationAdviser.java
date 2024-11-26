package pro.gural.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @author Vladyslav Gural
 * @version 2024-07-31
 */
@ControllerAdvice
public class ExceptionValidationAdviser {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionValidationAdviser.class);
}
