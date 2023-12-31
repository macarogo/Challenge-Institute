package com.institute.managementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "teachers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE teachers SET soft_delete = true WHERE id=?")
@Where(clause = "soft_delete=false")

public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @NotBlank
    @Column(name = "document_Type")
    private String documentType;
    @NotNull @NotBlank
    @Column(name = "document_number")
    private String documentNumber;
    @NotNull @NotEmpty @NotBlank
    private String firstName;
    @NotNull @NotEmpty @NotBlank
    private String lastName;
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @NotNull @NotBlank
    @Column(name = "current_address")
    private String currentAddress;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @NotNull @NotBlank
    private String phone;
    private boolean softDelete = Boolean.FALSE;

    @OneToMany(mappedBy = "teacher")
    private List<Course> dictatedCourses;

    @ElementCollection
    private List<String> trainings;
    @ElementCollection
    private List<String> titles;
}