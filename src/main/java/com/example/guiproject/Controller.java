package com.example.guiproject;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;



public class Controller implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    static PreparedStatement pst = null;
    @FXML
    public TableView<Course> table_course;

    @FXML
    public TableColumn<Course, String> col_name;

    @FXML
    public TableColumn<Course, String> col_id;


    @FXML
    public TableColumn<Course, String> col_credit_hours;

    @FXML
    public TableColumn<Course, String> col_department;

    @FXML
    public TableColumn<Course, String> col_semester;
    @FXML
    public TableColumn<Course, String> col_year;
    @FXML
    public TableColumn<Course, String> col_lecturer;
    @FXML
    ObservableList<Course> listM = FXCollections.observableArrayList();
    @FXML
    TextField course_name_TF;
    @FXML
    TextField course_code_TF;
    @FXML
    TextField course_credit_hours_TF;
    @FXML
    TextField course_department_TF;
    @FXML
    TextField course_semester_TF;
    @FXML
    TextField course_year_TF;
    @FXML
    TextField course_lecturer_TF;
    @FXML
    TextField student_name_TF;
    @FXML
   TextField student_course_TF;

    @FXML
     TextField student_department_TF;

    @FXML
     TextField student_grade_TF;

    @FXML
     TextField student_id_TF;

    @FXML
    TextField student_year_TF;

    @FXML
    private TextField lecturer_course_TF;

    @FXML
    private TextField lecturer_department_TF;

    @FXML
    private TextField lecturer_id_TF;

    @FXML
    private TextField lecturer_name_TF;

    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    ObservableList<Course> courses= FXCollections.observableArrayList();


    public void SwitchToMainMenu(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneStudent(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("Student.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneLecture(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("Lecturer.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneCourse(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("Course.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchToShowAllStudents(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("show-all-students.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchToRegisterNewStudent(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("register-new-student.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchToShowAllLecturers(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("show-all-lecturers.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchToAddNewLecturer(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("register-new-lecturer.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchToShowAllCourses(ActionEvent event) throws Exception {
        try {

            root = FXMLLoader.load(getClass().getResource("show-all-courses.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void RegisterNewCourse(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("register-new-course.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void RefreshTable(){
        connection = Database.InitConn();
        try {

            query = "SELECT * FROM courses";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                courses.add(new Course(
                        resultSet.getString("course_name"),
                        resultSet.getString("Course_ID"),
                        resultSet.getString("course_credit_hours"),
                        resultSet.getString("course_department"),
                        resultSet.getString("course_semester"),
                        resultSet.getString("course_year"),
                        resultSet.getString("Lecturer_name")
                ));
                table_course.setItems(courses);
            }
            preparedStatement.close();
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addCourse(){
        connection = Database.InitConn();
        try {
            col_name.setCellValueFactory(new PropertyValueFactory<>("Course_name"));
            col_id.setCellValueFactory(new PropertyValueFactory<>("Course_ID"));
            col_credit_hours.setCellValueFactory(new PropertyValueFactory<>("Course_credit_hours"));
            col_department.setCellValueFactory(new PropertyValueFactory<>("Course_department"));
            col_semester.setCellValueFactory(new PropertyValueFactory<>("Course_semester"));
            col_year.setCellValueFactory(new PropertyValueFactory<>("Course_year"));
            col_lecturer.setCellValueFactory(new PropertyValueFactory<>("Lecturer_name"));
            listM = Database.getCourseList();
            table_course.setItems(listM);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public void ClearButtonCourses(){
        course_name_TF.setText("");
        course_code_TF.setText("");
        course_credit_hours_TF.setText("");
        course_department_TF.setText("");
        course_semester_TF.setText("");
        course_year_TF.setText("");
        course_lecturer_TF.setText("");

    }
    public void ClearButtonStudents(){
        student_name_TF.setText("");
        student_course_TF.setText("");
        student_department_TF.setText("");
        student_grade_TF.setText("");
        student_id_TF.setText("");
        student_year_TF.setText("");
    }
    public void ClearButtonLecturers(){
        lecturer_course_TF.setText("");
        lecturer_department_TF.setText("");
        lecturer_id_TF.setText("");
        lecturer_name_TF.setText("");
    }


    @Override

    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



    }



