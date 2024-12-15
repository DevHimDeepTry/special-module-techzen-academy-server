package vn.techzen.academy_pnv_12.dto.request;

import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;
import vn.techzen.academy_pnv_12.models.Gender;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeSearchDTO {
    @Size(max = 255)
    String name;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate dobFrom;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate dobTo;

    Gender gender;

    @Size(max = 255)
    String salaryRange;

    @Size(max = 20)
    String phone;

    Integer departmentId;
}
