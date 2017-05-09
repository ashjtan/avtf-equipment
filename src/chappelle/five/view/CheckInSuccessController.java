package chappelle.five.view;

import java.io.IOException;

import chapman.five.model.ProjectUtilities;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CheckInSuccessController {

	//Fields
	/**
	 * Displays "Congratulations! You checked something in!" on the scene.
	 */
	@FXML
	private Label lblCongrats;
	/**
	 * Bound to the back button in the .fxml file.
	 */
	@FXML
	private Button btnBackButton;
	/**
	 * Bound to the back-to-menu button in the .fxml file.
	 */
	@FXML 
	private Button btnBackToMenu;

	
	

	//Scene Switch Methods
	/**
	 * Logs user out and switches scene back to LoginScreen after a successful item check-in.
	 * @throws IOException
	 */
	@FXML
	public void handleBack() throws IOException {
		ProjectUtilities.handleSceneSwitch(btnBackButton, "/tan/five/view/Login.fxml");
	}	
	
	/**
	 * Switches scene back to StudentWelcomeScreen after a successful item check-in.
	 * @throws IOException
	 */
	@FXML
	public void handleBackToMenu() throws IOException {
		ProjectUtilities.handleSceneSwitch(btnBackToMenu, "/chapman/five/view/StudentWelcomeScreen.fxml");
	}
}