package vn.techzen.academy_pnv_12.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.Timestamp;

public class ResponseData<T> {
    private final Timestamp timestamp;
    private final int status;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public ResponseData(int status, String message) {
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.status = status;
        this.message = message;
    }

    public ResponseData(int status, String message, T data) {
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
