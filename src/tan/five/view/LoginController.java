package tan.five.view;

import chapman.five.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import tan.five.mainApp;

public class LoginController {

	//Fields
	@FXML
	private Label welcome;
	@FXML
	private Label askStudentID;
	@FXML
	private TextField studentIDField;
	@FXML
	private Label errorMessage;

	private mainApp mainApp;




	//Empty Constructor
	public LoginController(){

	}

	//Initialize
	@FXML
	private void initialize(){
		//errorMessage.setVisible(false);
	}




	//Event Handlers
	@FXML
	private void handleInput() {
		if (isInputValid()) {
			
		}
	}



	private boolean isInputValid(){
		boolean inputValidity = false;
		if (studentIDField.getText() == null || studentIDField.getText().length() != 10) {				//Checks if TextField is filled
			errorMessage.setVisible(true);
		}

		for (int i=0; i<=10; i++) {
			if (studentIDField.getText().charAt(i) < 0 || studentIDField.getText().charAt(i) > 9) {		//Checks if TextField is all numbers
				errorMessage.setVisible(true);
			}
		}

		if (errorMessage.isVisible() == false) {
			inputValidity = true;
		}
		return inputValidity;
	}
	
	
	public void setMainApp(tan.five.mainApp mainApp) {

		//This sets the field for this controller to the application passed in:  
		//This allows the main application to have a pointer to itself by setting its own pointer into the controller's field
		this.mainApp = mainApp;
	}
	
	
	
	
	
}