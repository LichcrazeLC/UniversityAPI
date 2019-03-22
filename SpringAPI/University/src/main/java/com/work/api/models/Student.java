package com.work.api.models;

public class Student {
    private int studentId;
    private String studentFullName;

    public Student(int studentId, String studentFullName) {
        this.studentId = studentId;
        this.studentFullName = studentFullName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentFullName() {
        return studentFullName;
    }

    public void setStudentFullName(String studentFullName) {
        this.studentFullName = studentFullName;
    }

}
