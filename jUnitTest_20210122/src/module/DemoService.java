package module;

public class DemoService {
	/**
	 * 난수 점검 함수
	 * @param num 입력수
	 * @return 난수 100 초과 여부
	 */
	public static boolean isRandomOverNum(int num) {
//		boolean flag = false;
//		float result = (float)(Math.random()+1) * num;
//		flag = result > 100 ? true : false;
//		return flag;
		
//		//위 코드를 줄여서
//		return (float)((Math.random()+1) * num)> 100 ? true : false;
		
		//float result = (float)((Math.random()+1) * num); //before
		float result = (float)((Math.random()+1) * num * 100); //after
		System.out.println("result : "+result);
		return result> 100 ? true : false;
		
	}
	
	public float getRandomOverNum(int num) {

		//return (float)((Math.random()+1) * num); //before
		return (float)((Math.random()+1) * num * 100); //after

	}
}
