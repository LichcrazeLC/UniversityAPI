package com.work.api.resources;

import com.work.api.models.Group;
import com.work.api.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class GroupsResource {

    @Autowired
    private GroupRepository groupRepository;

    @RequestMapping("/groups")
    public ResponseEntity<Object> getGroups() {
        return new ResponseEntity<>(groupRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/groups", method = RequestMethod.POST)
    public ResponseEntity<Object> postGroup(@Valid @RequestBody Group group) {
        groupRepository.save(group);
        return new ResponseEntity<>("Group created successfully!", HttpStatus.CREATED);
    }

    @RequestMapping("/groups/{groupName}")
    public ResponseEntity<Object> getGroupByName(@PathVariable String groupName) {
        if (groupRepository.findByName(groupName) != null)
            return new ResponseEntity<>(groupRepository.findByName(groupName), HttpStatus.OK);
        else
            return new ResponseEntity<>("Group not found!", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/groups/{groupName}", method = RequestMethod.PUT)
    public ResponseEntity<Object> putGroupByName(@PathVariable String groupName, @RequestBody Group group) {
        Group oldRecord = groupRepository.findByName(groupName);
        if (oldRecord != null) {
            oldRecord.setName(group.getName());
            oldRecord.setFaculty(group.getFaculty());
            oldRecord.setSpecialty(group.getSpecialty());
            groupRepository.save(oldRecord);
            return new ResponseEntity<>(group, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Group not found!", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/groups/{groupName}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteGroupByName(@PathVariable String groupName) {
        if (groupRepository.findByName(groupName) != null) {
            groupRepository.delete(groupRepository.findByName(groupName));
            return new ResponseEntity<>("Group successfully deleted!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Group not found!", HttpStatus.NOT_FOUND);
        }
    }

}
