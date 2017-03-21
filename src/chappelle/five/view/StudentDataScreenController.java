package chappelle.five.view;


import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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


		response.setFont(Font.font("Arial", 14));
		root.getChildren().addAll(title,tvStudents, response);
		primaryStage.setTitle("Student List");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
