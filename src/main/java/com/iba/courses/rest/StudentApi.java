package com.iba.courses.rest;

import com.iba.courses.domain.Cat;
import com.iba.courses.repository.StudentRepository;
import com.iba.courses.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/student")
public class StudentApi {
    @Autowired
    private StudentService studentService;

    @GetMapping("/greeting/{message}")
    private String greeting(@PathVariable String message){
        return "Hello "+message;
    }
    @PostMapping("/simplePost")
    private void postMethod(@RequestBody String s){
        System.out.println(s);
    }
    @PostMapping("/simplePost/{id}")
    private int postMethod(@RequestBody String s,@PathVariable int id){
        System.out.println(s);
        return id;
    }
    @PostMapping("/insert")
    private void putStudent(){studentService.putStudent();}
    @GetMapping("/getAllStudents")
    private List<Cat> getAllStudent(){return studentService.getAllStudent();}
    @GetMapping("/simpleGet")
    private String simpleGet(){return studentService.simpleGet();}
}
