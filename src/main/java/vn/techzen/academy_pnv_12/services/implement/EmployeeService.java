package vn.techzen.academy_pnv_12.services.implement;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.techzen.academy_pnv_12.dto.request.EmployeeSearchDTO;
import vn.techzen.academy_pnv_12.models.Employee;
import vn.techzen.academy_pnv_12.dto.exception.AppException;
import vn.techzen.academy_pnv_12.dto.exception.ErrorCode;
import vn.techzen.academy_pnv_12.models.Gender;
import vn.techzen.academy_pnv_12.repositories.JPArepo.IEmployeeRepository;
import vn.techzen.academy_pnv_12.services.interfaces.IEmployeeService;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeService implements IEmployeeService {

    IEmployeeRepository employeeRepository;

    @Override
    public Page<Employee> getAllEmployees(EmployeeSearchDTO searchDTO, Pageable pageable) {
        return employeeRepository.filter(
                searchDTO.getName(),
                searchDTO.getDobFrom(),
                searchDTO.getDobTo(),
                searchDTO.getGender(),
                searchDTO.getSalaryRange(),
                searchDTO.getPhone(),
                searchDTO.getDepartmentId(),
                pageable
        );
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXIST));
    }

    @Transactional
    @Override
    public Employee addEmployee(Employee employee) {
        try {
            return employeeRepository.save(employee);
        } catch (Exception e) {
            throw new AppException(ErrorCode.CREATE_FAILED);
        }
    }

    @Transactional
    @Override
    public Employee updateEmployee(Employee updatedEmployee) {
        Employee existingEmployee = employeeRepository.findById(updatedEmployee.getId())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXIST));

        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setSalary(updatedEmployee.getSalary());
        existingEmployee.setGender(updatedEmployee.getGender());
        existingEmployee.setDob(updatedEmployee.getDob());

        return employeeRepository.save(existingEmployee);
    }

    @Transactional
    @Override
    public void deleteEmployee(Integer id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXIST));
        employeeRepository.delete(employee);
    }
}
