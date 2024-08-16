package extentReports;

import java.time.LocalDateTime;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TolearnExtendReports {
	
	@Test
	public void createReport()
	{
		String time = LocalDateTime.now().toString().replace(":", "-");
		ExtentSparkReporter spark= new ExtentSparkReporter("./HTML.reports/extentsreports"+time+".html");
		
		ExtentReports extReport = new ExtentReports();
		
		extReport.attachReporter(spark);
		
		ExtentTest test = extReport.createTest("CreateReport");
		test.log(Status.INFO, "open the browser");
		test.log(Status.PASS, "successfully created extent report");
     	test.log(Status.FAIL, "testscript is failed");
		test.log(Status.SKIP, "testscript is skiped");
		test.log(Status.WARNING, "show warning message");
		
		
		extReport.flush();
		


	
	}
}
