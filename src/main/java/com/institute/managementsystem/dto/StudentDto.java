package com.institute.managementsystem.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.institute.managementsystem.entity.Sex;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class StudentDto {

    @NotNull(message = "Document type number cannot be null")
    @NotBlank(message = "The document type Number field is required")
    private String documentType;
    @NotNull(message = "Document number cannot be null")
    @NotBlank(message = "The document Number field is required")
    private String documentNumber;
    @NotNull(message = "FirstName cannot be null")
    @NotEmpty(message = "FirstName may not be empty")
    @NotBlank(message = "The firstName field is required")
    private String firstName;
    @NotNull(message = "LastName cannot be null")
    @NotEmpty(message = "LastName may not be empty")
    @NotBlank(message = "The lastName field is required")
    private String lastName;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER, pattern = "yyyy-MM-dd")
    private Date birthdate;
    @NotNull(message = "Current address cannot be null")
    @NotBlank(message = "The current address Number field is required")
    private String currentAddress;
    @NotNull(message = "Sex address cannot be null")
    @NotBlank(message = "The sex address Number field is required")
    private Sex sex;
    @NotNull(message = "Phone address cannot be null")
    @NotBlank(message = "The phone address Number field is required")
    private String phone;
}
