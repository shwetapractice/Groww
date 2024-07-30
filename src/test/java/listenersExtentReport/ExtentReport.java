package listenersExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	static ExtentReports extent;
	
	public static ExtentReports generateReport()
	{
		
		String path=System.getProperty("user.dir")+"\\Report\\GrowwReport.html";
		
		ExtentHtmlReporter reporter=new ExtentHtmlReporter(path);
		
		reporter.config().setDocumentTitle("GrowwDailyReport");
		reporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		reporter.config().setReportName("Grow Test Report");
		reporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA_ID", "Shweta Nimkarde");
		extent.setSystemInfo("Parent_Organization", "Snaga Tech");
		return extent;
	}

}
      