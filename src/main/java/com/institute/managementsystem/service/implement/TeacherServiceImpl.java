package com.institute.managementsystem.service.implement;

import com.institute.managementsystem.dto.TeacherDto;
import com.institute.managementsystem.dto.TeacherDtoPublic;
import com.institute.managementsystem.entity.Course;
import com.institute.managementsystem.entity.Teacher;
import com.institute.managementsystem.mapper.TeacherMapper;
import com.institute.managementsystem.repository.CourseRepository;
import com.institute.managementsystem.repository.TeacherRepository;
import com.institute.managementsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public TeacherDto save(TeacherDto teacherDto) {
        Teacher teacher= teacherMapper.teacherDto2Entity(teacherDto);
        Teacher saveTeacher= teacherRepository.save(teacher);
        return teacherMapper.teacherEntity2Dto(saveTeacher);
    }

    @Override
    public TeacherDto update(TeacherDto teacherDto, Long id) {
        Teacher teacher= teacherRepository.findById(id).orElse(null);
        assert teacher != null;
        teacher.setDocumentType(teacherDto.getDocumentType());
        teacher.setDocumentNumber(teacherDto.getDocumentNumber());
        teacher.setFirstName(teacherDto.getFirstName());
        teacher.setLastName(teacherDto.getLastName());
        teacher.setBirthdate(teacherDto.getBirthdate());
        teacher.setCurrentAddress(teacherDto.getCurrentAddress());
        teacher.setSex(teacherDto.getSex());
        teacher.setPhone(teacherDto.getPhone());
        Teacher teacherSave= teacherRepository.save(teacher);
        return teacherMapper.teacherEntity2Dto(teacherSave);
    }

    @Override
    public void delete(Long id){
        Teacher teacher= teacherRepository.findById(id).orElse(null);
        if(teacher == null){
            throw new RuntimeException();
        }
        teacherRepository.deleteById(id);
    }

    @Override
    public List<TeacherDto> getAll() {
        List<Teacher> teacherList= teacherRepository.findAll();
        return teacherMapper.teacherEntityList2DtoList(teacherList);
    }

    @Override
    public TeacherDto getById(Long id) {
        Teacher teacherId= teacherRepository.findById(id).orElse(null);
        assert teacherId != null;
        return teacherMapper.teacherEntity2Dto(teacherId);
    }

    @Override
    public TeacherDtoPublic getCourseByTeacher(Long teacherId) {
        Teacher teacher= teacherRepository.findById(teacherId).orElse(null);
        assert teacher != null;
        List<Course> courses= courseRepository.findCoursesByTeacherId(teacherId);
        teacher.setDictatedCourses(courses);
        return teacherMapper.teacherEntity2DtoPublic(teacher);
    }
}
