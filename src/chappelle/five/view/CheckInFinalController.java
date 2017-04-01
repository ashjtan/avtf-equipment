package chappelle.five.view;

import java.io.IOException;
import java.util.ArrayList;

import chapman.five.model.ProjectUtilities;
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

public class CheckInFinalController {

	//Fields
	//Displayed by correct user barcode inputs
	/**
	 * Link to check mark picture in the .fxml file
	 * 
	 */
	@FXML
	private ImageView imgCheckMark1;
	/**
	 * Link to check mark picture in the .fxml file
	 */
	@FXML
	private ImageView imgCheckMark2;
	/**
	 * Link to check mark picture in the .fxml file
	 */
	@FXML
	private ImageView imgCheckMark3;
	/**
	 * Link to check mark picture in the .fxml file
	 */
	@FXML
	private ImageView imgCheckMark4;
	/**
	 * Link to check mark picture in the .fxml file
	 */
	@FXML
	private ImageView imgCheckMark5;
	/**
	 * Link to check mark picture in the .fxml file
	 */
	@FXML
	private ImageView imgCheckMark6;
	/**
	 * Sets the check mark variable to the resource 
	 */
	Image checkMark = new Image("file:resources/checkmark.png");

	//Set to names of items being checked in
	/**
	 * Link to item label in the .fxml file
	 */
	@FXML
	private Label lblItem1;
	/**
	 * Link to item label in the .fxml file
	 */
	@FXML
	private Label lblItem2;
	/**
	 * Link to item label in the .fxml file
	 */
	@FXML
	private Label lblItem3;
	/**
	 * Link to item label in the .fxml file
	 */
	@FXML
	private Label lblItem4;	
	/**
	 * Link to item label in the .fxml file
	 */
	@FXML
	private Label lblItem5;
	/**
	 * Link to item label in the .fxml file
	 */
	@FXML
	private Label lblItem6;

	//Read user barcode inputs
	/**
	 * Link to user input text field in the .fxml file
	 */
	@FXML
	private TextField txtInput1;
	/**
	 * Link to user input text field in the .fxml file
	 */
	@FXML
	private TextField txtInput2;
	/**
	 * Link to user input text field in the .fxml file
	 */
	@FXML
	private TextField txtInput3;
	/**
	 * Link to user input text field in the .fxml file
	 */
	@FXML
	private TextField txtInput4;
	/**
	 * Link to user input text field in the .fxml file
	 */
	@FXML
	private TextField txtInput5;
	/**
	 * Link to user input text field in the .fxml file
	 */
	@FXML
	private TextField txtInput6;

	//Switch scenes
	/**
	 * Link to back button in the .fxml file
	 */
	@FXML
	private Button btnBackButton;
	/**
	 * Link to check in button in the .fxml file
	 */
	@FXML
	private Button btnCheckIn;
	/**
	 * Link to incorrect barcode error in the .fxml file
	 */
	@FXML
	private Label lblIncorrectBarcodeError;		//Error displayed if barcode inputs incorrect
	/**
	 * ItemCheckIn's right-side viewable list of items selected to return
	 */
	@FXML
	private ListView<String> equipmentReturn;	//ItemCheckIn's right-side viewable list of items selected to return
	/**
	 * Equipment selected from list to return
	 */
	ArrayList<Equipment> equipmentCheckingIn = ItemCheckInController.getEquipmentToCheckIn();	//Equipment selected from list to return




	//Adds equipment name to Label + sets TextField/Label to visible
	/**
	 * 	Adds equipment name to Label + sets TextField/Label to visible
	 */
	@FXML
	private void initialize() {
		/**
		 * Generates depending on number of items returning
		 */
		switch (equipmentCheckingIn.size()) {		//Generates depending on number of items returning
		case 1:
			lblItem1.setVisible(true);
			lblItem1.setText(equipmentCheckingIn.get(0).getEquipmentName());
			txtInput1.setVisible(true);
			break;
		case 2:
			lblItem1.setVisible(true);
			lblItem1.setText(equipmentCheckingIn.get(0).getEquipmentName());
			txtInput1.setVisible(true);

			lblItem2.setVisible(true);
			lblItem2.setText(equipmentCheckingIn.get(1).getEquipmentName());
			txtInput2.setVisible(true);
			break;
		case 3:
			lblItem1.setVisible(true);
			lblItem1.setText(equipmentCheckingIn.get(0).getEquipmentName());
			txtInput1.setVisible(true);

			lblItem2.setVisible(true);
			lblItem2.setText(equipmentCheckingIn.get(1).getEquipmentName());
			txtInput2.setVisible(true);

			lblItem3.setVisible(true);
			lblItem3.setText(equipmentCheckingIn.get(2).getEquipmentName());
			txtInput3.setVisible(true);
			break;
		case 4:
			lblItem1.setVisible(true);
			lblItem1.setText(equipmentCheckingIn.get(0).getEquipmentName());
			txtInput1.setVisible(true);

			lblItem2.setVisible(true);
			lblItem2.setText(equipmentCheckingIn.get(1).getEquipmentName());
			txtInput2.setVisible(true);

			lblItem3.setVisible(true);
			lblItem3.setText(equipmentCheckingIn.get(2).getEquipmentName());
			txtInput3.setVisible(true);

			lblItem4.setVisible(true);
			lblItem4.setText(equipmentCheckingIn.get(3).getEquipmentName());
			txtInput4.setVisible(true);
			break;
		case 5:
			lblItem1.setVisible(true);
			lblItem1.setText(equipmentCheckingIn.get(0).getEquipmentName());
			txtInput1.setVisible(true);

			lblItem2.setVisible(true);
			lblItem2.setText(equipmentCheckingIn.get(1).getEquipmentName());
			txtInput2.setVisible(true);

			lblItem3.setVisible(true);
			lblItem3.setText(equipmentCheckingIn.get(2).getEquipmentName());
			txtInput3.setVisible(true);

			lblItem4.setVisible(true);
			lblItem4.setText(equipmentCheckingIn.get(3).getEquipmentName());
			txtInput4.setVisible(true);

			lblItem5.setVisible(true);
			lblItem5.setText(equipmentCheckingIn.get(4).getEquipmentName());
			txtInput5.setVisible(true);
			break;
		case 6:
			lblItem1.setVisible(true);
			lblItem1.setText(equipmentCheckingIn.get(0).getEquipmentName());
			txtInput1.setVisible(true);

			lblItem2.setVisible(true);
			lblItem2.setText(equipmentCheckingIn.get(1).getEquipmentName());
			txtInput2.setVisible(true);

			lblItem3.setVisible(true);
			lblItem3.setText(equipmentCheckingIn.get(2).getEquipmentName());
			txtInput3.setVisible(true);

			lblItem4.setVisible(true);
			lblItem4.setText(equipmentCheckingIn.get(3).getEquipmentName());
			txtInput4.setVisible(true);

			lblItem5.setVisible(true);
			lblItem5.setText(equipmentCheckingIn.get(4).getEquipmentName());
			txtInput5.setVisible(true);

			lblItem6.setVisible(true);
			lblItem6.setText(equipmentCheckingIn.get(5).getEquipmentName());
			txtInput6.setVisible(true);
			break;
		default:
			break;
		}
	}



	//Event Handlers
	
	//Checks for correct barcode + switches to Success screen + edits equipment file
	/**
	 * Checks for correct barcode + switches to Success screen + edits equipment file
	 * @throws IOException
	 * Switches alterEquipmentFile to Check In version
	 * Sets equipment's checkedOut boolean to false
	 * Alters equipment file's IN/OUT + holder studentID
	 * Prints equipment checkin to log
	 */
	@FXML
	public void handleCheckIn() throws IOException {
		switch (equipmentCheckingIn.size()) {		//Checks depending on number of items returning
		case 1:
			if (checkCorrectBarcode(txtInput1, 0, imgCheckMark1)) {
				for (Equipment equipment : equipmentCheckingIn) {
					PrintLog.setCheckInOrOut(2);										//Switches alterEquipmentFile to Check In version
					equipment.setCheckedOut(false);										//Sets equipment's checkedOut boolean to false
					PrintLog.alterEquipmentFile(equipment);								//Alters equipment file's IN/OUT + holder studentID
					PrintLog.updateLog(true, equipment);								//Prints equipment checkin to log
				}
				ProjectUtilities.handleSceneSwitch(btnCheckIn, "/chappelle/five/view/CheckInSuccess.fxml");
			}
			else {
				lblIncorrectBarcodeError.setVisible(true);
			}
			break;

		case 2:
			if (checkCorrectBarcode(txtInput1, 0, imgCheckMark1) &&
					checkCorrectBarcode(txtInput2, 1, imgCheckMark2)) {
				for (Equipment equipment : equipmentCheckingIn) {
					PrintLog.setCheckInOrOut(2);										//Switches alterEquipmentFile to Check In version
					equipment.setCheckedOut(false);										//Sets equipment's checkedOut boolean to false
					PrintLog.alterEquipmentFile(equipment);								//Alters equipment file's IN/OUT + holder studentID
					PrintLog.updateLog(true, equipment);								//Prints equipment checkin to log
				}
				ProjectUtilities.handleSceneSwitch(btnCheckIn, "/chappelle/five/view/CheckInSuccess.fxml");
			}
			else {
				lblIncorrectBarcodeError.setVisible(true);
			}
			break;
		case 3:
			if (checkCorrectBarcode(txtInput1, 0, imgCheckMark1) &&
					checkCorrectBarcode(txtInput2, 1, imgCheckMark2) &&
					checkCorrectBarcode(txtInput3, 2, imgCheckMark3)) {
				for (Equipment equipment : equipmentCheckingIn) {
					PrintLog.setCheckInOrOut(2);										//Switches alterEquipmentFile to Check In version
					equipment.setCheckedOut(false);										//Sets equipment's checkedOut boolean to false
					PrintLog.alterEquipmentFile(equipment);								//Alters equipment file's IN/OUT + holder studentID
					PrintLog.updateLog(true, equipment);								//Prints equipment checkin to log
				}
				ProjectUtilities.handleSceneSwitch(btnCheckIn, "/chappelle/five/view/CheckInSuccess.fxml");
			}
			else {
				lblIncorrectBarcodeError.setVisible(true);
			}
			break;
		case 4:
			if (checkCorrectBarcode(txtInput1, 0, imgCheckMark1) &&
					checkCorrectBarcode(txtInput2, 1, imgCheckMark2) &&
					checkCorrectBarcode(txtInput3, 2, imgCheckMark3) &&
					checkCorrectBarcode(txtInput4, 3, imgCheckMark4)){
				for (Equipment equipment : equipmentCheckingIn) {
					PrintLog.setCheckInOrOut(2);										//Switches alterEquipmentFile to Check In version
					equipment.setCheckedOut(false);										//Sets equipment's checkedOut boolean to false
					PrintLog.alterEquipmentFile(equipment);								//Alters equipment file's IN/OUT + holder studentID
					PrintLog.updateLog(true, equipment);								//Prints equipment checkin to log
				}
				ProjectUtilities.handleSceneSwitch(btnCheckIn, "/chappelle/five/view/CheckInSuccess.fxml");
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
				for (Equipment equipment : equipmentCheckingIn) {
					PrintLog.setCheckInOrOut(2);										//Switches alterEquipmentFile to Check In version
					equipment.setCheckedOut(false);										//Sets equipment's checkedOut boolean to false
					PrintLog.alterEquipmentFile(equipment);								//Alters equipment file's IN/OUT + holder studentID
					PrintLog.updateLog(true, equipment);								//Prints equipment checkin to log
				}
				ProjectUtilities.handleSceneSwitch(btnCheckIn, "/chappelle/five/view/CheckInSuccess.fxml");
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
				for (Equipment equipment : equipmentCheckingIn) {
					PrintLog.setCheckInOrOut(2);										//Switches alterEquipmentFile to Check In version
					equipment.setCheckedOut(false);										//Sets equipment's checkedOut boolean to false
					PrintLog.alterEquipmentFile(equipment);								//Alters equipment file's IN/OUT + holder studentID
					PrintLog.updateLog(true, equipment);								//Prints equipment checkin to log
				}
				ProjectUtilities.handleSceneSwitch(btnCheckIn, "/chappelle/five/view/CheckInSuccess.fxml");
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
	/**
	 * Loads ItemCheckIn
	 * @throws IOException
	 */
	@FXML
	public void handleBack() throws IOException {
		ProjectUtilities.handleSceneSwitch(btnBackButton, "/chappelle/five/view/ItemCheckIn.fxml");
	}




	//Helper Methods
	//Checks if barcode input correct
	/**
	 * Checks if barcode input correct
	 */
	public boolean checkCorrectBarcode(TextField barcodeInput, int listIndex, ImageView checkMark) {
		if (barcodeInput.getText().equals(equipmentCheckingIn.get(listIndex).getEquipmentID()) && !(barcodeInput.getText().equals(null))) {
			checkMark.setVisible(true);
			return true;
		}
		else {
			return false;
		}
	}
}