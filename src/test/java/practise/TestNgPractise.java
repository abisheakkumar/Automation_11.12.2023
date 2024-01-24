package practise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgPractise {
	
	@Test(priority=0,invocationCount=3)
	public void create()
	{
		System.out.println("create");
		Assert.fail();
	}
	@Test(priority=2,invocationCount=2,dependsOnMethods="create")
	public void modify()
	{
		System.out.println("modify");
	}
	@Test(priority=3,invocationCount=5,enabled=true)
	public void delete()
	{
		System.out.println("delete");
	}

}
