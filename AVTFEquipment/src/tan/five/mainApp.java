package tan.five;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import tan.five.model.Equipment;
import tan.five.model.Student;
import tan.five.model.StudentEquipmentManagement;
import tan.five.model.StudentFinal;

public class mainApp {

/*	
	static ArrayList<Student> myStudentList = StudentEquipmentManagement.getStudentList();
	//static ArrayList<Equipment> myEquipmentList = new ArrayList();

	static StudentEquipmentManagement studentEquipmentManagement = new StudentEquipmentManagement();
*/
	
	static ObservableList<Student> myStudentList = StudentEquipmentManagement.getStudentList();
	
	public static void main(String[] args) {

		myStudentList = StudentEquipmentManagement.getStudentList();

		Student student = new Student();

		for (int i = 0; i < myStudentList.size(); i++)
		{
			student = myStudentList.get(i);
			System.out.println(String.format("%-35s %-25s %-20s", student.getLastName(), student.getFirstName(), student.getStudentID()));
		}
	}
}