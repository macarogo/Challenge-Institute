package com.institute.managementsystem.seeder;

import com.institute.managementsystem.entity.Course;
import com.institute.managementsystem.entity.Sex;
import com.institute.managementsystem.entity.Student;
import com.institute.managementsystem.entity.Teacher;
import com.institute.managementsystem.repository.CourseRepository;
import com.institute.managementsystem.repository.StudentRepository;
import com.institute.managementsystem.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherStudentCourseSeeder implements CommandLineRunner {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void run(String... args) throws Exception {

        Teacher teacher1= new Teacher();
        teacher1.setDocumentType("D.N.I");
        teacher1.setDocumentNumber("33984753");
        teacher1.setFirstName("Benjamin");
        teacher1.setLastName("Leal");
        teacher1.setCurrentAddress("Av.Sarmiento 95");
        teacher1.setSex(Sex.MALE);
        teacher1.setPhone("3816987535");

        Teacher teacher2= new Teacher();
        teacher2.setDocumentType("D.N.I");
        teacher2.setDocumentNumber("31859684");
        teacher2.setFirstName("Cristina");
        teacher2.setLastName("Sanchez");
        teacher2.setCurrentAddress("25 de Mayo 156");
        teacher2.setSex(Sex.FEMALE);
        teacher2.setPhone("11865478");

        Course course1= new Course();
        course1.setName("Java");
        course1.setDurationHours(5);
        course1.setDescriptionContent("con Spring Boot");
        course1.setNoteApproval(8);

        Course course2= new Course();
        course2.setName("SQL");
        course2.setDurationHours(1);
        course2.setDescriptionContent("con MySQL");
        course2.setNoteApproval(10);

        List<Course> teacherCourse= new ArrayList<>();

        course1.setTeacher(teacher1);
        course2.setTeacher(teacher2);

        teacherCourse.add(course1);
        teacherCourse.add(course2);

        teacher1.setDictatedCourses(teacherCourse);
        teacher2.setDictatedCourses(teacherCourse);

        Teacher teacher1Save= teacherRepository.save(teacher1);
        Teacher teacher2Save= teacherRepository.save(teacher2);

        courseRepository.save(course1);
        courseRepository.save(course2);

        Student student1= new Student();
        student1.setDocumentType("D.N.I");
        student1.setDocumentNumber("31456875");
        student1.setFirstName("Carolina");
        student1.setLastName("Gomez");
        student1.setCurrentAddress("Av. Juan B Justo 2999");
        student1.setSex(Sex.FEMALE);
        student1.setPhone("3814956874");

        Student student2= new Student();
        student2.setDocumentType("D.N.I");
        student2.setDocumentNumber("34859685");
        student2.setFirstName("Celeste");
        student2.setLastName("Sanchez");
        student2.setCurrentAddress("Pje. 1 de Mayo 1223");
        student2.setSex(Sex.FEMALE);
        student2.setPhone("3816789584");

        List<Course> courseStudent1= new ArrayList<>();
        courseStudent1.add(course1);
        courseStudent1.add(course2);
        student1.setEnrolledCourse(courseStudent1);

        List<Course> courseStudent2= new ArrayList<>();
        courseStudent2.add(course1);
        student2.setEnrolledCourse(courseStudent2);

        studentRepository.save(student1);
        studentRepository.save(student2);
    }
}
