package tan.five.model;

import javafx.beans.property.SimpleStringProperty;

public class Student {

	//Field of logged-in student
	/**
	 * The currently logged-in student.
	 */
	public static Student SELECTED_STUDENT = new Student();

	//Fields
	/**
	 * The last name of a student, able to bind to JavaFX.
	 */
	private SimpleStringProperty lastName = new SimpleStringProperty();
	/**
	 * The first name of a student, able to bind to JavaFX.
	 */
	private SimpleStringProperty firstName = new SimpleStringProperty();
	/**
	 * The ten-digit school ID of a student, able to bind to JavaFX.
	 */
	private SimpleStringProperty studentID = new SimpleStringProperty();


	//Default Constructor
	/**
	 * The default constructor for the Student.
	 */
	public Student() {
		this("", "", "");
	}

	//Overloaded Constructor
	/**
	 * The overloaded constructor for the Student.
	 * @param lastName1 - the last name of the Student.
	 * @param firstName1 - the first name of the Student.
	 * @param studentID1 - the school ID of the student.
	 */
	public Student(String lastName1, String firstName1, String studentID1) {
		setLastName(lastName1);
		setFirstName(firstName1);
		setStudentID(studentID1);
	}


	//Getters + Setters
	/**
	 * Gets the last name of the Student.
	 * @return the last name of the Student.
	 */
	public String getLastName() {									//Returns String
		return lastName.get();
	}
	/**
	 * Sets the last name of the Student.
	 * @param lastName - the last name of the Student.
	 */
	public void setLastName(String lastName) {						//Takes String
		this.lastName.set(lastName);
	}

	/**
	 * Gets the first name of the student.
	 * @return the first name of the Student.
	 */
	public String getFirstName() {									//Returns String
		return firstName.get();
	}
	/**
	 * Sets the first name of the student.
	 * @param firstName - the first name of the Student.
	 */
	public void setFirstName(String firstName) {					//Takes String
		this.firstName.set(firstName);
	}

	/**
	 * Gets the school ID of the student.
	 * @return the ten-digit school ID of the student.
	 */
	public String getStudentID() {									//Returns String
		return studentID.get();
	}

	/**
	 * Sets the school ID of the student.
	 * @param studentID - the ten-digit school ID of the student.
	 */
	public void setStudentID(String studentID) {					//Takes String
		this.studentID.set(studentID);
	}




	//Overriding toString to return Student's name (for visibility)
	/**
	 * Gets the Student's first and last name for visibility.
	 * @return the Student's first and last name.
	 */
	public String toString() {
		return firstName.get() + " " + lastName.get();
	}
}