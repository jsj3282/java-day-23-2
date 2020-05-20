package ex06;

import java.io.IOException;

import ex06.commonService.CommonService;
import ex06.commonService.CommonServiceImpl;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginServiceImpl implements LoginService{
	
	@Override
	public void LoginProc(Parent root) {
		
		TextField txtField = (TextField) root.lookup("#fxId");
		System.out.println(txtField.getText());
		PasswordField passwordField = (PasswordField) root.lookup("#fxPw");
		System.out.println(passwordField.getText());
		Member mem = Controller6.db.select(txtField.getText());
		System.out.println(txtField.getText());
		if(mem==null) {
			CommonService.ErrorMsg("로그인 실패");
			txtField.clear();
			passwordField.clear();
			txtField.requestFocus();
		}else {
			System.out.println(mem.getPw());
			if(mem.getPw().equals(passwordField.getText())) {
				CommonService.ErrorMsg("로그인 성공");
			}else {
				CommonService.ErrorMsg("비밀번호 실패");
				passwordField.clear();
				passwordField.requestFocus();
			}
		}
		System.out.println("id : " + txtField.getText());
		System.out.println("pwd : " + passwordField.getText());
	}

	@Override
	public void CancelProc(Parent root) {
		
		TextField id = (TextField)root.lookup("#fxId");
		id.clear();
		
		PasswordField pw = (PasswordField)root.lookup("#fxPw");
		pw.clear();
		
		CommonService service = new CommonServiceImpl();
		service.setRoot(root);
		service.WindowClose();
		
	}

	@Override
	public void OpenMembershipForm() {
		
		System.out.println("회원가입 버튼이 눌려있습니다.");
		Stage membershipForm = new Stage();
		Parent root = null;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Membership.fxml"));
		try {
			root = loader.load();
		}catch(IOException e) {
			e.printStackTrace();
		}
		membershipForm.setScene(new Scene(root));
		MemberController ctrler = loader.getController();
		ctrler.setRoot(root);
		membershipForm.show();
	}

	

}
