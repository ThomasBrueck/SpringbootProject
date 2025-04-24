package org.example.primerproyecto.dto;

public class StudentDTO {

    private long id;

    private String name;

    private String code;

    private String program;


    public StudentDTO() {
    }

    public StudentDTO(long id, String name, String code, String program) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.program = program;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
}
