/*Chappelle, Chapman
 * Period 5
 * PSET 9999999
 * Febuary 16,2017 
 */

package chapman.five.view;

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
import java.io.IOException;
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



public class LoginScreenController {

	//Controls
	@FXML
	private Label lblWelcome;
	@FXML
	private Button btnStudentScreen;
	@FXML
	private Button btnAdminScreen;
	@FXML
	private Button btnGoBack;
	@FXML
	private TextField txtPassword;

	//testing the password
	String passwordTest = "2000006852";


	//So the main can reference itself to the controllers
	private MainApp mainApp;

	public LoginScreenController() {
		//loader needs this
	}

	//to initialize anything on start
	@FXML 
	private void initialize(){

	}

	//Method for handling user passwords
	public void handlePassword(ActionEvent event) {

		if(txtPassword.getText().equals(passwordTest))
		{
			btnStudentScreen.setVisible(true);
		}else {

		}             
	}

	//Method for switching scenes
	@FXML
	private void handleSceneSwitch(ActionEvent event) throws IOException{
		Stage stage; 
		Parent root;
		//Setting the scene to the check in menu
		if(event.getSource()==btnStudentScreen){
			//get reference to the button's stage         
			stage=(Stage) btnStudentScreen.getScene().getWindow();
			//load up OTHER FXML document
			root = FXMLLoader.load(getClass().getResource("StudentWelcomeScreen.fxml"));
		}
		//Setting the scene to the check out menu
		else {
			if(event.getSource()==btnAdminScreen){
				//get reference to the button's stage         
				stage=(Stage) btnAdminScreen.getScene().getWindow();
				//load up OTHER FXML document
				root = FXMLLoader.load(getClass().getResource("AdminWelcomeScreen.fxml"));
			}
			//So it may set the root scene again
			else{
				stage=(Stage) btnGoBack.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("chapman/five/view/RootLayout.fxml"));
			}
			//create a new scene with root and set the stage
			Scene newScene = new Scene(root);
			stage.setScene(newScene);
			stage.show();
		}
	}

	// @param mainApp
	public void setMainApp(MainApp mainApp) {

		//This sets the field for this controller to the application passed in:  
		//This allows the main application to have a pointer to itself by setting its own pointer into the controller's field
		this.mainApp = mainApp;
	}
}