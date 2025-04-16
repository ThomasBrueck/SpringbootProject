package org.example.primerproyecto.service.impl;

import org.example.primerproyecto.dto.StudentDTO;
import org.example.primerproyecto.entity.Course;
import org.example.primerproyecto.entity.Enrollment;
import org.example.primerproyecto.entity.Student;
import org.example.primerproyecto.mapper.StudentMapper;
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
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void createStudent(StudentDTO student) {
        var entity = studentMapper.toEntity(student);
        Student studentEntity = studentRepository.save(entity);
        studentMapper.toDTO(studentEntity);
        System.out.println("Creando estudiante " + studentEntity.getName());
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
    public List<StudentDTO> getStudentsByCourse(Course course) {
        List<Enrollment> enrollments = enrollmentRepository.findByCourse(course);
        return enrollments.stream()
                .map(Enrollment::getStudent)
                .map(student -> studentMapper.toDTO(student))
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
