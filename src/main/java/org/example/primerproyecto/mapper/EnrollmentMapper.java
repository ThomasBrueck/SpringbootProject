package org.example.primerproyecto.mapper;

import org.example.primerproyecto.dto.EnrollmentDTO;
import org.example.primerproyecto.entity.Enrollment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {

    @Mapping(source = "student.id", target = "studentId")
    @Mapping(source = "course.id", target = "courseId")
    EnrollmentDTO toDTO(Enrollment enrollment);

    @Mapping(source = "studentId", target = "student.id")
    @Mapping(source = "courseId", target = "course.id")
    Enrollment toEntity(EnrollmentDTO dto);

    @Mapping(source = "studentId", target = "student.id")
    @Mapping(source = "courseId", target = "course.id")
    void updateEntityFromDTO(EnrollmentDTO dto, @MappingTarget Enrollment enrollment);

    java.util.List<EnrollmentDTO> toDTOList(java.util.List<Enrollment> enrollments);
}
