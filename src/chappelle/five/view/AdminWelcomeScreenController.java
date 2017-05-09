package chappelle.five.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import chapman.five.model.ProjectUtilities;
import chapman.five.MainApp;

public class AdminWelcomeScreenController {

	//Fields
	/**
	 * Shows "Hello, Admin" on the scene.
	 * Bound to the Hello Label in the .fxml file.
	 */
	@FXML
	private Label lblHello;

	/**
	 * Switches to scene where the Admin can view the Student Info table.
	 * Bound to the View Student Info Button in the .fxml file.
	 */
	@FXML
	private Button btnStudentInfo;
	/**
	 * Switches to scene where the Admin can view the Equipment Info table.
	 * Bound to the View Equipment Info Button in the .fxml file.
	 */
	@FXML
	private Button btnEquipmentList;
	/**
	 * Logs the Admin out of the program.
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
	public AdminWelcomeScreenController() {

	}

	/**
	 * Called right after the FXML file is loaded to set up the scene.
	 * @throws IOException
	 */
	@FXML 
	private void initialize() throws IOException{

	}


	
	
	/**
	 * Switches scene to the StudentDataScreen when View Student Info button is clicked.
	 * @throws IOException
	 */
	@FXML
	public void studentInfo() throws IOException {		//View Student List
		ProjectUtilities.handleSceneSwitch(btnStudentInfo, "/chappelle/five/view/StudentDataScreen.fxml");
	}
	/**
	 * Switches scene to the EquipmentScreen when View Equipment Info button is clicked.
	 * @throws IOException
	 */
	@FXML
	public void equipmentList() throws IOException {	//View Equipment List
		ProjectUtilities.handleSceneSwitch(btnEquipmentList, "/chappelle/five/view/EquipmentScreen.fxml");
	}
	/**
	 * Logs the Admin out and switches scene back to the Login screen.
	 * @throws IOException
	 */
	@FXML
	public void handleLogout() throws IOException {		//Returns to Login screen
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