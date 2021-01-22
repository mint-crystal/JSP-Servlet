/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import module.DemoService;

/**
 * DemoService Test
 * @author 수정
 *
 */
public class DemoServiceTest {
	private DemoService demoSvc;
	int testNum;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("선 작업");
		demoSvc = new DemoService();
		testNum = 2;
	}

	@Test
	public void test() {
		//System.out.println(demoSvc.isRandomOverNum(testNum));
		
	//결과 단언(단정) : assertion
		//assertTrue("난수가 100보다 크다", demoSvc.isRandomOverNum(testNum));
		boolean flag = demoSvc.isRandomOverNum(testNum);
		//assertTrue("난수가 100보다 작다", flag);
	//역테스트
		assertFalse("난수가 100보다 크다", flag); 
		//assertFalse("난수가 100보다 크다", !flag);
	}

}
