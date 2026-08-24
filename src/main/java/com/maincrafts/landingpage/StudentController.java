package com.maincrafts.landingpage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // Create (Add)
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }

    // Read (Get All)
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    // Read (Get By ID)
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        return service.getStudent(id);
    }

    // Update (PUT)
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
    }
}
