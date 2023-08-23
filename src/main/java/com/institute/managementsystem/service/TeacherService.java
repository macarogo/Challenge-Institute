package com.institute.managementsystem.service;

import com.institute.managementsystem.dto.TeacherDto;

public interface TeacherService {

    TeacherDto save(TeacherDto teacherDto);
    TeacherDto update (TeacherDto teacherDto, String id);
    void delete(String id);
}
