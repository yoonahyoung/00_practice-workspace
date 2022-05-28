package com.ay.slot.controller;

import java.util.ArrayList;

import com.ay.slot.model.vo.Slot;

public class SlotController {
	
	// 슬롯의 내용들을 담고 있는 리스트
	private ArrayList<Slot> slotList = new ArrayList<Slot>();
	{
		slotList.add(new Slot("3","7","딸기","포도","금메달", "별"));
		slotList.add(new Slot("3","7","딸기","포도","금메달", "별"));
		slotList.add(new Slot("3","7","딸기","포도","금메달", "별"));
	}
	// 전재산
	private int coin = 5000;
	//private int jackpot = 0;
	public ArrayList<Slot> playSlot() {

		// 슬롯이 차례로 나올 출력문
		// 첫번째 슬롯, 두번째 슬롯, 세번째 슬롯이 필요하기때문에 3번의 반복문을 돌림
		// 이때 toString에 random값이 나오도록 오버라이딩했기때문에 6개의 항목중 하나만 출력됨

		for (int i = 0; i < slotList.size(); i++) {
			slotList.get(i).toString();
			// 슬롯을 한번 돌릴때마다 300원씩 차감
			coin -= 100;
		}
		
		return slotList;
	}
	
	public int resultSlot() {

		// jackpot == 1 당첨
		int jackpot = 0;
		// 첫번째 인덱스를 나머지 두개와 비교해서 일치하면 1이 쌓이도록
		// 첫번째 인덱스를 담을 original변수
		Slot original = slotList.get(0);
		if (original.equals(slotList.get(1)) && original.equals(slotList.get(2))) {
			jackpot++;
		}
		
		// jackpot이 1이면 당첨이라 1000원 추가
		if (jackpot == 1) {
			coin += 1000;
		}
		
		return jackpot;
	};
	
	// 잔고 출력
	public int myPage() {
		return coin;
	}
	
	// 로또구매
	public int lotto() {
		// 로또 1~30까지의 랜덤숫자뽑기
		int random = (int)(Math.random() * 30 + 1);
		// 복권 구매로 인한 500원 차감
		coin -= 500;
		
		// 랜덤값에 의한 등수 당첨결과
		switch(random) {
			case 1: 
					coin += 100000; break;
			case 2: 
					coin += 50000; break;
			case 3: 
					coin += 10000; break;
			case 4: 
					coin += 5000; break;
			case 5: 
					coin += 1000; break;
			default : // 1~5등이 아니면 모두 꽝이 되도록
					break;
		}
		
		return random;
	}

}
