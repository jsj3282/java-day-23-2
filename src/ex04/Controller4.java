package ex04;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller4  implements Initializable{
	
	@FXML private Button btn;
	@FXML private TextField id;
	@FXML private PasswordField pw;
	@FXML private CheckBox idChkBox;
	final int FIELDLENGTH = 9;
	
	private void checkFieldLength(TextField txtField) {
		if(txtField.getLength()>=FIELDLENGTH) {
			txtField.setText(txtField.getText().substring(0, FIELDLENGTH));
		}
	}
	private void IsTextField() {
		if(id.getLength()>0 && pw.getLength()>0) {
			btn.setDisable(false);
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btn.setDisable(true);
		pw.textProperty().addListener((obs, oldTxt, newTxt)->{
			System.out.println(obs);
			System.out.println(oldTxt);
			System.out.println(newTxt);
			checkFieldLength(this.id);
			IsTextField();
		});
		
	}
	public void MsgBox(String contents) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(contents);
		alert.show();
	}
	private void handleBtnAction() {
		if(!IsTextField(this.id, this.pw)) {
			return;
		}
		String id = this.id.getText();
		String pw = this.pw.getText();
		MyDB db = new MyDB();
		if(pw.equals(db.getPassword(id))){
			MsgBox("성공");
		}else {
			MsgBox("실패");
			this.pw.clear();
			if(!idChkBox.isSelected()) {
				this.id.clear();
				this.id.requestFocus();
			}else {
				this.pw.requestFocus();
			}
		}
	}
	public boolean IsTextField(TextField id, PasswordField pw) {
		if(id.getText().isEmpty()) {
			MsgBox("ID를 입력해야 합니다.");
			id.requestFocus();
			pw.clear();
			return false;
		}
		if(pw.getText().isEmpty()) {
			MsgBox("Password를 입력해야 합니다.");
			pw.requestFocus();
			return false;
		}
		return true;
	}

}
