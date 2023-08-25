package com.institute.managementsystem.repository;

import com.institute.managementsystem.entity.Course;
import com.institute.managementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

    /*@Query("SELECT c.students FROM Course c WHERE c.id = :courseId")
    List<Student> findStudentByCourseId(@Param("courseId") String courseId);*/
}
