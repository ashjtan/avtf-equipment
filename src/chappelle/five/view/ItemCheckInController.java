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

import tan.five.model.Equipment;
import tan.five.model.EquipmentType;
import tan.five.model.Student;
import tan.five.model.StudentEquipmentManagement;
import chapman.five.model.ProjectUtilities;


public class ItemCheckInController {

	//Fields
	/**
	 * Table of Equipment loaded from CSV file, able to bind to JavaFX.
	 */
	@FXML
	private TableView<Equipment> equipmentTableView;
	/**
	 * Table column displaying the title of the Equipment, able to bind to JavaFX.
	 */
	@FXML
	private TableColumn<Equipment, String> equipmentName;
	/**
	 * Table column displaying the category of AVTF equipment this piece falls into, able to bind to JavaFX.
	 */
	@FXML
	private TableColumn<Equipment, EquipmentType> equipmentType;


	/**
	 * Bound to the Add to List button in the .fxml file.
	 */
	@FXML
	private Button btnAddToList;
	/**
	 * Bound to the Check In button in the .fxml file.
	 */
	@FXML
	private Button btnCheckIn;
	/**
	 * Bound to the Clear button in the .fxml file.
	 */
	@FXML
	private Button btnClearList;

	/**
	 * Bound to the Back button in the .fxml file.
	 */
	@FXML
	private Button btnBackButton;


	/**
	 * Error shown if the user tries to add more than six items to his list to check in.
	 */
	@FXML
	private Label lblMaximumItemsError;
	/**
	 * Error shown if the user tries to check in with no items in his list to return.
	 */
	@FXML
	private Label lblNoItemsError;

	/**
	 * Right-side viewable list of items selected to return, able to bind to JavaFX.
	 */
	@FXML
	private ListView<String> equipmentReturn;		
	/**
	 * List backing the equipmentReturn ListView, able to bind to JavaFX.
	 */
	private static ObservableList<String> listForReturn = FXCollections.observableArrayList();	




	public void start(Stage primaryStage) {

	}

	/**
	 * Loads Equipment currently in possession of the user from the equipment CSV file 
	 * and sets the name and type into their respective table columns when the scene is loaded.
	 */
	@FXML
	public void initialize() {
		handleClear();
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
	/**
	 * Prevents duplicates of an item into the list to return.
	 * Displays an error when the user tries to add more than six items in his list to return.
	 * Adds the selected item to the list to return if there are no errors.
	 */
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

	/**
	 * Displays an error if the user tries to check in items without any in his list to return.
	 * Switches scene to CheckInFinal if there are no errors.
	 */
	@FXML
	public void handleCheckIn() throws IOException {
		if (listForReturn.size() > 0) {											//Checks that there are items to be returned
			ProjectUtilities.handleSceneSwitch(btnCheckIn, "/chappelle/five/view/CheckInFinal.fxml");
		}
		else {
			if (lblMaximumItemsError.isVisible()) {								//Displays error if needed
				lblMaximumItemsError.setVisible(false);
			}
			lblNoItemsError.setVisible(true);
		}
	}

	/**
	 * Clears list of items to return.
	 */
	@FXML
	public void handleClear() {			
		listForReturn.clear();
		equipmentReturn.setItems(listForReturn);
	}

	/**
	 * Switches scene back to the StudentWelcomeScreen and cancels item check-in.
	 * @throws IOException
	 */
	@FXML
	public void handleBack() throws IOException {
		handleClear();
		ProjectUtilities.handleSceneSwitch(btnBackButton, "/chappelle/five/view/StudentWelcomeScreen.fxml");
	}



	
	//Helper Methods
	/**
	 * Gets ArrayList<Equipment> of items in list checking in.
	 * @return Equipment in list to check in.
	 */
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

	/**
	 * Reads item selected in TableView.
	 * @return Equipment highlighted in table.
	 */
	@FXML
	public Equipment readSelectedItem() {
		Equipment equipment = equipmentTableView.getSelectionModel().getSelectedItem();
		return equipment;
	}
}