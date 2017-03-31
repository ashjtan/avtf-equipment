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

	//Fields

	//Displays CSV-loaded equipment info
	@FXML
	private TableView<Equipment> equipmentTableView;
	@FXML
	private TableColumn<Equipment, String> equipmentName;
	@FXML
	private TableColumn<Equipment, EquipmentType> equipmentType;

	//Allows user capability in selecting items
	@FXML
	private Button btnAddToList;
	@FXML
	private Button btnCheckIn;
	@FXML
	private Button btnClearList;

	//Switches scene
	@FXML
	private Button btnBackButton;

	//Errors displayed to user
	@FXML
	private Label lblMaximumItemsError;
	@FXML
	private Label lblNoItemsError;

	@FXML
	private ListView<String> equipmentReturn;		//Right-side viewable list of items selected to return

	private static ObservableList<String> listForReturn = FXCollections.observableArrayList();	//Backs equipmentReturn view




	public void start(Stage primaryStage) {

	}

	@FXML
	public void initialize() {
		for (Equipment equipment : StudentEquipmentManagement.getEquipmentListLoad())  {	//Loads equipment list from CSV file
			if (equipment.isCheckedOut()) {													//Prevents NullPointerException
				if (equipment.getHolder().equals(Student.SELECTED_STUDENT)) {				//Only loads equipment that student currently has checked out
					equipmentTableView.getItems().add(equipment);
				}
			}
		}
		equipmentName.setCellValueFactory(new PropertyValueFactory<>("equipmentName"));		//Sets info into correct table columns
		equipmentType.setCellValueFactory(new PropertyValueFactory<>("equipmentType"));
	}




	//Event Handlers
	//Adds item to list to return
	@FXML
	public void handleAddToList() {		
		boolean duplicate = false;

		for (String itemInList : listForReturn) {								//Checks for duplicate error
			if (readSelectedItem().getEquipmentName().equals(itemInList)) {
				duplicate = true;
			}
		}
		if (listForReturn.size() >= 6) {										//Checks for maximum number of items in list (6)
			lblMaximumItemsError.setVisible(true);
		}
		else if (!duplicate) {
			listForReturn.add(readSelectedItem().getEquipmentName());
			equipmentReturn.setItems(listForReturn);
		}
	}

	//Moves to check in items added to list to return
	@FXML
	public void handleCheckIn() throws IOException {
		if (listForReturn.size() > 0) {					//Checks that there are items to be returned
			ProjectUtilities.handleSceneSwitch(btnCheckIn, "/chappelle/five/view/CheckInFinal.fxml");
		}
		else {
			if (lblMaximumItemsError.isVisible()) {		//Displays error if needed
				lblMaximumItemsError.setVisible(false);
			}
			lblNoItemsError.setVisible(true);
		}
	}
	
	//Clears list of items to return
	@FXML
	public void handleClear() {			
		listForReturn.clear();
		equipmentReturn.setItems(listForReturn);
	}


	//Switches scene
	@FXML
	public void handleBack() throws IOException {
		ProjectUtilities.handleSceneSwitch(btnBackButton, "/chappelle/five/view/StudentWelcomeScreen.fxml");
	}



	//Helper Methods
	//Gets ArrayList<Equipment> of items in list checking in
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

	//Reads item selected in TableView
	@FXML
	public Equipment readSelectedItem() {
		Equipment equipment = equipmentTableView.getSelectionModel().getSelectedItem();
		return equipment;
	}
}