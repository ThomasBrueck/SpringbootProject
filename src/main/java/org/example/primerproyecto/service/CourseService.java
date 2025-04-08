package org.example.primerproyecto.service;

import org.example.primerproyecto.entity.Course;
import org.example.primerproyecto.entity.Student;

import java.util.List;

public interface CourseService {

    Course createCourse(Course course);

    List<Course> getAllCourses();

    List<Course> listCourseOfStudent(long id);

    Course getCourseById(long id);

    void deleteCourse(long id);

    List<Student> listStudentsOfCourse(Course course);

    List<Course> findAll();
}
