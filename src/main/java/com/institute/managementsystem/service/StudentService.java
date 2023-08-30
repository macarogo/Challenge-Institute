package com.institute.managementsystem.service;

import com.institute.managementsystem.dto.StudentDto;
import com.institute.managementsystem.entity.Course;

import java.util.List;

public interface StudentService {
    StudentDto save(StudentDto studentDto);
    StudentDto update(StudentDto studentDto, Long id);
    void delete(Long id);
    List<StudentDto> getAll();
    List<Course> getCourseStudent(Long studentId);
}
