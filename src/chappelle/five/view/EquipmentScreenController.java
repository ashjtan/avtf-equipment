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

	//Fields
	//Displays CSV-loaded equipment info
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
	private TableColumn<Equipment, String> holder;
	@FXML
	private TableColumn<Equipment, EquipmentType> equipmentType;

	//Switches scene
	@FXML
	private Button btnBackButton;






	public void start(Stage primaryStage) {

	}
	/**
	 * Loads equipment info from CSV file
	 * Sets info into correct table columns
	 */
	@FXML
	public void initialize() {
		for (Equipment equipment : StudentEquipmentManagement.getEquipmentListLoad()) {		//Loads equipment info from CSV file
			if (equipment.getHolder()!= null) {
				equipment.setHolderName(equipment.getHolder().toString());
			}
			equipmentTableView.getItems().add(equipment);
		}
		equipmentName.setCellValueFactory(new PropertyValueFactory<>("equipmentName"));		//Sets info into correct table columns
		equipmentID.setCellValueFactory(new PropertyValueFactory<>("equipmentID"));
		countyID.setCellValueFactory(new PropertyValueFactory<>("countyID"));
		checkedOut.setCellValueFactory(new PropertyValueFactory<>("checkedOut"));
		holder.setCellValueFactory(new PropertyValueFactory<>("holderName"));
		equipmentType.setCellValueFactory(new PropertyValueFactory<>("equipmentType"));
	}



	/**
	 * Loads Admin Welcome Screen
	 * @throws IOException
	 */
	//Switches scenes
	@FXML
	public void handleBack() throws IOException {
		ProjectUtilities.handleSceneSwitch(btnBackButton, "/chappelle/five/view/AdminWelcomeScreen.fxml");
	}
}