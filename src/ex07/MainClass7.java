package ex07;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClass7 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("eventTest7.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Controller7 ctrler = loader.getController();
		ctrler.setRoot(root);
		primaryStage.setTitle("Login");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		
		launch(args);

	}


}
