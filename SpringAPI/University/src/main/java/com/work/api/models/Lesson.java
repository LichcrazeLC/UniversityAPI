package com.work.api.models;

public class Lesson {
    private int lessonId;
    private String lessonName;
    private String faculty;
    private String specialty;
    private int year;

    public Lesson(int lessonId, String lessonName, String faculty, String specialty, int year) {
        this.lessonId = lessonId;
        this.lessonName = lessonName;
        this.faculty = faculty;
        this.specialty = specialty;
        this.year = year;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
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
