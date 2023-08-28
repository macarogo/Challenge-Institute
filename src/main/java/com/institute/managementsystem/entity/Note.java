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


@Entity
@Table(name = "notes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE notes SET soft_delete = true WHERE id=?")
@Where(clause = "soft_delete=false")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @NotEmpty @NotBlank
    private int note;
    private boolean softDelete = Boolean.FALSE;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course course;
}
