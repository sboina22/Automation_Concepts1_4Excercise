package TestAutomationConcepts;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class TC_001_ParallelClass1 {
	
	@Test
	void Class1Method1(){
		System.out.println("Class1 >> Method1 >>  "+ Thread.currentThread().threadId());

	}
	
	@Test
	void Class1Method2(){
		System.out.println("Class1 >> Method2 >>  "+ Thread.currentThread().threadId());

	}
	
	@Test
	void Class1Method3(){
		System.out.println("Class1 >> Method3 >>  "+ Thread.currentThread().threadId());

	}
	
	@Test
	void Class1Method4(){
		System.out.println("Class1 >> Method4 >>  "+ Thread.currentThread().threadId());
	}
}
