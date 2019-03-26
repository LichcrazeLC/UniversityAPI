package com.work.api.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @NotBlank
    private String name;
    @NotBlank
    private String faculty;
    @NotBlank
    private String specialty;
    @NotBlank
    private int year;

    public Lesson(){
        //DEFAULT
    }
    public Lesson(long id, @NotBlank String name, @NotBlank String faculty, @NotBlank String specialty, @NotBlank int year) {
        Id = id;
        this.name = name;
        this.faculty = faculty;
        this.specialty = specialty;
        this.year = year;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
