package com.example.guiproject;

import java.util.ArrayList;
public class Collage extends Course{
    private String collageName;
    private int collageID;
    private ArrayList<Course> courses = new ArrayList<Course>();
    public Collage(String collageName, int collageID) {
        super(collageName);
        this.collageName = collageName;
        this.collageID = collageID;
    }




    public String getCollageName() {
        return collageName;
    }
    public void setCollageName(String collageName) {
        this.collageName = collageName;
    }
    public int getCollageID() {
        return collageID;
    }
    public void setCollageID(int collageID) {
        this.collageID = collageID;
    }


    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addStudent(UnderGraduateStudents student) {
        for (Course course : courses) {
            if (course.getCourseName().equals(student.getCourseName())) {
                course.addStudent(student);
            }

        }
    }
    }



