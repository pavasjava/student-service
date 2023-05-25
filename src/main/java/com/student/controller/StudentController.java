package com.student.controller;

import com.student.request.StudentRequest;
import com.student.response.StudentResponse;
import com.student.service.StudentService;
import com.student.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/")
    public ResponseEntity<StudentResponse> getAllStudent(){
        return ResponseEntity.ok((StudentResponse) studentService.findAll());
    }
    @PostMapping("/")
    public ResponseEntity<StudentResponse> addStudent(@RequestBody StudentRequest studentRequest){
        return new ResponseEntity<>(studentService.save(studentRequest), HttpStatus.CREATED);
    }
}
