package chapman.five.model;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ProjectUtilities {

	//To load the checkmark image
		public static void handleUpdateImage(Label lbl, ImageView img) {
			Image checkMark = new Image("file:resources/checkmark.png");
			img.setImage(checkMark);
		}
		
		//Method for switching scenes
		public static void handleSceneSwitch(Button btn, String filePath) throws IOException{
			Stage stage; 
			Parent root;
			//Setting the scene to the check in menu
			//get reference to the button's stage         
			stage=(Stage) btn.getScene().getWindow();
			//load up OTHER FXML document
			root = FXMLLoader.load(ProjectUtilities.class.getResource(filePath));		//String name of FXML file location
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}	
		
	
}
