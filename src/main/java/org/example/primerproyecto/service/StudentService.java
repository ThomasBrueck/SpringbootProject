package org.example.primerproyecto.service;

import org.example.primerproyecto.dto.StudentDTO;
import org.example.primerproyecto.entity.Course;
import org.example.primerproyecto.entity.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {

     void createStudent(StudentDTO student);

     List<StudentDTO> getAllStudents();

     List<StudentDTO> getByProgram(String program);

     Page<StudentDTO> finAll(int page);

     List<StudentDTO> getStudentsByCourse(Course course);

     StudentDTO getStudentsById(long id);

     StudentDTO getStudentsByCode(String code);

     List<StudentDTO> finAll();
}
