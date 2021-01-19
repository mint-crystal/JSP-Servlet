package util;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import com.oreilly.servlet.multipart.FileRenamePolicy;

import lombok.extern.java.Log;

@Log
public class UploadFileReNamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File f) {
          
          SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    
          // 파일 형식 : 원본 파일명 + "_" + 날짜 포맷 + 해쉬코드 + 확장자
          String name = f.getName();
          String pureFileName = name.split("\\.")[0]; //.형식을 제외한 순수 파일명 추출
          String uniqueFileName = pureFileName + "_" 
        		  			    + sdf.format(new Date(System.currentTimeMillis())) 
        		  			    + Integer.toHexString(this.hashCode());
          						// 16진수 해쉬코드(최대 8자리)

          @SuppressWarnings("unused") //warning이 나올때 무시하고 넘어감
		  String body = null;
          String ext = null;
          
          //중간 로그 확인(필수)
          System.out.println("### name : "+name);
          System.out.println("### uniqueFileName : "+uniqueFileName);

          int dot = name.lastIndexOf(".");
          if (dot != -1) {
               body = name.substring(0, dot);
               ext = name.substring(dot);  // includes "."
          }
          else {
               body = name;
               ext = "";
          }
    
          String tempName = uniqueFileName + ext;
          System.out.println("tempName : "+tempName);
          
          f = new File(f.getParent(), tempName); //parent 폴더 경로의 child라는 파일에 대한 File 객체를 생성
          if (createNewFile(f)) {
               return f;
          }
          System.out.println("f : " + f.getParent());

          int count = 0;
          while (!createNewFile(f) && count < 9999) {
               count++;
               String newName = uniqueFileName + "_" + count + ext;
               f = new File(f.getParent(), newName);
          }

          return f;
     }

     private boolean createNewFile(File f) {
          try {
               return f.createNewFile();
          }
          catch (IOException ignored) {
               return false;
          }
     }
     
}	     