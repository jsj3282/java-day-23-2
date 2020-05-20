package ex02;

import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Controller2 implements Initializable{
	
	@FXML private TextField id;
	@FXML private TextField pw;
	@FXML private Button login;
	@FXML private CheckBox chkBox;
	
	final int FIELDLENGTH = 9;
	
	private void checkFieldLength(TextField txtField) {
		if(txtField.getLength()>=FIELDLENGTH) {
			txtField.setText(txtField.getText().substring(0, FIELDLENGTH));
		}
		if(id.getLength()>0 && pw.getLength()>0) {
			login.setDisable(false);
		}else {
			login.setDisable(true);
		}
	}

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		login.setDisable(true);
		this.id.textProperty().addListener((obs, oldTxt, newTxt)->{
			checkFieldLength(this.id);});
		this.pw.textProperty().addListener((obs, oldTxt, newTxt)->{
			checkFieldLength(this.pw);
		});
		
	}

}



