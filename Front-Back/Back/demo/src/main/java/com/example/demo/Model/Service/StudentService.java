package com.example.demo.Model.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Model.Student;
import com.example.demo.Model.Repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok().body(repo.findAll());
    }

    public ResponseEntity<Optional<Student>> findStudentById(Integer id) {
        if (!repo.findById(id).isPresent()) {
            throw new StudentException("Id not founded");
        }
        return ResponseEntity.ok().body(repo.findById(id));
    }

    public ResponseEntity<Student> addStudent(Student obj) {
        return ResponseEntity.ok().body(repo.save(obj));
    }

    public ResponseEntity<Student> updateStudent(Integer id, Student obj) {

        findStudentById(id);
        Student old = repo.getById(id);
        old.setName(obj.getName());
        old.setEmail(obj.getEmail());
        repo.save(old);
        return ResponseEntity.ok().body(old);

    }

    public void deleteStudent(Integer id) {
        findStudentById(id);
        repo.deleteById(id);

    }

}
