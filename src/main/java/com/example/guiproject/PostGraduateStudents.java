package com.example.guiproject;

public class PostGraduateStudents extends Student {


    private String studentSemester;
    private String studentYear;

    public PostGraduateStudents(String name, String status, String degree, String major, String year, String s, String major1) {
        super(name, major, year, null, null);
        this.degree = degree;
        this.major = major;
        this.year = year;
    }

@Override
    public String toString() {
        return "Name: " + this.name + " Major: " + this.major + " Year: " + this.year;
    }
}
