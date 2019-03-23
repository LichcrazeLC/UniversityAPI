package com.work.api.resources;

import com.work.api.models.Group;
import com.work.api.models.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GroupsResource {

    private static Map<String, Group> groupRepo = new HashMap<>();

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
        groupRepo.put(faf171.getGroupName(), faf171);
        groupRepo.put(faf172.getGroupName(), faf172);

    }

    @RequestMapping("/groups")
    public ResponseEntity<Object> getGroups() {
        return new ResponseEntity<>(groupRepo.values(), HttpStatus.OK);
    }

    @RequestMapping(value = "/groups", method = RequestMethod.POST)
    public ResponseEntity<Object> postGroup(@RequestBody Group group) {
        groupRepo.put(group.getGroupName(), group);
        return new ResponseEntity<>("Group created successfully!", HttpStatus.CREATED);
    }

    @RequestMapping("/groups/{groupName}")
    public ResponseEntity<Object> getGroupByName(@PathVariable String groupName) {
        return new ResponseEntity<>(groupRepo.get(groupName), HttpStatus.OK);
    }

    @RequestMapping(value = "/groups/{groupName}", method = RequestMethod.PUT)
    public ResponseEntity<Object> putGroupByName(@PathVariable String groupName, @RequestBody Group group) {
        if (groupRepo.containsKey(groupName)) {
            groupRepo.put(groupName, group);
            return new ResponseEntity<>(groupRepo.get(groupName), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Group not found!", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/groups/{groupName}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteGroupByName(@PathVariable String groupName) {
        if (groupRepo.containsKey(groupName)) {
            groupRepo.remove(groupName);
            return new ResponseEntity<>("Group successfully deleted!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Group not found!", HttpStatus.NOT_FOUND);
        }
    }

}
