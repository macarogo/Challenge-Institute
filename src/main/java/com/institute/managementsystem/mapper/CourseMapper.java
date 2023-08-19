package com.institute.managementsystem.mapper;

import com.institute.managementsystem.dto.CourseDto;
import com.institute.managementsystem.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public CourseDto courseEntity2Dto(Course course){
        CourseDto dto= new CourseDto();
        dto.setName(course.getName());
        dto.setDurationHours(course.getDurationHours());
        dto.setDescriptionContent(course.getDescriptionContent());
        dto.setNoteApproval(course.getNoteApproval());
        dto.setTeacherId(course.getTeacherId());
        return dto;
    }

    public Course courseDto2Entity(CourseDto courseDto){
        Course entity= new Course();
        entity.setName(courseDto.getName());
        entity.setDurationHours(courseDto.getDurationHours());
        entity.setDescriptionContent(courseDto.getDescriptionContent());
        entity.setNoteApproval(courseDto.getNoteApproval());
        entity.setTeacherId(courseDto.getTeacherId());
        return entity;
    }
}
