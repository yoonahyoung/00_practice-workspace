package com.ay.gym.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.ay.gym.model.vo.Gym;

public class GymDao {
	
	public ArrayList<Gym> selectMember() {
		
		ArrayList<Gym> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM GYM_MEM";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "GYM", "GYM");
			pst = conn.prepareStatement(sql);
			rset = pst.executeQuery();
			
			while(rset.next()) {
				list.add(new Gym(rset.getInt("mem_no"), rset.getString("mem_name"), rset.getString("birth"),
							  rset.getString("gender"), rset.getString("height"), rset.getString("weight"),
							  rset.getString("pt"), rset.getString("teacher"), rset.getString("vip"),
							  rset.getDate("enroll_date"), rset.getDate("end_date")));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
		
	}
	
	public int insertMember(String name, String birth, String gender, Date endDate) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pst = null;
		
		String sql = "INSERT INTO GYM_MEM(MEM_NO, MEM_NAME, BIRTH, GENDER, END_DATE) VALUES(SEQ_MEMNO.NEXTVAL, ?, ?, ?, ?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "GYM", "GYM");
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, name);
			pst.setString(2, birth);
			pst.setString(3, gender);
			pst.setDate(4, endDate);
			
			
			result = pst.executeUpdate();
			
			if(result > 0 ) {
				conn.commit();
			}else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return result;
	}
	
	public ArrayList<Gym> searchMember(String name) {
		ArrayList<Gym> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM GYM_MEM WHERE MEM_NAME = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "GYM", "GYM");
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, name);
			
			rset = pst.executeQuery();
			
			while(rset.next()) {
				list.add(new Gym(rset.getInt("mem_no"), rset.getString("mem_name"), rset.getString("birth"),
							  rset.getString("gender"), rset.getString("height"), rset.getString("weight"),
							  rset.getString("pt"), rset.getString("teacher"), rset.getString("vip"),
							  rset.getDate("enroll_date"), rset.getDate("end_date")));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
		
	}
	
	public int updateMember(HashMap<String, Object> map) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pst = null;
		
		String sql = "UPDATE GYM_MEM SET MEM_NAME = ?, BIRTH = ?, GENDER = ?, END_DATE = ? WHERE MEM_NO = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "GYM", "GYM");
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, (String) map.get("이름"));
			pst.setString(2, (String)map.get("생년월일"));
			pst.setString(3, (String)map.get("성별"));
			pst.setDate(4, (Date)map.get("종료일"));
			pst.setString(5, (String)map.get("회원번호"));
			
			result = pst.executeUpdate();
			
			if(result > 0 ) {
				conn.commit();
			}else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return result;
	}
	
	public int updateMemberEtc(HashMap<String, Object> map) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pst = null;
		
		String sql = "UPDATE GYM_MEM SET HEIGHT = ?, WEIGHT = ?, PT = ?, TEACHER = ?, VIP = ? WHERE MEM_NO = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "GYM", "GYM");
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, (String)map.get("키"));
			pst.setString(2, (String)map.get("몸무게"));
			pst.setString(3, (String)map.get("PT"));
			pst.setString(4, (String)map.get("트레이너"));
			pst.setString(5, (String)map.get("등급"));
			pst.setString(6, (String)map.get("회원번호"));
			
			result = pst.executeUpdate();
			
			if(result > 0 ) {
				conn.commit();
			}else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public int deleteMember(String memNo, String name) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pst = null;
		
		String sql = "DELETE FROM GYM_MEM WHERE MEM_NO = ? AND MEM_NAME = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "GYM", "GYM");
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, memNo);
			pst.setString(2, name);
			
			result = pst.executeUpdate();
			
			if(result > 0 ) {
				conn.commit();
			}else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	

}
