package chappelle.five.view;

import java.io.IOException;
import java.util.ArrayList;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import tan.five.model.Student;
import tan.five.model.StudentEquipmentManagement;
import tan.five.mainApp;
import chappelle.five.view.SceneSwitcher;



public class StudentDataScreenController extends Application {

	//fields
	@FXML
	private Button btnBackButton;

	@FXML
	private TableView<Student> studentTableView;
	@FXML
	private TableColumn<Student, String> firstName;
	@FXML
	private TableColumn<Student, String> lastName;
	@FXML
	private TableColumn<Student, String> ID;


	@Override
	public void start(Stage primaryStage) {

	}

	@FXML
	public void initialize() {
		for (Student student : StudentEquipmentManagement.getStudentListA()) {
			studentTableView.getItems().add(student);
		}
		
		firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		ID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
	}

	//Switching scenes
	@FXML
	public void backButton() throws IOException {
		SceneSwitcher.handleSceneSwitch(btnBackButton, "/chappelle/five/view/AdminWelcomeScreen.fxml");
	}


	public void setMainApp(mainApp mainApp) {
		

	}
}