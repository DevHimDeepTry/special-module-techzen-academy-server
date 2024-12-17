package vn.techzen.academy_pnv_12.services.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.techzen.academy_pnv_12.dto.request.EmployeeSearchDTO;
import vn.techzen.academy_pnv_12.models.Employee;

import java.util.List;

public interface IEmployeeService {
     Page<Employee> getAllEmployees(EmployeeSearchDTO searchDTO, Pageable pageable);
     Employee getEmployeeById(Integer id);
     Employee addEmployee(Employee employee);
     Employee updateEmployee(Employee employee);
     void deleteEmployee(Integer id);
}
