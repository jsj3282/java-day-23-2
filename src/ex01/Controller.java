package ex01;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class Controller implements Initializable{
	@FXML private TextField fxId;
	final int FIELDLENGTH = 9;
	private void checkFieldLength(TextField txtField) {
		if(txtField.getLength()>=FIELDLENGTH) {
			txtField.setText(txtField.getText().substring(0, FIELDLENGTH));
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.fxId.textProperty().addListener((obs, oldTxt, newTxt)->{
			System.out.println(obs);
			System.out.println(oldTxt);
			System.out.println(newTxt);
			checkFieldLength(this.fxId);
		});
		
	}

}
