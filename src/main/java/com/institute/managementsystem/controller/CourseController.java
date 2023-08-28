package com.institute.managementsystem.controller;

import com.institute.managementsystem.dto.CourseDto;
import com.institute.managementsystem.entity.Course;
import com.institute.managementsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/save")
    public ResponseEntity<CourseDto> saveCourse(@Valid @RequestBody CourseDto courseDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.save(courseDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CourseDto> updateCourse(@RequestBody CourseDto courseDto, @PathVariable Long id){
        if (courseDto == null){
            throw new RuntimeException();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(courseService.update(courseDto,id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable Long id){
        courseService.delete(id);
        return new ResponseEntity<Course>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CourseDto>> getAllCourse(){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.getAll());
    }
}
