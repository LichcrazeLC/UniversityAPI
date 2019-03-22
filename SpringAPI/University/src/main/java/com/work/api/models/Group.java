package com.work.api.models;

public class Group {
    private int groupId;
    private String groupName;
    private String faculty;
    private String specialty;
    private Student[] students;

    public Group(int groupId, String groupName, String faculty, String specialty, Student[] students) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.faculty = faculty;
        this.specialty = specialty;
        this.students = students;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
