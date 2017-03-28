package chappelle.five.view;

import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import tan.five.mainApp;
import tan.five.model.Equipment;
import tan.five.model.EquipmentType;
import tan.five.model.Student;
import tan.five.model.StudentEquipmentManagement;
import chappelle.five.view.SceneSwitcher;

public class ItemCheckOutController  {


	@FXML
	private Button btnBackButton;
	@FXML
	private Button btnAddToCart;
	@FXML 
	private Button btnClearCart;

	@FXML
	private TableView<Equipment> equipmentTableView;
	@FXML
	private TableColumn<Equipment, String> equipmentName;
	@FXML
	private TableColumn<Equipment, EquipmentType> equipmentType;

	@FXML
	private ListView<String> equipmentCart;

	private ObservableList<String> listForCart = FXCollections.observableArrayList();



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

	@FXML
	public void handleAddToCart() {
		/*for (String itemInCart : equipmentCart.getItems()) {
			if (!(readSelectedItem().equals(itemInCart))) {
				cartedItems.add(itemInCart);
				equipmentCart.setItems(cartedItems);
			}
		}*/

		//ADD CHECK SO NO CART DUPLICATES//
		listForCart.add(readSelectedItem().getEquipmentName());
		equipmentCart.setItems(listForCart);

	}

	//Method for switching scenes
	@FXML
	public void backButton() throws IOException {
		SceneSwitcher.handleSceneSwitch(btnBackButton, "/chappelle/five/view/StudentWelcomeScreen.fxml");
	}





	//Shopping cart
	@FXML
	public Equipment readSelectedItem() {
		Equipment equipment = equipmentTableView.getSelectionModel().getSelectedItem();
		return equipment;
	}

	@FXML
	public void handleClear() {
		listForCart.clear();
		equipmentCart.setItems(listForCart);
	}



	public void setMainApp(mainApp mainApp) {
		

	}

}