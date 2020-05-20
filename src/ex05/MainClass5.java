package ex05;


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainClass5 extends Application{

	@Override
	public void start(Stage primaryStage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("eventText5.fxml"));
		GridPane root = loader.load();
		
		Scene scene = new Scene(root);
		Controller5 ctrler = loader.getController();
		ctrler.setRoot(root);
		
		primaryStage.setTitle("Login");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		
		launch(args);

	}


}
