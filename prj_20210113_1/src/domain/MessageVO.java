package domain;

import java.util.Arrays;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageVO {
	private String writer;
	private String password;
	private String message;
	private String kind;
	private String phone;
	
	public MessageVO() {}
	
	//복사 생성자
	//DTO -> VO(변환)
	//front(html/jsp) -> DTO -> VO -> DAO CRUD 메서드 -> DB 저장
	public MessageVO(MessageDTO dto) {
		// 1:1 대응 인자들
		this.writer = dto.getWriter();
		this.password = dto.getPassword();
		this.message = dto.getMessage();
		
		// n:1 대응 인자들(가공)
		// ex) ["스포츠", "문화", "사회"] => "스포츠", "문화", "사회" 
		this.kind = toString(dto.getKind()); //배열 -> 문자열
		
		//문자열들 -> 문자열
		// ex) 010, 1234, 5678 => 010-1234-5678 (DB)
		this.phone = dto.getPhone1() + "-" + dto.getPhone2() + "-" + dto.getPhone3();
	}
	
	//문자열 배열 => 문자열
	//ex) ["스포츠", "문화", "사회"] => "스포츠" "문화" "사회" (DB)
	private String toString(String[] kind) {
		// 1) [스포츠, 문화, 사회] 저장
		// return Arrays.asList(kind).toString();
		
		// 2) 스포츠, 문화, 사회
		String result = "";
		for(String s : kind) {
			result += s + " ";
		}
		//for(String s : kind) result += s + " ";
		return result;
	}

	@Override
	public String toString() {
		return "MessageVO [writer=" + writer + ", password=" + password + ", message=" + message + ", kind=" + kind
				+ ", phone=" + phone + "]";
	}
	
	
}
