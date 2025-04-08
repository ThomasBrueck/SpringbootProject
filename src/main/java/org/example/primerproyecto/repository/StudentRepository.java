package org.example.primerproyecto.repository;

import org.example.primerproyecto.entity.Course;
import org.example.primerproyecto.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByProgram(String program);

    Page<Student> findAll(Pageable pageable);

    Optional<Student> findByCode(String code);

}
