package com.institute.managementsystem.service.implement;

import com.institute.managementsystem.dto.CourseDto;
import com.institute.managementsystem.entity.Course;
import com.institute.managementsystem.entity.Student;
import com.institute.managementsystem.mapper.CourseMapper;
import com.institute.managementsystem.repository.CourseRepository;
import com.institute.managementsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
    public CourseDto update(CourseDto courseDto, Long id) {
        Course course= courseRepository.findById(id).orElse(null);
        assert course != null;
        course.setNameCourse(courseDto.getNameCourse());
        course.setDurationHours(courseDto.getDurationHours());
        course.setDescriptionContent(courseDto.getDescriptionContent());
        course.setNoteApproval(courseDto.getNoteApproval());
        Course saveCourse= courseRepository.save(course);
        return courseMapper.courseEntity2Dto(saveCourse);
    }

    @Override
    public void delete(Long id) {
        Course course= courseRepository.findById(id).orElse(null);
        if(course == null){
            throw new RuntimeException();
        }
        courseRepository.deleteById(id);
    }

    @Override
    public List<CourseDto> getAll() {
        List<Course> courseList= courseRepository.findAll();
        return courseMapper.courseEntityList2DtoList(courseList);
    }

    @Override
    public List<Student> getStudentCourse(Long courseId) {
        Optional<Course> courseOptional= courseRepository.findById(courseId);
        if (courseOptional.isPresent()){
            Course course= courseOptional.get();
            return course.getStudents();
        }
        return Collections.emptyList();
    }
}
