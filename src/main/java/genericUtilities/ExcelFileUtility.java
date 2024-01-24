package genericUtilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



/*
 * This clas consists of re-usable methds related to excel File
 * @author Abisheak Kumar V
 */
public class ExcelFileUtility {

	/*
	 * This method will read data from excel file and returns the value ton caller
	 * @param sheetName
	 * @param return 
	 * @param cellNum
	 * @return 
	 * @throws EncryptedDocumentsException
	 * @throws IDException
	 */
	
	public String readDataFromExcel(String sheetName,int rowNum,int cellNum)throws Throwable
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\ReadDataFromExcel1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String value=wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;
	}
	
}
