package kr.or.test;  //현재 날짜와 시간을 알려주는 명령어 (대소문자를 확실하게)

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatConvent {

	public static void main(String[] args) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 HH시 mm분 ss초");
		System.out.println("현재 날짜와 시간은" + sdf.format(now) + "입니다.");
		
		///여기서 코드를 작성하세요

	}

}
