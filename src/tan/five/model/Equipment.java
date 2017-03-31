package tan.five.model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class Equipment {

	//Fields
	private SimpleStringProperty equipmentName = new SimpleStringProperty();
	private SimpleStringProperty equipmentID = new SimpleStringProperty();
	private SimpleStringProperty countyID = new SimpleStringProperty();
	private SimpleBooleanProperty checkedOut = new SimpleBooleanProperty();
	private Student holder;
	private SimpleStringProperty holderName = new SimpleStringProperty();
	private EquipmentType equipmentType;

	
	

	//Default Constructor
	public Equipment(){
		this("", "", "", false, null, EquipmentType.OTHER);
	}

	//Overloaded Constructor
	public Equipment(String equipmentName1, String equipmentID1, String countyID1, boolean checkedOut1, Student holder1, EquipmentType equipmentType1){
		setEquipmentName(equipmentName1);
		setEquipmentID(equipmentID1);
		setCountyID(countyID1);
		setCheckedOut(checkedOut1);
		setHolder(holder1);
		setEquipmentType(equipmentType1);
	}


	//Getters + Setters
	public String getEquipmentName() {							//Returns String
		return equipmentName.get();
	}

	public void setEquipmentName(String equipmentName) {		//Takes String
		this.equipmentName.set(equipmentName);
	}

	public String getEquipmentID() {							//Returns String
		return equipmentID.get();
	}

	public void setEquipmentID(String equipmentID) {			//Takes String	
		this.equipmentID.set(equipmentID);
	}

	public String getCountyID() {								//Returns String
		return countyID.get();
	}

	public void setCountyID(String countyID) {					//Takes String			
		this.countyID.set(countyID);
	}

	public boolean isCheckedOut() {								//Returns Boolean
		return checkedOut.get();
	}

	public void setCheckedOut(boolean checkedOut) {				//Takes Boolean
		this.checkedOut.set(checkedOut);
	}

	public void setCheckedOutI(String equipmentInfo) {			//WRITTEN FROM SCRATCH FOR INSTANTIATION FROM CSV
		if (equipmentInfo.equals("out") || equipmentInfo.equals("OUT")) {
			this.checkedOut.set(true);
		}
		else if (equipmentInfo.equals("in") || equipmentInfo.equals("IN")) {
			this.checkedOut.set(false);
		}
	}

	public Student getHolder() {
		return holder;
	}

	public void setHolder(Student holder) {						
		this.holder = holder;
	}
	
	public String getHolderName() {								//Returns String
		return holderName.get();
	}

	public void setHolderName(String holderName) {				//Takes String
		this.holderName.set(holderName);
	}

	public void setHolder(String holder) {						//WRITTEN FROM SCRATCH FOR INSTANTIATION FROM CSV	
		for (Student student : StudentEquipmentManagement.getStudentListA()) {
			if (holder.equals(student.getStudentID())) {			
				this.holder = student;
			}
		}
	}

	public EquipmentType getEquipmentType() {					
		return equipmentType;
	}

	public void setEquipmentType() {							//Default EquipmentType Setter
		this.equipmentType = EquipmentType.OTHER;
	}

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

	public void setEquipmentType(EquipmentType equipmentType) {
		this.equipmentType = equipmentType;
	}
}