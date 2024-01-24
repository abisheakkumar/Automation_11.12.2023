package genericUtilities;

import java.util.Date;

/**
 * This class consists of Java related reusable methods
 * @author Abisheak Kumar
 *
 */
public class JavaUtility {
	/**
	 * This method will return the current date
	 * @return
	 */
	
	public String getSystemDate()
	{
		Date d=new Date();
		String[] dArr=d.toString().split(" ");
		String currentDate=dArr[2]+"."+dArr[1]+"."+dArr[5]+"_"+dArr[3].replace(":", "-");
		return currentDate;
	}
}
