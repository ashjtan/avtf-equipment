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

	//Controls
	@FXML
	private Label lblHello;
	@FXML
	private Button btnCheckIn;
	@FXML
	private Button btnCheckOut;
	@FXML
	private Button btnGoBack;

	//Main can reference itself to the controllers
	private MainApp mainApp;

	public StudentWelcomeScreenController() {
		//Loader needs this
	}

	//Initializes anything on start
	@FXML 
	private void initialize() throws IOException{
		//Sets the Hello, statement to add their name 
		lblHello.setText(("Hello, "  + Student.SELECTED_STUDENT.getFirstName()));
	}

	//Methods for switching scenes
	@FXML
	public void checkIn() throws IOException {
		ProjectUtilities.handleSceneSwitch(btnCheckIn, "/chappelle/five/view/ItemCheckIn.fxml");
	}
	@FXML
	public void checkOut() throws IOException {
		ProjectUtilities.handleSceneSwitch(btnCheckOut, "/chappelle/five/view/ItemCheckOut.fxml");
	}

	// @param mainApp
	public void setMainApp(MainApp mainApp) {

		//This sets the field for this controller to the application passed in:  
		//This allows the main application to have a pointer to itself by setting its own pointer into the controller's field
		this.mainApp = mainApp;
	}
}