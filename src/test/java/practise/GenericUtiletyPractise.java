package practise;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;

public class GenericUtiletyPractise {
	public static void main(String[] args) throws Throwable{
		PropertyFileUtility putil=new PropertyFileUtility();
		String value=putil.readDataFromPropertyFile("url");
		System.out.println(value);
		
		
		ExcelFileUtility eutil=new ExcelFileUtility();
		String data=eutil.readDataFromExcel("contact", 0, 0);
		System.out.println(data);
		
		
		JavaUtility jutil=new JavaUtility();
		System.out.println(jutil.getSystemDate());
	}
}
