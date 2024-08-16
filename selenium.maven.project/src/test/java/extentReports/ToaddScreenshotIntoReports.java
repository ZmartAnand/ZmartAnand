package extentReports;

import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToaddScreenshotIntoReports {
	
	@Test
	public void addScreenshot() {
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demowebshop.tricentis.com/");
		TakesScreenshot ts= (TakesScreenshot) driver;
		String screenshot = ts.getScreenshotAs(OutputType.BASE64);
		String time = LocalDateTime.now().toString().replace(":", "-");
		
		
		ExtentSparkReporter spark= new ExtentSparkReporter("./HTML.reports/extentScreenshot.html");
		ExtentReports extReport= new ExtentReports();
		extReport.attachReporter(spark);
		ExtentTest test = extReport.createTest("addScreenshot");
		test.log(Status.PASS, "adding Screenshot");
		test.addScreenCaptureFromBase64String(screenshot);
		extReport.flush();
		
		
		
	}

}
