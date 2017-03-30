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


	@FXML
	private Button btnBackButton;
	@FXML
	private Button btnAddToCart;
	@FXML 
	private Button btnClearCart;
	@FXML
	private Button btnCheckOut;

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
	private ListView<String> equipmentCart;

	private static ObservableList<String> listForCart = FXCollections.observableArrayList();
	

	private mainApp mainApp;




	public void start(Stage primaryStage) {

	}

	@FXML
	public void initialize() {

		for (Equipment equipment : StudentEquipmentManagement.getEquipmentListLoad()) {
			if (equipment.isCheckedOut() == false) {
				equipmentTableView.getItems().add(equipment);
			}
		}
		equipmentName.setCellValueFactory(new PropertyValueFactory<>("equipmentName"));
		equipmentType.setCellValueFactory(new PropertyValueFactory<>("equipmentType"));
	}

	
	@FXML
	public void handleAddToCart() {
		boolean duplicate = false;
		int itemCount = 0;

		for (String itemInCart : listForCart) {
			itemCount++;
			if (readSelectedItem().getEquipmentName().equals(itemInCart)) {
				duplicate = true;
			}
		}

		if (itemCount >= 6) {
			lblMaximumItemsError.setVisible(true);
		}

		else if (!duplicate) {
			listForCart.add(readSelectedItem().getEquipmentName());
			equipmentCart.setItems(listForCart);

		}

	}





	//Method for switching scenes
	@FXML
	public void handleBack() throws IOException {
		ProjectUtilities.handleSceneSwitch(btnBackButton, "/chappelle/five/view/StudentWelcomeScreen.fxml");
	}
	@FXML
	public void handleCheckOut() throws IOException {
		if (listForCart.size() != 0) {
			ProjectUtilities.handleSceneSwitch(btnCheckOut, "/chappelle/five/view/CheckOutFinal.fxml");
		}
		else {
			if (lblMaximumItemsError.isVisible()) {
				lblMaximumItemsError.setVisible(false);
			}
			lblNoItemsError.setVisible(true);
		}
	}



	@FXML
	public void handleClear() {
		listForCart.clear();
		equipmentCart.setItems(listForCart);
	}


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






	//HELPER METHODS
	//Reads item clicked/selected in equipmentTableView
	@FXML
	public Equipment readSelectedItem() {
		Equipment equipment = equipmentTableView.getSelectionModel().getSelectedItem();
		return equipment;
	}

	public void setMainApp(mainApp mainApp) {
		this.mainApp = mainApp;
	}
}