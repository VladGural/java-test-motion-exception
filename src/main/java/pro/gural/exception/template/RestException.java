package pro.gural.exception.template;

import org.springframework.http.HttpStatus;

/**
 * @author Vladyslav Gural
 * @version 2024-07-31
 */
public abstract class RestException extends RuntimeException {

    private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

    private Object[] parameters = null;

    public RestException(String message) {
        super(message);
    }

    public RestException(String message, Object... parameters) {
        super(message);
        this.parameters = parameters;
    }

    public RestException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public RestException setStatus(HttpStatus status) {
        this.status = status;
        return this;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public RestException setParameters(Object[] parameters) {
        this.parameters = parameters;
        return this;
    }

    public abstract String getCode();
}
