package com.iba.courses.service;

import com.iba.courses.domain.Cat;
import com.iba.courses.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService{
    @Autowired
    private StudentRepository studentRepository;
    public List<Cat> getAllStudent() {
        return studentRepository.getAllStudent();
    }
    public String simpleGet() {
        return "HELLO";
    }
    public void putStudent() {
        studentRepository.addNewStudent();
    }
}
