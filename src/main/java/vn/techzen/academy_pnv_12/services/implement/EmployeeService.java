package vn.techzen.academy_pnv_12.services.implement;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techzen.academy_pnv_12.models.Employee;
import vn.techzen.academy_pnv_12.repositories.interfaces.IEmployeeRepository;
import vn.techzen.academy_pnv_12.services.interfaces.IEmployeeService;

import java.util.List;
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
        return employeeRepository.findById(id);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        if (employee.getId() == null || employeeRepository.findById(employee.getId()) == null) {
            throw new IllegalArgumentException("Employee không tồn tại hoặc ID không hợp lệ.");
        }
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(UUID id) {
        if (employeeRepository.findById(id) == null) {
            throw new IllegalArgumentException("Employee không tồn tại.");
        }
        employeeRepository.deleteById(id);
    }
}