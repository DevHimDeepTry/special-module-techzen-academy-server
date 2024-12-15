package vn.techzen.academy_pnv_12.dto.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

import java.util.UUID;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorCode {
    INVALID_SALARY_RANGE(UUID.randomUUID(), "Invalid Salary Range", HttpStatus.INTERNAL_SERVER_ERROR),
    CREATE_FAILED(UUID.randomUUID(), "Failed to create employee", HttpStatus.INTERNAL_SERVER_ERROR),
    UPDATE_FAILED(UUID.randomUUID(), "Update Failed", HttpStatus.BAD_REQUEST),
    WORD_NOT_EXIST(UUID.randomUUID(),"Word is not exist!", HttpStatus.NOT_FOUND),
    EMPLOYEE_NOT_EXIST(UUID.randomUUID(), "Employee is not exist!", HttpStatus.NOT_FOUND),
    USER_NOT_EXIST(UUID.randomUUID(), "User is not exist!", HttpStatus.NOT_FOUND),
    MISSING_PARAMETER(UUID.randomUUID(), "Tham số bắt buộc bị thiếu.", HttpStatus.BAD_REQUEST),
    INVALID_PARAMETER(UUID.randomUUID(), "Tham số không hợp lệ.", HttpStatus.BAD_REQUEST),
    DIVIDE_BY_ZERO(UUID.randomUUID(), "Không được phép chia cho số không.", HttpStatus.BAD_REQUEST);

    UUID code;
    String message;
    HttpStatus status;
}
