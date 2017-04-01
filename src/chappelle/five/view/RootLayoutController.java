/*Chappelle, Chapman
 * Period 5
 * PSET 4-0
 * December 7, 2016
 */
package chappelle.five.view;

import javafx.fxml.FXML;

public class RootLayoutController {
	/**
	 * Enables the mainApp to reference itself to controllers.
	 */
	private tan.five.mainApp mainApp;




	/**
	 * An empty constructor needed for the loader.
	 */
	public RootLayoutController() {

	}

	@FXML 
	private void initialize(){

	}




	/**
	 * //Allows mainApp to have pointer to itself
	 * @param mainApp - the main application for this controller to access.
	 */
	public void setMainApp(tan.five.mainApp mainApp) {
		this.mainApp = mainApp;
	}
}

