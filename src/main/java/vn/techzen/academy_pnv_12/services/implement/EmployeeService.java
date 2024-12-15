package vn.techzen.academy_pnv_12.services.implement;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techzen.academy_pnv_12.models.Employee;
import vn.techzen.academy_pnv_12.models.Gender;
import vn.techzen.academy_pnv_12.repositories.interfaces.IEmployeeRepository;
import vn.techzen.academy_pnv_12.services.interfaces.IEmployeeService;
import vn.techzen.academy_pnv_12.dto.exception.AppException;
import vn.techzen.academy_pnv_12.dto.exception.ErrorCode;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeService implements IEmployeeService {

    IEmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(UUID id) {
        Employee employee = employeeRepository.findById(id);
        if (employee == null) {
            throw new AppException(ErrorCode.USER_NOT_EXIST);
        }
        return employee;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        try {
            employeeRepository.save(employee);
            return employee;
        } catch (Exception e) {
            throw new AppException(ErrorCode.CREATE_FAILED);
        }
    }

    @Override
    public Employee updateEmployee(Employee updatedEmployee) {
        return Optional.ofNullable(employeeRepository.findById(updatedEmployee.getId()))
                .map(existingEmployee -> {
                    employeeRepository.save(updatedEmployee);
                    return updatedEmployee;
                })
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXIST));
    }


    @Override
    public void deleteEmployee(UUID id) {
        Employee employee = employeeRepository.findById(id);
        if (employee == null) {
            throw new AppException(ErrorCode.USER_NOT_EXIST);
        }
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> filterEmployees(String name, LocalDate dobFrom, LocalDate dobTo, Gender gender, String salaryRange, String phone, Integer departmentId) {
        return employeeRepository.filter(name, dobFrom, dobTo, gender, salaryRange, phone, departmentId);
    }
}