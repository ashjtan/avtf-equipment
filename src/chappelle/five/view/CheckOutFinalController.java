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
import tan.five.model.PrintLog;
import tan.five.model.Student;
import tan.five.model.StudentEquipmentManagement;
import chappelle.five.view.ItemCheckOutController;
import chapman.five.model.ProjectUtilities;

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
	Image checkMark = new Image("file:resources/checkmark.png");

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


<<<<<<< HEAD
=======










/*
	
	//Add the equipment name to the label
>>>>>>> refs/remotes/origin/master
	@FXML
	private void initialize() {
		switch (ItemCheckOutController.getEquipmentToCheckOut().size()) {
		case 1:
			lblItem1.setVisible(true);
			txtImput1.setVisible(true);
			break;
		case 2:
			lblItem1.setVisible(true);
			txtImput1.setVisible(true);
			lblItem2.setVisible(true);
			txtImput2.setVisible(true);
			break;
		case 3:
			lblItem1.setVisible(true);
			txtImput1.setVisible(true);
			lblItem2.setVisible(true);
			txtImput2.setVisible(true);
			lblItem3.setVisible(true);
			txtImput3.setVisible(true);
			break;
		case 4:
			lblItem1.setVisible(true);
			txtImput1.setVisible(true);
			lblItem2.setVisible(true);
			txtImput2.setVisible(true);
			lblItem3.setVisible(true);
			txtImput3.setVisible(true);
			lblItem4.setVisible(true);
			txtImput4.setVisible(true);
			break;
		case 5:
			lblItem1.setVisible(true);
			txtImput1.setVisible(true);
			lblItem2.setVisible(true);
			txtImput2.setVisible(true);
			lblItem3.setVisible(true);
			txtImput3.setVisible(true);
			lblItem4.setVisible(true);
			txtImput4.setVisible(true);
			lblItem5.setVisible(true);
			txtImput5.setVisible(true);
			break;
		case 6:
			lblItem1.setVisible(true);
			txtImput1.setVisible(true);
			lblItem2.setVisible(true);
			txtImput2.setVisible(true);
			lblItem3.setVisible(true);
			txtImput3.setVisible(true);
			lblItem4.setVisible(true);
			txtImput4.setVisible(true);
			lblItem5.setVisible(true);
			txtImput5.setVisible(true);
			lblItem6.setVisible(true);
			txtImput6.setVisible(true);
			break;
		default:
			//ERROR//
			break;
		}
	}
<<<<<<< HEAD
	
	public void handleCheckOut() throws FileNotFoundException {
		for (Equipment equipment : ItemCheckOutController.getEquipmentToCheckOut()) {
			equipment.setCheckedOut(true);
			PrintLog.updateLog(false, equipment);
		}
		
	}
=======
	 
*/
>>>>>>> refs/remotes/origin/master

}
