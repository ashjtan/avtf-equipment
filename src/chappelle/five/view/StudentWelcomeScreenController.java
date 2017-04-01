/*Chappelle, Chapman
 * Period 5
 * PSET 4-0
 * December 7, 2016
 */
package chappelle.five.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import tan.five.model.Student;
import chapman.five.model.ProjectUtilities;
import chapman.five.MainApp;

public class StudentWelcomeScreenController  {

	//Fields
	/**
	 * Shows "Hello, " and the Student's first name on the scene.
	 * Bound to the hello label in the .fxml file.
	 */
	@FXML
	private Label lblHello;

	/**
	 * Switches to scene where the Student can check in currently held equipment.
	 * Bound to the check in Button in the .fxml file.
	 */
	@FXML
	private Button btnCheckIn;
	/**
	 * Switches to scene where the Student can check out available equipment.
	 * Bound to the check out Button in the .fxml file.
	 */
	@FXML
	private Button btnCheckOut;
	/**
	 * Logs the Student out of the program.
	 * Bound to the Log Out Button in the .fxml file.
	 */
	@FXML
	private Button btnLogOut;

	/**
	 * Enables the mainApp to reference itself to the controllers.
	 */
	private MainApp mainApp;




	/**
	 * An empty constructor needed for the loader.
	 */
	public StudentWelcomeScreenController() {

	}

	/**
	 * Called right after the FXML file is loaded to set up the scene.
	 * Sets the "Hello, " statement on the Label to the Student's first name.
	 * @throws IOException
	 */
	@FXML 
	private void initialize() throws IOException{
		lblHello.setText(("Hello, "  + Student.SELECTED_STUDENT.getFirstName()));
	}




	/**
	 * Switches scene to ItemCheckIn.
	 * @throws IOException
	 */
	@FXML
	public void checkIn() throws IOException {		//Check In Equipment
		ProjectUtilities.handleSceneSwitch(btnCheckIn, "/chappelle/five/view/ItemCheckIn.fxml");
	}
	/**
	 * Switches scene to ItemCheckOut.
	 * @throws IOException
	 */
	@FXML
	public void checkOut() throws IOException {		//Check Out Equipment
		ProjectUtilities.handleSceneSwitch(btnCheckOut, "/chappelle/five/view/ItemCheckOut.fxml");
	}
	/**
	 * Logs user out and switches back to Login screen.
	 * @throws IOException
	 */
	@FXML
	public void handleLogOut() throws IOException {	//Returns to Login screen
		ProjectUtilities.handleSceneSwitch(btnLogOut, "/tan/five/view/Login.fxml");
	}




	/**
	 * Gives the mainApp a pointer to itself.
	 * @param mainApp - the main application for this controller to access.
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}