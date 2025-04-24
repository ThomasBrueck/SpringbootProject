package org.example.primerproyecto.mapper;

import org.example.primerproyecto.dto.StudentDTO;
import org.example.primerproyecto.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    // Definir explícitamente los mapeos
    @Mapping(source = "id", target = "id")
    @Mapping(source = "code", target = "code")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "program", target = "program")
    StudentDTO toDTO(Student student);

    // Mapeo inverso
    @Mapping(source = "id", target = "id")
    @Mapping(source = "code", target = "code")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "program", target = "program")
    Student toEntity(StudentDTO studentDTO);

    // Método para actualizar entidad
    void updateEntityFromDTO(StudentDTO studentDTO, @MappingTarget Student student);
}