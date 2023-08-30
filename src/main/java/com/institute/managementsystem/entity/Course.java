package com.institute.managementsystem.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
import java.util.List;


@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE courses SET soft_delete = true WHERE id=?")
@Where(clause = "soft_delete=false")

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @NotEmpty @NotBlank
    private String nameCourse;
    @Column(name = "duration_Hours")
    private int durationHours;
    @NotNull @NotBlank
    @Column(name = "description_Content")
    private String descriptionContent;
    @Column(name = "note_Approval")
    private int noteApproval;
    private boolean softDelete = Boolean.FALSE;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @JsonManagedReference
    @ManyToMany(mappedBy = "enrolledCourse")
    private List<Student> students;

    @OneToMany(mappedBy = "course")
    private List<Note> notes;
}
