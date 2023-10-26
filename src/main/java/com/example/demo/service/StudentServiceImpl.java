package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepo studentRepo;


    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepo.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> studentOptional=studentRepo.findById(id);
        return studentOptional.get();
    }



    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        Student existingStudent = studentRepo.findById(student.getId()).get();
        existingStudent.setName(student.getName());
        existingStudent.setAddress(student.getAddress());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setMobNo(student.getMobNo());
        Student updatedStudent = studentRepo.save(existingStudent);
        return updatedStudent;
    }

    @Override
    public void deleteById(Long id) {
        studentRepo.deleteById(id);


    }
}
