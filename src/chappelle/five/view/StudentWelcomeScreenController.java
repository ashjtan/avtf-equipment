/*Chappelle, Chapman
 * Period 5
 * PSET 4-0
 * December 7, 2016
 */

package chappelle.five.view;

import javafx.beans.value.ObservableValue;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import tan.five.model.Student;
import java.io.IOException;
import chapman.five.model.ProjectUtilities;
import chapman.five.MainApp;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.beans.value.ChangeListener;



public class StudentWelcomeScreenController  {

	//Fields
	//Welcome
	@FXML
	private Label lblHello;
	
	//Switch scenes
	@FXML
	private Button btnCheckIn;
	@FXML
	private Button btnCheckOut;
	@FXML
	private Button btnLogOut;

	//Enables main to reference itself to controllers
	private MainApp mainApp;
	
	
	/**
	 * Constructor needed for loader
	 */
	//Constructor needed for loader
	public StudentWelcomeScreenController() {
		
	}

	/**
	 * Called right after FXML file loaded
	 * @throws IOException
	 */
	//Called right after FXML file loaded
	@FXML 
	private void initialize() throws IOException{
		lblHello.setText(("Hello, "  + Student.SELECTED_STUDENT.getFirstName()));	//Sets the Hello, statement to add student's name 
	}

	//Scene Switch Methods
	/**
	 * Loads ItemCheckIn
	 * @throws IOException
	 */
	@FXML
	public void checkIn() throws IOException {		//Check In Equipment
		ProjectUtilities.handleSceneSwitch(btnCheckIn, "/chappelle/five/view/ItemCheckIn.fxml");
	}
	/**
	 * Loads ItemCheckOut
	 * @throws IOException
	 */
	@FXML
	public void checkOut() throws IOException {		//Check Out Equipment
		ProjectUtilities.handleSceneSwitch(btnCheckOut, "/chappelle/five/view/ItemCheckOut.fxml");
	}
	/**
	 * Loads Login Screen
	 * @throws IOException
	 */
	@FXML
	public void handleLogOut() throws IOException {	//Returns to Login screen
		ProjectUtilities.handleSceneSwitch(btnLogOut, "/tan/five/view/Login.fxml");
	}

	/**
	 * Allows mainApp to have pointer to itself
	 * @param mainApp
	 */
	//Allows mainApp to have pointer to itself
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}