package chappelle.five.view;

import chappelle.five.view.StudentWelcomeScreenController;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import chappelle.five.view.ItemCheckOutController;
import tan.five.model.Student;

public abstract class DragAndDrop {
/*

	TableView<Student> tvstudents;

	

	source.setOnDragDetected(new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			/* drag was detected, start a drag-and-drop gesture*/
			/* allow any transfer mode */
		//	Dragboard db = source.startDragAndDrop(TransferMode.ANY);

			/* Put a string on a dragboard */
	//		ClipboardContent content = new ClipboardContent();
//			content.putString(source.getText());
	///		db.setContent(content);

	///		event.consume();
//		}
//	}
	


}

