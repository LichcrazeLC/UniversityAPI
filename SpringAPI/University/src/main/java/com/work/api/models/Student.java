package com.work.api.models;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
    @NotBlank
        private String fullName;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "group_id", nullable = false)
        private Group group;

    public Student(){
        //DEFAULT
    }
    public Student(long id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public long getStudentId() {
        return id;
    }

    public void setStudentId(long Id) {
        this.id = Id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
