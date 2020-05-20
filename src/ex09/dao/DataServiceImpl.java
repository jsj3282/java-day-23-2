package ex09.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ex06.Member;
import ex09.Survey;

public class DataServiceImpl implements DataService{
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private String url = "jdbc:oracle:thin:@192.168.0.14:1521:xe";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String user = "java001";
	private String pwd = "1234";
	
	@Override
	public boolean insert(Survey survey) {
		String sql = "insert into survey(location, age, gender) values(?, ?, ?)";
		int gender = 0;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			ps = con.prepareStatement(sql);
			ps.setString(1, survey.getLocation());
			ps.setString(2, survey.getAge());
			if(survey.isGender()) {
				gender = 0;
			}else {
				gender = 1;
			}
			ps.setInt(3,  gender);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}

	@Override
	public int selectAge(int a) {
		System.out.println(a);
		String sql = "select count(age) from survey where age = '"+a+"대'";
		//select count(age) from survey where age = '10대'
		int age = 0;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				age = rs.getInt(1);
			}else {
				age = 0;
			}
			System.out.println(age);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
		return age;
	}

	@Override
	public int selectMan() {
		String sql = "select count(gender) from survey where gender = 1";
		int man = 0;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				man = rs.getInt(1);
			}else {
				man = 0;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			return  0;
		}
		return man;
	}

	@Override
	public int selectWoman() {
		String sql = "select count(gender) from survey where gender = 0";
		int woman = 0;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				woman = rs.getInt(1);
			}else {
				woman = 0;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return woman;
	}

	@Override
	public int selectTripAbroad() {
		String sql = "select count(location) from survey where location = '해외여행'";
		int tripAbroad = 0;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				tripAbroad = rs.getInt(1);
			}else {
				tripAbroad = 0;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return tripAbroad;
	}

	@Override
	public int selectTripDomestic() {
		String sql = "select count(location) from survey where location = '국내여행'";
		int tripDomestic;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				tripDomestic = rs.getInt(1);
			}else {
				tripDomestic = 0;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return tripDomestic;
	}

	@Override
	public int selectTripNo() {
		String sql = "select count(location) from survey where location = '없음'";
		int tripNo;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				tripNo = rs.getInt(1);
			}else {
				tripNo = 0;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return tripNo;
	}
	

}
