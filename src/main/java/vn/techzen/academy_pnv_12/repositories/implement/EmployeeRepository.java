package vn.techzen.academy_pnv_12.repositories.implement;

import org.springframework.stereotype.Repository;
import vn.techzen.academy_pnv_12.models.Employee;
import vn.techzen.academy_pnv_12.models.Gender;
import vn.techzen.academy_pnv_12.repositories.interfaces.IEmployeeRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.Optional;

@Repository
public class EmployeeRepository implements IEmployeeRepository {

    private final List<Employee> employees = new ArrayList<>(
            Arrays.asList(
                    new Employee(UUID.randomUUID(), "Mr. Duc", LocalDate.of(1990, 1, 1), Gender.MALE, 5000.0, "123456789"),
                    new Employee(UUID.randomUUID(), "Mr. Him", LocalDate.of(1995, 5, 20), Gender.FEMALE, 6000.0, "987654321")
            )
    );

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee findById(UUID id) {
        Optional<Employee> employee = employees.stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst();
        return employee.orElse(null);
    }

    @Override
    public Employee save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(UUID.randomUUID());
            employees.add(employee);
        } else {
            Employee existingEmployee = findById(employee.getId());
            if (existingEmployee != null) {
                int index = employees.indexOf(existingEmployee);
                employees.set(index, employee);
            }
        }
        return employee;
    }

    @Override
    public void deleteById(UUID id) {
        employees.removeIf(emp -> emp.getId().equals(id));
    }
}
