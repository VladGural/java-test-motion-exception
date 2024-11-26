package pro.gural.exception.template;

import org.springframework.http.HttpStatus;

/**
 * @author Vladyslav Gural
 * @version 2024-08-01
 */
public class PermissionDeniedRestException extends RestException {

    public PermissionDeniedRestException(String message) {
        super(message);
    }

    public PermissionDeniedRestException(String message, Object... parameters) {
        super(message, parameters);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.FORBIDDEN;
    }

    @Override
    public String getCode() {
        return "permission.denied.error";
    }
}
