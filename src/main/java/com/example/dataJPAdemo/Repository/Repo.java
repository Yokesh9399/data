package com.example.dataJPAdemo.Repository;

import com.example.dataJPAdemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface Repo extends JpaRepository<Student,Integer> {
  List<Student> findByGenderAndTech( String gender,  String tech);
  List<Student> findByName(String name);
  List<Student> findByTech(String tech);

  @Query(value = "Select * from Student where gender=:gender And tech=:tech",nativeQuery = true)
    List<Student> findByFilterStudent(String gender,String tech);

    @Query("SELECT s FROM Student s WHERE s.name='Priya'")
    List<Student> findByPriya();
}
