package vn.techzen.academy_pnv_12.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techzen.academy_pnv_12.dto.response.ApiResponse;
import vn.techzen.academy_pnv_12.models.Employee;
import vn.techzen.academy_pnv_12.models.Gender;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("api/v1/employees")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class EmployeeController {

    UUID id1 = UUID.randomUUID();
    UUID id2 = UUID.randomUUID();
    Map<UUID, Employee> employeeMap = new HashMap<>(
            Map.of(
                    id1, new Employee(id1, "Mr. Duc", LocalDate.of(1990, 1, 1), Gender.MALE, 5000.0, "123456789"),
                    id2, new Employee(id2, "Mr. Him", LocalDate.of(1995, 5, 20), Gender.FEMALE, 6000.0, "987654321")
            )
    );

    private <T> ResponseEntity<ApiResponse<T>> buildResponse(T data, String message) {
        return ResponseEntity.ok(
                ApiResponse.<T>builder()
                        .code(UUID.randomUUID())
                        .data(data)
                        .message(message)
                        .build()
        );
    }

    @Tag(name = "Exercise")
    @GetMapping(value = "/", headers = "apiKey=v1.0")
    public ResponseEntity<ApiResponse<List<Employee>>> getAllEmployees() {
        log.info("Fetching all employees...");
        return buildResponse(new ArrayList<>(employeeMap.values()), "Get all employees successfully");
    }

    @GetMapping(path = "/{id}", headers = "apiKey=v1.0")
    public ResponseEntity<ApiResponse<Employee>> getEmployeeById(@PathVariable UUID id) {
        log.info("Fetching employee with ID: {}", id);
        Employee employee = employeeMap.get(id);
        if (employee == null) {
            return buildResponse(null, "Employee not found");
        }
        return buildResponse(employee, "Employee fetched successfully");
    }

    @PostMapping(value = "/", headers = "apiKey=v1.0")
    public ResponseEntity<ApiResponse<Employee>> addEmployee(@Valid @RequestBody Employee employee) {
        UUID id = UUID.randomUUID();
        employee.setId(id);
        employeeMap.put(id, employee);
        log.info("Added new employee with ID: {}", id);
        return buildResponse(employee, "Employee added successfully");
    }

    @PutMapping(path = "/{id}", headers = "apiKey=v1.0")
    public ResponseEntity<ApiResponse<Employee>> updateEmployee(@PathVariable UUID id, @Valid @RequestBody Employee updatedEmployee) {
        log.info("Updating employee with ID: {}", id);

        Employee existingEmployee = employeeMap.get(id);
        if (existingEmployee == null) {
            return buildResponse(null, "Employee not found");
        }

        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setDob(updatedEmployee.getDob());
        existingEmployee.setGender(updatedEmployee.getGender());
        existingEmployee.setSalary(updatedEmployee.getSalary());
        existingEmployee.setPhone(updatedEmployee.getPhone());

        log.info("Updated employee with ID: {}", id);
        return buildResponse(existingEmployee, "Employee updated successfully");
    }

    @DeleteMapping(path = "/{id}", headers = "apiKey=v1.0")
    public ResponseEntity<ApiResponse<Void>> deleteEmployee(@PathVariable UUID id) {
        log.info("Deleting employee with ID: {}", id);

        if (employeeMap.remove(id) == null) {
            return buildResponse(null, "Employee not found");
        }

        log.info("Deleted employee with ID: {}", id);
        return buildResponse(null, "Employee deleted successfully");
    }
}