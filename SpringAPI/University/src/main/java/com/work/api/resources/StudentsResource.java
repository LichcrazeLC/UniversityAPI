package com.work.api.resources;

import com.work.api.exceptions.ResourceNotFoundException;
import com.work.api.models.Student;
import com.work.api.repositories.GroupRepository;
import com.work.api.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class StudentsResource {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GroupRepository groupRepository;

    @RequestMapping("/groups/{groupName}/students")
    public ResponseEntity<Object> getStudents(@PathVariable String groupName) {
        if (groupRepository.existsByName(groupName))
            return new ResponseEntity<>(studentRepository.findAllByGroupName(groupName), HttpStatus.OK);
        else
            throw new ResourceNotFoundException("Group not found with Name " + groupName + " and group name " + groupName);
    }

    @RequestMapping(value = "/groups/{groupName}/students", method = RequestMethod.POST)
    public Student postStudent(@PathVariable String groupName, @Valid @RequestBody Student student) {
        return groupRepository.findByName(groupName).map(group -> {
            student.setGroup(group);
            return studentRepository.save(student);
        }).orElseThrow(() -> new ResourceNotFoundException("Group name " + groupName + " not found"));
    }

    @RequestMapping("groups/{groupName}/students/{studentId}")
    public ResponseEntity<Object> getStudentById(@PathVariable String groupName, @PathVariable Long studentId) {
        if (studentRepository.findByGroupNameAndId(groupName, studentId).isPresent())
            return new ResponseEntity<>(studentRepository.findByGroupNameAndId(groupName, studentId), HttpStatus.OK);
        else
            throw new ResourceNotFoundException("Student not found with Id " + studentId + " from Group " + groupName);
    }

    @RequestMapping(value = "groups/{groupName}/students/{studentId}", method = RequestMethod.PUT)
    public Student putStudentById(@PathVariable String groupName, @PathVariable Long studentId, @RequestBody Student student) {
        if(!groupRepository.existsByName(groupName)) {
            throw new ResourceNotFoundException("Group " + groupName + " not found");
        }
        return studentRepository.findById(studentId).map(st -> {
            st.setFullName(student.getFullName());
            return studentRepository.save(st);
        }).orElseThrow(() -> new ResourceNotFoundException("StudentId " + studentId + " not found"));
    }

    @RequestMapping(value = "groups/{groupName}/students/{studentId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteStudentById(@PathVariable String groupName, @PathVariable Long studentId) {
        return studentRepository.findByGroupNameAndId(groupName, studentId).map(student -> {
            studentRepository.delete(student);
            return new  ResponseEntity<Object>("Student deleted!", HttpStatus.OK);
        }).orElseThrow(() -> new ResourceNotFoundException("Student not found with Id " + studentId + " and group name " + groupName));
    }

}

