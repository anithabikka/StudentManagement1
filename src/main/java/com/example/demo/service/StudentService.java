package com.example.demo.service;

import com.example.demo.entity.Student;

import java.util.List;

public interface StudentService {

   List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student saveStudent(Student student);
    Student updateStudent(Student student);
   void deleteById(Long id);

}
