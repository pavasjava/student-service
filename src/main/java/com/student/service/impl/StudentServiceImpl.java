package com.student.service.impl;

import com.student.model.Student;
import com.student.repository.StudentRepository;
import com.student.request.StudentRequest;
import com.student.response.StudentResponse;
import com.student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public StudentResponse toResponse(Student student){
        return StudentResponse.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .gender(student.getGender())
                .dob(student.getDob())
                .section(student.getSection())
                .marks1(student.getMarks1())
                .marks2(student.getMarks2())
                .marks3(student.getMarks3())
                .total(student.getTotal())
                .avg(student.getAvg())
                .result(student.getResult())
                .build();
    }

    public StudentResponse save(StudentRequest studentRequest){
        if (studentRequest.getFirstName() == null && studentRequest.getFirstName().length()>=3){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Student First Name is Required and it should be more than 3 character");
        }
        if (studentRequest.getLastName() == null && studentRequest.getLastName().length()>=3){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Student Last Name is Required and it should be more than 3 character");
        }
        if (studentRequest.getDob()==null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Student D.O.B is Required");
        }
        if (studentRequest.getGender()==null && studentRequest.getGender() == "M" || studentRequest.getGender() == "F"){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Student Gender is Required and it should be 'M' or 'F' ");
        }
        if (studentRequest.getMarks1()==null && studentRequest.getMarks1()>=0 && studentRequest.getMarks1()<=100){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Student Mark1 is Required and it should 0-100");
        }
        if (studentRequest.getMarks2()==null && studentRequest.getMarks2()>=0 && studentRequest.getMarks2()<=100){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Student Mark2 is Required and it should 0-100");
        }
        if (studentRequest.getMarks3()==null && studentRequest.getMarks3()>=0 && studentRequest.getMarks3()<=100){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Student Mark3 is Required and it should 0-100");
        }
        if (studentRequest.getSection()==null && studentRequest.getSection()=="A"  || studentRequest.getSection()=="B" ||studentRequest.getSection()=="C"){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Student Section is Required and it should A, B or C Section");
        }
        Student st = new Student();
        st.setFirstName(st.getFirstName());
        st.setLastName(st.getLastName());
        st.setGender(st.getGender());
        st.setDob(st.getDob());
        st.setSection(st.getSection());
        st.setMarks1(st.getMarks1());
        st.setMarks2(st.getMarks2());
        st.setMarks3(st.getMarks3());
        st.setTotal(st.getTotal());
        st.setAvg(st.getAvg());
        st.setResult(st.getResult());
        st = studentRepository.save(st);
        return toResponse(st);
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Optional<Student> findOne(Long id){
        return studentRepository.findById(id);
    }
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
