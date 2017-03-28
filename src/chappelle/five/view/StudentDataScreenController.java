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



public class StudentDataScreenController extends Application {

	@FXML
	private Button btnCheckIn;
	@FXML
	private Button btnCheckOut;
	@FXML
	private Button btnGoBack;

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

	//Method for switching scenes
	@FXML
	private void handleSceneSwitch(ActionEvent event) throws IOException {
		Stage stage; 
		Parent root;
		//Setting the scene to the check in menu
		if(event.getSource()==btnCheckIn){
			//get reference to the button's stage         
			stage=(Stage) btnCheckIn.getScene().getWindow();
			//load up OTHER FXML document
			root = FXMLLoader.load(getClass().getResource("CHECK IN MENU"));
		}
		//Setting the scene to the check out menu
		else {
			if(event.getSource()==btnCheckOut){
				//get reference to the button's stage         
				stage=(Stage) btnCheckOut.getScene().getWindow();
				//load up OTHER FXML document
				root = FXMLLoader.load(getClass().getResource("CHECK OUT MENU"));
			}
			//So it may set the root scene again
			else{
				stage=(Stage) btnGoBack.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("tan/five/view/Login.fxml"));
			}
			//create a new scene with root and set the stage
			Scene checkInMenu = new Scene(root);
			stage.setScene(checkInMenu);
			stage.show();
		}
	}

	public void setMainApp(mainApp mainApp) {
		// TODO Auto-generated method stub

	}
}