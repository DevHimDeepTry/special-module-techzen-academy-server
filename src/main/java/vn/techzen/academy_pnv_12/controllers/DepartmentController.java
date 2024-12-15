package vn.techzen.academy_pnv_12.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techzen.academy_pnv_12.dto.response.ResponseBuilder;
import vn.techzen.academy_pnv_12.models.Department;
import vn.techzen.academy_pnv_12.services.interfaces.IDepartmentService;

import java.util.List;

@RestController
@RequestMapping("api/v1/departments")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentController {

    IDepartmentService departmentService;

    @Tag(name = "Department")
    @GetMapping(value = "/", headers = "apiKey=v1.0")
    public ResponseEntity<?> getAllDepartments() {
        List<Department> data = departmentService.getAllDepartments();
        return ResponseBuilder.build(data, "Departments retrieved successfully");
    }

    @Tag(name = "Department")
    @GetMapping(path = "/{id}", headers = "apiKey=v1.0")
    public ResponseEntity<?> getDepartmentById(@PathVariable Integer id) {
        Department data = departmentService.getDepartmentById(id);
        return data != null
                ? ResponseBuilder.build(data, "Department fetched successfully")
                : ResponseEntity.notFound().build();
    }

    @Tag(name = "Department")
    @PostMapping(value = "/", headers = "apiKey=v1.0")
    public ResponseEntity<?> addDepartment(@RequestBody Department department) {
        Department data = departmentService.addDepartment(department);
        return ResponseBuilder.build(data, "Department added successfully");
    }

    @Tag(name = "Department")
    @PutMapping(path = "/{id}", headers = "apiKey=v1.0")
    public ResponseEntity<?> updateDepartment(@PathVariable Integer id, @RequestBody Department updatedDepartment) {
        updatedDepartment.setId(id);
        Department data = departmentService.updateDepartment(updatedDepartment);
        return ResponseBuilder.build(data, "Department updated successfully");
    }

    @Tag(name = "Department")
    @DeleteMapping(path = "/{id}", headers = "apiKey=v1.0")
    public ResponseEntity<?> deleteDepartment(@PathVariable Integer id) {
        departmentService.deleteDepartment(id);
        return ResponseBuilder.build(null, "Department deleted successfully");
    }
}