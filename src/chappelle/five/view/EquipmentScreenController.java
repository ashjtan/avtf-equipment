package chappelle.five.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tan.five.mainApp;
import tan.five.model.Equipment;
import tan.five.model.EquipmentType;
import tan.five.model.Student;
import tan.five.model.StudentEquipmentManagement;
import chapman.five.model.ProjectUtilities;

public class EquipmentScreenController {

	@FXML
	private Button btnBackButton;

	@FXML
	private TableView<Equipment> equipmentTableView;
	@FXML
	private TableColumn<Equipment, String> equipmentName;
	@FXML
	private TableColumn<Equipment, String> equipmentID;
	@FXML
	private TableColumn<Equipment, String> countyID;
	@FXML
	private TableColumn<Equipment, Boolean> checkedOut;
	@FXML 
	private TableColumn<Equipment, Student> holder;
	@FXML
	private TableColumn<Equipment, EquipmentType> equipmentType;


	public void start(Stage primaryStage) {

	}

	//CURRENTLY HOLDS ALL TABLE INFO BUT ACTUAL CHECKOUT WILL NOT HAVE ALL INFO
	@FXML
	public void initialize() {
		for (Equipment equipment : StudentEquipmentManagement.getEquipmentListA()) {
			equipmentTableView.getItems().add(equipment);
		}

		equipmentName.setCellValueFactory(new PropertyValueFactory<>("equipmentName"));
		equipmentID.setCellValueFactory(new PropertyValueFactory<>("equipmentID"));
		countyID.setCellValueFactory(new PropertyValueFactory<>("countyID"));
		checkedOut.setCellValueFactory(new PropertyValueFactory<>("checkedOut"));
		holder.setCellValueFactory(new PropertyValueFactory<>("holder"));
		equipmentType.setCellValueFactory(new PropertyValueFactory<>("equipmentType"));
	}

	//Switches scenes
	@FXML
	public void backButton() throws IOException {
		ProjectUtilities.handleSceneSwitch(btnBackButton, "/chappelle/five/view/AdminWelcomeScreen.fxml");
	}
	

	public void setMainApp(mainApp mainApp) {


	}

}
