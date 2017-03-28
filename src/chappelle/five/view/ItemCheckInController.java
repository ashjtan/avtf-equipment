package chappelle.five.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tan.five.mainApp;
import tan.five.model.Equipment;
import tan.five.model.EquipmentType;
import tan.five.model.StudentEquipmentManagement;


public class ItemCheckInController {


	@FXML
	private Button btnBackButton;

	@FXML
	private TableView<Equipment> equipmentTableView;
	@FXML
	private TableColumn<Equipment, String> equipmentName;
	@FXML
	private TableColumn<Equipment, EquipmentType> equipmentType;

	
	public void start(Stage primaryStage) {

	}

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
	
	//Method for switching scenes
	@FXML
	public void backButton() throws IOException {
		SceneSwitcher.handleSceneSwitch(btnBackButton, "/chappelle/five/view/StudentWelcomeScreen.fxml");
	}


	public void setMainApp(mainApp mainApp) {
		// TODO Auto-generated method stub

	}


}
