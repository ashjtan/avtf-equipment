package chappelle.five.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tan.five.model.Student;

public class CheckOutFinalController {
	
	//Fields
	@FXML
	private ImageView imgCheckMark1;
	@FXML
	private ImageView imgCheckMark2;
	@FXML
	private ImageView imgCheckMark3;
	@FXML
	private ImageView imgCheckMark4;
	@FXML
	private ImageView imgCheckMark5;
	@FXML
	private ImageView imgCheckMark6;
	@FXML
	private Label lblItem1;
	@FXML
	private Label lblItem2;
	@FXML
	private Label lblItem3;
	@FXML
	private Label lblItem4;
	@FXML
	private Label lblItem5;
	@FXML
	private Label lblItem6;
	
	
	@FXML
	private void handleUpdateImage() {

		Image check = new Image("file:resources/checkmark.png");
		imgCheckMark1.setImage(check);
		imgCheckMark2.setImage(check);
		imgCheckMark3.setImage(check);
		imgCheckMark4.setImage(check);
		imgCheckMark5.setImage(check);
		imgCheckMark6.setImage(check);
	}
	
	@FXML
	private void initialize() {
		
		
	}
	
	
	
}
