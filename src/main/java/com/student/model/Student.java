package com.student.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "student")
public class Student {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    @Size(min = 3)
    private String firstName;
    @Size(min = 3)
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "dob")
    private String dob;
    @Column(name = "section")
    private String section;
    @Column(name = "gender")
    private String gender;
    @Column(name = "marks1")
    @Range(min = 1, max = 100)
    private Integer marks1;
    @Column(name = "marks2")
    @Range(min = 1, max = 100)
    private Integer marks2;
    @Column(name = "marks3")
    @Range(min = 1, max = 100)
    private Integer marks3;
    @Column(name = "total")
    private Integer total;
    @Column(name = "avg")
    private Double avg;
    @Column(name = "result")
    private String result;
}
