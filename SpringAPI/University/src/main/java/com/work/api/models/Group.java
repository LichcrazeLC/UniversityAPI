package com.work.api.models;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "`groups`")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long Id;
    @NotBlank
    @Column(unique = true)
        private String name;
    @NotBlank
        private String faculty;
    @NotBlank
        private String specialty;
        private Student[] students;

    public Group(){
        //DEFAULT
    }

    public Group(long id, @NotBlank String name, @NotBlank String faculty, @NotBlank String specialty) {
        this.Id = id;
        this.name = name;
        this.faculty = faculty;
        this.specialty = specialty;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }
}
