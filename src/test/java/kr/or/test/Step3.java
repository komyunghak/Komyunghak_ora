package kr.or.test;

import java.util.Calendar;

public class Step3 {

	public static void main(String[] args) {
		System.out.println("외부 라이브러리를 사용한 열거형 자료형 소스");
		//열거형-enum
		Week today = null;  //
		Calendar cal = Calendar.getInstance();  // new calendar와 같은의미지만 카렌다는 특별하게 겟인스탄스를 사용한다.
		int week = cal.get(Calendar.DAY_OF_WEEK);
		switch(week) {
		case 1:
			today = Week.일; break;
		case 2:
			today = Week.월; break;
		case 3:
			today = Week.화; break;
		case 4:
			today = Week.수; break;
		case 5:
			today = Week.목; break;
		case 6:
			today = Week.금; break;
		case 7:
			today = Week.토; break;
		}
System.out.println("오늘은: "+ today + "요일 입니다");
		
		if(today == Week.수) {
			System.out.println("수요일에는 축구를 합니다.");
		} else {
			System.out.println("열심히 자바 공부합니다.");
	}
	}
}
