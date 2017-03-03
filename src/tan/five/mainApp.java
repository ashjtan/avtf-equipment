package tan.five;
import java.io.IOException;
import java.util.ArrayList;

import chapman.five.MainApp;
import chapman.five.view.LoginScreenController;
import chapman.five.view.RootLayoutController;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import tan.five.model.Equipment;
import tan.five.model.Student;
import tan.five.model.StudentEquipmentManagement;
import tan.five.model.StudentFinal;

public class mainApp extends Application{

	/*	
	static ArrayList<Student> myStudentList = StudentEquipmentManagement.getStudentList();
	//static ArrayList<Equipment> myEquipmentList = new ArrayList();

	static StudentEquipmentManagement studentEquipmentManagement = new StudentEquipmentManagement();
	 */

	static ObservableList<Student> myStudentList = StudentEquipmentManagement.getStudentList();

	public static void main(String[] args) {

		myStudentList = StudentEquipmentManagement.getStudentList();

		Student student = new Student();

		for (int i = 0; i < myStudentList.size(); i++)
		{
			student = myStudentList.get(i);
			System.out.println(String.format("%-35s %-25s %-20s", student.getLastName(), student.getFirstName(), student.getStudentID()));
		}
	}


	//GUI Stuff


	//private fields of a stage that will be the primary stage, and the root layout of our main window
	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		try {

			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("AVTF Equipment Manager");	//Sets the title of the Window

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
			loader.setLocation(MainApp.class.getResource("/tan/five/view/Login.fxml"));

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


		//GUI Stuff END
	}
}