package testNGAssgnments;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Ass_Alerts {
	
	WebDriver driver;
	String url="http://demo.guru99.com/test/delete_customer.php";
	
  @Test
  public void alertManaging() {
	  
	  WebElement custidbx=driver.findElement(By.xpath("//input[@name='cusid']"));
	  WebElement submitbt=driver.findElement(By.xpath("//input[@name='submit']"));
	  custidbx.sendKeys("123456");
	  submitbt.click();
	  
	  String actualResult  =driver.switchTo().alert().getText();
	  String expectedResult="Do you really want to delete this Customer?";
	  Assert.assertEquals(actualResult, expectedResult);
	  driver.switchTo().alert().accept();
	  
	  String actualResult1  =driver.switchTo().alert().getText();
	  String expectedResult1="Customer Successfully Delete!";
	  Assert.assertEquals(actualResult1, expectedResult1);
	  driver.switchTo().alert().accept();
	 
	  String actualResult2  =driver.getTitle();
	  String expectedResult2="Delete Customer";
	  Assert.assertEquals(actualResult2, expectedResult2);
  }
  
  @BeforeTest
  public void setUp() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  driver.get(url);
  }

  @AfterTest
  public void afterTest() {
  }

}
