package vn.techzen.academy_pnv_12.services.implement;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.techzen.academy_pnv_12.models.Department;
import vn.techzen.academy_pnv_12.repositories.JPArepo.IDepartmentRepository;
import vn.techzen.academy_pnv_12.services.interfaces.IDepartmentService;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentService implements IDepartmentService {

    IDepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Integer id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(Integer id) {
        departmentRepository.deleteById(id);
    }
}
