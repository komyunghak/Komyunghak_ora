package kr.or.test;

class NotExistIDException extends Exception {
	//아이디가 존재하지 않을때 예외사항 처리 내용
	public NotExistIDException() {}
	public NotExistIDException(String message) {
		super(message);
	}
	
}
class WrongPasswordException extends Exception{
	//패스워드 입력 오류에 대한 예외사항 처리 내용
	public WrongPasswordException() {}
	public WrongPasswordException(String message){
		super(message);
	}
}
public class LoginTryCatch {

	public static void main(String[] args) {
		try {
			login("white","12345");//로그인 1
		} catch (NotExistIDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WrongPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			login("blue","54321");//로그인 2
			//강제 오류예외 발생 - NotExistIDException 발생시킴
		} catch (NotExistIDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WrongPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	public static void login(String id, String passward) throws NotExistIDException, WrongPasswordException {
	//id가 'blue'가 아니라면 NotExistIDException 발생시킴
	if(id.equals("blue")) {
		throw new NotExistIDException("아이디가 존재하지 않습니다.");
	}//강제 오류예외 발생 - NotExistIDException
	//password가 "12345"가 아니라면 WrongPasswordException을 발생시킴
	if(!passward.equals("12345")) {
		throw new WrongPasswordException("패스워드가 일치하지 않습니다.");
	}
	}
}
