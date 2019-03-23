package com.work.api.resources;

import com.work.api.models.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentsResource {

    private static Map<Integer, Student> studentRepo = new HashMap<>();

    static{
        Student adrian = new Student(10, "Filip Adrian");
        Student eugen = new Student(11, "Eugen Chiseliov");
        studentRepo.put(adrian.getStudentId(), adrian);
        studentRepo.put(eugen.getStudentId(), eugen);
    }

    @RequestMapping("/students")
    public ResponseEntity<Object> getStudents() {
        return new ResponseEntity<>(studentRepo.values(), HttpStatus.OK);
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public ResponseEntity<Object> postStudent(@RequestBody Student student) {
        studentRepo.put(student.getStudentId(), student);
        return new ResponseEntity<>("Student created successfully!", HttpStatus.CREATED);
    }

}
