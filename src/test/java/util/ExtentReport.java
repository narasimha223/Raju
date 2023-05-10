package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	public static ExtentReports getExtentReport() {
		String extentReportFilePath=System.getProperty("user.dir")+"\\reportsextentreport.html";
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(extentReportFilePath);
		sparkReporter.config().setReportName("Narasimha Automation Results");
		sparkReporter.config().setDocumentTitle("Narasimha Test Automation Results");
		ExtentReports extentReport=new ExtentReports();
		extentReport.attachReporter(sparkReporter);
		extentReport.setSystemInfo("Selenium version", "4.4.0");
		extentReport.setSystemInfo("Operating System", "Windows 11");
		extentReport.setSystemInfo("Executed By", "Narasimha");
		return extentReport;
	}

}
