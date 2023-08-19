package com.institute.managementsystem.mapper;

import com.institute.managementsystem.dto.StudentDto;
import com.institute.managementsystem.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentDto studentEntity2Dto(Student student){
        StudentDto dto= new StudentDto();
        dto.setDocumentType(student.getDocumentType());
        dto.setDocumentNumber(student.getDocumentNumber());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setBirthdate(student.getBirthdate());
        dto.setCurrentAddress(student.getCurrentAddress());
        dto.setSex(student.getSex());
        dto.setPhone(student.getPhone());
        return dto;
    }

    public Student studentDto2Entity(StudentDto studentDto){
        Student entity= new Student();
        entity.setDocumentType(studentDto.getDocumentType());
        entity.setDocumentNumber(studentDto.getDocumentNumber());
        entity.setFirstName(studentDto.getFirstName());
        entity.setLastName(studentDto.getLastName());
        entity.setBirthdate(studentDto.getBirthdate());
        entity.setCurrentAddress(studentDto.getCurrentAddress());
        entity.setSex(studentDto.getSex());
        entity.setPhone(studentDto.getPhone());
        return entity;
    }
}
