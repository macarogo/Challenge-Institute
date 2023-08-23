package com.institute.managementsystem.service.implement;

import com.institute.managementsystem.dto.StudentDto;
import com.institute.managementsystem.entity.Student;
import com.institute.managementsystem.mapper.StudentMapper;
import com.institute.managementsystem.repository.StudentRepository;
import com.institute.managementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public StudentDto save(StudentDto studentDto) {
        Student student= studentMapper.studentDto2Entity(studentDto);
        Student saveStudent= studentRepository.save(student);
        return studentMapper.studentEntity2Dto(saveStudent);
    }

    @Override
    public StudentDto update(StudentDto studentDto, String id) {
        Student student= studentRepository.findById(id).orElse(null);
        assert student != null;
        student.setDocumentType(studentDto.getDocumentType());
        student.setDocumentNumber(studentDto.getDocumentNumber());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setBirthdate(studentDto.getBirthdate());
        student.setCurrentAddress(studentDto.getCurrentAddress());
        student.setSex(studentDto.getSex());
        student.setPhone(studentDto.getPhone());
        Student saveStudent= studentRepository.save(student);
        return studentMapper.studentEntity2Dto(saveStudent);
    }

    @Override
    public void delete(String id) {
        Student student= studentRepository.findById(id).orElse(null);
        if(student == null){
            throw new RuntimeException();
        }
        studentRepository.deleteById(id);
    }
}
