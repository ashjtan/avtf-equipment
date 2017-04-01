package chappelle.five.view;

import java.io.IOException;

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

import chappelle.five.view.ItemCheckOutController;
import chapman.five.model.ProjectUtilities;

public class CheckOutFinalController {

	//Fields
	/**
	 * Bound to the first check mark picture in the .fxml file.
	 */
	@FXML
	private ImageView imgCheckMark1;
	/**
	 * Bound to the second check mark picture in the .fxml file.
	 */
	@FXML
	private ImageView imgCheckMark2;
	/**
	 * Bound to the third check mark picture in the .fxml file.
	 */
	@FXML
	private ImageView imgCheckMark3;
	/**
	 * Bound to the fourth check mark picture in the .fxml file.
	 */
	@FXML
	private ImageView imgCheckMark4;
	/**
	 * Bound to the fifth check mark picture in the .fxml file.
	 */
	@FXML
	private ImageView imgCheckMark5;
	/**
	 * Bound to the sixth check mark picture in the .fxml file.
	 */
	@FXML
	private ImageView imgCheckMark6;
	/**
	 * Sets the check mark variable to the resource.
	 */
	Image checkMark = new Image("file:resources/checkmark.png");


	/**
	 * Sets to the name of the first item being checked out.
	 * Bound to the first item label in the .fxml file.
	 */
	@FXML
	private Label lblItem1;
	/**
	 * Sets to the name of the second item being checked out.
	 * Bound to the second item label in the .fxml file.
	 */
	@FXML
	private Label lblItem2;
	/**
	 * Sets to the name of the third item being checked out.
	 * Bound to the third item label in the .fxml file.
	 */
	@FXML
	private Label lblItem3;
	/**
	 * Sets to the name of the fourth item being checked out.
	 * Bound to the fourth item label in the .fxml file.
	 */
	@FXML
	private Label lblItem4;
	/**
	 * Sets to the name of the fifth item being checked out.
	 * Bound to the fifth item label in the .fxml file.
	 */
	@FXML
	private Label lblItem5;
	/**
	 * Sets to the name of the sixth item being checked out.
	 * Bound to the sixth item label in the .fxml file.
	 */
	@FXML
	private Label lblItem6;


	/**
	 * Reads the user's barcode input for the first item being checked in.
	 * Bound to the first user input text field in the .fxml file.
	 */
	@FXML
	private TextField txtInput1;
	/**
	 * Reads the user's barcode input for the second item being checked out.
	 * Bound to the second user input text field in the .fxml file.
	 */
	@FXML
	private TextField txtInput2;
	/**
	 * Reads the user's barcode input for the third item being checked out.
	 * Bound to the third user input text field in the .fxml file.
	 */
	@FXML
	private TextField txtInput3;
	/**
	 * Reads the user's barcode input for the fourth item being checked out.
	 * Bound to the fourth user input text field in the .fxml file.
	 */
	@FXML
	private TextField txtInput4;
	/**
	 * Reads the user's barcode input for the fifth item being checked out.
	 * Bound to the fifth user input text field in the .fxml file.
	 */
	@FXML
	private TextField txtInput5;
	/**
	 * Reads the user's barcode input for the sixth item being checked out.
	 * Bound to the sixth user input text field in the .fxml file.
	 */
	@FXML
	private TextField txtInput6;


	/**
	 * Switches back to ItemCheckOut scene and cancels item checkout.
	 * Bound to the back button in the .fxml file.
	 */
	@FXML
	private Button btnBackButton;

	/**
	 * Checks out items.
	 * Bound to the checkout button in the .fxml file.
	 */
	@FXML
	private Button btnCheckOut;


	/**
	 * Displayed if barcode inputs are incorrect.
	 * Bound to the incorrect barcode error in the .fxml file.
	 */
	@FXML
	private Label lblIncorrectBarcodeError;	


	/**
	 * The ItemCheckOut's right-side viewable list of items selected to check out, bound to JavaFX.
	 */
	@FXML
	private ListView<String> equipmentCart;	
	/**
	 * List of the equipment selected from available equipment to check out.
	 */
	ArrayList<Equipment> equipmentCheckingOut = ItemCheckOutController.getEquipmentToCheckOut();	



	/**
	 * Generates Labels and TextFields depending on the number of items being checked out.
	 * Sets the Label text to the equipment name.
	 */
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
	/**
	 * When the check out button is clicked, if the barcode inputs are correct, 
	 * edits the equipment file, updates the log, and switches scenes to the
	 * CheckOutSuccess screen.
	 * @throws IOException
	 */
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
				}
				ProjectUtilities.handleSceneSwitch(btnCheckOut, "/chappelle/five/view/CheckOutSuccess.fxml");
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
				}
				ProjectUtilities.handleSceneSwitch(btnCheckOut, "/chappelle/five/view/CheckOutSuccess.fxml");
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
				}
				ProjectUtilities.handleSceneSwitch(btnCheckOut, "/chappelle/five/view/CheckOutSuccess.fxml");
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
				}
				ProjectUtilities.handleSceneSwitch(btnCheckOut, "/chappelle/five/view/CheckOutSuccess.fxml");
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
				}
				ProjectUtilities.handleSceneSwitch(btnCheckOut, "/chappelle/five/view/CheckOutSuccess.fxml");

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
				}
				ProjectUtilities.handleSceneSwitch(btnCheckOut, "/chappelle/five/view/CheckOutSuccess.fxml");
			}
			else {
				lblIncorrectBarcodeError.setVisible(true);
			}
			break;
		default:
			break;
		}
	}

	/**
	 * Switches scenes back to the ItemCheckOut and cancels item checkout.
	 * @throws IOException
	 */
	@FXML
	public void handleBack() throws IOException {
		ProjectUtilities.handleSceneSwitch(btnBackButton, "/chappelle/five/view/ItemCheckOut.fxml");
	}




	//Helper Methods
	/**
	 * @param barcodeInput - Textfield to check for correct barcode input.
	 * @param cartIndex - which item in list of items returning to compare barcode.
	 * @param checkMark - image to display when barcode is correct.
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