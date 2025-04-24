package org.example.primerproyecto.service.impl;

import jakarta.transaction.Transactional;
import org.example.primerproyecto.dto.EnrollmentDTO;
import org.example.primerproyecto.entity.Course;
import org.example.primerproyecto.entity.Enrollment;
import org.example.primerproyecto.entity.Student;
import org.example.primerproyecto.mapper.EnrollmentMapper;
import org.example.primerproyecto.repository.EnrollmentRepository;
import org.example.primerproyecto.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private EnrollmentMapper enrollmentMapper;

    @Transactional
    public EnrollmentDTO enrollStudent(Long studentId, Long courseId) {
        var course = new Course();
        course.setId(courseId);

        var student = new Student();
        student.setId(studentId);

        var enrollment = new Enrollment();
        enrollment.setCourse(course);
        enrollment.setStudent(student);

        enrollmentRepository.save(enrollment);

        return enrollmentMapper.toDTO(enrollment);
    }

    @Override
    public void deleteEnrollment(Long enrollmentId) {

        if (!enrollmentRepository.existsById(enrollmentId)) {
            throw new RuntimeException("Enrollment not found with ID: " + enrollmentId);
        }

        // Delete the enrollment
        enrollmentRepository.deleteById(enrollmentId);
    }
}

