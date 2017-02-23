package tan.five;
import java.util.ArrayList;

import tan.five.model.Equipment;
import tan.five.model.Student;
import tan.five.model.StudentEquipmentManagement;

public class mainApp {

	
	static ArrayList<Student> myStudentList = new ArrayList();
	static ArrayList<Equipment> myEquipmentList = new ArrayList();

	static StudentEquipmentManagement studentEquipmentManagement = new StudentEquipmentManagement();

	public static void main(String[] args) {

		myStudentList = studentEquipmentManagement.getStudentList();

		Student student = new Student();

		for (int i = 0; i < myStudentList.size(); i++)
		{
			student = myStudentList.get(i);
			System.out.println(String.format("%-35s %-25s %-20s", student.getLastName(), student.getFirstName(), student.getStudentID()));
		}
		
		System.out.println("Hello");
	}
}