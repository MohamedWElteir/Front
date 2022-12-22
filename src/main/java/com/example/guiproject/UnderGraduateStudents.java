package com.example.guiproject;

public class UnderGraduateStudents extends Student{

    public UnderGraduateStudents(String name, int id, String major, String year, String grades) {
        super(name, major, year, null, null);
        this.id = id;
        this.major = major;
        this.year = year;
        this.grades = grades;
    }
    public void addStudent(UnderGraduateStudents student) {
        students.add(student);
    }

    @Override
    public String toString() {
        return "Name: " + this.name + " Major: " + this.major + " Year: " + this.year;
    }



}
