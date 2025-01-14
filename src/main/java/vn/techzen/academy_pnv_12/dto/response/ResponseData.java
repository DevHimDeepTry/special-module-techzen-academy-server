package vn.techzen.academy_pnv_12.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ResponseData<T> {
    UUID code;
    String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    T data;
}
