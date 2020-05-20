package ex09.dao;

import ex09.Survey;

public interface DataService {
	public boolean insert(Survey survey);
	public int selectAge(int a);
	public int selectMan();
	public int selectWoman();
	public int selectTripAbroad();
	public int selectTripDomestic();
	public int selectTripNo();
	
}
