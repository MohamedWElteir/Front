package com.example.guiproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.sql.*;


public class Database {


    public static Connection InitConn() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Courses", "root", "");
            System.out.println("Connected");
            return conn;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public static ObservableList<Course> getCourseList() {
        ObservableList<Course> courseList= FXCollections.observableArrayList();
        try {
            Connection conn = InitConn();
            courseList = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM courses");
            while (rs.next()) {
                courseList.add(new Course(rs.getString("Course_name"), rs.getInt("Course_ID"), rs.getString("Course_credit_hours"), rs.getString("Course_department"), rs.getString("Course_semester"), rs.getString("Course_year"), rs.getString("Lecturer_name")));

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return courseList;
    }


    public static ObservableList<Course> getCourses() {
        return getCourseList();
    }
}
