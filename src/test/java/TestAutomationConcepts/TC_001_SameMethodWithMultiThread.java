package TestAutomationConcepts;

import org.openqa.selenium.devtools.v143.log.model.ViolationSetting.Name;
import org.testng.annotations.Test;

public class TC_001_SameMethodWithMultiThread {

	@Test(threadPoolSize = 3, invocationCount = 3, timeOut = 1000)
	void Class4MethodA(){
		//System.out.println("**** Same method runs in multiple threads, using threadPoolSize, invocationCount, timeOut");
		System.out.println("Class4 >> MethodA >>  "+ Thread.currentThread().threadId());
	}
	
	@Test
	void Class4MethodB(){
		System.out.println("Class4 >> MethodB >>  "+ Thread.currentThread().threadId());
	}
	
	@Test
	void Class4MethodC(){
		System.out.println("Class4 >> MethodC >>  "+ Thread.currentThread().threadId());
	}
	
}
