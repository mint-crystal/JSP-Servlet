package collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ConllectionTest {

	public static void main(String[] args) {
		// 요소(element)의 중복 불허용. index 없음
		// Map의 Key성분과 동일 => Map.KeySet()
		// ex) 경품 추천, 복권 ...
		String []arr = {"정연","모모","사나","쯔위","채영","미나","지효"};
		Set<String> set = new HashSet<>();
		
		set.add("나연");
		set.add("나연");
		set.add("나연");
		set.add("다현");
		set.add("다현");
		set.addAll(Arrays.asList(arr));
		
		System.out.println("set의 크기 : "+set.size());
		
//		//전체 나열 - 방법 1
//		Iterator<String> it = set.iterator();
//		while(it.hasNext()) {
//			System.out.print(it.next()+" ");
//		}
		
		//전체 나열 - 방법 2
		for(String str : set) {
			System.out.print(str+" ");
		}
		
		//한 줄 코드로 전체 나열하는 방법
		//set.forEach(x->System.out.println(x));
		//set.forEach(System.out::println);
		
		//스트림으로 치환
		set.stream().forEach(System.out::println);
	}
	
	

}
