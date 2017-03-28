package tan.five.model;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Student {

	public static Student SELECTED_STUDENT = new Student();

	//Fields
	private SimpleStringProperty lastName = new SimpleStringProperty();
	private SimpleStringProperty firstName = new SimpleStringProperty();
	private SimpleStringProperty studentID = new SimpleStringProperty();
	private ObservableList<Equipment> checkedOutEquipment;


	//Default Constructor
	public Student() {
		this("", "", "", new ArrayList<Equipment>());
	}

	//Overloaded Constructor
	public Student(String lastName1, String firstName1, String studentID1, ArrayList<Equipment> checkedOutEquipment1) {
		setLastName(lastName1);
		setFirstName(firstName1);
		setStudentID(studentID1);
		setCheckedOutEquipment(checkedOutEquipment1);
	}


	//Getters + Setters
	public String getLastName() {									//Returns String
		return lastName.get();
	}

	public void setLastName(String lastName) {						//Takes String
		this.lastName.set(lastName);
	}

	public String getFirstName() {									//Returns String
		return firstName.get();
	}

	public void setFirstName(String firstName) {					//Takes String
		this.firstName.set(firstName);
	}

	public String getStudentID() {									//Returns String
		return studentID.get();
	}

	public void setStudentID(String studentID) {					//Takes String
		this.studentID.set(studentID);
	}

	public void setCheckedOutEquipment(ArrayList<Equipment> checkedOutEquipment1) {		//TENTATIVE: takes + converts ArrayList
		this.checkedOutEquipment = FXCollections.observableList(checkedOutEquipment1);
	}
	
	public ArrayList<Equipment> getCheckedOutEquipment() {			//TENTATIVE: returns ArrayList by casting
		return (ArrayList<Equipment>)checkedOutEquipment;
	}
}