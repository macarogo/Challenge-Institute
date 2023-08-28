package com.institute.managementsystem.service;

import com.institute.managementsystem.dto.NoteDto;

public interface NoteService {
    NoteDto save(NoteDto noteDto);
    NoteDto update(NoteDto noteDto, Long id);
    void delete(Long id);
}
