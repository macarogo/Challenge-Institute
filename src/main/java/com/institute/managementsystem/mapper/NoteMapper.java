package com.institute.managementsystem.mapper;

import com.institute.managementsystem.dto.NoteDto;
import com.institute.managementsystem.entity.Note;
import org.springframework.stereotype.Component;

@Component
public class NoteMapper {

    public NoteDto noteEntity2Dto(Note note){
        NoteDto dto= new NoteDto();
        dto.setNote(note.getNote());
        return dto;
    }

    public Note noteDto2Entity(NoteDto noteDto){
        Note entity= new Note();
        entity.setNote(noteDto.getNote());
        return entity;
    }
}
