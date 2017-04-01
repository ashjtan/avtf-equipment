package chappelle.five.view;

import java.io.IOException;
import chapman.five.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import tan.five.model.Student;
import chapman.five.model.ProjectUtilities;

public class AdminWelcomeScreenController {

	//Fields
	//Welcome
	/**
	 * Link to the hello label in the .fxml file
	 */
	@FXML
	private Label lblHello;
	
	//Switch scenes
	/**
	 * Link to the btnStudentInfo Button in the .fxml file
	 */
	@FXML
	private Button btnStudentInfo;
	/**
	 * Link to the btnStudentInfo Button in the .fxml file
	 */
	@FXML
	private Button btnEquipmentList;
	/**
	 * Link to the btnStudentInfo Button in the .fxml file
	 */
	@FXML
	private Button btnLogOut;
	
	/**
	 * Enables main to reference itself to controllers
	 */
	//Enables main to reference itself to controllers
	private MainApp mainApp;

	/**
	 * Constructor needed for loader
	 */
	//Constructor needed for loader
	public AdminWelcomeScreenController() {
		
	}

	/**
	 * 
	 * @throws IOException
	 * Called right after FXML file loaded
	 */
	//Called right after FXML file loaded
	@FXML 
	private void initialize() throws IOException{

	}

	
	/**
	 * Loads the StudentDataScreen
	 * @throws IOException
	 */
	//Scene Switch Methods
	@FXML
	public void studentInfo() throws IOException {		//View Student List
		ProjectUtilities.handleSceneSwitch(btnStudentInfo, "/chappelle/five/view/StudentDataScreen.fxml");
	}
	/**
	 * Loads the EquipmentScreen
	 * @throws IOException
	 */
	@FXML
	public void equipmentList() throws IOException {	//View Equipment List
		ProjectUtilities.handleSceneSwitch(btnEquipmentList, "/chappelle/five/view/EquipmentScreen.fxml");
	}
	/**
	 * Loads the Login Screen
	 * @throws IOException
	 */
	@FXML
	public void handleLogout() throws IOException {		//Returns to Login screen
		ProjectUtilities.handleSceneSwitch(btnLogOut, "/tan/five/view/Login.fxml");
	}
	
	/**
	 * Gives the mainApp a pointer to itself
	 * @param mainApp
	 */
	//Allows mainApp to have pointer to itself
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}