package org.example.primerproyecto.service.impl;

import org.example.primerproyecto.dto.StudentDTO;
import org.example.primerproyecto.entity.Course;
import org.example.primerproyecto.entity.Enrollment;
import org.example.primerproyecto.entity.Student;
import org.example.primerproyecto.mapper.StudentMapper;
import org.example.primerproyecto.repository.CourseRepository;
import org.example.primerproyecto.repository.EnrollmentRepository;
import org.example.primerproyecto.repository.StudentRepository;
import org.example.primerproyecto.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Value("${app.pagination.size}")
    private int pageSize;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public StudentDTO createStudent(StudentDTO student) {
        var entity = studentMapper.toEntity(student);
        Student studentEntity = studentRepository.save(entity);

        // Convert back to DTO and return
        StudentDTO createdStudent = studentMapper.toDTO(studentEntity);
        System.out.println("Creando estudiante " + studentEntity.getName());
        return createdStudent;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream().map(entity -> studentMapper.toDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> getByProgram(String program) {
        List<Student> students = studentRepository.findByProgram(program);
        return students.stream().map(entity -> studentMapper.toDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public Page<StudentDTO> finAll(int page) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Student> studentPage = studentRepository.findAll(pageable);
        return studentPage.map(student -> studentMapper.toDTO(student));
    }

    @Override
    public List<StudentDTO> finAll() {
        return studentRepository.findAll().stream()
                .map(student -> studentMapper.toDTO(student))
                .collect(Collectors.toList());
    }

    @Override
    public boolean enrollStudentInCourse(long studentId, long courseId) {
        // Find the student
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + studentId));

        // Find the course
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + courseId));

        // Check if student is already enrolled in this course
        boolean alreadyEnrolled = enrollmentRepository.findByStudent_Id(studentId).stream()
                .anyMatch(enrollment -> enrollment.getCourse().getId() == courseId);

        if (alreadyEnrolled) {
            throw new RuntimeException("Student is already enrolled in this course");
        }

        // Create new enrollment
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        // Save the enrollment
        enrollmentRepository.save(enrollment);

        return true;
    }

    @Override
    public Page<StudentDTO> findAllSortedByName(int page) {
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by("name").ascending());
        Page<Student> studentPage = studentRepository.findAll(pageable);
        return studentPage.map(student -> studentMapper.toDTO(student));
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));

        // Update fields if provided
        if (studentDTO.getName() != null && !studentDTO.getName().isEmpty()) {
            student.setName(studentDTO.getName());
        }

        if (studentDTO.getProgram() != null && !studentDTO.getProgram().isEmpty()) {
            student.setProgram(studentDTO.getProgram());
        }

        // Save the updated student
        Student updatedStudent = studentRepository.save(student);

        // Return the DTO
        return studentMapper.toDTO(updatedStudent);
    }

    @Override
    public List<StudentDTO> getStudentsByCourse(Long courseId) {
        // Check if course exists
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course with ID " + courseId + " not found"));

        // Find all enrollments for this course
        List<Enrollment> enrollments = enrollmentRepository.findByCourseId(courseId);

        // Extract students from enrollments and convert to DTOs
        return enrollments.stream()
                .map(Enrollment::getStudent)
                .map(studentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentsById(long id) {
        return studentRepository.findById(id)
                .map(student -> studentMapper.toDTO(student))
                .orElse(null);
    }

    @Override
    public StudentDTO getStudentsByCode(String code) {
        return studentRepository.findByCode(code)
                .map(student -> studentMapper.toDTO(student))
                .orElse(null);
    }




}
