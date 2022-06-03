package com.ay.gym.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.ay.gym.controller.GymController;
import com.ay.gym.model.vo.Gym;

public class GymMenu {
	
	private Scanner sc = new Scanner(System.in);
	private GymController gc = new GymController();
	
	public void mainMenu() {
		
		while(true) {
			System.out.println("\n=== 회원 관리 프로그램 ===");
			System.out.println("1. 전체 회원 조회");
			System.out.println("2. 회원 등록");
			System.out.println("3. 회원 검색");
			System.out.println("4. 회원 수정");
			System.out.println("5. 회원 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("원하는 메뉴를 입력하세요 >> ");
			int num = sc.nextInt();
			sc.nextLine();
			
			switch(num) { // 메뉴를 입력받을 실행되는 기능
			case 1: selectMember(); break; 
			case 2: insertMember(); break;
			case 3: searchMember(); break;
			case 4: updateMember(); break;
			case 5: deleteMember(); break;
			case 0: System.out.println("프로그램을 종료하시겠습니까?\n   1. 확인     2. 취소"); 
					if(sc.nextInt() == 1) { // 종료버튼 누를시 한번 더 확인하기
						return;
					}else {
						break;
					}
			default : System.out.println("잘못 입력하셨습니다. 다시 입력하세요."); break;
				
			}
			
		}
		
	}

	// 1번 메뉴
	public void selectMember() {
		new GymController().selectMember();
	}
	
	public void insertMember() {
		
	}
	
	public void searchMember() {
		
	}
	
	public void updateMember() {
		
	}
	
	public void deleteMember() {
		
	}
	
	
	
	// ----------------------------- 응답화면 -----------------------------
	public void displayNull(String noData) {
		System.out.println("조회 완료" + noData);
	}
	
	public void displayMemberList(ArrayList<Gym> g) {
		System.out.println("조회된 결과");
		
		for(Gym gy : g) {
			System.out.println(gy);
		}
		
	}
	
}
