package org.example.primerproyecto.service.impl;

import org.example.primerproyecto.dto.CourseDTO;
import org.example.primerproyecto.entity.Course;
import org.example.primerproyecto.entity.Student;
import org.example.primerproyecto.mapper.CourseMapper;
import org.example.primerproyecto.repository.CourseRepository;
import org.example.primerproyecto.repository.EnrollmentRepository;
import org.example.primerproyecto.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public CourseDTO createCourse(CourseDTO course) {
        var entity = courseMapper.toEntity(course);
        if (courseRepository.findByName(course.getName()).isEmpty()) {
            Course courseEntity = courseRepository.save(entity);
            return courseMapper.toDTO(courseEntity);
        }else{
            throw new RuntimeException("Course already exists with name " + course.getName());
        }

    }

    @Override
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream().map(entity -> courseMapper.toDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> listCourseOfStudent(long id) {
        var enrollments = enrollmentRepository.findByStudent_Id(id);
        return enrollments.stream().map(enrollment -> courseMapper.toDTO(enrollment.getCourse())).toList();
    }

    @Override
    public CourseDTO getCourseById(long id) {
       var entity =  courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found with id " + id));
       return courseMapper.toDTO(entity);
    }

    @Override
    public void deleteCourse(long id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
        } else {
            throw new RuntimeException("Course not found with id " + id);
        }
    }

    @Override
    public List<Student> listStudentsOfCourse(Course course) {
        var enrollments = enrollmentRepository.findAll();
        return enrollments.stream().filter(enrollment -> enrollment.getCourse().getId() == course.getId())
                .map(enrollment -> enrollment.getStudent()).toList();
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }
}
