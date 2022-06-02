package com.ay.slot.model.vo;

public class Slot {
	
	private String pic1;
	private String pic2;
	private String pic3;
	private String pic4;
	private String pic5;
	private String pic6;
	private Slot slot1;
	private Slot slot2;
	private Slot slot3;
	
	public Slot() {
		
	}
	
	
	public Slot(String pic1, String pic2, String pic3, String pic4, String pic5, String pic6) {
		
		this.pic1 = pic1;
		this.pic2 = pic2;
		this.pic3 = pic3;
		this.pic4 = pic4;
		this.pic5 = pic5;
		this.pic6 = pic6;
	}
	
	public Slot(Slot slot1, Slot slot2, Slot slot3) {
		
		this.slot1 = slot1;
		this.slot2 = slot2;
		this.slot3 = slot3;
	}
	
	

	public Slot getSlot1() {
		return slot1;
	}


	public void setSlot1(Slot slot1) {
		this.slot1 = slot1;
	}


	public Slot getSlot2() {
		return slot2;
	}


	public void setSlot2(Slot slot2) {
		this.slot2 = slot2;
	}


	public Slot getSlot3() {
		return slot3;
	}


	public void setSlot3(Slot slot3) {
		this.slot3 = slot3;
	}


	public String getPic1() {
		return pic1;
	}

	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}

	public String getPic2() {
		return pic2;
	}

	public void setPic2(String pic2) {
		this.pic2 = pic2;
	}

	public String getPic3() {
		return pic3;
	}

	public void setPic3(String pic3) {
		this.pic3 = pic3;
	}

	public String getPic4() {
		return pic4;
	}

	public void setPic4(String pic4) {
		this.pic4 = pic4;
	}

	public String getPic5() {
		return pic5;
	}

	public void setPic5(String pic5) {
		this.pic5 = pic5;
	}

	public String getPic6() {
		return pic6;
	}

	public void setPic6(String pic6) {
		this.pic6 = pic6;
	}

	
	 @Override
	public String toString() {
		//랜덤값을 여기서 발생시키지말고 컨트롤러에서 발생시키기
		//여기서 랜덤값 생성시 실행될때마다 계속 랜덤값이 나오기때문에 return할때마다 값이 다르게 출력됨
		
		String[] result = {pic1, pic2, pic3, pic4, pic5, pic6};
		
		int random = (int)(Math.random() * 6 + 1);
		
		String fin = result[random-1];
		
		
		return fin;
	}
		
	 
	
	
	
	
}
