package com.institute.managementsystem.controller;

import com.institute.managementsystem.dto.StudentDto;
import com.institute.managementsystem.entity.Student;
import com.institute.managementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<StudentDto> saveStudent(@Valid @RequestBody StudentDto studentDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(studentDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto, @PathVariable String id){
        if(studentDto == null){
            throw new RuntimeException();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentService.update(studentDto,id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable String id){
        studentService.delete(id);
        return new ResponseEntity<Student>(HttpStatus.ACCEPTED);
    }
}