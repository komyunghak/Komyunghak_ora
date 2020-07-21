package kr.or.member;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

import kr.or.member.MemberService;
import kr.or.member.MemberVO;

public class MainController {
	

	private static String TIME_SERVER = "pool.ntp.org";
													//입출력에대한에러
	public static void main(String[] args) throws IOException {
		System.out.println("클래스형 변수(사용자정의 자료형)");
		//MemberVO 클래스를 실행하기 위해 new 연산자 사용
		MemberVO m1 = new MemberVO();
		//setter 메서드를 이용해 해당 인스턴스(클래스) 변수(필드)에 값을 넣는다.
		m1.setName("고명학");
		m1.setAge(25);
		m1.setPhoneNum("010-4665-7836");
		//마찬가지로 다른 MeberVO객체(instance)를 생성해서 값을 얻는다.
		MemberVO m2 = new MemberVO();
		m2.setName("고명학");
		m2.setAge(25);
		m2.setPhoneNum("010-4665-7836");
		MemberVO m3 = new MemberVO();
		m3.setName("고명학");
		m3.setAge(25);
		m3.setPhoneNum("010-4665-7836");
		//크기가 3인 MemberVO클래스를 배열객체로 선언
		MemberVO[] members = new MemberVO[3];
		//MemberVO[]배열클래스 참조index에 m1,m2,m3,를 넣는다
		members[0] = m1;
		members[1] = m2;
		members[2] = m3;
		//출력: MemberService 클래스를 사용
		MemberService ms = new MemberService();
		ms.printMembers(members);
		
		
		/*
		 *  MainControl 클래스에 아래 내용 추가하 후 에러 상황 처리하기를 이용해서 외부 라이브러리 사용방법 확인 -->
		 */
		System.out.println("-서버타임 출력하기-");
		NTPUDPClient timeClient = new NTPUDPClient();
		timeClient.setDefaultTimeout(1000);
		try {
			timeClient.open();
		} catch (SocketException e) {
			System.out.println("open메서드 실행 오류");
			e.printStackTrace();
		}finally {  //말그대로 finally는 오류가 나도 실행이된다
			System.out.println("이부분은 성공/오류에 상관없이 항상 실행됩니다.");
		}
		InetAddress address = InetAddress.getByName(TIME_SERVER);//add throw 에러가 나도 상관을 안쓰겠다.  try catch는 에러가 나오면 문제를 잡고가겠다 라는 의미
	    TimeInfo timeInfo = timeClient.getTime(address);
	    //서버로부터 시간 가져오는 코드
	    long returnTime = timeInfo.getMessage().getTransmitTimeStamp().getTime();
	    Date date = new Date(returnTime);
	    LocalDateTime localDateTime = 
	            date.toInstant()
	            .atZone(ZoneId.systemDefault())
	            .toLocalDateTime();//date to LocalDateTime
	    
	    System.out.println("Server 시간: " + localDateTime);//서버 시간!
	    System.out.println("로컬 PC 시간: " + LocalDateTime.now());//피시 시간!
		}
	
	}
