package vn.techzen.academy_pnv_12.services.interfaces;

import vn.techzen.academy_pnv_12.models.Department;

import java.util.List;


public interface IDepartmentService {
     List<Department> getAllDepartments() ;

     Department getDepartmentById(Integer id) ;;

     Department addDepartment(Department department) ;

     Department updateDepartment(Department department);

    public void deleteDepartment(Integer id);
}
