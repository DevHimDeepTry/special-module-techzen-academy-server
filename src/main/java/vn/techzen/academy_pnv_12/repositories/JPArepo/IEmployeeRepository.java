package vn.techzen.academy_pnv_12.repositories.JPArepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.techzen.academy_pnv_12.models.Employee;
import vn.techzen.academy_pnv_12.models.Gender;

import java.time.LocalDate;
import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
     @Query("""
        FROM Employee
        WHERE (:name IS NULL OR LOWER(name) LIKE LOWER(CONCAT('%', :name, '%')))
        AND (:dobFrom IS NULL OR dob >= :dobFrom)
        AND (:dobTo IS NULL OR dob <= :dobTo)
        AND (:gender IS NULL OR gender = :gender)
        AND (
            :salaryRange IS NULL OR (
                :salaryRange = '5lt' AND salary < 5000000 OR
                :salaryRange = '5-10' AND salary >= 5000000 AND salary < 10000000 OR
                :salaryRange = '10-20' AND salary >= 10000000 AND salary <= 20000000 OR
                :salaryRange = 'gt20' AND salary > 20000000
            )
        )
        AND (:phone IS NULL OR phone LIKE CONCAT('%', :phone, '%'))
        AND (:departmentId IS NULL OR department.id = :departmentId)
    """)
     List<Employee> filter(
             @Param("name") String name,
             @Param("dobFrom") LocalDate dobFrom,
             @Param("dobTo") LocalDate dobTo,
             @Param("gender") Gender gender,
             @Param("salaryRange") String salaryRange,
             @Param("phone") String phone,
             @Param("departmentId") Integer departmentId
     );
}
