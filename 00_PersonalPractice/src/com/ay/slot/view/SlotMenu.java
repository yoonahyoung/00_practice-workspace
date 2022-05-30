package com.ay.slot.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.ay.slot.controller.SlotController;
import com.ay.slot.model.vo.Slot;

public class SlotMenu {
	// SlotController의 메소드들을 사용하기 위한 레퍼런스
	private SlotController slot = new SlotController();
	// 사용자에게 코인입력받기 위함
	private Scanner sc = new Scanner(System.in); 
	
	public void mainMenu() {
		
		while (true) {
			// 기계의 메인화면

			System.out.println("§============ Welcome to SlotMachine =============§");
			System.out.println("§               ※초기 자금은 5000원입니다※              §");
			System.out.println("§--------------------- 메뉴 선택 --------------------§");
			System.out.println("§   1. 슬롯 돌리기 (300원)                             §");
			System.out.println("§   2. 전재산 확인하기                                 §");
			System.out.println("§   3. 복권 구매 (500원)                              §");
			System.out.println("§   0. 종료하기                                      §");
			System.out.println("§=================================================§");
			System.out.print(">> 메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1: playSlot(); break; 
			case 2: myPage(); break;
			case 3: lotto(); break;
			case 0: {
					System.out.println("\n지금 종료하시면 저장되지 않습니다. 종료하시겠습니까?"); //종료 한번 더 묻기 
					System.out.println("1. 종료    | 2. 취소   \n");
					System.out.print("입력 : ");
					int exit = sc.nextInt();
					
					sc.nextLine();
						if(exit==1) { //1번 누를시 프로그램 종료
							System.out.println("\n프로그램을 종료합니다.\n"); return;
						}else if(exit==2) { //2번 누를시 메뉴화면
							System.out.println("\n다시 메뉴화면으로 돌아갑니다.\n");break;
						}else{ // 1번도 2번도 아닐 시 메뉴화면
							System.out.println("\n잘못입력하였습니다. 메뉴화면으로 돌아갑니다.\n"); break;
						}
					}
			default: System.out.println("\n잘못입력하였습니다. 다시 입력해주세요.\n"); break;
			}
			
		}
	}
	// 슬롯돌리기
	public void playSlot() {
		//세개의 슬롯값을 받음
		String slotArr = slot.playSlot();
		String[] returnSlot = slotArr.split(",");
		
		//ArrayList<Slot> slotArr = slot.playSlot();
		//슬롯을 차례로 출력하기
		if(returnSlot[3].equals("1")) {
			System.out.println("\n금액이 부족합니다. 메뉴화면으로 돌아갑니다.\n");
		}else {
			System.out.println();
			for(int i=0; i<returnSlot.length-1; i++) {
				System.out.print(returnSlot[i]);
		}
		System.out.println("\n");
		// 결과값에 대한 당첨 유무를 확인하기 위해 resultSlot 호출
		slot.resultSlot();
		}
	}
	// 슬롯 당첨유무
	public void resultSlot() {
		// 당첨결과를 받을 jackpot변수
		int jackpot = slot.resultSlot();
		// jackpot이 1이면 당첨 아니면 미당첨
		if (jackpot == 1) {
			System.out.println("\n★앗싸! 당첨★ 천원을 벌었다!\n");
		}else {
			System.out.println("\n 당첨되지 않았습니다! 다음 기회를 노려보세요!\n");
		}
	}
	// 잔고확인
	public void myPage() {
		// 현재 잔고를 넘겨받을 coin변수
		int coin = slot.myPage();
		// 잔고 출력
		System.out.println("\n현재 내가 가진 돈은 .. " + coin + "원이다.\n");
		 
	}
	// 로또구매
	public void lotto() {
		// 로또의 결과를 넘겨받을 random변수
		int random = slot.lotto();
		
		// random변수의 값에 따른 결과 출력
		switch(random) {
		case 1: System.out.println("\n1등 당첨!! 상금 100,000원 입금완.\n");
				break;
		case 2: System.out.println("\n2등 당첨!! 상금 50,000원 입금완.\n");
				break;
		case 3: System.out.println("\n3등 당첨!! 상금 10,000원 입금완.\n");
				break;
		case 4: System.out.println("\n4등 당첨!! 상금 5,000원 입금완.\n");
				break;
		case 5: System.out.println("\n5등 당첨!! 상금 1,000원 입금완.\n");
				break;
		default : System.out.println("\n꽝!꽝꽝!!꽝꽝꽝!!!꽝철인데요!!!\n");
				break;
	}
	}
}
