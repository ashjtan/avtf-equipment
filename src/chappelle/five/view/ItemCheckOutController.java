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
import tan.five.model.Student;
import tan.five.model.StudentEquipmentManagement;
import chappelle.five.view.SceneSwitcher;

public class ItemCheckOutController  {


	@FXML
	private Button btnBackButton;

	static ObservableList<Student> mySl;



	//Method for switching scenes
	@FXML
	public void backButton() throws IOException {
		SceneSwitcher.handleSceneSwitch(btnBackButton, "/chappelle/five/view/StudentWelcomeScreen.fxml");
	}
	



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


	public void setMainApp(mainApp mainApp) {
		// TODO Auto-generated method stub

	}

}