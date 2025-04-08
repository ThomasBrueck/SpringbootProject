package org.example.primerproyecto.repository;

import org.example.primerproyecto.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
