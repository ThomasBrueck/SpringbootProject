package org.example.primerproyecto.service;

import org.example.primerproyecto.dto.EnrollmentDTO;

public interface EnrollmentService {

    EnrollmentDTO enrollStudent(Long studentId, Long courseId);

    void deleteEnrollment(Long enrollmentId);
}
