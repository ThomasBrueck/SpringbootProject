package org.example.primerproyecto.service;

import org.example.primerproyecto.entity.Course;
import org.example.primerproyecto.entity.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {

     void createStudent(Student student);

     List<Student> getAllStudents();

     List<Student> getByProgram(String program);

     Page<Student> finAll(int page);

     List<Student> getStudentsByCourse(Course course);

     Student getStudentsById(long id);

     Student getStudentsByCode(String code);

     List<Student> finAll();
}
