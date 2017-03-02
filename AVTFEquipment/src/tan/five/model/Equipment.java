package tan.five.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.StringProperty;

public class Equipment {

	//Fields
	private StringProperty equipmentName;
	private StringProperty equipmentID;
	private StringProperty countyID;
	private BooleanProperty checkedOut;
	private Student holder;
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

	public Student getHolder() {
		return holder;
	}

	public void setHolder(Student holder) {
		this.holder = holder;
	}

	public EquipmentType getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(EquipmentType equipmentType) {
		this.equipmentType = equipmentType;
	}
}





