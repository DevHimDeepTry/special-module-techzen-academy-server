package vn.techzen.academy_pnv_12.services.interfaces;

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
     List<Employee> filterEmployees(String name, LocalDate dobFrom, LocalDate dobTo, Gender gender, String salaryRange, String phone, Integer departmentId);
}