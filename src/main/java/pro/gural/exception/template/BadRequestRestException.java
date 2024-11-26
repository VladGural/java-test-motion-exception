package pro.gural.exception.template;

import org.springframework.http.HttpStatus;

/**
 * @author Vladyslav Gural
 * @version 2024-08-01
 */
public class BadRequestRestException extends RestException {

    public BadRequestRestException(String message) {
        super(message);
    }

    public BadRequestRestException(String message, Object... parameters) {
        super(message, parameters);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }

    @Override
    public String getCode() {
        return "bad.request.error";
    }
}
