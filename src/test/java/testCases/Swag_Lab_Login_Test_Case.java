package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.DataProviders;

public class Swag_Lab_Login_Test_Case 
{
	public WebDriver driver;
	@BeforeClass
		
	public void SetUp()
	{
		driver = new ChromeDriver();
		
	}
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void LoginTest(String username, String password ) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='user-name'])[1]")).sendKeys(username);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='password'])[1]")).sendKeys(password);
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//input[@id='login-button'])[1]")).click();
	}
	
	@AfterClass
	public void close_the_app() throws InterruptedException
	{
		Thread.sleep(10000);
		driver.quit();
	}
	

}
