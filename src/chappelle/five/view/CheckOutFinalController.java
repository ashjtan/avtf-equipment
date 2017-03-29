package chappelle.five.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tan.five.model.Equipment;
import tan.five.model.Student;
import tan.five.model.StudentEquipmentManagement;
import chappelle.five.view.ItemCheckOutController;
import chappelle.five.view.UpdateImage;

public class CheckOutFinalController {

	//Fields
	@FXML
	private ImageView imgCheckMark1;
	@FXML
	private ImageView imgCheckMark2;
	@FXML
	private ImageView imgCheckMark3;
	@FXML
	private ImageView imgCheckMark4;
	@FXML
	private ImageView imgCheckMark5;
	@FXML
	private ImageView imgCheckMark6;
	@FXML
	private Label lblItem1;
	@FXML
	private Label lblItem2;
	@FXML
	private Label lblItem3;
	@FXML
	private Label lblItem4;
	@FXML
	private Label lblItem5;
	@FXML
	private Label lblItem6;
	Image checkMark = new Image("file:resources/checkmark.png");
	@FXML
	private ListView<String> equipmentCart;
	@FXML
	private TextField txtImput1;
	@FXML
	private TextField txtImput2;
	@FXML
	private TextField txtImput3;
	@FXML
	private TextField txtImput4;
	@FXML
	private TextField txtImput5;
	@FXML
	private TextField txtImput6;













	/*
	//Add the equipment name to the label
	@FXML
	private void initialize() {
		for(Equipment equipment : ItemCheckOutController.get) {

		}

	}
	 */


}
