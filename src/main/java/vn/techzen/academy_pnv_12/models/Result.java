package vn.techzen.academy_pnv_12.models;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.UniqueElements;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @UniqueElements
    @ManyToOne
    Student student;

    @UniqueElements
    @ManyToOne
    Subject subject;

    String year;
}
