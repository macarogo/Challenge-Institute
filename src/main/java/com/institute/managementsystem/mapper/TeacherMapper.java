package com.institute.managementsystem.mapper;

import com.institute.managementsystem.dto.TeacherDto;
import com.institute.managementsystem.entity.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {

    public TeacherDto teacherEntity2Dto(Teacher teacher){
        TeacherDto dto= new TeacherDto();
        dto.setDocumentType(teacher.getDocumentType());
        dto.setDocumentNumber(teacher.getDocumentNumber());
        dto.setFirstName(teacher.getFirstName());
        dto.setLastName(teacher.getLastName());
        dto.setBirthdate(teacher.getBirthdate());
        dto.setCurrentAddress(teacher.getCurrentAddress());
        dto.setSex(teacher.getSex());
        dto.setPhone(teacher.getPhone());
        return dto;
    }

    public Teacher teacherDto2Entity(TeacherDto teacherDto){
        Teacher entity= new Teacher();
        entity.setDocumentType(teacherDto.getDocumentType());
        entity.setDocumentNumber(teacherDto.getDocumentNumber());
        entity.setFirstName(teacherDto.getFirstName());
        entity.setLastName(teacherDto.getLastName());
        entity.setBirthdate(teacherDto.getBirthdate());
        entity.setCurrentAddress(teacherDto.getCurrentAddress());
        entity.setSex(teacherDto.getSex());
        entity.setPhone(teacherDto.getPhone());
        return entity;
    }
}
