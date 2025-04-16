//package org.example.primerproyecto.integration;
//
//
//import org.example.primerproyecto.entity.Course;
//import org.example.primerproyecto.entity.Enrollment;
//import org.example.primerproyecto.entity.Professor;
//import org.example.primerproyecto.entity.Student;
//import org.example.primerproyecto.repository.ProfessorRepository;
//import org.example.primerproyecto.service.CourseService;
//import org.example.primerproyecto.service.EnrollmentService;
//import org.example.primerproyecto.service.StudentService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@SpringBootTest
//public class StudentServiceIntegrationTest {
//
//
//    @Autowired
//    private StudentService studentService;
//
//    @Autowired
//    private EnrollmentService enrollmentService;
//
//    @Autowired
//    private CourseService courseService;
//
//    @Autowired
//    private ProfessorRepository professorRepository;
//
//
//    @Test
//    void getEnrolledStudents_whenCourseHasStudents_ShouldReturnStudentsList(){
//
//        var professor = new Professor();
//        professor.setName("Alice Andrew");
//        professorRepository.save(professor);
//
//        var courseA = new Course();
//        courseA.setName("Computación en Internet II");
//        courseA.setProfessor(professor);
//        courseService.createCourse(courseA);
//
//        var studentA = new Student();
//        studentA.setName("Juan");
//        studentA.setCode("124");
//        studentA.setProgram("Ing. de Sistemas");
//        //studentService.createStudent(studentA);
//
//        var studentB = new Student();
//        studentB.setName("Pedro");
//        studentB.setCode("125");
//        studentB.setProgram("Ing. de Sistemas2");
//        //studentService.createStudent(studentB);
//
//        enrollmentService.enrollStudent(studentA.getId(), courseA.getId());
//        enrollmentService.enrollStudent(studentB.getId(), courseA.getId());
//
//        //Act
//
//        List<Student> studentList = studentService.getStudentsByCourse(courseA);
//
//        //Assert
//
//        assertEquals(2, studentList.size());
//    }
//}
