package tan.five.model;

import java.util.ArrayList;

public class Student {

	//Fields
	private String lastName;
	private String firstName;
	private String studentID;
	private ArrayList<Equipment> checkedOutEquipment;


	//Default Constructor
	public Student(){
		lastName = "";
		firstName = "";
		studentID = "";
		checkedOutEquipment = new ArrayList<Equipment>();
	}

	//Overloaded Constructor
	public Student(String lastName1, String firstName1, String studentID1, ArrayList<Equipment> checkedOutEquipment1){
		lastName = lastName1;
		firstName = firstName1;
		studentID = studentID1;
		checkedOutEquipment = checkedOutEquipment1;
	}

	
	//Getters + Setters
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public ArrayList<Equipment> getCheckedOutEquipment() {
		return checkedOutEquipment;
	}

	public void setCheckedOutEquipment(ArrayList<Equipment> checkedOutEquipment) {
		this.checkedOutEquipment = checkedOutEquipment;
	}
}