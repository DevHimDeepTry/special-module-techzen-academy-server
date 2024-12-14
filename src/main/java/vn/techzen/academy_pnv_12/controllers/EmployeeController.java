package vn.techzen.academy_pnv_12.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techzen.academy_pnv_12.dto.response.ResponseBuilder;
import vn.techzen.academy_pnv_12.models.Employee;
import vn.techzen.academy_pnv_12.services.interfaces.IEmployeeService;

import java.util.*;

@RestController
@RequestMapping("api/v1/employees")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
@AllArgsConstructor
public class EmployeeController {

    IEmployeeService employeeService;

    @Tag(name = "Exercise")
    @GetMapping(value = "/", headers = "apiKey=v1.0")
    public ResponseEntity<?> getAllEmployees() {
        List<Employee> data = employeeService.getAllEmployees();
        return ResponseBuilder.build(data, "Get all employees successfully");
    }

    @GetMapping(path = "/{id}", headers = "apiKey=v1.0")
    public ResponseEntity<?> getEmployeeById(@PathVariable UUID id) {
        Employee data = employeeService.getEmployeeById(id);
        return ResponseBuilder.build(data, "Employee fetched successfully");
    }

    @PostMapping(value = "/", headers = "apiKey=v1.0")
    public ResponseEntity<?> addEmployee(@Valid @RequestBody Employee employee) {
            Employee data = employeeService.addEmployee(employee);
            return ResponseBuilder.build(data, "Employee added successfully");

    }

    @PutMapping(path = "/{id}", headers = "apiKey=v1.0")
    public ResponseEntity<?> updateEmployee(@PathVariable UUID id, @Valid @RequestBody Employee updatedEmployee) {
            updatedEmployee.setId(id);
            Employee data = employeeService.updateEmployee(updatedEmployee);
            return ResponseBuilder.build(data, "Employee updated successfully");
    }

    @DeleteMapping(path = "/{id}", headers = "apiKey=v1.0")
    public ResponseEntity<?> deleteEmployee(@PathVariable UUID id) {
            employeeService.deleteEmployee(id);
            return ResponseBuilder.build(null, "Employee deleted successfully");
    }
}