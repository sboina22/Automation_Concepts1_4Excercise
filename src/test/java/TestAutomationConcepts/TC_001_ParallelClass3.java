package TestAutomationConcepts;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class TC_001_ParallelClass3 {

	@Test
	void Class3Method1(){
		System.out.println("Class3 >> Method1 >>  "+ Thread.currentThread().threadId());

	}
	
	@Test
	void Class3Method2(){
		System.out.println("Class3 >> Method2 >>  "+ Thread.currentThread().threadId());

	}
	
	@Test
	void Class3Method3(){
		System.out.println("Class3 >> Method3 >>  "+ Thread.currentThread().threadId());

	}
	
}
