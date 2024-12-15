package vn.techzen.academy_pnv_12.repositories.interfaces;

import vn.techzen.academy_pnv_12.models.Employee;
import vn.techzen.academy_pnv_12.models.Gender;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface IEmployeeRepository {
     List<Employee> findAll();
     Employee findById(UUID id);
     Employee save(Employee employee);
     void deleteById(UUID id);
     List<Employee> filter(String name, LocalDate dobFrom, LocalDate dobTo, Gender gender, String salaryRange, String phone, Integer departmentId);
}
