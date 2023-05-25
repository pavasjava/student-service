package com.student.service;

import com.student.model.Student;
import com.student.repository.StudentRepository;
import com.student.request.StudentRequest;
import com.student.response.StudentResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public StudentResponse save(StudentRequest student);
    public List<Student> findAll();
    public Optional<Student> findOne(Long id);
    public void delete(Long id);
}
