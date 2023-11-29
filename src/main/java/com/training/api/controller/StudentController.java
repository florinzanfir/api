package com.training.api.controller;


import com.training.api.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    // Spring boot REST API that handles HTTP GET Request - return existing resource
    // http://localhost:8080/students/{id}

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int studentId) {

        Student student = new Student(studentId,"Florin", "Zanfir");

        return ResponseEntity.ok(student);
    }

    // HTTP Get Request
    // http://localhost:8080/students
    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {

        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Florin", "Zanfir"));
        students.add(new Student(2, "Florin", "Zanfir"));

        return ResponseEntity.ok(students);
    }


    // Spring boot REST API that handles HTTP POST Request - create new resource
    // @PostMapping and @RequestBody - retrieve Json object and create student object

    @PostMapping("create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {

        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        System.out.println(student.getAge());

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }


    // Spring boot REST API that handles HTTP PUT Request - update existing resource
    // @PostMapping and @RequestBody - retrieve Json object and create student object
    // http://localhost:8080/students/{id}/update
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int id) {

        student.setId(id);
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        System.out.println(student.getAge());

        return ResponseEntity.ok(student);
    }

    // Spring boot REST API that handles HTTP PUT Request - delete existing resource
    // @PostMapping and @RequestBody - retrieve Json object and create student object
    // http://localhost:8080/students/{id}/delete
    @DeleteMapping("{id}/delete")

    public ResponseEntity<String> deleteStudent(@PathVariable int id) {

        return ResponseEntity.ok( "Student deleted succesfully");
    }
}
