package tan.five.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class PrintLog {

	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File("test.csv"));
		StringBuilder sb = new StringBuilder();
		sb.append("DATE / TIME");
		sb.append(',');
		sb.append("CHECK IN / OUT");
		sb.append(',');
		sb.append("STUDENT");
		sb.append(',');
		sb.append("EQUIPMENT");
		sb.append('\n');



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
