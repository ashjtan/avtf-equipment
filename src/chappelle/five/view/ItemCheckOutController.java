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
import tan.five.model.StudentEquipmentManagement;
import chapman.five.model.ProjectUtilities;

public class ItemCheckOutController  {

	//Fields
	/**
	 * Table of Equipment that the Student is holding loaded from CSV file, able to bind to JavaFX.
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
	 * Bound to the Add to Cart button in the .fxml file.
	 */
	@FXML
	private Button btnAddToCart;
	/**
	 * Bound to the Check Out button in the .fxml file.
	 */
	@FXML
	private Button btnCheckOut;
	/**
	 * Bound to the Clear button in the .fxml file.
	 */
	@FXML 
	private Button btnClearCart;


	/**
	 * Bound to the Back button in the .fxml file.
	 */
	@FXML
	private Button btnBackButton;


	/**
	 * Error shown if the user tries to add more than six items to his cart.
	 */
	@FXML
	private Label lblMaximumItemsError;
	/**
	 * Error shown if the user tries to check in with no items in his cart.
	 */
	@FXML
	private Label lblNoItemsError;

	/**
	 * Right-side viewable list of items selected to check out, able to bind to JavaFX.
	 */
	@FXML
	private ListView<String> equipmentCart;		
	/**
	 * List backing the equipmentCart ListView, able to bind to JavaFX.
	 */
	private static ObservableList<String> listForCart = FXCollections.observableArrayList();	




	public void start(Stage primaryStage) {

	}

	/**
	 * Loads Equipment currently available from the equipment CSV file 
	 * and sets the name and type into their respective table columns when the scene is loaded.
	 */
	@FXML
	public void initialize() {
		handleClear();
		for (Equipment equipment : StudentEquipmentManagement.getEquipmentListLoad()) {		//Loads equipment list from CSV file
			if (equipment.isCheckedOut() == false) {										//Only loads equipment that is not currently checked out
				equipmentTableView.getItems().add(equipment);
			}
		}
		equipmentName.setCellValueFactory(new PropertyValueFactory<>("equipmentName"));		//Sets info into correct table columns
		equipmentType.setCellValueFactory(new PropertyValueFactory<>("equipmentType"));
	}




	//Event Handlers
	/**
	 * Prevents duplicates of an item into the cart.
	 * Displays an error when the user tries to add more than six items in his cart.
	 * Adds the selected item to the cart if there are no errors.
	 */
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


	/**
	 * Displays an error if the user tries to check out items without any in his cart.
	 * Switches scene to CheckOutFinal if there are no errors.
	 */

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

	/**
	 * Clears list of items to check out.
	 */
	@FXML
	public void handleClear() {
		listForCart.clear();
		equipmentCart.setItems(listForCart);
	}

	/**
	 * Switches scene back to the StudentWelcomeScreen and cancels item checkout.
	 * @throws IOException
	 */
	@FXML
	public void handleBack() throws IOException {
		handleClear();
		ProjectUtilities.handleSceneSwitch(btnBackButton, "/chappelle/five/view/StudentWelcomeScreen.fxml");
	}




	//Helper Methods
	/**
	 * Gets ArrayList<Equipment> of items in cart checking out.
	 * @return Equipment in cart to check out.
	 */
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