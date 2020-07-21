package kr.or.test;

class MemberVO { //VO(ValueObect)클래스형 자료  또 다른것은 BoradVO
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
	@Override
	public String toString() {
		return "MemberVO [name=" + name + ", age=" + age + ", phoneNum=" + phoneNum + "]";
	}
	
}
class MemberService {
	//액션-서비스 클래스 - 출력용 메서드 작성
	//매개변수로 배열을 받아서 출력하는 형태로 작성
	public void printMembers(MemberVO[] members) { //Members 앞에 현재는 print가 붙었지만  insert,delete,update 등등이 붙을수도있다.
		//향상된 for(loop)문 사용  (형태:단일값  : 전체값)
		for(MemberVO m : members) { // members에서 m을 MemberVO를 뽑아쓴다라는 의미
		System.out.println("이름은:" + m.getName() + " | 나이는:" +m.getAge()+" | 전화번호는:" + m.getPhoneNum());
		}
	}
}
public class Step2 {

	public static void main(String[] args) { //클래스형 변수(사용자정의 자료형)
		System.out.println("클래스형 변수(사용자정의 자료형)");
		//MemberVO 클래스를 실행하기 위해 new 연산자 사용
		MemberVO m1 = new MemberVO();
		//setter 메서드를 이용해 해당 인스턴스(클래스) 변수(필드)에 값을 넣는다.
		m1.setName("홍길동");
		m1.setAge(45);
		m1.setPhoneNum("000-0000-0000");
		//마찬가지로 다른 MeberVO객체(instance)를 생성해서 값을 얻는다.
		MemberVO m2 = new MemberVO();
		m2.setName("성춘향");
		m2.setAge(100);
		m2.setPhoneNum("111-1111-1111");
		MemberVO m3 = new MemberVO();
		m3.setName("각시탈");
		m3.setAge(3);
		m3.setPhoneNum("222-2222-2222");
		//크기가 3인 MemberVO클래스를 배열객체로 선언
		MemberVO[] members = new MemberVO[3];
		//MemberVO[]배열클래스 참조index에 m1,m2,m3,를 넣는다
		members[0] = m1;
		members[1] = m2;
		members[2] = m3;
		//출력: MemberService 클래스를 사용
		MemberService ms = new MemberService();
		ms.printMembers(members);
	}

}
