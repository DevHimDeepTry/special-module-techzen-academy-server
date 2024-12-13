package vn.techzen.academy_pnv_12.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techzen.academy_pnv_12.dto.response.ApiResponse;
import vn.techzen.academy_pnv_12.models.Employee;
import vn.techzen.academy_pnv_12.services.interfaces.IEmployeeService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/employees")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeController {

    private IEmployeeService employeeService;

    @Tag(name = "Exercise")
    @GetMapping(value = "/", headers = "apiKey=v1.0")
    public ResponseEntity<ApiResponse<List<Employee>>> getAll() {
        List<Employee> data = employeeService.getAllEmployees();
        return ResponseEntity.ok(
                ApiResponse.<List<Employee>>builder()
                        .code(UUID.randomUUID())
                        .data(data)
                        .message("Get all employees successfully")
                        .build()
        );
    }

    @PostMapping(value = "", headers = "apiKey=v1.0")
    public ResponseEntity<ApiResponse<Employee>> addEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.addEmployee(employee);
        return ResponseEntity.ok(
                ApiResponse.<Employee>builder()
                        .code(UUID.randomUUID())
                        .data(createdEmployee)
                        .message("Employee added successfully")
                        .build()
        );
    }

    @GetMapping(value = "/{id}", headers = "apiKey=v1.0")
    public ResponseEntity<ApiResponse<Employee>> getEmployeeById(@PathVariable UUID id) {
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(
                ApiResponse.<Employee>builder()
                        .code(UUID.randomUUID())
                        .data(employee)
                        .message("Employee fetched successfully")
                        .build()
        );
    }

    @PutMapping(value = "/{id}", headers = "apiKey=v1.0")
    public ResponseEntity<ApiResponse<Employee>> updateEmployee(@PathVariable UUID id, @RequestBody Employee employee) {
        employee.setId(id);
        Employee updatedEmployee = employeeService.updateEmployee(employee);
        return ResponseEntity.ok(
                ApiResponse.<Employee>builder()
                        .code(UUID.randomUUID())
                        .data(updatedEmployee)
                        .message("Employee updated successfully")
                        .build()
        );
    }

    @DeleteMapping(value = "/{id}", headers = "apiKey=v1.0")
    public ResponseEntity<ApiResponse<Void>> deleteEmployee(@PathVariable UUID id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok(
                ApiResponse.<Void>builder()
                        .code(UUID.randomUUID())
                        .message("Employee deleted successfully")
                        .build()
        );
    }
}