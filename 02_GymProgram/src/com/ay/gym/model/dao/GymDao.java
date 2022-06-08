package com.ay.gym.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import static com.ay.gym.common.JDBCTemplate.*;
import com.ay.gym.model.vo.Gym;

public class GymDao {
	
	Properties prop = new Properties();
	
	public GymDao(){
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Gym> selectMember(Connection conn) {
		ArrayList<Gym> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Gym(rset.getInt("mem_no"), rset.getString("mem_name"), rset.getString("birth"),
							  rset.getString("gender"), rset.getString("height"), rset.getString("weight"),
							  rset.getString("pt"), rset.getString("teacher"), rset.getString("vip"),
							  rset.getDate("enroll_date"), rset.getDate("end_date")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}
	
	public int insertMember(Connection conn, String name, String birth, String gender, Date endDate) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, birth);
			pstmt.setString(3, gender);
			pstmt.setDate(4, endDate);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	public ArrayList<Gym> searchMember(String name, Connection conn) {
		ArrayList<Gym> list = new ArrayList<>();
		PreparedStatement pst = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchMember");
		
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, "%" + name + "%");
			
			rset = pst.executeQuery();
			
			while(rset.next()) {
				list.add(new Gym(rset.getInt("mem_no"), rset.getString("mem_name"), rset.getString("birth"),
							  rset.getString("gender"), rset.getString("height"), rset.getString("weight"),
							  rset.getString("pt"), rset.getString("teacher"), rset.getString("vip"),
							  rset.getDate("enroll_date"), rset.getDate("end_date")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pst);
		}
		
		return list;
		
	}
	
	public int updateMember(HashMap<String, Object> map, Connection conn) {
		int result = 0;
		PreparedStatement pst = null;
		String sql = prop.getProperty("updateMember");
		
		try {
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
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pst);
		}
		return result;
	}
	
	public int updateMemberEtc(HashMap<String, Object> map, Connection conn) {
		int result = 0;
		PreparedStatement pst = null;
		
		String sql = prop.getProperty("updateMemberEtc");
		
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, (String)map.get("키"));
			pst.setString(2, (String)map.get("몸무게"));
			pst.setString(3, (String)map.get("PT"));
			pst.setString(4, (String)map.get("트레이너"));
			pst.setString(5, (String)map.get("등급"));
			pst.setString(6, (String)map.get("회원번호"));
			
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pst);
		}
		
		return result;
	}
	
	public int deleteMember(String memNo, String name, Connection conn) {
		int result = 0;
		PreparedStatement pst = null;
		
		String sql = prop.getProperty("deleteMember");
		
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, memNo);
			pst.setString(2, name);
			
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pst);
		}
		
		return result;
	}

	

}
