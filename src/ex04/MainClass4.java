package ex04;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainClass4 extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane root = FXMLLoader.load(getClass().getResource("eventTest4.fxml"));
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		
		launch(args);

	}


}
