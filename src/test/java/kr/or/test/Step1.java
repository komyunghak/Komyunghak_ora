package kr.or.test;

public class Step1 {

	public static void main(String[] args) {
		System.out.println("내장변수 자료형 소스");//변수는 자료형을 가지고있다.
		//필드=변수 
		String name; int age; String phoneNum; //정수형의 변수=변수표기    //phoneNum(카멜(camel)(낙타등표기법)) 같은 경우 대문자의 의미는 두가지의 영어가 붙어있을경우 뒤에있는 낱말의 앞글자를 대문자로 붙힌다.
		name = "홍길동"; age = 45; phoneNum = "000-0000-0000";
		printMember(name,age,phoneNum);//메서드의 매개변수(인자=파라미터)로 값을전달
		name = "성춘향"; age = 100; phoneNum = "111-1111-1111";
		printMember(name,age,phoneNum);
		name = "각시탈"; age = 3; phoneNum = "222-2222-2222";
		printMember(name,age,phoneNum);
		
	System.out.println("내장변수 배열자료형 소스"); // [] 는 뒤에 무조건 배열이 오게만든다
	String[] names = {"홍길동","성춘향","각시탈"};
	int[] ages = {45,100,3};
	String[] phoneNums = {"000-0000-0000","111-1111-1111","222-2222-2222"}; 
	printMember(names,ages,phoneNums);
	}
	//오버 로드(같은 이름의 매개변수(피라미터)가 틀린  메서드 
	private static void printMember(String[] names, int[] ages, String[] phoneNums) {
		int cntLength = names.length;
		System.out.println("매개변수 이름의 갯수는 " + cntLength + "입니다.");
		for(int cnt=0;cnt<cntLength;cnt++) {//배열을 값을 참조할때 주소(index)를 사용하는데 0번 주소부터 시작 
		System.out.println("이름은:" + names[cnt] + " | 나이는:" + ages[cnt]+" | 전화번호는:" + phoneNums[cnt]);
		}
	}
	private static void printMember(String name, int age, String phoneNum) {
	System.out.println("이름은:" + name + " | 나이는:" + age+" | 전화번호는:" + phoneNum);
	}

}
