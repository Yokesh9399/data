package com.example.dataJPAdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private Integer rollno;

@NotBlank(message = "Name cannot be Empty")
private String name;

@Email(message = "Invalid Email")
private String email;

@NotBlank(message = "Gender cannot be Empty")
private String gender;

@NotBlank(message= "Technology cannot be Empty")
private String tech;
}
