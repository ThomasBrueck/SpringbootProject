package org.example.primerproyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
//Esto no es un bean pero se puede usar PostConstruct
public class PrimerProyectoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PrimerProyectoApplication.class, args);
    }

}
