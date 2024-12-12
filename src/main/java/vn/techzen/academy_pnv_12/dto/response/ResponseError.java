package vn.techzen.academy_pnv_12.dto.response;

public class ResponseError extends ResponseData{

    public ResponseError(
            int status, String message
    ) {
        super(status, message);
    }
}
