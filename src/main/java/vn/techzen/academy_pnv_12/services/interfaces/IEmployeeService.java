package vn.techzen.academy_pnv_12.services.interfaces;

import vn.techzen.academy_pnv_12.dto.request.EmployeeSearchDTO;
import vn.techzen.academy_pnv_12.models.Employee;
import vn.techzen.academy_pnv_12.models.Gender;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface IEmployeeService {
     List<Employee> getAllEmployees();
     Employee getEmployeeById(UUID id);
     Employee addEmployee(Employee employee);
     Employee updateEmployee(Employee employee);
     void deleteEmployee(UUID id);
     List<Employee> filterEmployees(EmployeeSearchDTO searchDTO);
}