package tan.five.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class PrintLog {

	private static File log = new File("log.csv");

	public static void main(String[] args) throws FileNotFoundException {

		PrintWriter pw = new PrintWriter(new FileOutputStream(log, true));
		StringBuilder sb = new StringBuilder();
		sb.append("id");
		sb.append(',');
		sb.append("Name");
		sb.append('\n');

		sb.append("1");
		sb.append(',');
		sb.append("Prashant Ghimire");
		sb.append('\n');

		pw.write(sb.toString());
		pw.close();
		System.out.println("done!");
	}


	public static void updateLog(Boolean checkIn) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new FileOutputStream(log, true));
		StringBuilder sb = new StringBuilder();
		sb.append(LocalDateTime.now()); 			//Date + Time
		sb.append(',');

		if(checkIn) {								//In / Out
			sb.append("IN");
		}
		else {
			sb.append("OUT");
		}

		sb.append(',');
		sb.append(Student.SELECTED_STUDENT.getFirstName() + " " + Student.SELECTED_STUDENT.getLastName());		//Student Name
		sb.append(',');
		sb.append(Student.SELECTED_STUDENT.getStudentID());			//Student ID
		sb.append(',');
		//PRINT EQUIPMENT HERE//									//Equipment Name
		sb.append('\n');

	}
}
