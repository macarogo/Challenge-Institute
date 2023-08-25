package com.institute.managementsystem.service.implement;

import com.institute.managementsystem.dto.TeacherDto;
import com.institute.managementsystem.entity.Teacher;
import com.institute.managementsystem.mapper.TeacherMapper;
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

    @Override
    public TeacherDto save(TeacherDto teacherDto) {
        Teacher teacher= teacherMapper.teacherDto2Entity(teacherDto);
        Teacher saveTeacher= teacherRepository.save(teacher);
        return teacherMapper.teacherEntity2Dto(saveTeacher);
    }

    @Override
    public TeacherDto update(TeacherDto teacherDto, String id) {
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
    public void delete(String id){
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
}
