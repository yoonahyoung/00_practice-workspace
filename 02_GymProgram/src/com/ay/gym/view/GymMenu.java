package com.ay.gym.view;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.ay.gym.controller.GymController;
import com.ay.gym.model.vo.Gym;

public class GymMenu {
	
	private Scanner sc = new Scanner(System.in);
	private GymController gc = new GymController();
	SimpleDateFormat formatter = new SimpleDateFormat("yy/MM/dd");
	
	public void mainMenu() {
		
		while(true) {
			System.out.println("\n=== GYM 회원 관리 프로그램 ===");
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
			case 1: gc.selectMember(); break; 
			case 2: insertMember(); break;
			case 3: gc.searchMember(searchMember()); break;
			case 4: updateMember(); break;
			case 5: deleteMember(); break;
			case 0: System.out.println("프로그램을 종료하시겠습니까?\n   1. 확인     2. 취소"); 
					if(sc.nextInt() == 1) { // 종료버튼 누를시 한번 더 확인하기
						System.out.println("프로그램이 종료됩니다.");
						return;
					}else {
						break;
					}
			default : System.out.println("잘못 입력하셨습니다. 다시 입력하세요."); break;
				
			}
			
		}
		
	}

	// 회원 등록
	public void insertMember() {
		System.out.print("\n회원명 : ");
		String name = sc.nextLine();
		System.out.print("생년월일(xx/xx/xx) : ");
		String birth = sc.nextLine();
		System.out.print("성별(여/남) : ");
		String gender = sc.nextLine();
		System.out.print("회원권 종료일(yyyy/mm/dd) : ");
		String[] strDate = sc.nextLine().split("/");
		
		Date endDate = new Date(Integer.parseInt(strDate[0])-1900, Integer.parseInt(strDate[1])-1, Integer.parseInt(strDate[2]));
		gc.insertMember(name, birth, gender, endDate);
		
	}
	
	// 회원 검색
	public String searchMember() {
		System.out.print("\n회원명 : ");
		return sc.nextLine();
	}
	// 회원 정보 수정
	public void updateMember() {
		System.out.println("\n1) 기본 정보 수정");
		System.out.println("2) 부가 정보 수정");
		System.out.print("메뉴 선택 >> ");
		int num = sc.nextInt();
		sc.nextLine();
		
		// 기본정보 (회원명, 생년월일, 성별, 회원권 종료일) 수정
		if(num == 1) {
			System.out.print("\n회원번호 : ");
			String memNo =  sc.nextLine();
			System.out.print("회원명 : ");
			String name = sc.nextLine();
			System.out.print("생년월일(xx/xx/xx) : ");
			String birth = sc.nextLine();
			System.out.print("성별(여/남) : ");
			String gender = sc.nextLine();
			System.out.print("회원권 종료일(yyyy/mm/dd) : ");
			String[] strDate = sc.nextLine().split("/");
			Date endDate = new Date(Integer.parseInt(strDate[0])-1900, Integer.parseInt(strDate[1])-1, Integer.parseInt(strDate[2]));
			
			HashMap<String, Object> map = new HashMap<>();
			map.put("회원번호", memNo);
			map.put("이름", name);
			map.put("생년월일", birth);
			map.put("성별", gender);
			map.put("종료일", endDate);
			
			gc.updateMember(map);
			
		// 부가정보 (키, 몸무게, PT등록, 트레이너, 등급) 수정
		}else if(num == 2) {
			System.out.print("\n회원번호 : ");
			String memNo =  sc.nextLine();
			System.out.print("키 : ");
			String height = sc.nextLine();
			System.out.print("몸무게 : ");
			String weight = sc.nextLine();
			System.out.print("PT등록(Y/N) : ");
			String pt = sc.nextLine().toUpperCase();
			System.out.print("트레이너 : ");
			String teacher = sc.nextLine();
			System.out.print("등급 : ");
			String vip = sc.nextLine().toUpperCase();
			
			HashMap<String, Object> map = new HashMap<>();
			map.put("회원번호", memNo);
			map.put("키", height);
			map.put("몸무게", weight);
			map.put("PT", pt);
			map.put("트레이너", teacher);
			map.put("등급", vip);
			
			gc.updateMemberEtc(map);
		}else {
			System.out.println("\n잘못입력하셨습니다.");
		}
		
	}
	
	// 회원삭제 
	public void deleteMember() {
		System.out.print("회원번호 : ");
		String memNo = sc.nextLine();
		System.out.print("회원명 : ");
		String name = sc.nextLine();
		
		gc.deleteMember(memNo, name);
	}
	
	
	
	// ----------------------------- 응답화면 -----------------------------
	// 데이터가 없을시
	public void displayNull(String noData) {
		System.out.println(noData);
	}
	// 목록 조회 결과
	public void displayMemberList(ArrayList<Gym> list) {
		System.out.println("\n조회 결과 입니다.\n");
		
		for(Gym g : list) {
			System.out.println(g);
		}
	}
	// 등록 및 변경에 성공하였을시
	public void displaySuccess(String success) {
		System.out.println(success);
	}

	// 등록 및 변경에 실패하였을시
	public void displayFail(String fail) {
		System.out.println(fail);
	}
	
}
