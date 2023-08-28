package com.institute.managementsystem.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class NoteDto {

    @NotNull(message = "Note type number cannot be null")
    @NotEmpty(message = "Note may not be empty")
    @NotBlank(message = "The note type Number field is required")
    private int note;
}
