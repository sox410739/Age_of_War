package ce1002.Final.s107502533.controller;

import ce1002.Final.s107502533.Final;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class wincontroller {
	@FXML
	ImageView _exit, _stream2;
	
	public void onExitClicked(MouseEvent e) {
		Final.mainStage.close();
	}
	
	public void onExitEntered(MouseEvent e) {
		_exit.setLayoutX(_exit.getLayoutX() - 3);
		_exit.setLayoutY(_exit.getLayoutY() - 3);
		Final.mainScene.setCursor(Cursor.HAND);
		_stream2.setVisible(true);
	}
	
	public void onExitExit(MouseEvent e) {
		_exit.setLayoutX(_exit.getLayoutX() + 3);
		_exit.setLayoutY(_exit.getLayoutY() + 3);
		Final.mainScene.setCursor(Cursor.DEFAULT);
		_stream2.setVisible(false);
	}
}
