package org.example.primerproyecto.controller.api;


import org.example.primerproyecto.dto.EnrollmentDTO;
import org.example.primerproyecto.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;


    @PostMapping("/{studentId}/{courseId}")
    public ResponseEntity<EnrollmentDTO> enrollStudentInCourse(@PathVariable Long studentId, @PathVariable Long courseId) {

        EnrollmentDTO enrollmentDTO = enrollmentService.enrollStudent(studentId, courseId);

        return ResponseEntity.status(200).body(enrollmentDTO);
    }

    @DeleteMapping("/{enrollmentId}")
    public ResponseEntity<EnrollmentDTO> deleteEnrollment(@PathVariable Long enrollmentId) {
        try {
            // Use the enrollment service directly or through student service
            enrollmentService.deleteEnrollment(enrollmentId);
            return ResponseEntity.status(200).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).build();
        }
    }
}
