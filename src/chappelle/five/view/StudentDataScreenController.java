package chappelle.five.view;

import java.io.IOException;
import java.util.ArrayList;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
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
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import tan.five.model.Student;
import tan.five.model.StudentEquipmentManagement;

public class StudentDataScreenController extends Application {


	@FXML
	private Button btnCheckIn;
	@FXML
	private Button btnCheckOut;
	@FXML
	private Button btnGoBack;

	static ObservableList<Student> mySl;

	@Override
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

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

	//Method for switching scenes
	@FXML
	private void handleSceneSwitch(ActionEvent event) throws IOException{
		Stage stage; 
		Parent root;
		//Setting the scene to the check in menu
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
				root = FXMLLoader.load(getClass().getResource("chappelle/five/view/RootLayout.fxml"));
			}
			//create a new scene with root and set the stage
			Scene checkInMenu = new Scene(root);
			stage.setScene(checkInMenu);
			stage.show();
		}
	}
}