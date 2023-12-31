package com.institute.managementsystem.repository;

import com.institute.managementsystem.entity.Course;
import com.institute.managementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM courses WHERE teacher_id = ?1")
    List<Course> findCoursesByTeacherId(Long teacherId);

    default void addStudentCourse(Student student, Course course) {
        student.getEnrolledCourse().add(course);
        course.getStudents().add(student);
        save(course);
    }
}
