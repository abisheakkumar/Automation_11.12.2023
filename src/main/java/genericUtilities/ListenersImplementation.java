package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides Implementation for ITestListener Interface of TestNG
 * @author Abisheak Kumar V
 *
 */
public class ListenersImplementation implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		//start of @Test -> Test Method -> Method Name
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"=====Test Execution Started=====");
		
		
		//For Extent Report to recognize the @Test
		test=report.createTest(methodName);
		
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"=====Test Passed=====");
		
		//For logging the status of Test in extent reports
		test.log(Status.PASS, methodName+"=====Test Passed=====");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"=====Test Failed=====");
		
		System.out.println(result.getThrowable()); //print the exception
		
		//For logging the status of Test in extent reports
		test.log(Status.FAIL, methodName+"=====Test Failed=====");
		test.log(Status.INFO, result.getThrowable());
		
		
		//Capture the screen shot
		SeleniumUtility s=new SeleniumUtility();
		JavaUtility j=new JavaUtility();
		
		String screenShotName=methodName+"-"+j.getSystemDate();
		try {
			String path=s.captureScreenShot(BaseClass.sdriver, screenShotName);
			
			//For Attaching the screenshot to extent Reports
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"=====Test Skipped=====");
		
		System.out.println(result.getThrowable());
		
		//For logging the status of Test in extent Report
		test.log(Status.SKIP, methodName+"=====Test Skipped=====");
		test.log(Status.INFO, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("=====Suite Execution Started=====");
		
		//Extent Report Configuration
		ExtentSparkReporter esr=new ExtentSparkReporter(".\\ExtentReports\\Reports-"+new JavaUtility().getSystemDate()+".html");
		esr.config().setDocumentTitle("Execution Report");
		esr.config().setReportName("Vtiger Execution Report");
		esr.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base environment", "Testing");
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Reporter", "Abisheak Kumar.V");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("=====Suite Execution Finished=====");
		
		//Extent Report Generation
		report.flush();
		
	}
	
	
	
}
