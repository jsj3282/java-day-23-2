package ex09;

import java.net.URL;
import java.util.ResourceBundle;

import ex06.LoginService;
import ex09.dao.DataServiceImpl;
import ex09.surveyService.serveyService;
import ex09.surveyService.serveyServiceImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;


public class eventTestController implements Initializable{
	private Parent root;
	public static DataServiceImpl db;
	private serveyService surveyService;
	static {
		try {
			db = new DataServiceImpl();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	public void setRoot(Parent root) {
		this.root = root;
		
	}
	public void OkProc() {
		surveyService = new serveyServiceImpl();
		surveyService.OkProc(root);
	}
	public void CancelProc() {
		surveyService = new serveyServiceImpl();
		surveyService.CancelProc(root);
	}
	public void OpenResultForm() {
		surveyService = new serveyServiceImpl();
		surveyService.OpenResultForm();
	}
	
}
