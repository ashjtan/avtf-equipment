package chappelle.five.view;

import java.io.IOException;
import chapman.five.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import tan.five.model.Student;

public class AdminWelcomeScreenController {

	//Controls
	@FXML
	private Label lblHello;
	@FXML
	private Button btnStudentInfo;
	@FXML
	private Button btnEquipmentList;
	@FXML
	private Button btnGoBack;

	//So the main can reference itself to the controllers
	private MainApp mainApp;

	public AdminWelcomeScreenController() {
		//loader needs this
	}

	//to initialize anything on start
	@FXML 
	private void initialize() throws IOException{

	}

	//Methods for switching scenes
	@FXML
	public void studentInfo() throws IOException {
		SceneSwitcher.handleSceneSwitch(btnStudentInfo, "/chappelle/five/view/StudentDataScreen.fxml");
	}
	@FXML
	public void equipmentList() throws IOException {
		SceneSwitcher.handleSceneSwitch(btnEquipmentList, "EQUIPMENT");
	}

	// @param mainApp
	public void setMainApp(MainApp mainApp) {

		//This sets the field for this controller to the application passed in:  
		//This allows the main application to have a pointer to itself by setting its own pointer into the controller's field
		this.mainApp = mainApp;
	}
}