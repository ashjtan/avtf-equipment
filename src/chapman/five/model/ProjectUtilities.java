package chapman.five.model;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ProjectUtilities {

	/**
	 * Loads the check mark image.
	 * @param img - image file to load onto scene
	 */
	public static void handleUpdateImage(ImageView img) {
		Image checkMark = new Image("file:resources/checkmark.png");
		img.setImage(checkMark);
	}

	/**
	 * Switches from one scene to another.
	 * @param btn - the button to click that is bound to the handleSceneSwitch method.
	 * @param filePath - String name of the filepath.
	 */
	public static void handleSceneSwitch(Button btn, String filePath) throws IOException {		
		Stage stage; 																//Sets up stage
		Parent root;
		stage=(Stage) btn.getScene().getWindow();									//References button's stage         
		root = FXMLLoader.load(ProjectUtilities.class.getResource(filePath));		//Loads FXML document to switch to
		Scene scene = new Scene(root);
		stage.setScene(scene);														//Sets new scene on referenced stage
		stage.show();
	}	
}
