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

import java.io.IOException;

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



public class RootLayoutController {
	/**
	 * 	//Allows main to reference itself to controllers
	 */
	//Allows main to reference itself to controllers
	private tan.five.mainApp mainApp;

	
	
	
	//Constructor needed for loader
	/**
	 * Constructor needed for loader
	 */
	public RootLayoutController() {

	}

	@FXML 
	private void initialize(){

	}

	
	

	//Allows mainApp to have pointer to itself
	/**
	 * //Allows mainApp to have pointer to itself
	 * @param mainApp
	 */
	public void setMainApp(tan.five.mainApp mainApp) {
		this.mainApp = mainApp;
	}
}

