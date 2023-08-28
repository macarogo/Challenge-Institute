package com.institute.managementsystem.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.institute.managementsystem.entity.Sex;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class TeacherDtoPublic {

    private String documentType;
    private String documentNumber;
    private String firstName;
    private String lastName;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER, pattern = "yyyy-MM-dd")
    private Date birthdate;
    private String currentAddress;
    private Sex sex;
    private String phone;

    private List<CourseDto> dictatedCourses;
}
