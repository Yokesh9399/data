package com.example.dataJPAdemo.Controller;

import com.example.dataJPAdemo.Service.StudentService;
import com.example.dataJPAdemo.model.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
public class StudentController {
    @Autowired
    StudentService s;
    @GetMapping("student")
    public List<Student> getStudent(){
        return s.getStudents();
    }

    @PostMapping("/student")
    public Student addStudent(@Valid @RequestBody Student std){
        s.addStudent(std);
        return std;
    }

    @GetMapping("/student/{rollno}")
    public Student getStudent(@PathVariable Integer rollno){

        return s.getStudentById(rollno);
    }

    @PutMapping("/student/{rollno}")
    public Student updateStudent(@PathVariable Integer rollno, @RequestBody Student std){
        return s.updateStudent(rollno,std);
    }

    @DeleteMapping("/student/{rollno}")
    public String deleteStudent(@PathVariable Integer rollno){
        return s.deleteStudent(rollno);
    }

    @DeleteMapping("/student")
    public String deleteStudents(){
        return s.deleteAllStudent();
    }

    @GetMapping("/student/customs")
    public List<Student> getAllStudentsByGenderAndtech(
            @Param("gender") String gender,
            @Param("tech") String tech
    ){
        return s.getStudentByGenderAndTechnology(gender,tech);
    }

    @GetMapping("/student/name")
    public List<Student> getStudentByName(@Param("name") String name){
        return s.getStudentByName(name);
    }

    @GetMapping("/student/tech/{tech}")
    public List<Student> getStudentByTechnology(@PathVariable String tech){
        return s.getStudentByTech(tech);
    }

    //Native Query
    @GetMapping("/student/filter")
    public List<Student> getStudentByFilter(
            @Param("gender") String gender
            , @Param("tech") String tech){
        return s.getStudentByfilter(gender,tech);
    }

    @GetMapping("/students/findPriya")
    public List<Student> getStudentBynameQuery( ){
        return s.getStudentByNameQuery();
    }
}