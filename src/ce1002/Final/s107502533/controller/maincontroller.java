package ce1002.Final.s107502533.controller;

import javafx.scene.Cursor;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ce1002.Final.s107502533.Final;

public class maincontroller implements Initializable{
	@FXML
	ImageView _background, _swordL, _swordR, _easy, _hard, _impossible;
	@FXML
	ImageView _stream1, _stream2, _stream3;
	@FXML
	Button _sandbox;
	
	public void onSandboxPressed(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(Final.class.getResource("view/maze.fxml"));
		Parent maze = loader.load();
		Final.mainScene = new Scene(maze);
		Final.mainStage.setScene(Final.mainScene);
		Final.mainStage.setFullScreen(true);
	}
	
	public void onEasyClicked(MouseEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(Final.class.getResource("view/easy.fxml"));
		Parent maze = loader.load();
		Final.mainScene = new Scene(maze);
		Final.mainStage.setScene(Final.mainScene);
		Final.mainStage.setFullScreen(true);
	}
	
	public void onHardClicked(MouseEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(Final.class.getResource("view/hard.fxml"));
		Parent maze = loader.load();
		Final.mainScene = new Scene(maze);
		Final.mainStage.setScene(Final.mainScene);
		Final.mainStage.setFullScreen(true);
	}
	
	public void onImpossibleClicked(MouseEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(Final.class.getResource("view/impossible.fxml"));
		Parent maze = loader.load();
		Final.mainScene = new Scene(maze);
		Final.mainStage.setScene(Final.mainScene);
		Final.mainStage.setFullScreen(true);
	}
	
	public void onEasyEntered(MouseEvent e) {
		_easy.setLayoutX(_easy.getLayoutX() - 3);
		_easy.setLayoutY(_easy.getLayoutY() - 3);
		Final.mainScene.setCursor(Cursor.HAND);
		_stream1.setVisible(true);
	}
	
	public void onEasyExit(MouseEvent e) {
		_easy.setLayoutX(_easy.getLayoutX() + 3);
		_easy.setLayoutY(_easy.getLayoutY() + 3);
		Final.mainScene.setCursor(Cursor.DEFAULT);
		_stream1.setVisible(false);
	}
	
	public void onHardEntered(MouseEvent e) {
		_hard.setLayoutX(_hard.getLayoutX() - 3);
		_hard.setLayoutY(_hard.getLayoutY() - 3);
		Final.mainScene.setCursor(Cursor.HAND);
		_stream2.setVisible(true);
	}
	
	public void onHardExit(MouseEvent e) {
		_hard.setLayoutX(_hard.getLayoutX() + 3);
		_hard.setLayoutY(_hard.getLayoutY() + 3);
		Final.mainScene.setCursor(Cursor.DEFAULT);
		_stream2.setVisible(false);
	}
	
	public void onImpossibleEntered(MouseEvent e) {
		_impossible.setLayoutX(_impossible.getLayoutX() - 3);
		_impossible.setLayoutY(_impossible.getLayoutY() - 3);
		Final.mainScene.setCursor(Cursor.HAND);
		_stream3.setVisible(true);
	}
	
	public void onImpossibleExit(MouseEvent e) {
		_impossible.setLayoutX(_impossible.getLayoutX() + 3);
		_impossible.setLayoutY(_impossible.getLayoutY() + 3);
		Final.mainScene.setCursor(Cursor.DEFAULT);
		_stream3.setVisible(false);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Timeline left = new Timeline(new KeyFrame(Duration.millis(3), (e)-> {
			_swordL.setLayoutX(_swordL.getLayoutX() + 5);
		}));
		left.setCycleCount(500);
		left.play();
		
		Timeline right = new Timeline(new KeyFrame(Duration.millis(3), (e)-> {
			_swordR.setLayoutX(_swordR.getLayoutX() - 5);
		}));
		right.setCycleCount(500);
		right.play();
		
		Timeline delay = new Timeline(new KeyFrame(Duration.millis(2500), (e)-> {
			_swordL.setLayoutX(-684);
			_swordL.setRotate(0);
			_swordR.setLayoutX(1685);
			_swordR.setRotate(0);
			Timeline leftup = new Timeline(new KeyFrame(Duration.millis(12), (e1)-> {
				_swordL.setLayoutX(_swordL.getLayoutX() + 55);
				_swordL.setLayoutY(_swordL.getLayoutY() - 14.4);
			}));
			leftup.setCycleCount(20);
			leftup.play();
			
			Timeline rightup = new Timeline(new KeyFrame(Duration.millis(12), (e1)-> {
				_swordR.setLayoutX(_swordR.getLayoutX() - 55);
				_swordR.setLayoutY(_swordR.getLayoutY() - 20.5);
			}));
			rightup.setCycleCount(20);
			rightup.play();
			
			Timeline back = new Timeline(new KeyFrame(Duration.millis(40), (e1)-> {
				_background.setOpacity(_background.getOpacity() + 0.05);
				_easy.setOpacity(_easy.getOpacity() + 0.05);
				_hard.setOpacity(_hard.getOpacity() + 0.05);
				_impossible.setOpacity(_impossible.getOpacity() + 0.05);
			}));
			back.setCycleCount(20);
			back.play();
		}));
		delay.setCycleCount(1);
		delay.play();
	}
	
	public EventHandler<KeyEvent> onKeyPressed  = (e) ->{
		if(e.getCode() == KeyCode.A) {
			_sandbox.setVisible(true);
		}
	};
	
}
