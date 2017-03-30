package chappelle.five.view;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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


public class ItemCheckInController {


	@FXML
	private Button btnBackButton;
	@FXML
	private Button btnAddToList;
	@FXML
	private Button btnCheckIn;
	@FXML
	private Button btnClearList;

	@FXML
	private TableView<Equipment> equipmentTableView;
	@FXML
	private TableColumn<Equipment, String> equipmentName;
	@FXML
	private TableColumn<Equipment, EquipmentType> equipmentType;

	@FXML
	private Label lblMaximumItemsError;
	@FXML
	private Label lblNoItemsError;

	@FXML
	private ListView<String> equipmentReturn;

	private static ObservableList<String> listForReturn = FXCollections.observableArrayList();


	public void start(Stage primaryStage) {

	}

	@FXML
	public void initialize() {
		for (Equipment equipment : StudentEquipmentManagement.getEquipmentListLoad())  {
			if (equipment.isCheckedOut()) {													//Prevents NullPointerException
				if (equipment.getHolder().equals(Student.SELECTED_STUDENT)) {
					equipmentTableView.getItems().add(equipment);
				}
			}
		}

		equipmentName.setCellValueFactory(new PropertyValueFactory<>("equipmentName"));
		equipmentType.setCellValueFactory(new PropertyValueFactory<>("equipmentType"));

	}

	@FXML
	public void handleAddToList() {
		boolean duplicate = false;

		for (String itemInList : listForReturn) {
			if (readSelectedItem().getEquipmentName().equals(itemInList)) {
				duplicate = true;
			}
		}

		if (listForReturn.size() >= 6) {
			lblMaximumItemsError.setVisible(true);
		}

		else if (!duplicate) {
			listForReturn.add(readSelectedItem().getEquipmentName());
			equipmentReturn.setItems(listForReturn);
		}
	}

	@FXML
	public void handleClear() {
		listForReturn.clear();
		equipmentReturn.setItems(listForReturn);
	}

	//Gets ArrayList<Equipment> of items in cart checking out
	public static ArrayList<Equipment> getEquipmentToCheckIn() {
		ArrayList<Equipment> equipmentToCheckIn = new ArrayList<Equipment>();
		for (String itemInList : listForReturn) {
			for (Equipment equipment : StudentEquipmentManagement.getEquipmentListA())
				if (itemInList.equals(equipment.getEquipmentName())) {
					equipmentToCheckIn.add(equipment);
				}
		}
		return equipmentToCheckIn;
	}


	//Method for switching scenes
	@FXML
	public void handleBack() throws IOException {
		ProjectUtilities.handleSceneSwitch(btnBackButton, "/chappelle/five/view/StudentWelcomeScreen.fxml");
	}

	@FXML
	public void handleCheckIn() throws IOException {
		if (listForReturn.size() != 0) {
			ProjectUtilities.handleSceneSwitch(btnCheckIn, "/chappelle/five/view/CheckInFinal.fxml");
		}
		else {
			if (lblMaximumItemsError.isVisible()) {
				lblMaximumItemsError.setVisible(false);
			}
			lblNoItemsError.setVisible(true);
		}
	}

	@FXML
	public Equipment readSelectedItem() {
		Equipment equipment = equipmentTableView.getSelectionModel().getSelectedItem();
		return equipment;
	}

	public void setMainApp(mainApp mainApp) {

	}

}