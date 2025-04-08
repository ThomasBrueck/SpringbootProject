package org.example.primerproyecto.service.impl;

import org.example.primerproyecto.entity.Course;
import org.example.primerproyecto.entity.Enrollment;
import org.example.primerproyecto.entity.Student;
import org.example.primerproyecto.repository.EnrollmentRepository;
import org.example.primerproyecto.repository.StudentRepository;
import org.example.primerproyecto.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    private EnrollmentRepository enrollmentRepository;

    @Override
    public void createStudent(Student student) {
        studentRepository.save(student);
        System.out.println("Creando estudiante " + student.getName());
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getByProgram(String program) {
        return studentRepository.findByProgram(program);
    }

    @Override
    public Page<Student> finAll(int page) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return studentRepository.findAll(pageable);
    }

    @Override
    public List<Student> finAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudentsByCourse(Course course) {
        List<Enrollment> enrollments = enrollmentRepository.findByCourse(course);
        return enrollments.stream().map(Enrollment::getStudent).collect(Collectors.toList());
    }

    @Override
    public Student getStudentsById(long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student getStudentsByCode(String code) {
        return studentRepository.findByCode(code).orElse(null);
    }


}
