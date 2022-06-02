package com.ay.slot.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.ay.slot.model.vo.Slot;

public class SlotController {

	// 슬롯의 내용들을 담고 있는 리스트
	private ArrayList<String> slotList = new ArrayList<>();
	{
		slotList.add("3");
		slotList.add("7");
		slotList.add("딸기");
		slotList.add("포도");
		slotList.add("금메달");
		slotList.add("별");
	}

	// 전재산
	private int coin = 5000;

	public HashMap<String, Object> playSlot() {

		int noCoin = 0;
		int jackPot = 0; // jackPot이 1이 되면 당첨
		String[] lastSlot = new String[3];
		// 코인이 300원 미만일시 playslot불가
		if (coin < 300) {
			noCoin++;
		} else {
			// 슬롯을 돌릴때마다 300원 차감되고 시작
			coin -= 300;
			// 슬롯이 차례로 나올 출력문
			// 랜덤값 발생시켜서 출력시키기
			int random1 = (int) (Math.random() * 6 + 1);
			int random2 = (int) (Math.random() * 6 + 1);
			int random3 = (int) (Math.random() * 6 + 1);

			// lastSlot에 결과 담기
			lastSlot[0] = slotList.get(random1 - 1);
			lastSlot[1] = slotList.get(random2 - 1);
			lastSlot[2] = slotList.get(random3 - 1);

			// lastSlot의 1번째 인덱스와 2,3번째 인덱스 비교하여 전부 일치하면 jackPot++
			if (lastSlot[0].equals(lastSlot[1]) && lastSlot[0].equals(lastSlot[2])) {
				jackPot++;
				coin += 3000;
			}
			;
		}

		HashMap<String, Object> map = new HashMap<>();
		map.put("lastSlot", lastSlot);
		map.put("noCoin", noCoin);
		map.put("jackPot", jackPot);

		return map;
	}

	// 잔고 출력
	public int myPage() {
		return coin;
	}

	// 로또구매
	public HashMap<String, Object> lotto() {
		// 로또 1~30까지의 랜덤숫자뽑기
		int random = (int) (Math.random() * 30 + 1);
		// coin이 500원 미만시 lotto불가
		int noCoin = 0;

		if (coin < 500) {
			noCoin++;
		} else {
			// 복권 구매로 인한 500원 차감
			coin -= 500;
			// 랜덤값에 의한 등수 당첨결과
			switch (random) {
			case 1:
				coin += 100000;
				break;
			case 2:
				coin += 50000;
				break;
			case 3:
				coin += 10000;
				break;
			case 4:
				coin += 5000;
				break;
			case 5:
				coin += 1000;
				break;
			default: // 1~5등이 아니면 모두 꽝이 되도록
				break;
			}
		}
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("코인", noCoin);
		map.put("등수", random);
		
		return map;
	}

}
