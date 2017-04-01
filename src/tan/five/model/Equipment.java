package tan.five.model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class Equipment {

	//Fields
	/**
	 * The title of the equipment able to bind to JavaFX.
	 */
	private SimpleStringProperty equipmentName = new SimpleStringProperty();
	/**
	 * The four-digit barcode number of the equipment able to bind to JavaFX.
	 */
	private SimpleStringProperty equipmentID = new SimpleStringProperty();
	/**
	 * The county-provided ID number of the equipment able to bind to JavaFX.
	 */
	private SimpleStringProperty countyID = new SimpleStringProperty();
	/**
	 * Whether or not the equipment is checked out, able to bind to JavaFX..
	 */
	private SimpleBooleanProperty checkedOut = new SimpleBooleanProperty();
	/**
	 * The student (if any) in possession of the equipment.
	 */
	private Student holder;
	/**
	 * The name of the Student (if any) in possession of the equipment.
	 */
	private SimpleStringProperty holderName = new SimpleStringProperty();
	/**
	 * The category of AVTF equipment this piece falls into.
	 */
	private EquipmentType equipmentType;




	//Default Constructor
	/**
	 * The default constructor for a piece of equipment.
	 */
	public Equipment(){
		this("", "", "", false, null, EquipmentType.OTHER);
	}

	//Overloaded Constructor
	/**
	 * The overloaded constructor for a piece of equipment.
	 * @param equipmentName1 - the title of the equipment.
	 * @param equipmentID1 - the four-digit barcode of the equipment.
	 * @param countyID1 - the county-provided ID number of the equipment.
	 * @param checkedOut1 - whether or not the equipment is checked out.
	 * @param holder1 - the Student (if any) in possession of the equipment.
	 * @param equipmentType1 - the category of AVTF equipment this piece falls into.
	 */
	public Equipment(String equipmentName1, String equipmentID1, String countyID1, boolean checkedOut1, Student holder1, EquipmentType equipmentType1){
		setEquipmentName(equipmentName1);
		setEquipmentID(equipmentID1);
		setCountyID(countyID1);
		setCheckedOut(checkedOut1);
		setHolder(holder1);
		setEquipmentType(equipmentType1);
	}


	
	
	//Getters + Setters
	/**
	 * Gets the title of the equipment.
	 * @return the title of the piece of equipment.
	 */
	public String getEquipmentName() {							//Returns String
		return equipmentName.get();
	}
	/**
	 * Sets the title of the equipment.
	 * @param equipmentName - the title of the equipment.
	 */
	public void setEquipmentName(String equipmentName) {		//Takes String
		this.equipmentName.set(equipmentName);
	}
	
	/**
	 * Gets the four-digit barcode of the equipment.
	 * @return the four-digit barcode of the equipment.
	 */
	public String getEquipmentID() {							//Returns String
		return equipmentID.get();
	}
	/**
	 * Sets the four-digit barcode of the equipment.
	 * @param equipmentID - the four-digit barcode of the equipment.
	 */
	public void setEquipmentID(String equipmentID) {			//Takes String	
		this.equipmentID.set(equipmentID);
	}
	
	/**
	 * Gets the county-provided ID number of the equipment.
	 * @return the county-provided ID number of the equipment.
	 */
	public String getCountyID() {								//Returns String
		return countyID.get();
	}
	/**
	 * the county-provided ID number of the equipment.
	 * @param countyID - the county-provided ID number of the equipment.
	 */
	public void setCountyID(String countyID) {					//Takes String			
		this.countyID.set(countyID);
	}
	
	/**
	 * Gets whether or not the equipment is checked out.
	 * @return if the equipment is checked out.
	 */
	public boolean isCheckedOut() {								//Returns Boolean
		return checkedOut.get();
	}
	/**
	 * Sets whether or not the equipment is checked out.
	 * @param checkedOut - if the equipment is checked out.
	 */
	public void setCheckedOut(boolean checkedOut) {				//Takes Boolean
		this.checkedOut.set(checkedOut);
	}
	/**
	 * Sets whether or not the equipment is checked out.
	 * Written from scratch for object instantiation from CSV file.
	 * @param equipmentInfo - the value "IN" or "OUT" in the CSV file cell.
	 */
	public void setCheckedOutI(String equipmentInfo) {			//WRITTEN FROM SCRATCH FOR INSTANTIATION FROM CSV
		if (equipmentInfo.equals("out") || equipmentInfo.equals("OUT")) {
			this.checkedOut.set(true);
		}
		else if (equipmentInfo.equals("in") || equipmentInfo.equals("IN")) {
			this.checkedOut.set(false);
		}
	}
	
	/**
	 * Gets the Student (if any) in possession of the equipment.
	 * @return the Student (if any) in possession of the equipment.
	 */
	public Student getHolder() {
		return holder;
	}
	/**
	 * Sets the Student (if any) in possession of the equipment.
	 * @param holder - the Student (if any) in possession of the equipment.
	 */
	public void setHolder(Student holder) {						
		this.holder = holder;
	}
	/**
	 * Sets the Student (if any) in possession of the equipment. 
	 * Written from scratch for object instantiation from CSV file.
	 * @param holder - the Student (if any) in possession of the equipment.
	 */
	public void setHolder(String holder) {						//WRITTEN FROM SCRATCH FOR INSTANTIATION FROM CSV	
		for (Student student : StudentEquipmentManagement.getStudentListA()) {
			if (holder.equals(student.getStudentID())) {			
				this.holder = student;
			}
		}
	}

	/**
	 * Gets the Student (if any) in possession of the equipment.
	 * @return the Student (if any) in possession of the equipment, as a String.
	 */
	public String getHolderName() {								//Returns String
		return holderName.get();
	}
	/**
	 * Sets the name of the Student (if any) in possession of the equipment.
	 * @param holderName - the name of the Student (if any) in possession of the equipment.
	 */
	public void setHolderName(String holderName) {				//Takes String
		this.holderName.set(holderName);
	}
	
	/**
	 * Gets the category of AVTF equipment this piece falls into.
	 * @return the category of AVTF equipment this piece falls into.
	 */
	public EquipmentType getEquipmentType() {					
		return equipmentType;
	}
	/**
	 * A default EquipmentType Setter that sets the category of AVTF 
	 * equipment this piece falls into as OTHER.
	 */
	public void setEquipmentType() {							//Default EquipmentType Setter
		this.equipmentType = EquipmentType.OTHER;
	}
	/**
	 * Sets the category of AVTF equipment this piece falls into.
	 * Written from scratch for object instantiation from CSV file.
	 * @param equipmentType
	 */
	public void setEquipmentType(String equipmentType) {		//WRITTEN FROM SCRATCH FOR INSTANTIATION FROM CSV
		switch (equipmentType) {
		case "CAMERA":
			this.equipmentType = EquipmentType.CAMERA;
			break;
		case "TRIPOD":
			this.equipmentType = EquipmentType.TRIPOD;
			break;
		case "MICROPHONE":
			this.equipmentType = EquipmentType.MICROPHONE;
			break;
		case "MICROPHONE_ACCESSORY":
			this.equipmentType = EquipmentType.MICROPHONE_ACCESSORY;
			break;
		case "LAPTOP":
			this.equipmentType = EquipmentType.LAPTOP;
			break;
		case "LIGHT":
			this.equipmentType = EquipmentType.LIGHT;
			break;
		case "LIGHT_ACCESSORY":
			this.equipmentType = EquipmentType.LIGHT_ACCESSORY;
			break;
		case "CABLE":
			this.equipmentType = EquipmentType.CABLE;
			break;
		default:
			this.equipmentType = EquipmentType.OTHER;
			break;
		}
	}
	/**
	 * Sets the category of AVTF equipment this piece falls into.
	 * @param equipmentType - the category of AVTF equipment this piece falls into.
	 */
	public void setEquipmentType(EquipmentType equipmentType) {
		this.equipmentType = equipmentType;
	}
}