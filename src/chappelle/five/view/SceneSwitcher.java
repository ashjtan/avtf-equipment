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
/*
	//Method for switching scenes
		@FXML
		private void handleSceneSwitch(ActionEvent event) throws IOException{
			Stage stage; 
			Parent root;
			//Setting the scene to the check in menu
			if(event.getSource()==btnCheckIn){
				//get reference to the button's stage         
				stage=(Stage) btnCheckIn.getScene().getWindow();
				//load up OTHER FXML document
				root = FXMLLoader.load(getClass().getResource("CHECK IN MENU"));
			}
			//Setting the scene to the check out menu
			else {
				if(event.getSource()==btnCheckOut){
					//get reference to the button's stage         
					stage=(Stage) btnCheckOut.getScene().getWindow();
					//load up OTHER FXML document
					root = FXMLLoader.load(getClass().getResource("CHECK OUT MENU"));
				}
				//So it may set the root scene again
				else{
					stage=(Stage) btnGoBack.getScene().getWindow();
					root = FXMLLoader.load(getClass().getResource("chapman/five/view/RootLayout.fxml"));
				}
				//create a new scene with root and set the stage
				Scene checkInMenu = new Scene(root);
				stage.setScene(checkInMenu);
				stage.show();
			}
		}
		
		*/
		
		
		
	/*	
		public static void handleSceneSwitch(ActionEvent event, Button btn, Button btnGoBack, String fxmlScene) throws IOException{
			Stage stage; 
			Parent root;
			//Setting the scene to the check in menu
			if(event.getSource()==btn){
				//get reference to the button's stage         
				stage=(Stage) btn.getScene().getWindow();
				//load up OTHER FXML document
				root = FXMLLoader.load(SceneSwitcher.class.getResource(fxmlScene));		//String name of FXML file
			}
				//So it may set the root scene again
				else{
					stage=(Stage) btnGoBack.getScene().getWindow();
					root = FXMLLoader.load(SceneSwitcher.class.getResource("chappelle/five/view/RootLayout.fxml"));
				}
				//create a new scene with root and set the stage
				Scene checkInMenu = new Scene(root);
				stage.setScene(checkInMenu);
				stage.show();
			}
	*/
	

	
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



