package ex05;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Controller5 implements Initializable{
	private GridPane root;
	public void setRoot(GridPane root) {
		this.root = root;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	public void LoginProc() {
		TextField txtField = (TextField) root.lookup("#fxId");
		System.out.println(txtField.getText());
	}

}
