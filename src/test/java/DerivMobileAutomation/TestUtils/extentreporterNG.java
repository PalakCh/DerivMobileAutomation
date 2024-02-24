package DerivMobileAutomation.TestUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentreporterNG {
	
	public static ExtentReports getReportObject()
	{
		String path=System.getProperty("user.dir") + "//reports//index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Test Report");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Palak");
		return extent;
	
	}

}
