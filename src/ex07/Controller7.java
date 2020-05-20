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
			cmbAge.getItems().addAll("20�� �̸�", "20��", "30��", "40��", "50��", "60�� �̻�");
		}
	}
	
	public void viewProc() {
		boolean gender = getGender();
		int hobby = getHobby();
		String age = getComboBoxString();
		System.out.println("���� (true��), (false��) : " + gender);
		System.out.println("��� (1����)(2������)(4��ȭ)(�Ǵ� 3����, ������...)" + hobby);
		System.out.println("���� : " + age);
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
			System.out.println("ComboBox�� ���� �����ϴ�");
		}else if(cmbAge.getValue()==null) {
			System.out.println("ComboBox�� �����ϼ���");
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
