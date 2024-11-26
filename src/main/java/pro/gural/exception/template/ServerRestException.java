package pro.gural.exception.template;

import org.springframework.http.HttpStatus;

/**
 * @author Vladyslav Gural
 * @version 2024-08-01
 */
public class ServerRestException extends RestException {
    public ServerRestException(String message) {
        super(message);
    }

    public ServerRestException(String message, Object... parameters) {
        super(message, parameters);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    @Override
    public String getCode() {
        return "internal.server.error";
    }
}
