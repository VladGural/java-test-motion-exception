package pro.gural.exception.template;

import org.springframework.http.HttpStatus;

/**
 * @author Vladyslav Gural
 * @version 2024-08-01
 */
public abstract class SecurityException extends RuntimeException {
    private HttpStatus status = HttpStatus.UNAUTHORIZED;

    private Object[] parameters = null;

    public SecurityException(String message) {
        super(message);
    }

    public SecurityException(String message, Object... parameters) {
        super(message);
        this.parameters = parameters;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public SecurityException setStatus(HttpStatus status) {
        this.status = status;
        return this;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public SecurityException setParameters(Object[] parameters) {
        this.parameters = parameters;
        return this;
    }

    public abstract String getCode();
}
