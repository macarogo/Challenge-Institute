package com.institute.managementsystem.mapper;

import com.institute.managementsystem.dto.*;
import com.institute.managementsystem.entity.Teacher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<TeacherDto> teacherEntityList2DtoList(List<Teacher> teachers){
        List<TeacherDto> dtoList= new ArrayList<>();
        for (Teacher teacher : teachers){
            dtoList.add(this.teacherEntity2Dto(teacher));
        }
        return dtoList;
    }

    public TeacherDtoPublic teacherEntity2DtoPublic(Teacher teacher){
        TeacherDtoPublic dtoPublic= new TeacherDtoPublic();
        dtoPublic.setDocumentType(teacher.getDocumentType());
        dtoPublic.setDocumentNumber(teacher.getDocumentNumber());
        dtoPublic.setFirstName(teacher.getFirstName());
        dtoPublic.setLastName(teacher.getLastName());
        dtoPublic.setBirthdate(teacher.getBirthdate());
        dtoPublic.setCurrentAddress(teacher.getCurrentAddress());
        dtoPublic.setSex(teacher.getSex());
        dtoPublic.setPhone(teacher.getPhone());
        dtoPublic.setDictatedCourses(teacher.getDictatedCourses().stream().map(dictatedCourses -> new CourseDto(dictatedCourses)).collect(Collectors.toList()));
        return dtoPublic;
    }
}
