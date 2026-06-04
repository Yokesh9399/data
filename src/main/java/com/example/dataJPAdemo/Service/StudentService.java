package com.example.dataJPAdemo.Service;

import com.example.dataJPAdemo.Repository.Repo;
import com.example.dataJPAdemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service

public class StudentService {
    @Autowired
    Repo r;

    public List<Student> getStudents() {

        return r.findAll();
    }

    public void addStudent(Student std) {
        r.save(std);

    }


    public Student getStudentById( Integer rollno) {
       return r.findById(rollno).orElse(null);
    }

    public Student updateStudent(Integer rollno, Student std) {
        return r.save(std);

    }

    public String deleteStudent(Integer rollno) {
         r.deleteById(rollno);
         return "Deleted student with rollno: " + rollno;
    }

    public String deleteAllStudent() {
        r.deleteAll();
        return "Deleted all students";
    }


    public List<Student> getStudentByGenderAndTechnology(String gender, String tech) {
        return r.findByGenderAndTech(gender, tech);
    }

    public List<Student> getStudentByName(String name) {
        return r.findByName(name);
    }

    public List<Student> getStudentByTech(String tech) {
        return r.findByTech(tech);
    }

    public List<Student> getStudentByfilter(String gender, String tech) {
        return r.findByFilterStudent(gender,tech);
    }

    public List<Student> getStudentByNameQuery() {
        return r.findByPriya();
    }
}
