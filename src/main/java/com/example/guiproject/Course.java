package com.example.guiproject;


import javafx.collections.ObservableList;

import java.sql.Connection;
import java.util.ArrayList;

public class Course {

    public static Connection conn;
    private String courseName;
    private String courseDepartment;
    private String courseCode;
    private String courseCreditHours;
    private String courseSemester;
    private String courseYear;
    private int numberOfRegisteredStudents;
    protected Lecture lecture;
    private final ArrayList<Student> students = new ArrayList<>();

public Course(String courseName, String courseDepartment, String courseCode, String courseCreditHours, String courseSemester, String courseYear,String LecturerName) {
    this.courseName = courseName;
    this.courseDepartment = courseDepartment;
    this.courseCode = courseCode;
    this.courseCreditHours = courseCreditHours;
    this.courseSemester = courseSemester;
    this.courseYear = courseYear;
    this.lecture = new Lecture(LecturerName);

}
    public Course(String courseName, String courseDepartment, String courseCode, String courseSemester) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseCreditHours = courseCreditHours;
        this.courseDepartment = courseDepartment;
        this.courseSemester = courseSemester;
    }
    public Course(String courseName, int id, String courseCode, String department, String courses){
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseDepartment = department;
        this.courseCode = courses;
    }

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public Course(String courseName, int courseId, String courseCreditHours, String courseDepartment, String courseSemester, String courseYear, String lecturerName) {
        this.courseName = courseName;
        this.courseCode = String.valueOf(courseId);
        this.courseCreditHours = courseCreditHours;
        this.courseDepartment = courseDepartment;
        this.courseSemester = courseSemester;
        this.courseYear = courseYear;
        this.lecture = new Lecture(lecturerName);
    }

    public Course(String name, String courses) {
        this.courseName = name;
        this.courseCode = courses;
    }


    public static ObservableList<Course> getCourses() {
        return Database.getCourseList();
    }

    public String getCourseName() {
        return courseName;
    }


    public void addStudent(UnderGraduateStudents student) {
        students.add(student);
    }
    public void addStudent(PostGraduateStudents student) {
        students.add(student);
    }




    protected void addLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public Lecture getLecture() {
        return lecture;
    }


    public Course() {
    }


    @Override
    public String toString() {
        return  courseName;
    }

    public String getLecturerName() {
        return lecture.getName();
    }
}