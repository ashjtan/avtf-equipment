package tan.five.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {

	public static void updateCSV(String[] arrayToWrite) throws IOException {
		FileWriter fw = new FileWriter("Sample Equipment.csv");
		BufferedWriter bw = new BufferedWriter(fw);

		String writableString = "";

		for(String item : arrayToWrite){											//adds strings to write to CSV file
			writableString += item + ",";
		};

		writableString = writableString.substring(0, writableString.length() - 1);

		bw.write(writableString);


	}
}