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
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;


public class PrintLog {

	private static File log = new File("log.csv");
	private static File equipmentList = new File("Resources/Sample Equipment.csv");
	private static int checkInOrOut = 0;					//For switch: 1 indicates check out, 2 indicates check in



	//Updates Log + writes to CSV
	/**
	 * @param checkIn - switch depending on if item checked in or out
	 * @param equipment - equipment checked in/out
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

	//Edits CSV file when equipment checked in/out
	public static void alterEquipmentFile(Equipment equipmentCheckingInOut) throws IOException {
		//Reads existing file
		CSVReader reader = new CSVReader(new FileReader(equipmentList));
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
		checkInOrOut = 0;										//Resets alterEquipmentFile to be set to Check In/Out version

		//Writes to open CSV file
		CSVWriter writer = new CSVWriter(new FileWriter(equipmentList),  CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER);
		writer.writeAll(csvBody);
		writer.flush();
		writer.close();
	}




	//Getters + Setters
	public static int getCheckInOrOut() {
		return checkInOrOut;
	}

	public static void setCheckInOrOut(int checkInOrOut) {
		PrintLog.checkInOrOut = checkInOrOut;
	}
}