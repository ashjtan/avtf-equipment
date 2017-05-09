package chappelle.five.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import chapman.five.model.ProjectUtilities;

public class CheckOutSuccessController {

	//Fields
	/**
	 * Displays "Congratulations! You checked something out!" on the scene.
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
	
	
	

	//Event Handlers
	/**
	 * Logs user out and switches scene back to LoginScreen after a successful item checkout.
	 * @throws IOException
	 */
	@FXML
	public void handleBack() throws IOException {
		ProjectUtilities.handleSceneSwitch(btnBackButton, "/tan/five/view/Login.fxml");
	}
	
	/**
	 * Switches scene back to StudentWelcomeScreen after a successful item checkout.
	 * @throws IOException
	 */
	@FXML
	public void handleBackToMenu() throws IOException {
		ProjectUtilities.handleSceneSwitch(btnBackToMenu, "/chapman/five/view/StudentWelcomeScreen.fxml");
	}
}
