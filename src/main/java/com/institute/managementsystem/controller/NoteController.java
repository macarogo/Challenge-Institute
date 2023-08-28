package com.institute.managementsystem.controller;

import com.institute.managementsystem.dto.CourseDto;
import com.institute.managementsystem.dto.NoteDto;
import com.institute.managementsystem.entity.Course;
import com.institute.managementsystem.entity.Note;
import com.institute.managementsystem.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping("/save")
    public ResponseEntity<NoteDto> saveNote(@Valid @RequestBody NoteDto noteDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(noteService.save(noteDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<NoteDto> updateNote(@RequestBody NoteDto noteDto, @PathVariable Long id){
        if (noteDto == null){
            throw new RuntimeException();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(noteService.update(noteDto, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Note> deleteNote(@PathVariable Long id){
        noteService.delete(id);
        return new ResponseEntity<Note>(HttpStatus.ACCEPTED);
    }
}
