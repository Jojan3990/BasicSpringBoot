package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //is basis required for using @getmapping and @postmapping
@RequestMapping(path = "api/v1/student") //instead of going to localhost:8080
public class StudentController {

    private final StudentService studentService; //this is a reference. final keyword is non-access modifier which makes them non-changeable(impossible to inherit or override)

    @Autowired //here we are basically saying upper StudentService should be autowired or upper studentservice will be instansiated and be injected on down studentservice constructor
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping //this will pass json array type to restful end array
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){ // here we take request body and map it into student
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){ //we have mapped upper studentId to here using pathvariable
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path="{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,@RequestParam(required = false) String name, @RequestParam(required = false) String email){
        studentService.updateStudent(studentId,name,email);
    }
}
