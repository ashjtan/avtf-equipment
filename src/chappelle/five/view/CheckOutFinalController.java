package chappelle.five.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
	//Displayed by correct user barcode inputs
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

	//Set to names of items being checked out
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

	//Read user barcode inputs
	@FXML
	private TextField txtInput1;
	@FXML
	private TextField txtInput2;
	@FXML
	private TextField txtInput3;
	@FXML
	private TextField txtInput4;
	@FXML
	private TextField txtInput5;
	@FXML
	private TextField txtInput6;

	//Switch scenes
	@FXML
	private Button btnBackButton;
	@FXML
	private Button btnCheckOut;

	@FXML
	private Label lblIncorrectBarcodeError;	//Error displayed if barcode inputs incorrect

	@FXML
	private ListView<String> equipmentCart;	//ItemCheckOut's right-side viewable list of items selected to check out
	ArrayList<Equipment> equipmentCheckingOut = ItemCheckOutController.getEquipmentToCheckOut();	//Equipment selected from list to return




	//Adds equipment name to Label + sets TextField/Label to visible
	@FXML
	private void initialize() {
		switch (equipmentCheckingOut.size()) {		//Generates depending on number of items returning
		case 1:
			lblItem1.setVisible(true);
			lblItem1.setText(equipmentCheckingOut.get(0).getEquipmentName());
			txtInput1.setVisible(true);
			break;
		case 2:
			lblItem1.setVisible(true);
			lblItem1.setText(equipmentCheckingOut.get(0).getEquipmentName());
			txtInput1.setVisible(true);

			lblItem2.setVisible(true);
			lblItem2.setText(equipmentCheckingOut.get(1).getEquipmentName());
			txtInput2.setVisible(true);
			break;
		case 3:
			lblItem1.setVisible(true);
			lblItem1.setText(equipmentCheckingOut.get(0).getEquipmentName());
			txtInput1.setVisible(true);

			lblItem2.setVisible(true);
			lblItem2.setText(equipmentCheckingOut.get(1).getEquipmentName());
			txtInput2.setVisible(true);

			lblItem3.setVisible(true);
			lblItem3.setText(equipmentCheckingOut.get(2).getEquipmentName());
			txtInput3.setVisible(true);
			break;
		case 4:
			lblItem1.setVisible(true);
			lblItem1.setText(equipmentCheckingOut.get(0).getEquipmentName());
			txtInput1.setVisible(true);

			lblItem2.setVisible(true);
			lblItem2.setText(equipmentCheckingOut.get(1).getEquipmentName());
			txtInput2.setVisible(true);

			lblItem3.setVisible(true);
			lblItem3.setText(equipmentCheckingOut.get(2).getEquipmentName());
			txtInput3.setVisible(true);

			lblItem4.setVisible(true);
			lblItem4.setText(equipmentCheckingOut.get(3).getEquipmentName());
			txtInput4.setVisible(true);
			break;
		case 5:
			lblItem1.setVisible(true);
			lblItem1.setText(equipmentCheckingOut.get(0).getEquipmentName());
			txtInput1.setVisible(true);

			lblItem2.setVisible(true);
			lblItem2.setText(equipmentCheckingOut.get(1).getEquipmentName());
			txtInput2.setVisible(true);

			lblItem3.setVisible(true);
			lblItem3.setText(equipmentCheckingOut.get(2).getEquipmentName());
			txtInput3.setVisible(true);

			lblItem4.setVisible(true);
			lblItem4.setText(equipmentCheckingOut.get(3).getEquipmentName());
			txtInput4.setVisible(true);

			lblItem5.setVisible(true);
			lblItem5.setText(equipmentCheckingOut.get(4).getEquipmentName());
			txtInput5.setVisible(true);
			break;
		case 6:
			lblItem1.setVisible(true);
			lblItem1.setText(equipmentCheckingOut.get(0).getEquipmentName());
			txtInput1.setVisible(true);

			lblItem2.setVisible(true);
			lblItem2.setText(equipmentCheckingOut.get(1).getEquipmentName());
			txtInput2.setVisible(true);

			lblItem3.setVisible(true);
			lblItem3.setText(equipmentCheckingOut.get(2).getEquipmentName());
			txtInput3.setVisible(true);

			lblItem4.setVisible(true);
			lblItem4.setText(equipmentCheckingOut.get(3).getEquipmentName());
			txtInput4.setVisible(true);

			lblItem5.setVisible(true);
			lblItem5.setText(equipmentCheckingOut.get(4).getEquipmentName());
			txtInput5.setVisible(true);

			lblItem6.setVisible(true);
			lblItem6.setText(equipmentCheckingOut.get(5).getEquipmentName());
			txtInput6.setVisible(true);
			break;
		default:
			break;
		}
	}




	//Event Handlers
	//Checks for correct barcode + switches to Success screen + edits equipment file
	@FXML
	public void handleCheckOut() throws IOException {
		switch (equipmentCheckingOut.size()) {
		case 1:
			if (checkCorrectBarcode(txtInput1, 0, imgCheckMark1)) {
				for (Equipment equipment : equipmentCheckingOut) {
					PrintLog.setCheckInOrOut(1);										//Switches alterEquipmentFile to Check Out version
					equipment.setCheckedOut(true);										//Sets equipment's checkedOut boolean to true
					PrintLog.alterEquipmentFile(equipment);								//Alters equipment file's IN/OUT + holder studentID
					PrintLog.updateLog(false, equipment);								//Prints equipment checkout to log
					ProjectUtilities.handleSceneSwitch(btnCheckOut, "/chappelle/five/view/CheckOutSuccess.fxml");
				}
			}
			else {
				lblIncorrectBarcodeError.setVisible(true);
			}
			break;
		case 2:
			if (checkCorrectBarcode(txtInput1, 0, imgCheckMark1) &&
					checkCorrectBarcode(txtInput2, 1, imgCheckMark2)) {
				for (Equipment equipment : equipmentCheckingOut) {
					PrintLog.setCheckInOrOut(1);										//Switches alterEquipmentFile to Check Out version
					equipment.setCheckedOut(true);										//Sets equipment's checkedOut boolean to true
					PrintLog.alterEquipmentFile(equipment);								//Alters equipment file's IN/OUT + holder studentID
					PrintLog.updateLog(false, equipment);								//Prints equipment checkout to log
					ProjectUtilities.handleSceneSwitch(btnCheckOut, "/chappelle/five/view/CheckOutSuccess.fxml");
				}
			}
			else {
				lblIncorrectBarcodeError.setVisible(true);
			}
			break;
		case 3:
			if (checkCorrectBarcode(txtInput1, 0, imgCheckMark1) &&
					checkCorrectBarcode(txtInput2, 1, imgCheckMark2) &&
					checkCorrectBarcode(txtInput3, 2, imgCheckMark3)) {
				for (Equipment equipment : equipmentCheckingOut) {
					PrintLog.setCheckInOrOut(1);										//Switches alterEquipmentFile to Check Out version
					equipment.setCheckedOut(true);										//Sets equipment's checkedOut boolean to true
					PrintLog.alterEquipmentFile(equipment);								//Alters equipment file's IN/OUT + holder studentID
					PrintLog.updateLog(false, equipment);								//Prints equipment checkout to log
					ProjectUtilities.handleSceneSwitch(btnCheckOut, "/chappelle/five/view/CheckOutSuccess.fxml");
				}
			}
			else {
				lblIncorrectBarcodeError.setVisible(true);
			}
			break;
		case 4:
			if (checkCorrectBarcode(txtInput1, 0, imgCheckMark1) &&
					checkCorrectBarcode(txtInput2, 1, imgCheckMark2) &&
					checkCorrectBarcode(txtInput3, 2, imgCheckMark3) &&
					checkCorrectBarcode(txtInput4, 3, imgCheckMark4)) {
				for (Equipment equipment : equipmentCheckingOut) {
					PrintLog.setCheckInOrOut(1);										//Switches alterEquipmentFile to Check Out version
					equipment.setCheckedOut(true);										//Sets equipment's checkedOut boolean to true
					PrintLog.alterEquipmentFile(equipment);								//Alters equipment file's IN/OUT + holder studentID
					PrintLog.updateLog(false, equipment);								//Prints equipment checkout to log
					ProjectUtilities.handleSceneSwitch(btnCheckOut, "/chappelle/five/view/CheckOutSuccess.fxml");
				}
			}
			else {
				lblIncorrectBarcodeError.setVisible(true);
			}
			break;
		case 5:
			if (checkCorrectBarcode(txtInput1, 0, imgCheckMark1) &&
					checkCorrectBarcode(txtInput2, 1, imgCheckMark2) &&
					checkCorrectBarcode(txtInput3, 2, imgCheckMark3) &&
					checkCorrectBarcode(txtInput4, 3, imgCheckMark4) &&
					checkCorrectBarcode(txtInput5, 4, imgCheckMark5)) {
				for (Equipment equipment : equipmentCheckingOut) {
					PrintLog.setCheckInOrOut(1);										//Switches alterEquipmentFile to Check Out version
					equipment.setCheckedOut(true);										//Sets equipment's checkedOut boolean to true
					PrintLog.alterEquipmentFile(equipment);								//Alters equipment file's IN/OUT + holder studentID
					PrintLog.updateLog(false, equipment);								//Prints equipment checkout to log
					ProjectUtilities.handleSceneSwitch(btnCheckOut, "/chappelle/five/view/CheckOutSuccess.fxml");
				}
			}
			else {
				lblIncorrectBarcodeError.setVisible(true);
			}
			break;
		case 6:
			if (checkCorrectBarcode(txtInput1, 0, imgCheckMark1) &&
					checkCorrectBarcode(txtInput2, 1, imgCheckMark2) &&
					checkCorrectBarcode(txtInput3, 2, imgCheckMark3) &&
					checkCorrectBarcode(txtInput4, 3, imgCheckMark4) &&
					checkCorrectBarcode(txtInput5, 4, imgCheckMark5) &&
					checkCorrectBarcode(txtInput6, 5, imgCheckMark6)) {
				for (Equipment equipment : equipmentCheckingOut) {
					PrintLog.setCheckInOrOut(1);										//Switches alterEquipmentFile to Check Out version
					equipment.setCheckedOut(true);										//Sets equipment's checkedOut boolean to true
					PrintLog.alterEquipmentFile(equipment);								//Alters equipment file's IN/OUT + holder studentID
					PrintLog.updateLog(false, equipment);								//Prints equipment checkout to log
					ProjectUtilities.handleSceneSwitch(btnCheckOut, "/chappelle/five/view/CheckOutSuccess.fxml");
				}
			}
			else {
				lblIncorrectBarcodeError.setVisible(true);
			}
			break;
		default:
			break;
		}
	}


	//Scene Switch Method
	@FXML
	public void handleBack() throws IOException {
		ProjectUtilities.handleSceneSwitch(btnBackButton, "/chappelle/five/view/ItemCheckOut.fxml");
	}



	//Helper Methods
	//Checks if barcode input correct
	/**
	 * @param barcodeInput - Textfield to check
	 * @param cartIndex - which item in list of items returning to compare barcode
	 * @param checkMark - image to display
	 */
	public boolean checkCorrectBarcode(TextField barcodeInput, int cartIndex, ImageView checkMark) {
		if (barcodeInput.getText().equals(equipmentCheckingOut.get(cartIndex).getEquipmentID()) && !(barcodeInput.getText().equals(null))) {
			checkMark.setVisible(true);
			return true;
		}
		else {
			return false;
		}
	}
}