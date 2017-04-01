package tan.five.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import tan.five.mainApp;
import tan.five.model.Student;
import tan.five.model.StudentEquipmentManagement;
import chapman.five.model.ProjectUtilities;
import chappelle.five.view.StudentWelcomeScreenController;

public class LoginController {

	//Fields
	/**
	 * Shows "Welcome!" on the scene.
	 */
	@FXML
	private Label welcome;	
	/**
	 * Instructs the student to type in their student ID in order to log in.
	 */
	@FXML
	private Label askStudentID;
	/**
	 * Displays an error when the user enters an incorrect student ID.
	 */
	@FXML
	private Label errorMessage;

	/**
	 * Reads the user's student ID input to log in.
	 */
	@FXML
	private TextField studentIDField;

	/**
	 * Login button that switches to the StudentWelcomeScreen when a valid student ID is entered.
	 */
	@FXML
	private Button btnStudent;
	/**
	 * Login button that switches to the AdminWelcomeScreen when the admin key is entered.
	 */
	@FXML
	private Button btnAdmin;

	/**
	 * The application icon displayed beside the window title.
	 */
	@FXML
	private ImageView imgAppIcon;

	/**
	 * Enables the mainApp to reference itself to controllers.
	 */
	private mainApp mainApp;



	//Empty Constructor
	/**
	 * An empty constructor needed for the loader.
	 */
	public LoginController(){

	}

	//Initialize
	/**
	 * Called right after the FXML file is loaded to set up the scene.
	 */
	@FXML
	private void initialize(){

	}



	//Event Handlers
	/**
	 * Switches scene to the StudentWelcomeScreen or the AdminWelcomeScreen depending on the user's input when button is clicked.
	 * @throws IOException
	 */
	@FXML
	private void handleInput() throws IOException {
		if (isStudentInputValid()) {
			//Student Scene Switch
			ProjectUtilities.handleSceneSwitch(btnStudent, "/chappelle/five/view/StudentWelcomeScreen.fxml");
		}
		else if (studentIDField.getText().equals("0123456789")) {
			//Reveals Admin button
			btnAdmin.setVisible(true);
			ProjectUtilities.handleSceneSwitch(btnAdmin, "/chappelle/five/view/AdminWelcomeScreen.fxml");
		}
		else {errorMessage.setVisible(true);}

	}


	//Tests if student ID is correct
	/**
	 * Checks if the user's input is a valid student ID.
	 * @return the user's input as a valid student ID.
	 */
	@FXML	
	private boolean isStudentInputValid() {
		for (Student student : StudentEquipmentManagement.getStudentListLoad()) {
			if (studentIDField.getText().equals(student.getStudentID())) {
				Student.SELECTED_STUDENT = student;
				return true;
			}
		}
		return false;
	}


	/**
	 * Gives the mainApp a pointer to itself.
	 * @param mainApp - the main application for this controller to access.
	 */
	public void setMainApp(tan.five.mainApp mainApp) {
		this.mainApp = mainApp;
	}
}