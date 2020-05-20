package ex07;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;

public class Controller7 implements Initializable{
	private Parent root;
	public void setRoot(Parent root) {
		this.root = root;
		AddComboBox();
	}
	
	public void AddComboBox() {
		ComboBox<String> cmbAge = (ComboBox<String>)root.lookup("#cmbAge");
		if(cmbAge!=null) {
			cmbAge.getItems().addAll("20대 미만", "20대", "30대", "40대", "50대", "60대 이상");
		}
	}
	
	public void viewProc() {
		boolean gender = getGender();
		int hobby = getHobby();
		String age = getComboBoxString();
		System.out.println("성별 (true남), (false여) : " + gender);
		System.out.println("취미 (1음악)(2스포츠)(4영화)(또는 3음악, 스포츠...)" + hobby);
		System.out.println("나이 : " + age);
	}
	
	private boolean getGender() {
		RadioButton rdoMan = (RadioButton)root.lookup("#rdoMan");
		if(rdoMan.isSelected()) {
			return true;		//Man
		}
		return false;	//WOMAN
		//return rdoMan.isSelected();
	}
	
	private String getComboBoxString() {
		
		ComboBox<String> cmbAge = (ComboBox<String>)root.lookup("#cmbAge");
		String age = "";
		if(cmbAge==null) {
			System.out.println("ComboBox에 값이 없습니다");
		}else if(cmbAge.getValue()==null) {
			System.out.println("ComboBox를 선택하세요");
			cmbAge.requestFocus();
		}else {
			age = cmbAge.getValue().toString();
		}
		return age;
		
	}
	
	private int getHobby() {
		int hobby = 0;
		if(((CheckBox)root.lookup("#chkMusic")).isSelected()) {
			hobby += 1;
		}
		if(((CheckBox)root.lookup("#chkSport")).isSelected()) {
			hobby += 2;
		}
		if(((CheckBox)root.lookup("#chkMovie")).isSelected()) {
			hobby += 4;
		}
		return hobby;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

}
