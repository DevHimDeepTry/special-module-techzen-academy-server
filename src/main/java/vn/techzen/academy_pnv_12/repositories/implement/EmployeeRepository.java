package vn.techzen.academy_pnv_12.repositories.implement;

import org.springframework.stereotype.Repository;
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
        employeeMap.put(id1, new Employee(id1, "Mr. Duc", LocalDate.of(1990, 1, 1), Gender.MALE, 5000.0, "123456789"));
        employeeMap.put(id2, new Employee(id2, "Mr. Him", LocalDate.of(1995, 5, 20), Gender.FEMALE, 6000.0, "987654321"));
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