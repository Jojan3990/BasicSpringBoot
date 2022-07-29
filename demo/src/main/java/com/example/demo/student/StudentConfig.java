package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean //this runs(bean is simply a java object created when framework starts)
    CommandLineRunner commandLineRunner(StudentRepository repository){ //injecting
        return args -> {
            Student jojan = new Student(
                    "Jojan",
                    "raijozan2443@gmail.com",
                    LocalDate.of(2001, Month.NOVEMBER, 11)
            );
            Student alex = new Student(
                    "awesome",
                    "raialex2443@gmail.com",
                    LocalDate.of(2004, Month.NOVEMBER, 11)
            );

            repository.saveAll( //invoking database and doing some function
                    List.of(jojan,alex)
            );
        };
    }
}
