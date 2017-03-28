package chappelle.five.view;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import tan.five.mainApp;
import tan.five.model.Equipment;
import tan.five.model.EquipmentType;
import tan.five.model.Student;
import tan.five.model.StudentEquipmentManagement;

public class ItemCheckOutController  {


	@FXML
	private Button btnCheckIn;
	@FXML
	private Button btnCheckOut;
	@FXML
	private Button btnGoBack;
	
	@FXML
	private TableView<Equipment> equipmentTableView;
	@FXML
	private TableColumn<Equipment, String> equipmentName;
	@FXML
	private TableColumn<Equipment, String> equipmentID;
	@FXML
	private TableColumn<Equipment, String> countyID;
	@FXML
	private TableColumn<Equipment, Boolean> checkedOut;
	@FXML 
	private TableColumn<Equipment, Student> holder;
	@FXML
	private TableColumn<Equipment, EquipmentType> equipmentType;
	

	public void start(Stage primaryStage) {

<<<<<<< HEAD

=======
	}
>>>>>>> origin/master

	//CURRENTLY HOLDS ALL TABLE INFO BUT ACTUAL CHECKOUT WILL NOT HAVE ALL INFO
	@FXML
	public void initialize() {
		for (Equipment equipment : StudentEquipmentManagement.getEquipmentListA()) {
			equipmentTableView.getItems().add(equipment);
		}
		
		equipmentName.setCellValueFactory(new PropertyValueFactory<>("equipmentName"));
		equipmentID.setCellValueFactory(new PropertyValueFactory<>("equipmentID"));
		countyID.setCellValueFactory(new PropertyValueFactory<>("countyID"));
		checkedOut.setCellValueFactory(new PropertyValueFactory<>("checkedOut"));
		holder.setCellValueFactory(new PropertyValueFactory<>("holder"));
		equipmentType.setCellValueFactory(new PropertyValueFactory<>("equipmentType"));
	}

	//Switches scenes
	@FXML
	private void handleSceneSwitch(ActionEvent event) throws IOException{
		Stage stage; 
		Parent root;
		//Setting the scene to scene one
		if(event.getSource()==btnCheckIn){
			//get reference to the button's stage         
			stage=(Stage) btnCheckIn.getScene().getWindow();
			//load up OTHER FXML document
			root = FXMLLoader.load(getClass().getResource("CHECK IN MENU"));
		}
		//Setting the scene to the check out menu
		else {
			if(event.getSource()==btnCheckOut){
				//get reference to the button's stage         
				stage=(Stage) btnCheckOut.getScene().getWindow();
				//load up OTHER FXML document
				root = FXMLLoader.load(getClass().getResource("CHECK OUT MENU"));
			}
			//So it may set the root scene again
			else{
				stage=(Stage) btnGoBack.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("tan/five/view/Login.fxml"));
			}
			//create a new scene with root and set the stage
			Scene checkInMenu = new Scene(root);
			stage.setScene(checkInMenu);
			stage.show();
		}
	}

<<<<<<< HEAD


	public void start(Stage primaryStage) {
		Label response = new Label("");
		Label title = new Label("Student List Using a TableView\n");
		title.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		title.setTextFill(Color.CADETBLUE);


		FlowPane root = new FlowPane();
		root.setAlignment(Pos.CENTER);

		Scene scene = new Scene(root, 700, 700);

		mySl = StudentEquipmentManagement.getStudentListO();
		Student stu = new Student();

		TableView<Student> tvStudents;

		tvStudents = new TableView<Student>(mySl);

		TableColumn<Student, String> lName = new TableColumn<>("Last Name");
		lName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		tvStudents.getColumns().add(lName);

		TableColumn<Student, String> fName = new TableColumn<>("First Name");
		fName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		tvStudents.getColumns().add(fName);

		TableColumn<Student, String> iD = new TableColumn<>("ID");
		iD.setCellValueFactory(new PropertyValueFactory<>("id"));
		tvStudents.getColumns().add(iD);


		tvStudents.setPrefWidth(600);
		tvStudents.setPrefHeight(300);

		TableView.TableViewSelectionModel<Student> tvSelStudent = 
				tvStudents.getSelectionModel();
		/*
	        tvSelStudent.selectedIndexProperty().addListener(new ChangeListener<Number>()
	        {
	            public void changed(ObservableValue<? extends Number> changed, 
	                    Number oldVal, Number newVal) {
	                int index = (int)newVal;
	                response.setText("The cell number for the Student selected is "
	                        +mySl.get(index).getZip());
	            }
	        });
		 */

		response.setFont(Font.font("Helvetica Neue", 14));
		root.getChildren().addAll(title, tvStudents, response);
		primaryStage.setTitle("Student List");
		primaryStage.setScene(scene);
		primaryStage.show();
	}


=======
>>>>>>> origin/master
	public void setMainApp(mainApp mainApp) {
		

	}

}