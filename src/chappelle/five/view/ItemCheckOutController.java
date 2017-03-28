package chappelle.five.view;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import tan.five.mainApp;
import tan.five.model.Equipment;
import tan.five.model.EquipmentType;
import tan.five.model.Student;
import tan.five.model.StudentEquipmentManagement;

public class ItemCheckOutController  {


	@FXML
	private Button btnCheckIn;
	@FXML
	private Button btnCheckOut;
	@FXML
	private Button btnGoBack;
	
	@FXML
	private TableView<Equipment> equipmentTableView;
	@FXML
	private TableColumn<Equipment, String> equipmentName;
	@FXML
	private TableColumn<Equipment, EquipmentType> equipmentType;
	

	public void start(Stage primaryStage) {

	}

	//CURRENTLY HOLDS ALL TABLE INFO BUT ACTUAL CHECKOUT WILL NOT HAVE ALL INFO
	@FXML
	public void initialize() {
		for (Equipment equipment : StudentEquipmentManagement.getEquipmentListA()) {
			if (equipment.isCheckedOut() == false) {
				equipmentTableView.getItems().add(equipment);
			}
		}
		equipmentName.setCellValueFactory(new PropertyValueFactory<>("equipmentName"));
		equipmentType.setCellValueFactory(new PropertyValueFactory<>("equipmentType"));
	}

	//Switches scenes
	@FXML
	private void handleSceneSwitch(ActionEvent event) throws IOException{
		Stage stage; 
		Parent root;
		//Setting the scene to scene one
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
				root = FXMLLoader.load(getClass().getResource("tan/five/view/Login.fxml"));
			}
			//create a new scene with root and set the stage
			Scene checkInMenu = new Scene(root);
			stage.setScene(checkInMenu);
			stage.show();
		}
	}

	public void setMainApp(mainApp mainApp) {
		

	}

}