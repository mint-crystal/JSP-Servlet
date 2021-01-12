package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ConllectionTest2 {

	public static void main(String[] args) {
		//인터페이스 생성자가 없기 때문에 HashMap을 구현클래스로 생성?
		//구현클래스로 HashMap, Hashtable, LinkedHashMap, Properties, TreeMap가 있음
		Map<String, String> map = new HashMap<>();
		map.put("회","노량진");
		map.put("순대","신림");
		map.put("떡볶이", "신당");
		map.put("떡볶이", "종로");
		map.put("육고기", "마장");
		map.put("부대찌개","의정부");
		map.put("부대찌개","을지로");
		map.put("족발","장충동");
		
		//크기
		System.out.println(map.size());
		
		//낱개의 요소
		System.out.println(map.get("떡볶이")); //나중 값이 출력 = 종로
		
		Set<String> set = map.keySet();
		
//		Iterator<String> it = set.iterator();
//		while(it.hasNext()) {
//			String key = it.next();
//			String value = map.get(key);
//			System.out.println(key + "=" + value);
//		}
		
		//위 코드를 한 줄로 처리
		//map.entrySet().forEach(x->System.out.println(x));
		//map.entrySet().forEach(System.out::println);
		//map.forEach((x,y)->System.out.println(x+"="+y));
		map.keySet().forEach(x->System.out.println(x+"="+map.get(x)));
	}
}
