package com.ay.gym.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import com.ay.gym.model.dao.GymDao;
import com.ay.gym.model.vo.Gym;
import com.ay.gym.service.GymService;
import com.ay.gym.view.GymMenu;

public class GymController {
	
	public void selectMember() {
		ArrayList<Gym> list = new GymService().selectMember();
		
		if(list.isEmpty()) {
			new GymMenu().displayNull("\n조회 결과가 없습니다.");
		}else {
			new GymMenu().displayMemberList(list);
		}
	}
	
	public void insertMember(String name, String birth, String gender, Date endDate) {
		
		int result = new GymService().insertMember(name, birth, gender, endDate);
		
		if(result > 0) {
			new GymMenu().displaySuccess("\n성공적으로 등록되었습니다.");
		}else {
			new GymMenu().displayFail("\n회원 등록에 실패하였습니다.");
		}
		
	}
	
	public void searchMember(String name) {
		ArrayList<Gym> list = new GymService().searchMember(name);
		
		if(list.isEmpty()) {
			new GymMenu().displayNull("\n조회 결과가 없습니다.");
		}else {
			new GymMenu().displayMemberList(list);
		}
	}
	
	public void updateMember(HashMap<String, Object> map) {
		
		int result = new GymService().updateMember(map);
		
		if(result > 0) {
			new GymMenu().displaySuccess("\n성공적으로 수정되었습니다.");
		}else {
			new GymMenu().displayFail("\n회원 수정에 실패하였습니다.");
		}
	}
	
	public void updateMemberEtc(HashMap<String, Object> map) {
		int result = new GymService().updateMemberEtc(map);
		
		if(result > 0) {
			new GymMenu().displaySuccess("\n성공적으로 수정되었습니다.");
		}else {
			new GymMenu().displayFail("\n회원 수정에 실패하였습니다.");
		}
	}
	
	public void deleteMember(String memNo, String name) {
		int result = new GymService().deleteMember(memNo, name);;
		
		if(result > 0) {
			new GymMenu().displaySuccess("\n성공적으로 삭제되었습니다.");
		}else {
			new GymMenu().displayFail("\n회원 삭제에 실패하였습니다.");
		}
	}

}
