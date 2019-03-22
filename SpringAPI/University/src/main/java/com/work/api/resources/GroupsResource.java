package com.work.api.resources;

import com.work.api.models.Group;
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
public class GroupsResource {

    private static Map<Integer, Group> groupRepo = new HashMap<>();

    static{
        Group faf171 = new Group( 1, "FAF-171", "Computers, Informatics and Microelectronics",
                "Software Engineering",
                new Student[]{
                        new Student(10, "Filip Adrian"),
                }
        );
        Group faf172 = new Group( 2, "FAF-172", "Computers, Informatics and Microelectronics",
                "Software Engineering",
                new Student[]{
                        new Student(11, "Eugen Chiseliov"),
                }
        );
        groupRepo.put(faf171.getGroupId(), faf171);
        groupRepo.put(faf172.getGroupId(), faf172);

    }

    @RequestMapping("/groups")
    public ResponseEntity<Object> getGroups() {
        return new ResponseEntity<>(groupRepo.values(), HttpStatus.OK);
    }

    @RequestMapping(value = "/groups", method = RequestMethod.POST)
    public ResponseEntity<Object> postGroup(@RequestBody Group group) {
        groupRepo.put(group.getGroupId(), group);
        return new ResponseEntity<>("Group created successfully!", HttpStatus.CREATED);
    }

}
