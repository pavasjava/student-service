package com.student.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class StudentRequest {
    @Size(min = 3)
    private String firstName;
    @Size(min = 3)
    private String lastName;
    @NotNull
    private String dob;
    private String section;
    private String gender;
    @Range(min = 1, max = 100)
    private Integer marks1;
    @Range(min = 1, max = 100)
    private Integer marks2;
    @Range(min = 1, max = 100)
    private Integer marks3;
    private Integer total;
    private Double avg;
    private String result;
}
