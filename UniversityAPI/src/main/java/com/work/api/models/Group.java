package com.work.api.models;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "`groups`")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
    @NotBlank
    @Column(unique = true)
        private String name;
    @NotBlank
        private String faculty;
    @NotBlank
        private String specialty;

    public Group(){
        //DEFAULT
    }

    public Group(long id, @NotBlank String name, @NotBlank String faculty, @NotBlank String specialty) {
        this.id = id;
        this.name = name;
        this.faculty = faculty;
        this.specialty = specialty;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

}
