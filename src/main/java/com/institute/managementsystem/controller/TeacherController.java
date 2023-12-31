package com.institute.managementsystem.controller;

import com.institute.managementsystem.dto.TeacherDto;
import com.institute.managementsystem.dto.TeacherDtoPublic;
import com.institute.managementsystem.entity.Teacher;
import com.institute.managementsystem.repository.TeacherRepository;
import com.institute.managementsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private TeacherRepository teacherRepository;

    @PostMapping("/save")
    public ResponseEntity<TeacherDto> saveTeacher(@Valid @RequestBody TeacherDto teacherDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.save(teacherDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TeacherDto> updateTeacher(@RequestBody TeacherDto teacherDto, @PathVariable Long id){
        if(teacherDto == null){
            throw new RuntimeException();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(teacherService.update(teacherDto,id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Teacher> deleteTeacher(@PathVariable Long id){
        teacherService.delete(id);
        return new ResponseEntity<Teacher>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TeacherDto>> getAllTeacher(){
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getAll());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<TeacherDto> getById(@PathVariable Long id){
        TeacherDto teacherId= teacherService.getById(id);
        if (teacherId == null){
            throw new RuntimeException();
        }
        return ResponseEntity.status(HttpStatus.OK).body(teacherId);
    }

    @GetMapping("/coursesTeacher/{id}")
    public ResponseEntity<Object> getCoursesByTeacher(@PathVariable Long id){
        TeacherDtoPublic teacherCourses = teacherService.getCourseByTeacher(id);
        if (teacherCourses == null){
            throw new RuntimeException();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(teacherCourses);
    }
}
