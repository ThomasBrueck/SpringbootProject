package org.example.primerproyecto.service.impl;

import jakarta.transaction.Transactional;
import org.example.primerproyecto.entity.Course;
import org.example.primerproyecto.entity.Enrollment;
import org.example.primerproyecto.entity.Student;
import org.example.primerproyecto.repository.EnrollmentRepository;
import org.example.primerproyecto.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Transactional
    public void enrollStudent(Long studentId, Long courseId) {
        var course = new Course();
        course.setId(courseId);

        var student = new Student();
        student.setId(studentId);

        var enrollment = new Enrollment();
        enrollment.setCourse(course);
        enrollment.setStudent(student);

        enrollmentRepository.save(enrollment);

        /*
        if (true) {
            throw new RuntimeException("Intentional failure for rollback");
        }

         */

    }
}

