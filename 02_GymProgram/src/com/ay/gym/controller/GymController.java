package com.ay.gym.controller;

import java.util.ArrayList;

import com.ay.gym.model.dao.GymDao;
import com.ay.gym.model.vo.Gym;
import com.ay.gym.view.GymMenu;

public class GymController {
	
	public void selectMember() {
		ArrayList<Gym> g = new GymDao().selectMember();
		
		if(g.isEmpty()) {
			new GymMenu().displayNull("조회 결과가 없습니다.");
		}else {
			new GymMenu().displayMemberList(g);
			
		}
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
