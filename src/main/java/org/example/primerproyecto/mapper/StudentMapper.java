package org.example.primerproyecto.mapper;

import org.example.primerproyecto.dto.StudentDTO;
import org.example.primerproyecto.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    // Define mapping methods here
    // For example:
    // StudentDTO toDTO(Student student);
    // Student toEntity(StudentDTO studentDTO);
    // void updateEntityFromDTO(StudentDTO studentDTO, @MappingTarget Student student);


    StudentDTO toDTO(Student student);

    Student toEntity(StudentDTO studentDTO);

    void updateEntityFromDTO(StudentDTO studentDTO, @MappingTarget Student student);
}
