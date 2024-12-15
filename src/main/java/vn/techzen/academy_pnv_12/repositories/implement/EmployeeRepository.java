package vn.techzen.academy_pnv_12.repositories.implement;

import org.springframework.stereotype.Repository;
import vn.techzen.academy_pnv_12.dto.exception.AppException;
import vn.techzen.academy_pnv_12.dto.exception.ErrorCode;
import vn.techzen.academy_pnv_12.models.Employee;
import vn.techzen.academy_pnv_12.models.Gender;
import vn.techzen.academy_pnv_12.repositories.interfaces.IEmployeeRepository;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class EmployeeRepository implements IEmployeeRepository {

    private final Map<UUID, Employee> employeeMap = new ConcurrentHashMap<>();

    public EmployeeRepository() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        UUID id3 = UUID.randomUUID();
        UUID id4 = UUID.randomUUID();
        employeeMap.put(id1, new Employee(id1, "Mr. Duc", LocalDate.of(1990, 1, 1), Gender.MALE, 5000.0, "123456789",1124124));
        employeeMap.put(id2, new Employee(id2, "Mr. Him", LocalDate.of(1995, 5, 20), Gender.FEMALE, 6000.0, "987654321",12412241));
        employeeMap.put(id3, new Employee(id3, "Mr. Dev", LocalDate.of(1990, 1, 1), Gender.MALE, 4500000.0, "123456789", 1241241214));
        employeeMap.put(id4, new Employee(id4, "Mr. Ops", LocalDate.of(1995, 5, 20), Gender.FEMALE, 15000000.0, "987654321", 23532523));
    }

    @Override
    public List<Employee> filter(String name, LocalDate dobFrom, LocalDate dobTo, Gender gender, String salaryRange, String phone, Integer departmentId) {
        return employeeMap.values().stream()
                .filter(e -> name == null || name.isEmpty() || e.getName().toLowerCase().contains(name.toLowerCase()))
                .filter(e -> dobFrom == null || !e.getDob().isBefore(dobFrom))
                .filter(e -> dobTo == null || !e.getDob().isAfter(dobTo))
                .filter(e -> gender == null || e.getGender() == gender)
                .filter(e -> salaryRange == null || salaryRange.isEmpty() || filterBySalaryRange(e.getSalary(), salaryRange))
                .filter(e -> phone == null || phone.isEmpty() || e.getPhone().contains(phone))
                .filter(e -> departmentId == null || e.getDepartmentId().equals(departmentId))
                .toList();
    }

    private boolean filterBySalaryRange(Double salary, String salaryRange) {
        if (salaryRange == null || salaryRange.isEmpty()) {
            return true;
        }
        switch (salaryRange) {
            case "5lt":
                return salary < 5000000;
            case "5-10":
                return salary >= 5000000 && salary <= 10000000;
            case "10-20":
                return salary > 10000000 && salary <= 20000000;
            case "gt20":
                return salary > 20000000;
            default:
                return false;
        }
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employeeMap.values());
    }

    @Override
    public Employee findById(UUID id) {
        return employeeMap.get(id);
    }

    @Override
    public Employee save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(UUID.randomUUID());
        }
        employeeMap.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public void deleteById(UUID id) {
        employeeMap.remove(id);
    }
}