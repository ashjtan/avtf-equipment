package chappelle.five.view;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import tan.five.model.Equipment;
import tan.five.model.PrintToFile;
import chapman.five.model.ProjectUtilities;

public class CheckInFinalController {

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
	 * Sets to the name of the first item being checked in.
	 * Bound to the first item label in the .fxml file.
	 */
	@FXML
	private Label lblItem1;
	/**
	 * Sets to the name of the second item being checked in.
	 * Bound to the second item label in the .fxml file.
	 */
	@FXML
	private Label lblItem2;
	/**
	 * Sets to the name of the third item being checked in.
	 * Bound to the third item label in the .fxml file.
	 */
	@FXML
	private Label lblItem3;
	/**
	 * Sets to the name of the fourth item being checked in.
	 * Bound to the fourth item label in the .fxml file.
	 */
	@FXML
	private Label lblItem4;	
	/**
	 * Sets to the name of the fifth item being checked in.
	 * Bound to the fifth item label in the .fxml file.
	 */
	@FXML
	private Label lblItem5;
	/**
	 * Sets to the name of the sixth item being checked in.
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
	 * Reads the user's barcode input for the second item being checked in.
	 * Bound to the second user input text field in the .fxml file.
	 */
	@FXML
	private TextField txtInput2;
	/**
	 * Reads the user's barcode input for the third item being checked in.
	 * Bound to the third user input text field in the .fxml file.
	 */
	@FXML
	private TextField txtInput3;
	/**
	 * Reads the user's barcode input for the fourth item being checked in.
	 * Bound to the fourth user input text field in the .fxml file.
	 */
	@FXML
	private TextField txtInput4;
	/**
	 * Reads the user's barcode input for the fifth item being checked in.
	 * Bound to the fifth user input text field in the .fxml file.
	 */
	@FXML
	private TextField txtInput5;
	/**
	 * Reads the user's barcode input for the sixth item being checked in.
	 * Bound to the sixth user input text field in the .fxml file.
	 */
	@FXML
	private TextField txtInput6;


	/**
	 * Switches back to ItemCheckIn scene and cancels item check-in.
	 * Bound to the back button in the .fxml file.
	 */
	@FXML
	private Button btnBackButton;
	/**
	 * Checks in items.
	 * Bound to the check-in button in the .fxml file.
	 */
	@FXML
	private Button btnCheckIn;


	/**
	 * Displayed if barcode inputs are incorrect.
	 * Bound to the incorrect barcode error in the .fxml file.
	 */
	@FXML
	private Label lblIncorrectBarcodeError;		


	/**
	 * The ItemCheckIn's right-side viewable list of items selected to return, bound to JavaFX.
	 */
	@FXML
	private ListView<String> equipmentReturn;	
	/**
	 * List of the equipment selected from equipment currently in possession to return.
	 */
	ArrayList<Equipment> equipmentCheckingIn = ItemCheckInController.getEquipmentToCheckIn();	


	/**
	 * List of Labels for items being checked in.
	 */
	List<Label> labels = new ArrayList<Label>();
	/**
	 * List of TextFields for barcodes of items being checked in.
	 */
	List<TextField> textFields = new ArrayList<TextField>();
	/**
	 * List of check mark Images to be displayed when checking barcodes.
	 */
	List<ImageView> checkMarks = new ArrayList<ImageView>();




	/**
	 * Generates Labels and TextFields depending on the number of items being checked back in.
	 * Sets the Label text to the equipment name.
	 */
	@FXML
	private void initialize() {
		labels.addAll(Arrays.asList(new Label[]{lblItem1, lblItem2, lblItem3, lblItem4, lblItem5, lblItem6}));
		textFields.addAll(Arrays.asList(new TextField[]{txtInput1, txtInput2, txtInput3, txtInput4, txtInput5, txtInput6}));
		checkMarks.addAll(Arrays.asList(new ImageView[]{imgCheckMark1, imgCheckMark2, imgCheckMark3, imgCheckMark4, imgCheckMark5, imgCheckMark6}));

		for(int i = 0; i < equipmentCheckingIn.size(); i++) {
			labels.get(i).setVisible(true);
			labels.get(i).setText(equipmentCheckingIn.get(i).getEquipmentName());
			textFields.get(i).setVisible(true);
		}
	}




	//Event Handlers
	/**
	 * When the check-in button is clicked, if the barcode inputs are correct, 
	 * edits the equipment file, updates the log, and switches scenes to the
	 * CheckInSuccess screen.
	 * @throws IOException
	 */
	@FXML
	public void handleCheckIn() throws IOException {
		if (checkAllBarcodes()) {
			for (int i = 0; i < equipmentCheckingIn.size(); i++) {
				PrintToFile.setCheckInOrOut(2);										//Switches alterEquipmentFile to Check In version
				equipmentCheckingIn.get(i).setCheckedOut(false);					//Sets equipment's checkedOut boolean to false
				PrintToFile.alterEquipmentFile(equipmentCheckingIn.get(i));			//Alters equipment file's IN/OUT + holder studentID
				PrintToFile.updateLog(true, equipmentCheckingIn.get(i));		
			}
			ProjectUtilities.handleSceneSwitch(btnCheckIn, "/chappelle/five/view/CheckInSuccess.fxml");
		}
		else {
			lblIncorrectBarcodeError.setVisible(true);
		}
	}


	/**
	 * Switches scenes back to the ItemCheckIn and cancels item check-in.
	 * @throws IOException
	 */
	@FXML
	public void handleBack() throws IOException {
		ProjectUtilities.handleSceneSwitch(btnBackButton, "/chappelle/five/view/ItemCheckIn.fxml");
	}




	//Helper Methods
	/**
	 * Checks the user input for the correct equipment barcode.
	 * @param cartIndex - which item in list of items returning to compare barcode.
	 */
	public boolean checkCorrectBarcode(int cartIndex) {
		if (textFields.get(cartIndex).getText().equals(equipmentCheckingIn.get(cartIndex).getEquipmentID()) && !(textFields.get(cartIndex).getText().equals(null))) {
			textFields.get(cartIndex).setEditable(false);
			ProjectUtilities.handleUpdateImage(checkMarks.get(cartIndex));
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Checks all user inputs for correct equipment barcodes.
	 * @return whether or not all barcodes are correct.
	 */
	public boolean checkAllBarcodes() {
		boolean allBarcodesCorrect = true;
		for (int i = 0; i < equipmentCheckingIn.size(); i++) {
			if (!checkCorrectBarcode(i)) {
				allBarcodesCorrect = false;
			}
		}
		return allBarcodesCorrect;
	}
}