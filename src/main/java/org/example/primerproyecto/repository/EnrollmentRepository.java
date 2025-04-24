package org.example.primerproyecto.repository;

import org.example.primerproyecto.entity.Course;
import org.example.primerproyecto.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    List<Enrollment> findByStudent_Id(long id);

    List<Enrollment> findByCourse(Course course);

    List<Enrollment> findByCourseId(Long courseId);


}
