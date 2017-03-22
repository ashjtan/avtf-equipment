/*Chappelle, Chapman
 * Period 5
 * PSET 4-0
 * December 7, 2016
 */

package chappelle.five.view;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import tan.five.model.Student;
import tan.five.model.StudentEquipmentManagement;

import java.io.IOException;

import chapman.five.MainApp;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.beans.value.ChangeListener;



public class StudentDataScreenController  {

	//Controls
	@FXML
	static ObservableList<Student> mySl;
	@FXML



	//So the main can reference itself to the controllers
	private MainApp mainApp;

	public StudentDataScreenController() {
		//loader needs this
	}

	//to initialize anything on start
	@FXML 
	private void initialize(){



		//TableView

		mySl = StudentEquipmentManagement.getStudentListO();
		Student stu = new Student();


		TableView<Student> tvStudents;
		tvStudents = new TableView<Student>(mySl);		

		TableColumn<Student, String> lName = new TableColumn<>("Last Name");
		lName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		tvStudents.getColumns().add(lName);

		TableColumn<Student, String> fName = new TableColumn<>("First Name");
		fName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		tvStudents.getColumns().add(fName);

		TableColumn<Student, String> iD = new TableColumn<>("ID");
		iD.setCellValueFactory(new PropertyValueFactory<>("id"));
		tvStudents.getColumns().add(iD);


		tvStudents.setPrefWidth(600);
		tvStudents.setPrefHeight(300);

		TableView.TableViewSelectionModel<Student> tvSelStudent = tvStudents.getSelectionModel();
	}



	// @param mainApp
	public void setMainApp(MainApp mainApp) {

		//This sets the field for this controller to the application passed in:  
		//This allows the main application to have a pointer to itself by setting its own pointer into the controller's field
		this.mainApp = mainApp;
	}
}