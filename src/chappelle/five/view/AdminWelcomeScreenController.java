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
	@FXML
	private Label lblHello;
	
	//Switch scenes
	@FXML
	private Button btnStudentInfo;
	@FXML
	private Button btnEquipmentList;
	@FXML
	private Button btnLogOut;
	
	//Enables main to reference itself to controllers
	private MainApp mainApp;

	
	
	
	//Constructor needed for loader
	public AdminWelcomeScreenController() {
		
	}

	//Called right after FXML file loaded
	@FXML 
	private void initialize() throws IOException{

	}

	
	
	
	//Scene Switch Methods
	@FXML
	public void studentInfo() throws IOException {		//View Student List
		ProjectUtilities.handleSceneSwitch(btnStudentInfo, "/chappelle/five/view/StudentDataScreen.fxml");
	}
	@FXML
	public void equipmentList() throws IOException {	//View Equipment List
		ProjectUtilities.handleSceneSwitch(btnEquipmentList, "/chappelle/five/view/EquipmentScreen.fxml");
	}
	@FXML
	public void handleLogout() throws IOException {		//Returns to Login screen
		ProjectUtilities.handleSceneSwitch(btnEquipmentList, "/tan/five/view/Login.fxml");
	}
	
	
	
	
	//Allows mainApp to have pointer to itself
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}