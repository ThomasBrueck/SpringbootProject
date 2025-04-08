package org.example.primerproyecto.controller;


import org.example.primerproyecto.entity.Student;
import org.example.primerproyecto.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String student(Model model) {
        var students = studentService.getAllStudents();
        model.addAttribute("greeting", "Hola mundo");
        model.addAttribute("students", students);
        model.addAttribute("student", new Student());

        return "student";  //html student
    }

    @GetMapping("/index/{id}")
    public String detail(Model model, @PathVariable("id") long id) {
        try {
            var student = studentService.getStudentsById(id);
            model.addAttribute("student", student);
            return "studentdetail";  //html studentDetail
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/index") // student/index?code=123
    public String detailByCode(Model model, @RequestParam("code") String code) {
        try {
            var student = studentService.getStudentsByCode(code);
            model.addAttribute("student", student);
            return "studentdetail";  //html studentDetail
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping
    public String saveStudent(@ModelAttribute Student student) {
        studentService.createStudent(student);
        return "redirect:/student";
    }


    @GetMapping("/first-task")
    public String studentFirstTask(Model model) {
        var students = studentService.getAllStudents();
        model.addAttribute("greeting", "Hola mundo");
        model.addAttribute("students", students);
        model.addAttribute("student", new Student());

        return "studentfirsttastk";  //html student
    }



}
