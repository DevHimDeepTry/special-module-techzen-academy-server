package vn.techzen.academy_pnv_12.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    LocalDate dob;

    @Enumerated(EnumType.STRING)
    Gender gender;

    Double salary;

    String phone;

    @ManyToOne
    private Department department;
}
