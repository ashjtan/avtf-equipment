package chappelle.five.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public abstract class UpdateImage {

	public static void handleUpdateImage(Label lbl, ImageView img) {
		Image checkMark = new Image("file:resources/checkmark.png");
		img.setImage(checkMark);
	}
}
