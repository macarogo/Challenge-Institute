package com.institute.managementsystem.dto;

import com.institute.managementsystem.entity.Course;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class CourseDto {
    @NotNull(message = "Name type number cannot be null")
    @NotEmpty(message = "Name may not be empty")
    @NotBlank(message = "The name type Number field is required")
    private String nameCourse;
    private int durationHours;
    @NotNull(message = "Description content type number cannot be null")
    @NotBlank(message = "The description Content type Number field is required")
    private String descriptionContent;
    private int noteApproval;

    public CourseDto(Course course1) {
        this.nameCourse= course1.getNameCourse();
        this.durationHours= course1.getDurationHours();
        this.descriptionContent= course1.getDescriptionContent();
        this.noteApproval= course1.getNoteApproval();
    }
}