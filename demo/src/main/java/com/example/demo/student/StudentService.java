package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service // we can use component also but as this is more service type so. this helps Contoller know which beam is what it is refearing to
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll(); //this returns list to us
//        return List.of(
//                new Student(
//                        1L,
//                        "Jojan",
//                        "raijozan2443@gmail.com",
//                        LocalDate.of(2001, Month.NOVEMBER,11),
//                        21
//                )
//        );
    }


    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
//        System.out.println(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("student with id "+studentId + "doesn't exists");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student=studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student with id "+studentId+" doesnt exists"));
        if(name!=null && name.length()>0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }
        if(email!=null && email.length()>0 && !Objects.equals(student.getEmail(),email)){
            Optional<Student> studentOptional=studentRepository.findStudentByEmail(email); //checking if email is taken by other or not
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
    }
}
