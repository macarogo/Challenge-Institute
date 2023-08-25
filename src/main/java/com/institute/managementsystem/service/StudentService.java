package com.institute.managementsystem.service;

import com.institute.managementsystem.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto save(StudentDto studentDto);
    StudentDto update(StudentDto studentDto, String id);
    void delete(String id);
    List<StudentDto> getAll();
}
