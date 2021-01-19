package action;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import lombok.extern.java.Log;
import util.UploadFileReNamePolicy;

/**
 * Servlet implementation class FileProAction
 */
@Log //lombok
@WebServlet("/file_action.do")
public class FileProAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("doGet");
		//log.info("do Get : file_action.do");	//로그 확인(lombok)
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
													
	@SuppressWarnings({ "unused", "unchecked" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
																					//throws가 있어서 예외처리는 따로 안 해주어도 됨
		System.out.println("doPost");
		//log.info("do Post : file_action.do"); //로그확인
		
		try {
			// 파일 저장 설정 정보(config info)
			// 저장 경로(local repo path) ex) 절대경로, 상대경로 
			String repoPath="E:\\KH\\uplode"; //절대경로
			
			// 파일 쿼터량(크기 제한) : 10MB	
			int fileMaxSize = 10 * 1024 *1024; 
			
			// 파일 명명 정책(policy) : 파일명_접미어(날짜+hashcode).확장자 => 파일 중복 대비
			UploadFileReNamePolicy ufp = new UploadFileReNamePolicy(); 
			
			// 인코딩 방식 ex) UTF-8, EUC-KR, MS-949...
			String encoding = "UTF-8";
			
			/* 파일 요청 객체 생성(MultipartRequest(javax.servlet.http.HttpServletRequest request, 
											 java.lang.String saveDirectory, 
											 int maxPostSize, 
											 java.lang.String encoding, 
											 FileRenamePolicy policy)) */
			//파일 업로드 완성
			MultipartRequest multi = new MultipartRequest(request, repoPath, fileMaxSize, encoding, ufp);
			
			//후속 조치 : 파일 정보 획득
			Enumeration<String> en = multi.getFileNames(); //file 속성을 가진 파라미터의 이름을 Enumeration 객체 타입으로 반환
			String file = en.nextElement(); //file 속성의 파라미터 값 꺼내오기
			String filename = multi.getFilesystemName(file); //서버에 저장된 파일명
			
			String originalFilename = multi.getOriginalFileName(file); //사용자가 기정한 파일명
			log.info("업로드 파일명-1 : "+filename);
			log.info("업로드 파일명-2(오리지널) : "+originalFilename); 
			
			//업로드 파일의 컨텐츠 타입 반환
			String type = multi.getContentType(file);
			System.out.println("파일의 컨텐츠 타입 : "+type);
			
			//서버에 업로드한 파일에 대한 객체 반환 - 저장된 파일의 경로 확인
			File f = multi.getFile(file);
			System.out.println("getFile() : "+f);
			
		} catch(Exception e) {
			log.info("파일 저장 시 문제 발생");
			e.printStackTrace();
		}
	}

}
