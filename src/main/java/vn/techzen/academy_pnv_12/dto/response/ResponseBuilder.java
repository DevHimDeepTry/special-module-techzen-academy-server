package vn.techzen.academy_pnv_12.dto.response;

import org.springframework.http.ResponseEntity;

import java.util.UUID;

public class ResponseBuilder {

    public static <T> ResponseEntity<ApiResponse<T>> build(T data, String message) {
        return ResponseEntity.ok(
                ApiResponse.<T>builder()
                        .code(UUID.randomUUID())
                        .data(data)
                        .message(message)
                        .build()
        );
    }
}
