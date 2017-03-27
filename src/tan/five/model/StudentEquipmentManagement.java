package tan.five.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StudentEquipmentManagement {

///STUDENT///

	static ObservableList<Student> studentList; 
	static ArrayList<Student> stList = new ArrayList();

	//Student List Getter (ArrayList)
	public static ArrayList<Student> getStudentListA() {
		try {
			loadStudentFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stList;
	}

	//Student List Getter (ObservableList)
	public static ObservableList<Student> getStudentListO() {
		try {
			loadStudentFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return studentList;
	}


	//Student CSV File Loader
	public static void loadStudentFile() throws IOException {
		FileReader file = new FileReader("/Users/ashleytan/Desktop/avtf files/AVTF_StudentList2017.csv"); 	//"/Users/ashleytan/Desktop/avtf files/AVTF_StudentList2017.csv"
		BufferedReader reader = new BufferedReader(file);													//"/Users/chapmanchappelle/Desktop/AVTF_StudentList2017.csv"

		String line;
		while ((line = reader.readLine()) != null) {
			String[] studentInfo = line.split(",");					//Splits CSV into array by commas

			Student student = new Student();						//Creates new Student object

			student.setLastName(studentInfo[0]);					//Sets fields based on CSV file array
			student.setFirstName(studentInfo[1]);
			student.setStudentID(studentInfo[2]);

			stList.add(student);
		}
		studentList = FXCollections.observableArrayList(stList);
		reader.close();
	}


	

/// EQUIPMENT ///

	//Creates accessible ArrayList for equipment
	static ArrayList<Equipment> equipmentList = new ArrayList();

	//Equipment List Getter
	public ArrayList<Equipment> getEquipmentList() {
		try {
			loadEquipmentFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return equipmentList;
	}


	//Equipment CSV File Loader
	public static void loadEquipmentFile() throws IOException {
		FileReader file = new FileReader("Sample Equipment.csv");
		BufferedReader reader = new BufferedReader(file);
		String line;

		while ((line = reader.readLine()) != null) {
			String[] equipmentInfo = line.split(",");				//Splits CSV into array by commas

			Equipment equipment = new Equipment();					//Creates new Equipment object

			equipment.setEquipmentName(equipmentInfo[0]);			//Sets fields based on CSV file array
			equipment.setEquipmentID(equipmentInfo[1]);
			equipment.setCountyID(equipmentInfo[2]);
			equipment.setCheckedOutI(equipmentInfo[3]);
			equipment.setHolder(equipmentInfo[4]);
			equipment.setEquipmentType(equipmentInfo[5]);

			//System.out.println(String.format("%-35s %-25s %-20s", "Student [last=" + equipmentInfo[0], "first=" + student[1], "id=" + student[2] + "] "));
			
			equipmentList.add(equipment);							//Adds Equipment to equipmentList ArrayList
		}
		reader.close();
	}
}
