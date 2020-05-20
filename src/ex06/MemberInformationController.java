package ex06;

import java.net.URL;
import java.util.ResourceBundle;

import ex06.commonService.CommonService;
import ex06.commonService.CommonServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.Alert.AlertType;

public class MemberInformationController implements Initializable {
	private Parent root;
	CommonService commonService;
	Member member;
	public void setMember(Parent root, Member member) {
		((TextField)root.lookup("#fxName")).setText(member.getName());
		((TextField)root.lookup("#fxId")).setText(member.getId());
		((TextField)root.lookup("#fxAge")).setText(member.getAge());
		String gender;
		if(member.isGender()) {
			gender = "����";
		}else {
			gender = "����";
		}
		((TextField)root.lookup("#fxGender")).setText(gender);
		int hobby = member.getHobby();
		String strHobby = "��� ����";
		if(hobby == 1) {
			strHobby = "����";
		}else if(hobby == 2) {
			strHobby = "������";
		}else if(hobby == 3) {
			strHobby = "���� & ������";
		}else if(hobby == 4) {
			strHobby = "��ȭ";
		}else if(hobby == 5) {
			strHobby = "���� & ��ȭ";
		}else if(hobby == 6) {
			strHobby = "���� & ������ & ��ȭ";
		}
		((TextField)root.lookup("#fxHobby")).setText(strHobby);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	public void memberSuccess(ActionEvent event) {
		Parent root = (Parent)event.getSource();
		commonService = new CommonServiceImpl();
		commonService.setRoot(root);
		commonService.WindowClose();
	}
	
}
