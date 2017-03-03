package tan.five.model;

import java.util.ArrayList;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StudentProperty {

	//Fields
	private StringProperty lastName;
	private StringProperty firstName;
	private StringProperty studentID;
	private ObservableList<Equipment> checkedOutEquipment;


	//Default Constructor
	public StudentProperty(){
		this(null, null, null, null);
	}

	//Overloaded Constructor
	//Converts String type into SimpleStringProperty type
	//Calls SimpleStringProperty constructors inheriting from StringProperty type
	public StudentProperty(String lastName1, String firstName1, String studentID1, ArrayList<Equipment> checkedOutEquipment1){
		//Checks for nulls to prevent null pointers
		if(lastName1==null){lastName = new SimpleStringProperty("---");}
		else {lastName = new SimpleStringProperty(lastName1);}

		if(firstName1==null){firstName = new SimpleStringProperty("---");}
		else {firstName = new SimpleStringProperty(firstName1);}

		if(studentID1==null){studentID = new SimpleStringProperty("---");}
		else {studentID = new SimpleStringProperty(studentID1);}

		//Default Call: creates new ArrayList + converts into ObservableList
		//Overloaded Call: converts parameter ArrayList into ObservableList
		if(checkedOutEquipment1==null){checkedOutEquipment = FXCollections.observableArrayList(new ArrayList<Equipment>());}
		else {checkedOutEquipment = FXCollections.observableArrayList(checkedOutEquipment1);
		}
	}

	
	//Getters + Setters
	public String getLastName() {						//StringProperty getter returns String
		return lastName.get();
	}

	public void setLastName(String lastName) {			//StringProperty setter passes String
		this.lastName.set(lastName);
	}

	public String getFirstName() {						//StringProperty getter returns String
		return firstName.get();
	}

	public void setFirstName(String firstName) {		//StringProperty setter passes String
		this.firstName.set(firstName);
	}

	public String getStudentID() {						//StringProperty getter returns String
		return studentID.get();
	}

	public void setStudentID(String studentID) {		//StringProperty setter passes String
		this.studentID.set(studentID);
	}

	public ArrayList<Equipment> getCheckedOutEquipment() {		//TENTATIVE: casts ArrayList onto ObseravableArrayList
		return (ArrayList<Equipment>)checkedOutEquipment;
	}

	public void setCheckedOutEquipment(ArrayList<Equipment> checkedOutEquipment) {				//TENTATIVE: converts ArrayList into ObservableArrayList
		this.checkedOutEquipment = FXCollections.observableArrayList(checkedOutEquipment);	
	}
	
	
	//Property Getters
	public StringProperty lastNameProperty() {
		return lastName;
	}
	
	public StringProperty firstNameProperty() {
		return firstName;
	}
	
	public StringProperty studentIDProperty() {
		return studentID;
	}
}
