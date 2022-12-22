package com.example.guiproject;

import java.util.ArrayList;

public class Lecture extends Course{
    private static final String courses = new String();
    private String name;
    private String id;
    private String department;


    public Lecture(String name) {
          super(name,courses);

    }
    public Lecture(String LecturerName, String lectureID, String lectureDepartment, String lectureYear, String lectureSemester) {
        super(LecturerName);
    }



    public void addLecture(Lecture lecture) {
        ArrayList<Course> courses = new ArrayList<Course>();
        for (Course course : courses) {
            if (course.getCourseName().equals(lecture.getCourseName())) {
                course.addLecture(lecture);
            }

        }
    }


    public String getLectureName() {
        return name;
    }

    public String getLectureID() {
        return id;
    }

    public String getLectureDepartment() {
        return department;
    }

    public String getLectureCourses() {
        return courses;
    }

    public String getName() {
        return name;
    }
}
