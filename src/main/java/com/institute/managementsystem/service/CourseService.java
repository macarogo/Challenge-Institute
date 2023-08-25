package com.institute.managementsystem.service;

import com.institute.managementsystem.dto.CourseDto;
import com.institute.managementsystem.entity.Student;

import java.util.List;

public interface CourseService {

    CourseDto save(CourseDto courseDto);
    CourseDto update(CourseDto courseDto, String id);
    void delete(String id);
}
