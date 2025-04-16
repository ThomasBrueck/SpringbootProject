package org.example.primerproyecto.controller.api;


import org.example.primerproyecto.dto.CourseDTO;
import org.example.primerproyecto.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> findAll() {
        var courseList = courseService.getAllCourses();
        return ResponseEntity.status(200).body(courseList);
    }

    @GetMapping
    public ResponseEntity<?> all() {
        return ResponseEntity.status(200).body(List.of("course1", "course2", "course3"));
    }
}
