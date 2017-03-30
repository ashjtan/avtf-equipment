package chappelle.five.view;

import java.io.IOException;

import javafx.fxml.FXML;
import tan.five.model.Equipment;
import tan.five.model.PrintLog;
import tan.five.model.Student;

public class CheckInFinalController {

	
	@FXML
	public void handleCheckIn() throws IOException {
		for (Equipment equipment : equipmentCheckingIn) {
			PrintLog.setCheckInOrOut(2);
			equipment.setCheckedOut(false);										//Sets equipment's checkedOut boolean to true
			PrintLog.alterEquipmentFile(equipment);								//Alters equipment file's IN/OUT + holder studentID
			//FIX THIS!!!!//
			Student.SELECTED_STUDENT.getCheckedOutEquipment().add(equipment);	//Adds equipment to student's ArrayList of held equipment
			PrintLog.updateLog(false, equipment);								//Prints equipment checkout to log
			PrintLog.setCheckInOrOut(0);
		}
	}
}
