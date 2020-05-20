package ex06;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ex06.commonService.CommonService;
import ex06.commonService.CommonServiceImpl;
import ex06.commonService.membership.MemberServiceImpl;
import ex06.commonService.membership.MembershipService;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class MemberController implements Initializable {
	
	private Parent root;
	private CommonService service;
	MembershipService memservice;
	
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
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	public void memberCancle() {
		service = new CommonServiceImpl();
		service.setRoot(root);
		service.WindowClose();
	}
	public void membershipProc() {
		memservice = new MemberServiceImpl();
		memservice.setRoot(root);
		memservice.membershipProc();
		
	}
	
}
