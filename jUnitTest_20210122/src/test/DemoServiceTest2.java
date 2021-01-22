package test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import lombok.extern.java.Log;
import module.DemoService;

@Log
public class DemoServiceTest2 {
	
	private DemoService demoSvc;
	int num;
	
	@Before
	public void setup() {
		demoSvc = new DemoService();
		num=3;
	}
	
	@Test
	public void testService() {
		//System.out.println("sysout"); //화면엔 표시되지만 기록에 남지 않아 log를 사용하는 것이 바람직
		
		/*
		 *	기대값(expected value) : 100초과 
		 */
		log.info("test getRandomOverNum");
		
		float result;
		int count = 0;
		for(int i=0; i<=10; i++) {
			result = demoSvc.getRandomOverNum(num);
			log.info("result : "+result);
			if(result>100) count++;
			assertTrue(result > 100);
		}
		log.info("100초과인 수가 나온 경우 : "+count);
	}
}
