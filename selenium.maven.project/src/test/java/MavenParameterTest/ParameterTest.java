package MavenParameterTest;

import java.security.PublicKey;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ParameterTest {
	@Test
	public void receving() {
		String url = System.getProperty("url");
		String email = System.getProperty("email");
		String password = System.getProperty("password");
		Reporter.log(url,true);
		
		WebDriver driver =new EdgeDriver();
		driver.get(url);
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		

}
}

