package com.institute.managementsystem.service;

import com.institute.managementsystem.dto.StudentDto;

public interface StudentService {
    StudentDto save(StudentDto studentDto);
    StudentDto update(StudentDto studentDto, String id);
    void delete(String id);
}
