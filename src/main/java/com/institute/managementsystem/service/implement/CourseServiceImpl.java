package com.institute.managementsystem.service.implement;

import com.institute.managementsystem.dto.CourseDto;
import com.institute.managementsystem.entity.Course;
import com.institute.managementsystem.mapper.CourseMapper;
import com.institute.managementsystem.repository.CourseRepository;
import com.institute.managementsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseMapper courseMapper;
    @Override
    public CourseDto save(CourseDto courseDto) {
        Course course= courseMapper.courseDto2Entity(courseDto);
        Course saveCourse= courseRepository.save(course);
        return courseMapper.courseEntity2Dto(saveCourse);
    }

    @Override
    public CourseDto update(CourseDto courseDto, String id) {
        Course course= courseRepository.findById(id).orElse(null);
        assert course != null;
        course.setName(courseDto.getName());
        course.setDurationHours(courseDto.getDurationHours());
        course.setDescriptionContent(courseDto.getDescriptionContent());
        course.setNoteApproval(courseDto.getNoteApproval());
        course.setTeacherId(courseDto.getTeacherId());
        Course saveCourse= courseRepository.save(course);
        return courseMapper.courseEntity2Dto(saveCourse);
    }

    @Override
    public void delete(String id) {
        Course course= courseRepository.findById(id).orElse(null);
        if(course == null){
            throw new RuntimeException();
        }
        courseRepository.deleteById(id);
    }
}
