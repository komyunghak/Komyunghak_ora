package kr.or.member;

public class MemberVO {
	private String name;// 겟셋업 메서드 만드는 방법. 오른쪽마우스클릭 소스 후 겟셋업클릭후 체크 후 제네레이트 
	private int age;
	private String phoneNum;
	
	
	public int getAge() { // string 은 리턴으로 돌려받는값이기때문에 숫자를 받건가 내용을 받아야한다. 하지만 void는 받는게아닌 0 이기때문에 돌려줄 필요가 없으므로 보이드를 사용한다.
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
