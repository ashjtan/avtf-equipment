package chappelle.five.view;

import java.io.IOException;

import chapman.five.model.ProjectUtilities;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CheckInSuccessController {
	
	//Fields
	@FXML
	private Button btnBackButton;
	@FXML 
	private Button btnBackToMenu;
	@FXML
	private Label lblCongrats;
	
	//Scene Switch Method
	@FXML
	public void handleBack() throws IOException {
		ProjectUtilities.handleSceneSwitch(btnBackButton, "/tan/five/view/Login.fxml");
	}
	@FXML
	public void handleBackToMenu() throws IOException {
		ProjectUtilities.handleSceneSwitch(btnBackToMenu, "/chapman/five/view/StudentWelcomeScreen.fxml");
	}
	
	
	
}

