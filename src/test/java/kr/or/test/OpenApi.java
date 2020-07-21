package kr.or.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class OpenApi {

	//외부연계 매서드
public static void serviceApi() {//버퍼리더 버퍼란 외부에서 계속 자료가 들어올경우 중간에서 충격완화처럼 파일을 보호해주는 그리고 버퍼리더는 그 값을 읽어내주는것을 뜻한다.
	BufferedReader br = null;    //HRD넷에서 전송받은 데이터를 일시저장하는 저수지와 같은 역할
	String urlstr = "http://www.hrd.go.kr/jsp/HRDP/HRDPO00/HRDPOA60/HRDPOA60_1.jsp?returnType=XML"
			+ "&authKey=인증키부분gVt1YLZk4NmjAYhyfXxLeYSEjk7TGWFu&pageNum=1&pageSize=10"
			+ "&srchTraStDt=20200501&srchTraEndDt=20201231&outType=1&sort=ASC&sortCol=TR_STT_DT&srchTraArea1=44";  //원래는 1줄이지만 깨끗하게 보이려고 3줄로 만듬       
	try {
		URL url = new URL(urlstr);  //스프링일 경우는 throw catch를 사용하겠지만 클래스 사용일 경우는 try catch사용을 권장한다.
		HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
		urlconnection.setRequestMethod("GET");
		br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"euc-kr"));// ecu-kr 인 이유는 hrd-net에서 이 파일로 보내기 떄문이다.
		String result = "";
		String line;
		while ((line=br.readLine()) != null) { //저수지의 있는 값이 라인에 들어갔는데 널이 아니라면
			 result = result + line + "\n";    //1부터 100까지 더하는값과 같은 로직
		}
		//System.out.println(result);
		String result_xmlUtils = XmlUtils.formatXml(result);
		System.out.println(result_xmlUtils);
	} catch (MalformedURLException e) {
			e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	//콘솔화면에 현재PC시간을 표시
	Calendar cal = Calendar.getInstance();
	System.out.println(cal.getTime());
}
	public static void main(String[] args) {
		//실행간격 지정(10초)
		int sleepSec = 10;
		//주기적인 작업을 위한 코딩 exec 실행가능한 클래스만듬
		final ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
    	exec.scheduleAtFixedRate(new Runnable(){ 
    		public void run(){ 
    			serviceApi();
    		}
    	},0,sleepSec,TimeUnit.SECONDS);	
		

	}

}
