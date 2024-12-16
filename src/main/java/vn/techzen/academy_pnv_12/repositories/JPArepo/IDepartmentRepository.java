package vn.techzen.academy_pnv_12.repositories.JPArepo;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techzen.academy_pnv_12.models.Department;

import java.util.List;
import java.util.Optional;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
    List<Department> findAll();
    Optional<Department> findById(Integer id);
    Department save(Department department);
    void deleteById(Integer id);
}
