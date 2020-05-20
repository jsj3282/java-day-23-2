package ex06.commonService;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public interface CommonService {
	public void setRoot(Parent root);
	public void WindowClose();
	public static void ErrorMsg(String ContentTxt) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("error");
		alert.setHeaderText("ÀÔ·Â Ã¢");
		alert.setContentText(ContentTxt);
	}
}
