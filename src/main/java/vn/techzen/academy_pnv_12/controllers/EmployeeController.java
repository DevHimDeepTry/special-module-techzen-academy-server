package vn.techzen.academy_pnv_12.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techzen.academy_pnv_12.dto.request.EmployeeSearchDTO;
import vn.techzen.academy_pnv_12.dto.response.PaginatedResponse;
import vn.techzen.academy_pnv_12.dto.response.ResponseBuilder;
import vn.techzen.academy_pnv_12.models.Employee;
import vn.techzen.academy_pnv_12.services.interfaces.IEmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@AllArgsConstructor
public class EmployeeController {

    private final IEmployeeService employeeService;

    @Tag(name = "Employee")
    @GetMapping(headers = "apiKey=v1.0")
    public ResponseEntity<?> getAllEmployees(
            @Valid EmployeeSearchDTO searchDTO,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> data = employeeService.getAllEmployees(searchDTO, pageable);
        PaginatedResponse<Employee> res = new PaginatedResponse<>(data);
        return ResponseBuilder.build(res, "Filtered employees retrieved successfully");
    }

    @Tag(name = "Employee")
    @GetMapping(path = "/{id}", headers = "apiKey=v1.0")
    public ResponseEntity<?> getEmployeeById(@PathVariable Integer id) {
        Employee data = employeeService.getEmployeeById(id);
        return ResponseBuilder.build(data, "Employee fetched successfully");
    }

    @Tag(name = "Employee")
    @PostMapping(headers = "apiKey=v1.0")
    public ResponseEntity<?> addEmployee(@Valid @RequestBody Employee employee) {
        Employee data = employeeService.addEmployee(employee);
        return ResponseBuilder.build(data, "Employee added successfully");
    }

    @Tag(name = "Employee")
    @PutMapping(path = "/{id}", headers = "apiKey=v1.0")
    public ResponseEntity<?> updateEmployee(@PathVariable Integer id, @Valid @RequestBody Employee updatedEmployee) {
        updatedEmployee.setId(id);
        Employee data = employeeService.updateEmployee(updatedEmployee);
        return ResponseBuilder.build(data, "Employee updated successfully");
    }

    @Tag(name = "Employee")
    @DeleteMapping(path = "/{id}", headers = "apiKey=v1.0")
    public ResponseEntity<?> deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return ResponseBuilder.build(null, "Employee deleted successfully");
    }
}
