package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")

public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> student=studentService.getAllStudents();
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/createStudent")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student saveStudent=studentService.saveStudent(student);
        return new ResponseEntity<>(saveStudent, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id){
        Student student =studentService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity <Student> updateStudent(@PathVariable("id") Long id, @RequestBody Student student){
        student.setId(id);
        Student updteStudent=studentService.updateStudent(student);
        return new ResponseEntity<>(updteStudent, HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id){
        studentService.deleteById(id);
        return new ResponseEntity<>("Student successfully deleted!", HttpStatus.OK);
    }
}
