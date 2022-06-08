package com.ay.gym.service;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import static com.ay.gym.common.JDBCTemplate.*;
import com.ay.gym.model.dao.GymDao;
import com.ay.gym.model.vo.Gym;

public class GymService {

	public ArrayList<Gym> selectMember() {
		Connection conn = getConnection();
		ArrayList<Gym> list = new GymDao().selectMember(conn);
		
		close(conn);
		
		return list;
	}

	public int insertMember(String name, String birth, String gender, Date endDate) {
		Connection conn = getConnection();
		int result = new GymDao().insertMember(conn, name, birth, gender, endDate);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public ArrayList<Gym> searchMember(String name) {
		Connection conn = getConnection();
		ArrayList<Gym> list = new GymDao().searchMember(name, conn);
		
		close(conn);
		
		return list;
	}

	public int updateMember(HashMap<String, Object> map) {
		Connection conn = getConnection();
		int result = new GymDao().updateMember(map, conn);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}

	public int updateMemberEtc(HashMap<String, Object> map) {
		Connection conn = getConnection();
		int result = new GymDao().updateMemberEtc(map, conn);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int deleteMember(String memNo, String name) {
		Connection conn = getConnection();
		int result = new GymDao().deleteMember(memNo, name, conn);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	

}
