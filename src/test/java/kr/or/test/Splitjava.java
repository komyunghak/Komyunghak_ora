package kr.or.test;   //문자열분리시의 방법 2가지 참고

import java.util.StringTokenizer;

public class Splitjava {

	public static void main(String[] args) {
		String str = "아이디,이름,패스워드";
		//방법 1 split()매서드 사용
		System.out.println("Split을 사용한 문자열 분리");
		String[] tokens = str.split(",");  //regex  정규식
		int cnt=0;
		for(String token:tokens) {
			System.out.println("배열["+ (cnt++)+"]" + token);
		}
		System.out.println();
		//방법2 Tokenizer 이용
		System.out.println("StringTokenizer를 이용한 문자열 분리");
		StringTokenizer st = new StringTokenizer(str,",");//위에는 str은 클래스사용자없이 바로갖다가쓸수있지만 Tokenizer은 클래스 실행명령어를 붙혀줘야한다.
		while(st.hasMoreTokens()) {   //참일때는 무조건들어가고 거짓일때는 안들어간다는 명령어이다.(값이 있다없다의 차이)
			String token = st.nextToken();
			System.out.println(token);
		}
	}

}
