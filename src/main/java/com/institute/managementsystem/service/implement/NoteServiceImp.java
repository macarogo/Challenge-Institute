package com.institute.managementsystem.service.implement;

import com.institute.managementsystem.dto.NoteDto;
import com.institute.managementsystem.entity.Note;
import com.institute.managementsystem.mapper.NoteMapper;
import com.institute.managementsystem.repository.NoteRepository;
import com.institute.managementsystem.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImp implements NoteService {
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private NoteMapper noteMapper;

    @Override
    public NoteDto save(NoteDto noteDto) {
        Note note= noteMapper.noteDto2Entity(noteDto);
        Note save= noteRepository.save(note);
        return noteMapper.noteEntity2Dto(save);
    }

    @Override
    public NoteDto update(NoteDto noteDto, Long id) {
        Note note= noteRepository.findById(id).orElse(null);
        assert note != null;
        note.setNote(noteDto.getNote());
        Note noteSave= noteRepository.save(note);
        return noteMapper.noteEntity2Dto(noteSave);
    }

    @Override
    public void delete(Long id) {
        Note note= noteRepository.findById(id).orElse(null);
        if (note == null){
            throw new RuntimeException();
        }
        noteRepository.deleteById(id);
    }
}
