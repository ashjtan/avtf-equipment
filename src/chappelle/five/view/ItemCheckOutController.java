package chappelle.five.view;

import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
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

public class ItemCheckOutController  {

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
	private Button btnAddToCart;
	@FXML 
	private Button btnClearCart;
	@FXML
	private Button btnCheckOut;

	//Switches scene
	@FXML
	private Button btnBackButton;

	//Errors displayed to user
	@FXML
	private Label lblMaximumItemsError;
	@FXML
	private Label lblNoItemsError;

	@FXML
	private ListView<String> equipmentCart;		//Right-side viewable list of items selected to check out

	private static ObservableList<String> listForCart = FXCollections.observableArrayList();	//Backs equipmentCart view




	public void start(Stage primaryStage) {

	}

	@FXML
	public void initialize() {

		for (Equipment equipment : StudentEquipmentManagement.getEquipmentListLoad()) {		//Loads equipment list from CSV file
			if (equipment.isCheckedOut() == false) {										//Only loads equipment that is not currently checked out
				equipmentTableView.getItems().add(equipment);
			}
		}
		equipmentName.setCellValueFactory(new PropertyValueFactory<>("equipmentName"));		//Sets info into correct table columns
		equipmentType.setCellValueFactory(new PropertyValueFactory<>("equipmentType"));
	}




	//Event Handlers
	//Adds item to list to check out
	@FXML
	public void handleAddToCart() {
		boolean duplicate = false;

		for (String itemInCart : listForCart) {
			if (readSelectedItem().getEquipmentName().equals(itemInCart)) {
				duplicate = true;
			}
		}
		if (listForCart.size() >= 6) {
			lblMaximumItemsError.setVisible(true);
		}
		else if (!duplicate) {
			listForCart.add(readSelectedItem().getEquipmentName());
			equipmentCart.setItems(listForCart);
		}
	}




	//Moves to check out items added to list to check out
	@FXML
	public void handleCheckOut() throws IOException {
		if (listForCart.size() > 0) {						//Checks that there are items to be checked out
			ProjectUtilities.handleSceneSwitch(btnCheckOut, "/chappelle/five/view/CheckOutFinal.fxml");
		}
		else {
			if (lblMaximumItemsError.isVisible()) {			//Displays error if needed
				lblMaximumItemsError.setVisible(false);
			}
			lblNoItemsError.setVisible(true);
		}
	}

	//Clears list of items to check out
	@FXML
	public void handleClear() {
		listForCart.clear();
		equipmentCart.setItems(listForCart);
	}


	//Switches scene
	@FXML
	public void handleBack() throws IOException {
		listForCart.clear();
		equipmentCart.setItems(listForCart);
		ProjectUtilities.handleSceneSwitch(btnBackButton, "/chappelle/five/view/StudentWelcomeScreen.fxml");
	}




	//Helper Methods
	//Gets ArrayList<Equipment> of items in cart checking out
	public static ArrayList<Equipment> getEquipmentToCheckOut() {
		ArrayList<Equipment> equipmentToCheckOut = new ArrayList<Equipment>();
		for (String itemInCart : listForCart) {
			for (Equipment equipment : StudentEquipmentManagement.getEquipmentListA())
				if (itemInCart.equals(equipment.getEquipmentName())) {
					equipmentToCheckOut.add(equipment);
				}
		}
		return equipmentToCheckOut;
	}

	//Reads item selected in TableView
	@FXML
	public Equipment readSelectedItem() {
		Equipment equipment = equipmentTableView.getSelectionModel().getSelectedItem();
		return equipment;
	}
}