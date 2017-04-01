package chappelle.five.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import tan.five.model.Equipment;
import tan.five.model.EquipmentType;
import tan.five.model.StudentEquipmentManagement;
import chapman.five.model.ProjectUtilities;

public class EquipmentScreenController {

	//Fields
	/**
	 * Table of Equipment information loaded from CSV file, able to bind to JavaFX.
	 */
	@FXML
	private TableView<Equipment> equipmentTableView;
	/**
	 * Table column displaying the title of the Equipment, able to bind to JavaFX.
	 */
	@FXML
	private TableColumn<Equipment, String> equipmentName;
	/**
	 * Table column displaying the four-digit barcode number of the Equipment, able to bind to JavaFX.
	 */
	@FXML
	private TableColumn<Equipment, String> equipmentID;
	/**
	 * Table column displaying the county ID of the Equipment, able to bind to JavaFX.
	 */
	@FXML
	private TableColumn<Equipment, String> countyID;
	/**
	 * Table column displaying if the Equipment is checked out, able to bind to JavaFX.
	 */
	@FXML
	private TableColumn<Equipment, Boolean> checkedOut;
	/**
	 * Table column displaying the Student (if any) in possession of the Equipment, able to bind to JavaFX.
	 */
	@FXML 
	private TableColumn<Equipment, String> holder;
	/**
	 * Table column displaying the category of AVTF equipment this piece falls into, able to bind to JavaFX.
	 */
	@FXML
	private TableColumn<Equipment, EquipmentType> equipmentType;

	/**
	 * Bound to the back button in the .fxml file.
	 */
	@FXML
	private Button btnBackButton;




	public void start(Stage primaryStage) {

	}

	/**
	 * Loads Equipment information from the equipment CSV file and sets the information 
	 * into its respective table column when the scene is loaded.
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




	//Event Handlers
	/**
	 * Switches scene back to the AdminWelcomeScreen.
	 * @throws IOException
	 */
	@FXML
	public void handleBack() throws IOException {
		ProjectUtilities.handleSceneSwitch(btnBackButton, "/chappelle/five/view/AdminWelcomeScreen.fxml");
	}
}