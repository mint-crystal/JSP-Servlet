package test;

import java.util.Arrays;

import domain.MessageVO;

public class ArrayTest {
	
	private String toString(String[] kind) {
		// 1) ["스포츠", "문화", "사회"] 저장
		return Arrays.asList(kind).toString();
	}
	
	public static void main(String[] args) {
		String []arr = {"나연","다현","쯔위"};
		
		//System.out.println(new ArrayTest().toString(arr));
		
		// 1) [나연, 다현, 쯔위] (DB 저장)
		// 2) 나연 다현 쯔위 (DB 저장)
		//System.out.println(new MessageVO().toString(arr));
	}

}
