package org.example.primerproyecto.dto;


public class CourseWithStudentCountDTO {

    private Long id;

    private String name;

    private Long professorId;

    private String professorName;

    private int studentCount;


    // Getters and setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Long getProfessorId() { return professorId; }

    public void setProfessorId(Long professorId) { this.professorId = professorId; }

    public String getProfessorName() { return professorName; }

    public void setProfessorName(String professorName) { this.professorName = professorName; }

    public int getStudentCount() { return studentCount; }

    public void setStudentCount(int studentCount) { this.studentCount = studentCount; }
}
