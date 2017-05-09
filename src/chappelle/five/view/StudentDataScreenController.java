package chappelle.five.view;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import tan.five.model.Equipment;
import tan.five.model.Student;
import tan.five.model.StudentEquipmentManagement;
import chapman.five.model.ProjectUtilities;

public class StudentDataScreenController extends Application {

	//Fields
	/**
	 * Table of Student information loaded from CSV file, able to bind to JavaFX.
	 */
	@FXML
	private TableView<Student> studentTableView;
	/**
	 * Table column displaying the first name of the Student, able to bind to JavaFX.
	 */
	@FXML
	private TableColumn<Student, String> firstName;
	/**
	 * Table column displaying the last name of the Student, able to bind to JavaFX.
	 */
	@FXML
	private TableColumn<Student, String> lastName;
	/**
	 * Table column displaying the school ID of the Student, able to bind to JavaFX.
	 */
	@FXML
	private TableColumn<Student, String> ID;


	/**
	 * Bound to the back button in the .fxml file.
	 */
	@FXML
	private Button btnBackButton;


	/**
	 * Right-side viewable list of items held by selected Student, able to bind to JavaFX.
	 */
	@FXML
	private ListView<String> heldEquipment;	
	/**
	 * List backing the heldEquipment ListView, able to bind to JavaFX.
	 */
	private static ObservableList<String> listForHeldEquipment = FXCollections.observableArrayList();	




	@Override
	public void start(Stage primaryStage) {

	}

	/**
	 * Loads Student information from the student CSV file and sets the information 
	 * into its respective table column when the scene is loaded.
	 */
	@FXML
	public void initialize() {
		for (Student student : StudentEquipmentManagement.getStudentListA()) {		//Loads student info from CSV file
			studentTableView.getItems().add(student);
		}
		firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));		//Sets info into correct table columns
		lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		ID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
	}



	//Event Handlers
	@FXML
	public void handleSelect() {
		Student selectedStudent = readSelectedStudent();
		listForHeldEquipment.clear();
		for (Equipment equipment : StudentEquipmentManagement.getEquipmentListA()) {
			if (equipment.getHolder()!= null) {
				if (equipment.getHolder().equals(selectedStudent)) {
					listForHeldEquipment.add(equipment.getEquipmentName());
				}
			}
		}
		heldEquipment.setItems(listForHeldEquipment);
	}




	/**
	 * Switches scene back to the AdminWelcomeScreen.
	 * @throws IOException
	 */
	@FXML
	public void handleBack() throws IOException {
		ProjectUtilities.handleSceneSwitch(btnBackButton, "/chappelle/five/view/AdminWelcomeScreen.fxml");
	}




	//Helper Methods
	/**
	 * Reads student selected in TableView.
	 * @return Student highlighted in table.
	 */
	@FXML
	public Student readSelectedStudent() {
		Student student = studentTableView.getSelectionModel().getSelectedItem();
		return student;
	}
}