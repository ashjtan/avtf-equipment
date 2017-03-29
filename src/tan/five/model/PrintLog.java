package tan.five.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrintLog {

	private static File log = new File("log.csv");

	public static void main(String[] args) throws FileNotFoundException {
		
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
}
