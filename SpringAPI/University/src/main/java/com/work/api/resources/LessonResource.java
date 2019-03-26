package com.work.api.resources;

import com.work.api.models.Lesson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

public class LessonResource {
    private static Map< Integer, Lesson> lessonRepo = new HashMap<>();

    @RequestMapping("/lessons")
    public ResponseEntity<Object> getStudents() {
        return new ResponseEntity<>(lessonRepo.values(), HttpStatus.OK);
    }

    @RequestMapping(value = "/lessons", method = RequestMethod.POST)
    public ResponseEntity<Object> postLesson(@RequestBody Lesson lesson) {
       // lessonRepo.put(lesson.getLessonId(),lesson);
        return new ResponseEntity<>("Lesson created successfully!", HttpStatus.CREATED);
    }

    @RequestMapping("/lessons/{lessonId}")
    public ResponseEntity<Object> getLessonById(@PathVariable int lessonId) {
        return new ResponseEntity<>(lessonRepo.get(lessonId), HttpStatus.OK);
    }

    @RequestMapping(value = "/lessons/{lessonId}", method = RequestMethod.PUT)
    public ResponseEntity<Object> putLessonById(@PathVariable int lessonId, @RequestBody Lesson lesson) {
        if (lessonRepo.containsKey(lessonId)) {
            lessonRepo.put(lessonId, lesson);
            return new ResponseEntity<>(lessonRepo.get(lessonId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Lesson not found!", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/lessons/{lessonId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteLessonById(@PathVariable int lessonId) {
        if (lessonRepo.containsKey(lessonId)) {
            lessonRepo.remove(lessonId);
            return new ResponseEntity<>("Lesson successfully deleted!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Lesson not found!", HttpStatus.NOT_FOUND);
        }
    }

}
