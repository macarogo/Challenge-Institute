package com.institute.managementsystem.mapper;

import com.institute.managementsystem.dto.CourseDto;
import com.institute.managementsystem.entity.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseMapper {

    public CourseDto courseEntity2Dto(Course course){
        CourseDto dto= new CourseDto();
        dto.setNameCourse(course.getNameCourse());
        dto.setDurationHours(course.getDurationHours());
        dto.setDescriptionContent(course.getDescriptionContent());
        dto.setNoteApproval(course.getNoteApproval());
        return dto;
    }

    public Course courseDto2Entity(CourseDto courseDto){
        Course entity= new Course();
        entity.setNameCourse(courseDto.getNameCourse());
        entity.setDurationHours(courseDto.getDurationHours());
        entity.setDescriptionContent(courseDto.getDescriptionContent());
        entity.setNoteApproval(courseDto.getNoteApproval());
        return entity;
    }
    public List<CourseDto> courseEntityList2DtoList(List<Course> courses){
        List<CourseDto> dtoList= new ArrayList<>();
        for (Course course : courses){
            dtoList.add(this.courseEntity2Dto(course));
        }
        return dtoList;
    }
}
