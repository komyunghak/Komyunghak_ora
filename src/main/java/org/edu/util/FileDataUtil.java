package org.edu.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.edu.service.IF_MemberService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileDataUtil {

   private ArrayList<String> extNameArray = new ArrayList<String>() 
   {
	   {
		   add("gif");
		   add("jpg");
		   add("png");
	   }
   };
   private IF_MemberService memberService;
   // 첨부파일 업로드 경로 변수값으로 가져옴 servlet-context
   @Resource(name = "uploadPath")
   private String uploadPath;

   
   public String getUploadPath() {
      return uploadPath;
   }

   public void setUploadPath(String uploadPath) {
      this.uploadPath = uploadPath;
   }

   /**
    * 게시물 상세보기에서 첨부파일 다운로드 메서드 구현
    */
   @RequestMapping(value = "/download", method = RequestMethod.GET)
   @ResponseBody
   public FileSystemResource fileDownload(@RequestParam("filename") String fileName, HttpServletResponse response) {
      File file = new File(uploadPath + "/" + fileName);
      response.setContentType("application/download; utf-8");
      response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
      return new FileSystemResource(file);
   }

   /**
    * 파일 업로드 메서드(공통)
    * 
    * @throws IOException
    */
   public String[] fileUpload(MultipartFile file) throws IOException {
      String originalName = file.getOriginalFilename(); // jsp에서 전송받은 파일의 이름
      UUID uid = UUID.randomUUID(); // 랜덤문자 구하기
      String saveName = uid.toString() + "." + originalName.split("\\.")[1]; // 한글 파일명 처리 때문임.
      String[] files = new String[] { saveName }; // 형변환 get set을 쓰려고(배열로 선언해서 스트링으로 형변환)
      byte[] fileData = file.getBytes(); // 67번째줄 보드롸이트 파일(매개변수) 받음
      File target = new File(uploadPath, saveName);// 31~33 업로드 경로 변수값으로 받음 저장 될 위치 지정
      FileCopyUtils.copy(fileData, target);
      return files;
   }

public ArrayList<String> getExtNameArray() {
	return extNameArray;
}

public void setExtNameArray(ArrayList<String> extNameArray) {
	this.extNameArray = extNameArray;
}
}