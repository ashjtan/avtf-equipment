package tan.five.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import tan.five.mainApp;
import tan.five.model.Student;
import tan.five.model.StudentEquipmentManagement;

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


	@FXML	
	private boolean isInputValid(){		//INCOMPLETE
		boolean inputValidity = false;
		for (Student student : StudentEquipmentManagement.getStudentListA()) {
			if (studentIDField.getText() != student.getStudentID()) {
				errorMessage.setVisible(true);
			}
			else {inputValidity = true;}
		}
		return inputValidity;
	}
}