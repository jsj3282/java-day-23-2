package ex09;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

public class viewChartController implements Initializable {
	@FXML private PieChart pieChart;
	@FXML private BarChart barChart;
	@FXML private AreaChart areaChart;
	private Parent root;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pieChart.setData(FXCollections.observableArrayList(
	            new PieChart.Data("10��",eventTestController.db.selectAge(10)),
	            new PieChart.Data("20��",eventTestController.db.selectAge(20)),
	            new PieChart.Data("30��",eventTestController.db.selectAge(30)),
	            new PieChart.Data("40��",eventTestController.db.selectAge(40))
	      ));
	      
	      XYChart.Series series1 = new XYChart.Series();
	      series1.setName("����");
	      series1.setData(FXCollections.observableArrayList(
	         new XYChart.Data("���� �������� ����",eventTestController.db.selectMan())
	      ));
	      XYChart.Series series2 = new XYChart.Series();
	      series2.setName("����");
	      series2.setData(FXCollections.observableArrayList(
	         new XYChart.Data("���� �������� ����",eventTestController.db.selectWoman())
	      ));
	      
	      barChart.getData().add(series1);
	      barChart.getData().add(series2);
	      
	      XYChart.Series series3 = new XYChart.Series();
	      series3.setName("������� ������");
	      series3.setData(FXCollections.observableArrayList(
	         new XYChart.Data("�ؿܿ���",eventTestController.db.selectTripAbroad()),
	         new XYChart.Data("��������",eventTestController.db.selectTripDomestic()),
	         new XYChart.Data("����",eventTestController.db.selectTripNo())
	      ));
	      areaChart.getData().add(series3);
		
	}
	public void setRoot(Parent root) {
		this.root = root;		
	}

}
