package TestAutomationConcepts;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class TC_001_ParallelClass2 {

		@Test
		void Class2Method1(){
			System.out.println("Class2 >> Method1 >>  "+ Thread.currentThread().threadId());

		}
		
		@Test
		void Class2Method2(){
			System.out.println("Class2 >> Method2 >>  "+ Thread.currentThread().threadId());

		}
		
		@Test
		void Class2Method3(){
			System.out.println("Class2 >> Method3 >>  "+ Thread.currentThread().threadId());

		}
	}
