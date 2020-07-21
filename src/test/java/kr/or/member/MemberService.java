package kr.or.member;

import kr.or.member.MemberVO;

public class MemberService {
	//액션-서비스 클래스 - 출력용 메서드 작성
	//매개변수로 배열을 받아서 출력하는 형태로 작성
	public void printMembers(MemberVO[] members) { //Members 앞에 현재는 print가 붙었지만  insert,delete,update 등등이 붙을수도있다.
		//향상된 for(loop)문 사용  (형태:단일값  : 전체값)
		for(MemberVO m : members) { // members에서 m을 MemberVO를 뽑아쓴다라는 의미
		System.out.println("이름은:" + m.getName() + " | 나이는:" +m.getAge()+" | 전화번호는:" + m.getPhoneNum());
			}
		}
}
