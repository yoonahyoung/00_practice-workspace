package com.ay.gym.model.vo;

import java.sql.Date;
	
public class Gym {
	
	private int memNo;			
	private String memName;
	private String birth;
	private String gender;
	private String height;
	private String weight;
	private String pt;
	private String teacher;
	private String vip;
	private Date enrollDate;
	private Date endDate;
	
	public Gym() {}
	
	/**
	 * 
	 * @param memNo			회원번호
	 * @param memName		회원명
	 * @param birth			생년월일
	 * @param gender		성별
	 * @param height		키
	 * @param weight		몸무게
	 * @param pt			PT등록여부
	 * @param teacher		담당트레이너
	 * @param vip			등급
	 * @param enrollDate	회원가입일 
	 * @param endDate		회원종료일
	 */
	public Gym(int memNo, String memName, String birth, String gender, String height, String weight, String pt,
			String teacher, String vip, Date enrollDate, Date endDate) {
		super();
		this.memNo = memNo;
		this.memName = memName;
		this.birth = birth;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.pt = pt;
		this.teacher = teacher;
		this.vip = vip;
		this.enrollDate = enrollDate;
		this.endDate = endDate;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getPt() {
		return pt;
	}

	public void setPt(String pt) {
		this.pt = pt;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getVip() {
		return vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return  "회원번호 : " + memNo + ", 회원명 : " + memName + ", 생년월일 : " + birth + ", 성별 : " + gender + ", 키 : "
				+ height + ", 몸무게 : " + weight + ", PT등록 : " + pt + ", 트레이너 : " + teacher + ", 등급 : " + vip
				+ ", 등록일 : " + enrollDate + ", 회원종료일 : " + endDate;
	}
	
	
	
	

}
