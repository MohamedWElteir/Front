package com.example.guiproject;

import java.util.ArrayList;

public class Classroom extends Collage {
    private String classroomName;
    private int classroomID;
    private ArrayList<Lecture> lectures = new ArrayList<Lecture>();
    private ArrayList<Student> students = new ArrayList<Student>();
    public Classroom(String classroomName, int classroomID, String collageName, int collageID) {
        super(collageName, collageID);
        this.classroomName = classroomName;
        this.classroomID = classroomID;
    }
    public String getClassroomName() {
        return classroomName;
    }
    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }
    public int getClassroomID() {
        return classroomID;
    }
    public void setClassroomID(int classroomID) {
        this.classroomID = classroomID;
    }
    public ArrayList<Lecture> getLectures() {
        return lectures;
    }
    public void setLectures(ArrayList<Lecture> lectures) {
        this.lectures = lectures;
    }
//    public ArrayList<Student> getStudents() {
//        return students;
//    }
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
    public void addLecture(Lecture lecture) {
        lectures.add(lecture);
    }
    public void addStudent(Student student) {
        students.add(student);
    }
}
