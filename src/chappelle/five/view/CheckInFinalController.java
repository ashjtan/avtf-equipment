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

	@FXML
	private Button btnBackButton;
	@FXML
	private Button btnCheckOut;

	@FXML
	private Label lblIncorrectBarcodeError;

	ArrayList<Equipment> equipmentCheckingIn = ItemCheckInController.getEquipmentToCheckIn();


	//Add the equipment name to the label
	@FXML
	private void initialize() {
		switch (equipmentCheckingIn.size()) {
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

	@FXML
	public void handleCheckIn() throws IOException {
		switch (equipmentCheckingIn.size()) {
		case 1:
			if (checkCorrectBarcode(txtInput1, 0, imgCheckMark1)) {
				for (Equipment equipment : equipmentCheckingIn) {
					PrintLog.setCheckInOrOut(2);										//Switches alterEquipmentFile to Check In version
					equipment.setCheckedOut(false);										//Sets equipment's checkedOut boolean to false
					PrintLog.alterEquipmentFile(equipment);								//Alters equipment file's IN/OUT + holder studentID
					PrintLog.updateLog(true, equipment);								//Prints equipment checkin to log
					ProjectUtilities.handleSceneSwitch(btnCheckOut, "/chappelle/five/view/CheckInSuccess.fxml");
				}
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
					ProjectUtilities.handleSceneSwitch(btnCheckOut, "/chappelle/five/view/CheckInSuccess.fxml");
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
				for (Equipment equipment : equipmentCheckingIn) {
					PrintLog.setCheckInOrOut(2);										//Switches alterEquipmentFile to Check In version
					equipment.setCheckedOut(false);										//Sets equipment's checkedOut boolean to false
					PrintLog.alterEquipmentFile(equipment);								//Alters equipment file's IN/OUT + holder studentID
					PrintLog.updateLog(true, equipment);								//Prints equipment checkin to log
					ProjectUtilities.handleSceneSwitch(btnCheckOut, "/chappelle/five/view/CheckInSuccess.fxml");
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
					checkCorrectBarcode(txtInput4, 3, imgCheckMark4)){
				for (Equipment equipment : equipmentCheckingIn) {
					PrintLog.setCheckInOrOut(2);										//Switches alterEquipmentFile to Check In version
					equipment.setCheckedOut(false);										//Sets equipment's checkedOut boolean to false
					PrintLog.alterEquipmentFile(equipment);								//Alters equipment file's IN/OUT + holder studentID
					PrintLog.updateLog(true, equipment);								//Prints equipment checkin to log
					ProjectUtilities.handleSceneSwitch(btnCheckOut, "/chappelle/five/view/CheckInSuccess.fxml");

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
				for (Equipment equipment : equipmentCheckingIn) {
					PrintLog.setCheckInOrOut(2);										//Switches alterEquipmentFile to Check In version
					equipment.setCheckedOut(false);										//Sets equipment's checkedOut boolean to false
					PrintLog.alterEquipmentFile(equipment);								//Alters equipment file's IN/OUT + holder studentID
					PrintLog.updateLog(true, equipment);								//Prints equipment checkin to log
					ProjectUtilities.handleSceneSwitch(btnCheckOut, "/chappelle/five/view/CheckInSuccess.fxml");
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
				for (Equipment equipment : equipmentCheckingIn) {
					PrintLog.setCheckInOrOut(2);										//Switches alterEquipmentFile to Check In version
					equipment.setCheckedOut(false);										//Sets equipment's checkedOut boolean to false
					PrintLog.alterEquipmentFile(equipment);								//Alters equipment file's IN/OUT + holder studentID
					PrintLog.updateLog(true, equipment);								//Prints equipment checkin to log
					ProjectUtilities.handleSceneSwitch(btnCheckOut, "/chappelle/five/view/CheckInSuccess.fxml");
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

	@FXML
	public void handleBack() throws IOException {
		ProjectUtilities.handleSceneSwitch(btnBackButton, "/chappelle/five/view/ItemCheckOut.fxml");
	}

	public boolean checkCorrectBarcode(TextField barcodeInput, int cartIndex, ImageView checkMark) {
		if (barcodeInput.getText().equals(equipmentCheckingIn.get(cartIndex).getEquipmentID()) && !(barcodeInput.getText().equals(null))) {
			checkMark.setVisible(true);
			return true;
		}
		else {
			return false;
		}
	}
}