package tan.five.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;


public class PrintToFile {

	/**
	 * The CSV file of the log to print equipment movements to.
	 */
	private static File log = new File("Resources/Log.csv");
	/**
	 * The CSV file of the list of equipment to load equipment from.
	 */
	private static File equipmentList = new File("Resources/EquipmentList.csv");
	/**
	 * A switch for updating the equipment CSV file for checkouts vs check-ins.
	 */
	private static int checkInOrOut = 0;					//For switch: 1 indicates check out, 2 indicates check in




	/**
	 * Writes in the log the date and time of the equipment transaction, whether the equipment is being checked in or out,
	 * the name of the student making the transaction, the ID of the student, and the name of the equipment that
	 * is affected.
	 * @param checkIn - whether the item is being checked in.
	 * @param equipment - the equipment that is being checked in or out.
	 * @throws FileNotFoundException
	 */
	public static void updateLog(Boolean checkIn, Equipment equipment) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new FileOutputStream(log, true));
		StringBuilder sb = new StringBuilder();

		sb.append(LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy MM dd HH mm ss")),		//Date + Time
				DateTimeFormatter.ofPattern("yyyy MM dd HH mm ss"))); 										
		sb.append(',');

		if(checkIn) {																										//In / Out
			sb.append("IN");
		}
		else {
			sb.append("OUT");
		}

		sb.append(',');
		sb.append(Student.SELECTED_STUDENT.getFirstName() + " " + Student.SELECTED_STUDENT.getLastName());					//Student Name
		sb.append(',');
		sb.append(Student.SELECTED_STUDENT.getStudentID());																	//Student ID
		sb.append(',');
		sb.append(equipment.getEquipmentName());																			//Equipment Name
		sb.append('\n');

		pw.write(sb.toString());
		pw.close();

	}


	/**
	 * Edits the equipment CSV file when a piece of equipment is checked in or out depending
	 * on its updated status.
	 * @param equipmentCheckingInOut - the piece of equipment being checked in or out.
	 * @throws IOException
	 */
	public static void alterEquipmentFile(Equipment equipmentCheckingInOut) throws IOException {
		CSVReader reader = new CSVReader(new FileReader(equipmentList));					//Reads existing file
		List<String[]> csvBody = reader.readAll();

		switch (checkInOrOut) {
		case 1: //Check Out
			for (int i = 0; i < csvBody.size(); i++) {
				if (csvBody.get(i)[0].equals(equipmentCheckingInOut.getEquipmentName())) {
					csvBody.get(i)[3] = "OUT";
					csvBody.get(i)[4] = Student.SELECTED_STUDENT.getStudentID();
				}
			}
			break;
		case 2: //Check In
			for (int i = 0; i < csvBody.size(); i++) {
				if (csvBody.get(i)[0].equals(equipmentCheckingInOut.getEquipmentName())) {
					csvBody.get(i)[3] = "IN";
					csvBody.get(i)[4] = "";
				}
			}
			break;
		default:
			break;
		}
		reader.close();
		checkInOrOut = 0;																	//Resets alterEquipmentFile to be set to Check In/Out version

		CSVWriter writer = new CSVWriter(new FileWriter(equipmentList),  					//Writes to open CSV file
				CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER);	
		writer.writeAll(csvBody);
		writer.flush();
		writer.close();
	}




	//Getters + Setters
	/**
	 * Gets the switch for updating the equipment CSV file for checkouts vs check-ins.
	 * @return the switch for updating the equipment CSV file for checkouts vs check-ins.
	 */
	public static int getCheckInOrOut() {
		return checkInOrOut;
	}
	/**
	 * Sets the switch for updating the equipment CSV file for checkouts vs check-ins.
	 * @param checkInOrOut - "1" if the equipment is being checked out, "2" if it is being checked in.
	 */
	public static void setCheckInOrOut(int checkInOrOut) {
		PrintToFile.checkInOrOut = checkInOrOut;
	}
}