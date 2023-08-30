package com.institute.managementsystem.controller;

import com.institute.managementsystem.dto.StudentDto;
import com.institute.managementsystem.entity.Course;
import com.institute.managementsystem.entity.Student;
import com.institute.managementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto, @PathVariable Long id){
        if(studentDto == null){
            throw new RuntimeException();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentService.update(studentDto,id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id){
        studentService.delete(id);
        return new ResponseEntity<Student>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StudentDto>> getAllStudent(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAll());
    }

    @GetMapping("/{studentId}/courses")
    public ResponseEntity<List<Course>> getStudentEnrollCourse(@PathVariable Long studentId){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentService.getCourseStudent(studentId));
    }
}
