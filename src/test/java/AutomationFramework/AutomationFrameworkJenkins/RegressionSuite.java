package AutomationFramework.AutomationFrameworkJenkins;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegressionSuite {

	WebDriver driver;
	private String url="http://183.82.103.245/nareshit/login.php";
	@BeforeTest
	
	public void init() {
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	
	@Test
	public void VerifyTitle() {
		String getPageTitle=driver.getTitle();
		System.out.println(getPageTitle);
		Assert.assertEquals(getPageTitle, "OrangeHRM - New Level of HR Management");
	}
	
	@Test
	public void login() {
		driver.findElement(By.xpath("//input[@name='txtUserName']")).sendKeys("nareshit");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("nareshit");
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
	
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
