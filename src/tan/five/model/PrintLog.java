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
	private static int checkInOrOut = 0;					//1 indicates check out, 2 indicates check in

	public static void main(String[] args) throws IOException {

	}


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


	public static void alterEquipmentFile(Equipment equipmentCheckingOut) throws IOException {
		//Reads existing file
		CSVReader reader = new CSVReader(new FileReader(equipmentList));
		List<String[]> csvBody = reader.readAll();
		
		switch (checkInOrOut) {
		case 1: //Check Out
			for (int i = 0; i < csvBody.size(); i++) {
				if (csvBody.get(i)[0].equals(equipmentCheckingOut.getEquipmentName())) {
					csvBody.get(i)[3] = "OUT";
					csvBody.get(i)[4] = Student.SELECTED_STUDENT.getStudentID();
				}
			}
			break;

		case 2: //Check In
			for (int i = 0; i < csvBody.size(); i++) {
				if (csvBody.get(i)[0].equals(equipmentCheckingIn.getEquipmentName())) {
					csvBody.get(i)[3] = "IN";
					csvBody.get(i)[4] = "";
				}
			}
			break;
		default:
			break;
		}

			reader.close();

			//Writes to open file
			CSVWriter writer = new CSVWriter(new FileWriter(equipmentList));
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