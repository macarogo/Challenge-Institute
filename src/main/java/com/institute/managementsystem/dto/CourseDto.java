package com.institute.managementsystem.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CourseDto {

    @NotNull(message = "Name type number cannot be null")
    @NotEmpty(message = "Name may not be empty")
    @NotBlank(message = "The name type Number field is required")
    private String name;
    @NotNull(message = "Duration hours type number cannot be null")
    @NotBlank(message = "The document duration Hours Number field is required")
    private int durationHours;
    @NotNull(message = "Description content type number cannot be null")
    @NotBlank(message = "The description Content type Number field is required")
    private String descriptionContent;
    @NotNull(message = "Note approval type number cannot be null")
    @NotBlank(message = "The note approval type Number field is required")
    private int noteApproval;

    private String teacherId;
}
