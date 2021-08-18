package com.example.demo.Model.Controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.Model.Student;
import com.example.demo.Model.Service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(path = "students")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Optional<Student>> finStudentById(@PathVariable Integer id) {
        return service.findStudentById(id);
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student obj) {
        return service.addStudent(obj);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student obj, @PathVariable Integer id) {

        return service.updateStudent(id, obj);

    }

    @DeleteMapping(path = "{id}")
    public void deleteStudent(@PathVariable Integer id) {
        service.deleteStudent(id);
    }

}
