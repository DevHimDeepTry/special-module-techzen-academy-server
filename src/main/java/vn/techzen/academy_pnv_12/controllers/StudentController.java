//package vn.techzen.academy_pnv_12.controllers;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import vn.techzen.academy_pnv_12.models.Student;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@RestController
//@RequestMapping("techzen-academy/api/v1/students")
//public class StudentController {
//
//    private List<Student> students=
//            new ArrayList<>(
//                    Arrays.asList(
//                            new Student(1,"DevHimDeepTry",10),
//                            new Student(2,"Student 2",5)
//                    )
//            );
//
//    @GetMapping
//    public ResponseEntity<List<Student>> readAll(){
//        return ResponseEntity.ok(students);
//    }
//
//    @GetMapping("{id}")
//    public ResponseEntity<Student> readStudent(@PathVariable int id){
//        for(Student student : students){
//            if(student.getId()==id){
//                return ResponseEntity.ok(student);
//            }
//        }
//        return null;
//    }
//
//    @PostMapping("create")
//    public ResponseEntity<Student> createStudent(@RequestBody Student student){
//        student.setId((int)(Math.random()*999999));
//        students.add(student);
//        return ResponseEntity.status(HttpStatus.CREATED).body(student);
//    }
//
//    @PutMapping("{id}")
//    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student){
//        for(Student student1 : students){
//            if(student1.getId()==id){
//                student1.setName(student.getName());
//                student1.setScore(student.getScore());
//            }
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(student);
//    }
//
//}
