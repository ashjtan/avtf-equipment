package chappelle.five.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public abstract class SceneSwitcher {

	public static void handleSceneSwitch(Button btn, String filePath) throws IOException{
		Stage stage; 
		Parent root;
		//Setting the scene to the check in menu
		//get reference to the button's stage         
		stage=(Stage) btn.getScene().getWindow();
		//load up OTHER FXML document
		root = FXMLLoader.load(SceneSwitcher.class.getResource(filePath));		//String name of FXML file location
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}