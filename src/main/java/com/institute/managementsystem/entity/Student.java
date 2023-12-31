package com.institute.managementsystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE students SET soft_delete = true WHERE id=?")
@Where(clause = "soft_delete=false")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @NotBlank
    @Column(name = "document_Type")
    private String documentType;
    @NotNull @NotBlank
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

    @JsonBackReference
    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
    private List<Course> enrolledCourse;

    @OneToMany(mappedBy = "student")
    private List<Note> notes;

}
