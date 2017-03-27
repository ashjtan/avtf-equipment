package tan.five;

import java.io.IOException;
import java.util.ArrayList;
import chappelle.five.view.RootLayoutController;
import chappelle.five.view.StudentDataScreenController;
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
import tan.five.view.LoginController;

public class mainApp extends Application{
	
	
	
	public static void main(String[] args) throws IOException {
		launch(args);
	}


	//private fields of a stage that will be the primary stage, and the root layout of our main window
	private Stage primaryStage;
	private AnchorPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		try {

			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("AVTF Equipment Manager");	//Sets the title of the Window

			//Sets application icon
			//this.primaryStage.getIcons().add(new Image());

			//Sets up Root Layout
			initRootLayout();

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
			loader.setLocation(mainApp.class.getResource("/tan/five/view/Login.fxml"));

			//Sets the rootlayout field to the BorderPane FXM file injected via @FXML
			rootLayout = (AnchorPane) loader.load();

			//Sets a Scene object to this rootLayout
			Scene scene = new Scene(rootLayout);

			//Give the controller access to the main app.
			LoginController controller = loader.getController();
			controller.setMainApp(this);

			//Sets the primaryScene Scene object to scene
			primaryStage.setScene(scene);

			//Shows the primaryStage object
			primaryStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}