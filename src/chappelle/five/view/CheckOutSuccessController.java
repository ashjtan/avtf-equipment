package chappelle.five.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

import chapman.five.model.ProjectUtilities;

public class CheckOutSuccessController {
	
	//Fields
	@FXML
	private Button btnBackButton;
	@FXML
	private Label lblCongrats;
	
	//Scene Switch Method
	@FXML
	public void handleBack() throws IOException {
		ProjectUtilities.handleSceneSwitch(btnBackButton, "/tan/five/view/Login.fxml");
	}
	
	
	
}
