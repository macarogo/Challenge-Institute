package com.institute.managementsystem.service;

import com.institute.managementsystem.dto.CourseDto;

import java.util.List;

public interface CourseService {

    CourseDto save(CourseDto courseDto);
    CourseDto update(CourseDto courseDto, String id);
    void delete(String id);
    List<CourseDto> getAll();
}
