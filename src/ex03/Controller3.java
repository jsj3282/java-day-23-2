package ex03;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class Controller3 implements Initializable{
	@FXML private TextField id;
	@FXML private TextField pw;
	@FXML private CheckBox chkBox;
	@FXML private Button login;
	final int FIELDLENGTH = 9;
	
	private void checkFieldLength(TextField txtField) {
		if(txtField.getLength()>=FIELDLENGTH) {
			txtField.setText(txtField.getText().substring(0, FIELDLENGTH));
		}
		if(id.getLength()>0 || pw.getLength()>0) {
			login.setDisable(false);
		}else {
			login.setDisable(true);
		}
		login.setOnAction(e->handleBtnAction());
	}
	public void handleBtnAction() {
		pw.clear();
		if(!chkBox.isSelected()) {
			this.id.clear();
			this.pw.requestFocus();
		}else {
			this.pw.requestFocus();
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		login.setDisable(true);
		this.id.textProperty().addListener((obs, oldTxt, newTxt)->{
			checkFieldLength(this.id);
		});
		this.pw.textProperty().addListener((obs, oldTxt, newTxt)->{
			checkFieldLength(this.pw);
		});
		
	}

}
