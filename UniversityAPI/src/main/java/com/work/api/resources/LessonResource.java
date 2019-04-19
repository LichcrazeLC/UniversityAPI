package com.work.api.resources;

import com.work.api.exceptions.ResourceNotFoundException;
import com.work.api.models.Lesson;
import com.work.api.repositories.GroupRepository;
import com.work.api.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class LessonResource {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private GroupRepository groupRepository;

    @RequestMapping("/groups/{groupName}/lessons")
    public ResponseEntity<Object> getLessons(@PathVariable String groupName) {
        if (groupRepository.existsByName(groupName))
            return new ResponseEntity<>(lessonRepository.findAllByGroupName(groupName), HttpStatus.OK);
        else
            throw new ResourceNotFoundException("Group not found with name " + groupName);
    }

    @RequestMapping(value = "/groups/{groupName}/lessons", method = RequestMethod.POST)
    public Lesson postLesson(@PathVariable String groupName, @Valid @RequestBody Lesson lesson) {
        return groupRepository.findByName(groupName).map(group -> {
            lesson.setGroup(group);
            return lessonRepository.save(lesson);
        }).orElseThrow(() -> new ResourceNotFoundException("Group name " + groupName + " not found"));
    }

    @RequestMapping("groups/{groupName}/lessons/{lessonId}")
    public ResponseEntity<Object> getLessonById(@PathVariable String groupName, @PathVariable Long lessonId) {
        if (lessonRepository.findByGroupNameAndId(groupName, lessonId).isPresent())
            return new ResponseEntity<>(lessonRepository.findByGroupNameAndId(groupName, lessonId), HttpStatus.OK);
        else
            throw new ResourceNotFoundException("Lesson not found with Id " + lessonId + " from Group " + groupName);
    }

    @RequestMapping(value = "groups/{groupName}/lessons/{lessonId}", method = RequestMethod.PUT)
    public Lesson putLessonById(@PathVariable String groupName, @PathVariable Long lessonId, @RequestBody Lesson lesson) {
        if(!groupRepository.existsByName(groupName)) {
            throw new ResourceNotFoundException("Group " + groupName + " not found");
        }
        return lessonRepository.findById(lessonId).map(ls -> {
            ls.setFaculty(lesson.getFaculty());
            ls.setName(lesson.getName());
            ls.setSpecialty(lesson.getSpecialty());
            ls.setYear(lesson.getYear());
            return lessonRepository.save(ls);
        }).orElseThrow(() -> new ResourceNotFoundException("Lesson Id " + lessonId + " not found"));
    }

    @RequestMapping(value = "groups/{groupName}/lessons/{lessonId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteLessonById(@PathVariable String groupName, @PathVariable Long lessonId) {
        return lessonRepository.findByGroupNameAndId(groupName, lessonId).map(lesson -> {
            lessonRepository.delete(lesson);
            return new  ResponseEntity<Object>("Lesson successfully deleted!", HttpStatus.OK);
        }).orElseThrow(() -> new ResourceNotFoundException("Lesson not found with Id " + lessonId + " and group name " + groupName));
    }


}
