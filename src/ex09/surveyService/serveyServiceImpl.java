package ex09.surveyService;

import java.io.IOException;

import ex09.Survey;
import ex09.eventTestController;
import ex09.viewChartController;
import ex09.commonService.CommonService;
import ex09.commonService.CommonServiceImpl;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class serveyServiceImpl implements serveyService{
	private RadioButton tripAbroad;
	private RadioButton tripDomestic;
	private RadioButton tripNo;
	private RadioButton age10;
	private RadioButton age20;
	private RadioButton age30;
	private RadioButton age40;
	private RadioButton man;
	private RadioButton woman;
	private Label labelTravel0;
	private Label labelTravel1;
	private Label labelTravel2;
	private Label labelAge0;
	private Label labelAge1;
	private Label labelAge2;
	private Label labelAge3;
	private Label labelGender0;
	private Label labelGender1;
	private Label labelSum;
	private Parent root;
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	@Override
	public void OkProc(Parent root) {
		
		Survey survey = new Survey();
		tripAbroad = (RadioButton) root.lookup("#radioTr0");
		tripDomestic = (RadioButton) root.lookup("#radioTr1");
		tripNo = (RadioButton)root.lookup("#radioTr2");
		if(tripAbroad.isSelected()) {
			survey.setLocation("해외여행");
		}else if(tripDomestic.isSelected()) {
			survey.setLocation("국내여행");
		}else if(tripNo.isSelected()) {
			survey.setLocation("없음");
		}
		labelTravel1 = (Label)root.lookup("#labelTravel0");
		age10 = (RadioButton) root.lookup("#radioAge0");
		age20 = (RadioButton) root.lookup("#radioAge1");
		age30 = (RadioButton) root.lookup("#radioAge2");
		age40 = (RadioButton) root.lookup("#radioAge3");
		if(age10.isSelected()) {
			survey.setAge("10대");
		}else if(age20.isSelected()) {
			survey.setAge("20대");
		}else if(age30.isSelected()) {
			survey.setAge("30대");
		}else if(age40.isSelected()) {
			survey.setAge("40대");
		}
	
		man = (RadioButton) root.lookup("#radioGender0");
		woman = (RadioButton) root.lookup("#radioGender1");
		if(man.isSelected()) {
			survey.setGender(true);
		}else if(woman.isSelected()) {
			survey.setGender(false);
		}
		if(checkButton()) {
			eventTestController.db.insert(survey);
			
		}else {
			
		}
	
		
	}

	@Override
	public void CancelProc(Parent root) {
		CommonService service = new CommonServiceImpl();
		service.setRoot(root);
		service.WindowClose();
		
	}

	@Override
	public void OpenResultForm() {
	
		Stage resultForm = new Stage();
		Parent root = null;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../viewChart.fxml"));
		try {
			root = loader.load();
		}catch(IOException e) {
			e.printStackTrace();
		}
		resultForm.setScene(new Scene(root));
		viewChartController ctrler = loader.getController();
		ctrler.setRoot(root);
		resultForm.show();
		labelAge0 = (Label) root.lookup("#labelAge0");
		labelAge0.setText("10대 : " + eventTestController.db.selectAge(10) + "명");
		labelAge1 = (Label)root.lookup("#labelAge1");
		labelAge1.setText("20대 : " + eventTestController.db.selectAge(20) + "명");
		labelAge2 = (Label)root.lookup("#labelAge2");
		labelAge2.setText("30대 : " + eventTestController.db.selectAge(30) + "명");
		labelAge3 = (Label)root.lookup("#labelAge3");
		labelAge3.setText("40대 : " + eventTestController.db.selectAge(40) + "명");
		labelGender0 = (Label) root.lookup("#labelGender0");
		labelGender0.setText("남성 : " + eventTestController.db.selectMan()+"명");
		labelGender1 = (Label) root.lookup("#labelGender1");
		labelGender1.setText("여성 : " + eventTestController.db.selectWoman()+"명");
		labelSum = (Label)root.lookup("#labelSum");
		labelSum.setText("설문조사 총 인원 : " + (eventTestController.db.selectMan() + eventTestController.db.selectWoman())+"명");
		labelTravel0 = (Label)root.lookup("#labelTravel0");
		labelTravel0.setText("해외여행 : " + eventTestController.db.selectTripAbroad());
		labelTravel1 = (Label)root.lookup("#labelTravel1");
		labelTravel1.setText("국내여행 : " + eventTestController.db.selectTripDomestic());
		labelTravel2 = (Label)root.lookup("#labelTravel2");
		labelTravel2.setText("없음 : " + eventTestController.db.selectTripNo());
		
	}
	private boolean checkButton() {
		if((!(tripAbroad.isSelected() || tripDomestic.isSelected() || tripNo.isSelected()))){
			Alert alert1 = new Alert(AlertType.ERROR, "가고싶은 여행지를 선택해주세요");
			alert1.setTitle("error");
			alert1.setHeaderText("입력 창");
			alert1.show();
			return false;
		}if(!(age10.isSelected() || age20.isSelected() || age30.isSelected() || age40.isSelected())) {
			Alert alert2 = new Alert(AlertType.ERROR, "연령대를 선택해주세요");
			alert2.setTitle("error");
			alert2.setHeaderText("입력 창");
			alert2.show();
			return false;
		}if(!(man.isSelected() || woman.isSelected())) {
			Alert alert3 = new Alert(AlertType.ERROR, "성별을 선택해주세요");
			alert3.setTitle("error");
			alert3.setHeaderText("입력 창");
			alert3.show();
			return false;
		}
		return true;
	}

}
