package vn.techzen.academy_pnv_12.repositories.interfaces;

import vn.techzen.academy_pnv_12.models.Department;

import java.util.List;

public interface IDepartmentRepository {
    List<Department> findAll();
    Department findById(Integer id);
    Department save(Department department);
    void deleteById(Integer id);
}
