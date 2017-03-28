package chappelle.five.view;

import java.io.IOException;
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
	private TableView<Equipment> equipmentTableView;
	@FXML
	private TableColumn<Equipment, String> equipmentName;
	@FXML
	private TableColumn<Equipment, EquipmentType> equipmentType;


	public void start(Stage primaryStage) {

	}

	@FXML
	public void initialize() {
<<<<<<< HEAD
		for (Equipment equipment : StudentEquipmentManagement.getEquipmentListA()) {
			if (equipment.isCheckedOut() == false) {
				equipmentTableView.getItems().add(equipment);
			}
=======
		for (Equipment equipment : Student.SELECTED_STUDENT.getCheckedOutEquipmentA()) {
			equipmentTableView.getItems().add(equipment);
>>>>>>> refs/remotes/origin/master
		}

		equipmentName.setCellValueFactory(new PropertyValueFactory<>("equipmentName"));
		equipmentType.setCellValueFactory(new PropertyValueFactory<>("equipmentType"));
	}

	//Method for switching scenes
	@FXML
	public void backButton() throws IOException {
		SceneSwitcher.handleSceneSwitch(btnBackButton, "/chappelle/five/view/StudentWelcomeScreen.fxml");
	}




	//Shopping cart
	equipmentTableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
		@Override
		public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
			//Check whether item is selected and set value of selected item to Label
			if(equipmentTableView.getSelectionModel().getSelectedItem() != null) 
			{    
				TableViewSelectionModel selectionModel = equipmentTableView.getSelectionModel();
				ObservableList selectedCells = selectionModel.getSelectedCells();
				TablePosition tablePosition = (TablePosition) selectedCells.get(0);
				Object val = tablePosition.getTableColumn().getCellData(newValue);
				System.out.println("Selected Value" + val);
			}
		}
	});





























	public void setMainApp(mainApp mainApp) {
		// TODO Auto-generated method stub

	}

}