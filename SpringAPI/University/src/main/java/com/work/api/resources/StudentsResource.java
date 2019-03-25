package com.work.api.resources;

import com.work.api.models.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/students/{studentId}")
    public ResponseEntity<Object> getStudentById(@PathVariable int studentId) {
        return new ResponseEntity<>(studentRepo.get(studentId), HttpStatus.OK);
    }

    @RequestMapping(value = "/students/{studentId}", method = RequestMethod.PUT)
    public ResponseEntity<Object> putStudentById(@PathVariable int studentId, @RequestBody Student student) {
        if (studentRepo.containsKey(studentId)) {
            studentRepo.put(studentId, student);
            return new ResponseEntity<>(studentRepo.get(studentId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student not found!", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/students/{studentId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteStudentById(@PathVariable int studentId) {
        if (studentRepo.containsKey(studentId)) {
            studentRepo.remove(studentId);
            return new ResponseEntity<>("Student successfully deleted!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student not found!", HttpStatus.NOT_FOUND);
        }
    }

}
