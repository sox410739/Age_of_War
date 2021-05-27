package ce1002.Final.s107502533;

import ce1002.Final.s107502533.controller.maincontroller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Final extends Application{
	public static Stage mainStage;
	public static Scene mainScene;
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage arg0) throws Exception {
		Final.mainStage = arg0;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("view/main.fxml"));
		Parent main = loader.load();
		mainScene = new Scene(main);
		maincontroller mainCtrl = loader.getController();
		mainScene.setOnKeyPressed(mainCtrl.onKeyPressed);
		mainStage.setFullScreen(true);
		mainStage.setTitle("age of war");
		mainStage.setScene(mainScene);
		mainStage.show();
	}
}
