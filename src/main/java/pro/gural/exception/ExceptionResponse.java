package pro.gural.exception;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Vladyslav Gural
 * @version 2024-08-01
 */
public class ExceptionResponse {
    private Instant timeStamp = Instant.now();
    private String code;
    private String message;
    private Map<String, String> placeHolders = new HashMap<>();

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public ExceptionResponse setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
        return this;
    }

    public String getCode() {
        return code;
    }

    public ExceptionResponse setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ExceptionResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public Map<String, String> getPlaceHolders() {
        return placeHolders;
    }

    public ExceptionResponse setPlaceHolders(Map<String, String> placeHolders) {
        this.placeHolders = placeHolders;
        return this;
    }

    @Override
    public String toString() {
        return "ExceptionResponse{" +
                "timeStamp=" + timeStamp +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", placeHolders=" + placeHolders +
                '}';
    }
}
