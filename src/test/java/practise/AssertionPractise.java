package practise;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractise {

	@Test
	public void sample()
	{
		String s="sample";
		System.out.println("Step1");
		System.out.println("Step2");
//		Assert.assertEquals(1, 0);
		Assert.assertTrue(s.contains("s"));
		System.out.println("Step3");
		System.out.println("Step4");
	}
	
	@Test
	public void sample1()
	{
		SoftAssert sa=new SoftAssert();
		System.out.println("step1");
		System.out.println("step2");
		
		sa.assertEquals(0,1);
		
		System.out.println("step3");
		System.out.println("step4");
		
		sa.assertAll();
	}
}
