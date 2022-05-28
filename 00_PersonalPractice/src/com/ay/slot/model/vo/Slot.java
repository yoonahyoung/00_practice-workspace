package com.ay.slot.model.vo;

public class Slot {
	
	private String pic1;
	private String pic2;
	private String pic3;
	private String pic4;
	private String pic5;
	private String pic6;
	
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
	
	public void threeSlot(String pic1, String pic2, String pic3) {
		
		this.pic1 = pic1;
		this.pic2 = pic2;
		this.pic3 = pic3;
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
		String[] result = {pic1, pic2, pic3, pic4, pic5, pic6};
		
		int random = (int)(Math.random() * 6 + 1);
		
		String fin = result[random-1];
		
		
		return fin;
	}
	
	
	
}
