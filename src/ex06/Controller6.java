package ex06;

import java.net.URL;
import java.util.ResourceBundle;

import ex06.dao.DatabaseServiceImpl;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Controller6 implements Initializable{
	private Parent root;
	private LoginService loginService;
	public static DatabaseServiceImpl db;
	
	static {
		try {
			db = new DatabaseServiceImpl();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void initialize(URL location, ResourceBundle resources) {
		loginService = new LoginServiceImpl();
		System.out.println("Controller==========");
		
	}
	
	public void LoginProc() {
		loginService.LoginProc(root);
		System.out.println("controller ·Î±×ÀÎ");
		
	}
	
	public void CancelProc() {
		loginService.CancelProc(root);
		System.out.println("controller Äµ½½");
	}
	public void OpenMemberShipForm()  {
		loginService.OpenMembershipForm();
		System.out.println("controller ¸â¹ö");
		/*
		Stage membershipForm = new Stage();
		//Parent parent = null;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Membership.fxml"));
		try {
			//parent = loader.load();
			root = loader.load();
		}catch(IOException e) {
			e.printStackTrace();
		}
		//membershipForm.setScene(new Scene(parent));
		membershipForm.setScene(new Scene(root));
		membershipForm.show();
		*/
	}
	
	
}
