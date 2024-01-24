package genericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

/*
 * This class consists of resuable methods related to property file
 * @author Abisheak Kumar V
 * 
 */
public class PropertyFileUtility {

	/*
	 * This method will read data from property file and return the value to call the statiement
	 * @param key
	 * @return 
	 * @throws IOException
	 */
	
	
	
	
	
	public String readDataFromPropertyFile(String key)throws Throwable
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Properties.properties");
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		return value;
		
	}
}
