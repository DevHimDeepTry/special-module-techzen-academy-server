package vn.techzen.academy_pnv_12.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techzen.academy_pnv_12.dto.response.ResponseBuilder;
import vn.techzen.academy_pnv_12.models.Employee;
import vn.techzen.academy_pnv_12.models.Gender;
import vn.techzen.academy_pnv_12.services.interfaces.IEmployeeService;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("api/v1/employees")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
@AllArgsConstructor
public class EmployeeController {

    IEmployeeService employeeService;

    @Tag(name = "Employee")
    @GetMapping(value = "/", headers = "apiKey=v1.0")
    public ResponseEntity<?> getAllEmployees(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "dobFrom", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dobFrom,
            @RequestParam(value = "dobTo", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dobTo,
            @RequestParam(value = "gender", required = false) Gender gender,
            @RequestParam(value = "salaryRange", required = false) String salaryRange,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "departmentId", required = false) Integer departmentId
    ) {
        List<Employee> data = employeeService.filterEmployees(name, dobFrom, dobTo, gender, salaryRange, phone, departmentId);
        return ResponseBuilder.build(data, "Filtered employees retrieved successfully");
    }

    @Tag(name = "Exercise")
    @GetMapping(path = "/{id}", headers = "apiKey=v1.0")
    public ResponseEntity<?> getEmployeeById(@PathVariable UUID id) {
        Employee data = employeeService.getEmployeeById(id);
        return ResponseBuilder.build(data, "Employee fetched successfully");
    }

    @Tag(name = "Exercise")
    @PostMapping(value = "/", headers = "apiKey=v1.0")
    public ResponseEntity<?> addEmployee(@Valid @RequestBody Employee employee) {
            Employee data = employeeService.addEmployee(employee);
            return ResponseBuilder.build(data, "Employee added successfully");

    }

    @Tag(name = "Exercise")
    @PutMapping(path = "/{id}", headers = "apiKey=v1.0")
    public ResponseEntity<?> updateEmployee(@PathVariable UUID id, @Valid @RequestBody Employee updatedEmployee) {
            updatedEmployee.setId(id);
            Employee data = employeeService.updateEmployee(updatedEmployee);
            return ResponseBuilder.build(data, "Employee updated successfully");
    }

    @Tag(name = "Exercise")
    @DeleteMapping(path = "/{id}", headers = "apiKey=v1.0")
    public ResponseEntity<?> deleteEmployee(@PathVariable UUID id) {
            employeeService.deleteEmployee(id);
            return ResponseBuilder.build(null, "Employee deleted successfully");
    }
}