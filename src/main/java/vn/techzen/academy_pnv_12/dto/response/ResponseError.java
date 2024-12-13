package vn.techzen.academy_pnv_12.dto.response;

import java.util.UUID;

public class ResponseError extends ResponseData<Void> {

    public ResponseError(UUID code, String message) {
        super(code, message, null);
    }
}

