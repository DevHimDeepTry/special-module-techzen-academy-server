package vn.techzen.academy_pnv_12.services.interfaces;

import vn.techzen.academy_pnv_12.dto.request.EmployeeSearchDTO;
import vn.techzen.academy_pnv_12.models.Employee;

import java.util.List;

public interface IEmployeeService {
     List<Employee> getAllEmployees(EmployeeSearchDTO searchDTO);
     Employee getEmployeeById(Integer id);
     Employee addEmployee(Employee employee);
     Employee updateEmployee(Employee employee);
     void deleteEmployee(Integer id);
}
