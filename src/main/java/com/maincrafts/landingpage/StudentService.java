package com.maincrafts.landingpage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public Student addStudent(Student student) {
        return repo.save(student);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student getStudent(int id) {
        return repo.findById(id).orElse(null);
    }

    public Student updateStudent(int id, Student updatedStudent) {
        Student existingStudent = repo.findById(id).orElse(null);
        if (existingStudent != null) {
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setAge(updatedStudent.getAge());
            return repo.save(existingStudent);
        }
        return null;
    }

    public void deleteStudent(int id) {
        repo.deleteById(id);
    }
}
