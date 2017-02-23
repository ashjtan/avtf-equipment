package tan.five.model;

public class Equipment {

	//Fields
	private String equipmentName;
	private String equipmentID;
	private String countyID;
	private boolean checkedOut;
	private Student holder;
	private EquipmentType equipmentType;


	//Default Constructor
	public Equipment(){
		equipmentName = "";
		equipmentID = "";
		countyID = "";
		checkedOut = false;
		holder = new Student();
		equipmentType = EquipmentType.OTHER;
	}
	
	//Overloaded Constructor
	public Equipment(String equipmentName1, String equipmentID1, String countyID1, boolean checkedOut1, Student holder1, EquipmentType equipmentType1){
		equipmentName = equipmentName1;
		equipmentID = equipmentID1;
		countyID = countyID1;
		checkedOut = checkedOut1;
		holder = holder1;
		equipmentType = equipmentType1;
	}

	
	//Getters + Setters
	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getEquipmentID() {
		return equipmentID;
	}

	public void setEquipmentID(String equipmentID) {
		this.equipmentID = equipmentID;
	}

	public String getCountyID() {
		return countyID;
	}

	public void setCountyID(String countyID) {
		this.countyID = countyID;
	}

	public boolean isCheckedOut() {
		return checkedOut;
	}

	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
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





