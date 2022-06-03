package com.ay.gym.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ay.gym.model.vo.Gym;

public class GymDao {
	
	public ArrayList<Gym> selectMember() {
		
		ArrayList<Gym> g = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM GYM_MEM";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			pst = conn.prepareStatement(sql);
			rset = pst.executeQuery();
			
			while(rset.next()) {
				g.add(new Gym(rset.getInt("mem_no"), rset.getString("mem_name"), rset.getString("birth"),
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
		return g;
		
	}
	
	public void insertMember() {
		
	}
	
	public void searchMember() {
		
	}
	
	public void updateMember() {
		
	}
	
	public void deleteMember() {
		
	}

}
