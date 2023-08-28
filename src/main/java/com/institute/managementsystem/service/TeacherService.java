package com.institute.managementsystem.service;

import com.institute.managementsystem.dto.TeacherDto;
import com.institute.managementsystem.dto.TeacherDtoPublic;

import java.util.List;

public interface TeacherService {

    TeacherDto save(TeacherDto teacherDto);
    TeacherDto update (TeacherDto teacherDto, Long id);
    void delete(Long id);
    List<TeacherDto> getAll();
    TeacherDto getById(Long id);
    TeacherDtoPublic getCourseByTeacher(Long teacherId);
}
