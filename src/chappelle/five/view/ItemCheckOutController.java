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
		for (Equipment equipment : Student.SELECTED_STUDENT.getCheckedOutEquipmentA()) {
				equipmentTableView.getItems().add(equipment);
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