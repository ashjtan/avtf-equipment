package tan.five.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

<<<<<<< HEAD
	public static void main(String[] args) throws IOException {
/*
		String csvFile = "/Users/ashleytan/Desktop/avtf files/AVTF_StudentList2017.csv";
=======
	public static void main(String[] args) {
		
		String csvFile = "/Users/chapmanchappelle/Desktop/AVTF_StudentList2017.csv";
		//String csvFile = "/Users/ashleytan/Desktop/avtf files/AVTF_StudentList2017.csv";
>>>>>>> refs/remotes/origin/master
		String line = "";
		String cvsSplitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {

				//Comma separator
				String[] student = line.split(cvsSplitBy);

				//Each column is array index
				//Prints last name, first name, student id
				
				System.out.println(String.format("%-35s %-25s %-20s", "Student [last=" + student[0], "first=" + student[1], "id=" + student[2] + "] "));

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		StudentEquipmentManagement.loadEquipmentFile();
	}
}