package pro.gural.exception.template;

import org.springframework.http.HttpStatus;
import pro.gural.exception.template.RestException;

/**
 * @author Vladyslav Gural
 * @version 2024-07-31
 */
public class NotFoundRestException extends RestException {

    public NotFoundRestException(String message) {
        super(message);
    }

    public NotFoundRestException(String message, Object... parameters) {
        super(message, parameters);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }

    @Override
    public String getCode() {
        return "not.found.error";
    }
}
