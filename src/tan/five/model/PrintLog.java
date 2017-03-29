package tan.five.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class PrintLog {

	private static File log = new File("test.csv");

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


	public static void updateLog(StringBuilder sb) {
		sb.append(LocalDateTime.now());
		sb.append(',');
		//IF(CHECKING IN / CHECKING OUT)//
		sb.append(Student.SELECTED_STUDENT);
		sb.append(',');
		//PRINT EQUIPMENT HERE//
		sb.append(',');

	}
}
