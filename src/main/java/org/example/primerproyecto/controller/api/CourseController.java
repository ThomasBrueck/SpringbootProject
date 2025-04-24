package org.example.primerproyecto.controller.api;


import org.example.primerproyecto.dto.CourseDTO;
import org.example.primerproyecto.dto.CourseWithStudentCountDTO;
import org.example.primerproyecto.service.CourseService;
import org.example.primerproyecto.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @GetMapping("/all")
    public ResponseEntity<List<CourseDTO>> findAll() {
        var courseList = courseService.getAllCourses();
        return ResponseEntity.status(200).body(courseList);
    }

    @GetMapping
    public ResponseEntity<?> all() {
        return ResponseEntity.status(200).body(List.of("course1", "course2", "course3"));
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<?> getStudentCourses(@PathVariable Long studentId) {
        try {
            List<CourseDTO> courses = courseService.getStudentCourses(studentId);
            return ResponseEntity.ok(courses);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createCourse(@RequestBody CourseDTO courseDTO) {
        try {
            CourseDTO createdCourse = courseService.createCourse(courseDTO);
            return ResponseEntity.status(201).body(createdCourse);
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping("/with-student-count")
    public ResponseEntity<?> getCoursesWithStudentCount() {
        try {
            List<CourseWithStudentCountDTO> coursesWithCount = courseService.getCoursesWithStudentCount();
            return ResponseEntity.ok(coursesWithCount);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error retrieving courses: " + e.getMessage());
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchCoursesByName(@RequestParam String name, @RequestParam(defaultValue = "0") int page) {
        try {
            Page<CourseDTO> courses = courseService.findByNameContaining(name, page);

            if (courses.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(courses);
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body("Error searching courses: " + e.getMessage());
        }
    }


}
