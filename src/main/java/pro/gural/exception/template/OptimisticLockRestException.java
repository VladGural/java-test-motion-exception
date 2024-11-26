package pro.gural.exception.template;

import org.springframework.http.HttpStatus;

/**
 * @author Vladyslav Gural
 * @version 2024-08-01
 */
public class OptimisticLockRestException extends RestException {
    public OptimisticLockRestException(String message) {
        super(message);
    }

    public OptimisticLockRestException(String message, Object... parameters) {
        super(message, parameters);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.CONFLICT;
    }

    @Override
    public String getCode() {
        return "optimistic.lock.error";
    }
}
