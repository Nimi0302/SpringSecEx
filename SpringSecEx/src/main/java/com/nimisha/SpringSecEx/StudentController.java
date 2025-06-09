package com.nimisha.SpringSecEx;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private List<Student> s= new ArrayList<>(List.of(
             new Student(1,"Nimi",88),
             new Student(3,"Akash",66) ,
             new Student(3,"YASH",55)
   ));

    @GetMapping("/students")
    public List<Student> getStudents() {
        return s;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/students")
    public Student createStudents(@RequestBody Student student) {
        s.add(student);
        return student;
    }
}
