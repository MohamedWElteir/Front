package com.example.guiproject;

import java.util.ArrayList;
public class Student extends Course {
    ArrayList<Student> students = new ArrayList<>();
    protected String degree,major,year,name,grades;
    protected int id;



public Student(String name, String major, String year, String studentYear, String studentSemester){
    this.name=name;
    this.major=major;
    this.year=year;
    this.degree=studentYear;
    this.grades=studentSemester;
    }


    public void addStudent(Student student) {
        students.add(student);
    }
    public void addStudent(UnderGraduateStudents student) { students.add(student);
    }

    @Override
    public String toString() {
        return "Name: " + this.name + " Major: " + this.major + " Year: " + this.year;
    }


    public String getCourseName() {
        return name;
    }

    public String getName() {
        return name;
    }


    public String getStudentName() {
        return name;
    }

    public String getStudentID() {
        return String.valueOf(id);
    }

    public String getStudentDepartment() {
        return major;
    }

    public String getStudentYear() {
        return year;
    }

    public String getStudentCourses() {
        return grades;
    }

    public String getStudentGrade() {
        return grades;
    }
}

