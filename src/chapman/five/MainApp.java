/*Chappelle, Chapman
 * Period 5
 * PSET 4-0
 * December 7, 2016
 */

package chapman.five;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import chapman.five.MainApp;
import chapman.five.view.LoginScreenController;
import chapman.five.view.RootLayoutController;

public class MainApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/*
	//private fields of a stage that will be the primary stage, and the root layout of our main window
	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		try {

			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("AVTFEquipment");	//Sets the title of the Window

			//set the application icon
			//this.primaryStage.getIcons().add(new Image());

			//a method to set up the Root Layout
			initRootLayout();
			
			//to load the login screen
			showLoginScreen();


		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void initRootLayout() {

		try {
			//Main initialization routines for layout and app commencement

			//create an FXML Loader object
			FXMLLoader loader = new FXMLLoader();

			//Point the loader at the FXML file to load
			loader.setLocation(MainApp.class.getResource("/chapman/five/view/RootLayout.fxml"));

			//Sets the rootlayout field to the BorderPane FXM file injected via @FXML
			rootLayout = (BorderPane) loader.load();

			//Sets a Scene object to this rootLayout
			Scene scene = new Scene(rootLayout);

			//Give the controller access to the main app.
			RootLayoutController controller = loader.getController();
			controller.setMainApp(this);

			//Sets the primaryScene Scene object to scene
			primaryStage.setScene(scene);

			//Shows the primaryStage object
			primaryStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	//Loads the login page
	public void showLoginScreen() {
		
		try {
			
			//Instantiates the loader class
			FXMLLoader loader = new FXMLLoader();
			
			//Provides the file access location for the FXML file
			loader.setLocation(MainApp.class.getResource("/chapman/five/view/LoginScreen.fxml"));
			
			//Loads the AnchorPane into the itemOverview object
			AnchorPane loginScreen = (AnchorPane) loader.load();
			
			//Centers the itemOverview in the root layout screen
			rootLayout.setCenter(loginScreen);
					
			//Sets the controller for the ItemOverview View
			LoginScreenController controller = loader.getController();
			
			//Provides the reference to the main application for the controller
			controller.setMainApp(this);
			
			
		  //Again, standard debug crash dump with errors.  NOT used in production code releases
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
	
	
	*/
	
}	

