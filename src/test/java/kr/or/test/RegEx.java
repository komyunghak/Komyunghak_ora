package kr.or.test;  // 회원가입시 아이디 중복확인시 나오는 오류내용

import java.util.regex.Pattern;

public class RegEx {

 public static void main(String[] args) {
  String id = "a1234567890";    //3~4면 에러가나오며, 8~12글자를 만들면 아이디가 생성가능하다.
  String regExp = "[a-zA-Z][a-zA-Z0-9]{8,12}";
  boolean isMatch = Pattern.matches(regExp, id);
  if(isMatch) {
   System.out.println("아이디로 사용가능 합니다.");
  }else {
    System.out.println("아이디는 최소 8자 최대 12자까지 가능합니다. 영문 소문자 사용 가능합니다.");
    
   }
  }

 }