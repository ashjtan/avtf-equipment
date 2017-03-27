package tan.five.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import tan.five.mainApp;
import tan.five.model.Student;
import tan.five.model.StudentEquipmentManagement;
import chappelle.five.view.SceneSwitcher;
import chappelle.five.view.StudentWelcomeScreenController;

public class LoginController {

	//Fields
	@FXML
	private Label welcome;
	@FXML
	private Label askStudentID;
	@FXML
	private TextField studentIDField;
	@FXML
	private Label errorMessage;
	@FXML
	private Button btnStudent;
	@FXML
	private Button btnAdmin;
	@FXML
	private Button btnGoBack;

	private mainApp mainApp;



	//Empty Constructor
	public LoginController(){

	}

	//Initialize
	@FXML
	private void initialize(){

	}



	//Event Handlers
	@FXML
	private void handleInput() throws IOException {
		if (isStudentInputValid()) {
			//Student Scene Switch
			SceneSwitcher.handleSceneSwitch(btnStudent, "/chappelle/five/view/StudentWelcomeScreen.fxml");
		}
<<<<<<< HEAD
=======

>>>>>>> refs/remotes/origin/master
		else if (studentIDField.getText().equals("0123456789")) {
<<<<<<< HEAD
			//Reveal Admin button
			btnAdmin.setVisible(true);
			SceneSwitcher.handleSceneSwitch(btnAdmin, "/chappelle/five/view/AdminWelcomeScreen.fxml");
		}
		else {errorMessage.setVisible(true);}
=======

			if (studentIDField.getText().equals("0123456789")) {

				//Reveal Admin button
				btnAdmin.setVisible(true);
				SceneSwitcher.handleSceneSwitch(btnAdmin, "/chappelle/five/view/AdminWelcomeScreen.fxml");
			}
			else {errorMessage.setVisible(true);}}
>>>>>>> refs/remotes/origin/master
	}



<<<<<<< HEAD

=======
>>>>>>> refs/remotes/origin/master
	//Tests if student ID is correct
	@FXML	
	private boolean isStudentInputValid(){
		for (Student student : StudentEquipmentManagement.getStudentListA()) {
			if (studentIDField.getText().equals(student.getStudentID())) {
				Student.SELECTED_STUDENT = student;
				return true;
			}
		}
		return false;
	}


	public void setMainApp(tan.five.mainApp mainApp) {
		//Sets the field for this controller to the application passed in:  
		//Allows the main application to have a pointer to itself by setting its own pointer into the controller's field
		this.mainApp = mainApp;
	}
}