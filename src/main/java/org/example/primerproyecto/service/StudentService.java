package org.example.primerproyecto.service;

import org.example.primerproyecto.dto.CourseDTO;
import org.example.primerproyecto.dto.StudentDTO;
import org.example.primerproyecto.entity.Course;
import org.example.primerproyecto.entity.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {

     StudentDTO createStudent(StudentDTO student);

     List<StudentDTO> getAllStudents();

     List<StudentDTO> getByProgram(String program);

     Page<StudentDTO> finAll(int page);

     StudentDTO updateStudent(Long id, StudentDTO studentDTO);

     List<StudentDTO> getStudentsByCourse(Long courseId);

     StudentDTO getStudentsById(long id);

     StudentDTO getStudentsByCode(String code);

     List<StudentDTO> finAll();

     boolean enrollStudentInCourse(long studentId, long courseId);

     Page<StudentDTO> findAllSortedByName(int page);





}
