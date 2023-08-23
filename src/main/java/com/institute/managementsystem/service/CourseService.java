package com.institute.managementsystem.service;

import com.institute.managementsystem.dto.CourseDto;

public interface CourseService {

    CourseDto save(CourseDto courseDto);
    CourseDto update(CourseDto courseDto, String id);
    void delete(String id);
}
