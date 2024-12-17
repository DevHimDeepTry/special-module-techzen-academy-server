package vn.techzen.academy_pnv_12.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Clazz {
    @Id
    Long id;
    String name;

    @OneToMany(mappedBy = "clazz")
    List<Student> student;
}
