package com.example.demo.Model.Configuration;

import java.util.List;

import com.example.demo.Model.Student;
import com.example.demo.Model.Repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig implements CommandLineRunner {

    @Autowired
    private StudentRepository repo;

    @Override
    public void run(String... args) throws Exception {
        Student s1 = new Student("Julia", "julia@email.com");
        Student s2 = new Student("Cassiano", "cassiano@email.com");
        repo.saveAll(List.of(s1, s2));

    }

}
