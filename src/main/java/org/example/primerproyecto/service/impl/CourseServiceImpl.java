package org.example.primerproyecto.service.impl;

import org.example.primerproyecto.entity.Course;
import org.example.primerproyecto.entity.Student;
import org.example.primerproyecto.repository.CourseRepository;
import org.example.primerproyecto.repository.EnrollmentRepository;
import org.example.primerproyecto.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public Course createCourse(Course course) {
        if (courseRepository.findByName(course.getName()).isEmpty()) {
            return courseRepository.save(course);
        }else{
            throw new RuntimeException("Course already exists with name " + course.getName());
        }

    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> listCourseOfStudent(long id) {
        var enrollments = enrollmentRepository.findByStudent_Id(id);
        return enrollments.stream().map(enrollment -> enrollment.getCourse()).toList();
    }

    @Override
    public Course getCourseById(long id) {

       return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found with id " + id));

       /*
       Optional<Course> course = courseRepository.findById(id);
         if(course.isPresent()){
              return course.get();
         } else {
              throw new RuntimeException("Course not found with id " + id);
         }

         */
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
