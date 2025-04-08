package org.example.primerproyecto.controller;

import org.example.primerproyecto.entity.Course;
import org.example.primerproyecto.entity.Enrollment;
import org.example.primerproyecto.entity.Student;
import org.example.primerproyecto.service.CourseService;
import org.example.primerproyecto.service.EnrollmentService;
import org.example.primerproyecto.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EnrrolmentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping("/matricula")
    public String showMatriculaForm(Model model) {

        List<Student> students = studentService.finAll();
        List<Course> courses = courseService.findAll();

        // Añade las listas al modelo para que estén disponibles en la vista
        model.addAttribute("students", students);
        model.addAttribute("courses", courses);

        return "concurso5"; // Nombre de la vista HTML
    }

    @PostMapping("/matricula")
    public String createMatricula(@RequestParam Long student, @RequestParam Long course, Model model) {
        // Lógica para crear la matrícula (puedes usar tu servicio de matrícula)
        enrollmentService.enrollStudent(student, course);

        model.addAttribute("enrrolment", new Enrollment());

        return "matriculas"; // Redirige a una página con la lista de matrículas
    }


}
