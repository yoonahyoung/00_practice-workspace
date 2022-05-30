package com.ay.codeUp.question;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Q {
	
	public void q0530() {
		
		// 1015
		Scanner sc = new Scanner(System.in);
		System.out.print("실수 1개 입력 : ");
		float f = sc.nextFloat();
		System.out.printf("%.2f", f);
		
		sc.nextLine();
		System.out.println();
		
		// 1017
		System.out.print("정수 1개 입력 : ");
		int num = sc.nextInt();
		System.out.printf("%d %d %d", num, num, num);
	}
	
	public void q0531() {
		
		// 1018
		// 단순출력하는 간단한 코드
		Scanner sc = new Scanner(System.in);
		System.out.println(sc.nextLine()); 
		
		// split으로 각각 분, 초 변수에 담아서 출력
		String[] hm = sc.nextLine().split(":");
		int h = Integer.parseInt(hm[0]);
		int m = Integer.parseInt(hm[1]);
		System.out.println(h + " : " + m);
		
		
		// 1019
		// 입력받은 데이터를 split으로 분리
		String[] date = sc.nextLine().split("\\.");
		// 분리된 데이터를 숫자로 변환
		int year = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1]);
		int day = Integer.parseInt(date[2]);
		// 각 년,월,일을 Date변수에 넣어주기
		Date date1 = new Date(year-1900, month-1, day);
		//SimpleDateFormat클래스를 이용해 원하는 형식으로 출력
		SimpleDateFormat date2 = new SimpleDateFormat("yyyy.MM.dd");
		System.out.println(date2.format(date1));
	}
	
	
}
