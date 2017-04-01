package tan.five;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tan.five.view.LoginController;

public class mainApp extends Application{

	public static void main(String[] args) throws IOException {
		launch(args);
	}

	/**
	 * The primary stage where scenes are set.
	 */
	private Stage primaryStage;
	/**
	 * The root layout of the main window on which the stage is set.
	 */
	private AnchorPane rootLayout;


	
	/**
	 * Sets the stage, the window's title, and the application icon beside the title. 
	 * Sets up the rootLayout.
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("AVTF Equipment Manager");	//Sets the title of the Window
			this.primaryStage.getIcons().add(new Image("file:resources/Camcorder Pro-100.png"));

			initRootLayout();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loads the rootLayout from its .fxml file and sets the scene onto the
	 * primaryStage. Gives the controller access to the mainApp and shows the stage.
	 */
	public void initRootLayout() {

		try {
			//Main initialization routines for layout + app commencement

			//Creates FXML Loader object
			FXMLLoader loader = new FXMLLoader();

			//Point the loader at the FXML file to load
			loader.setLocation(mainApp.class.getResource("/tan/five/view/Login.fxml"));

			//Sets the rootlayout field to the BorderPane FXM file injected via @FXML
			rootLayout = (AnchorPane) loader.load();

			//Sets a Scene object to this rootLayout
			Scene scene = new Scene(rootLayout);

			//Gives controller access to the main app
			LoginController controller = loader.getController();
			controller.setMainApp(this);

			//Sets primaryScene Scene object to scene
			primaryStage.setScene(scene);

			//Shows primaryStage object
			primaryStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}