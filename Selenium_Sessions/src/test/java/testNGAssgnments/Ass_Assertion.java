package testNGAssgnments;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Ass_Assertion {
	
	WebDriver driver;
	String url="http://www.opesmount.in/grocerystore1/";
	String ExpectedResult;
	String ActualResult;
	SoftAssert obj=new SoftAssert();
	
  @Test
  public void hardAssert() {
	 
	  Assert.assertEquals(ActualResult, ExpectedResult);
	  System.out.println("Hard Assert-The title of the page is same as expected result");
  }
  
  @Test
  public void softAssert() {
	
	obj.assertEquals(ActualResult, ExpectedResult);
	System.out.println("Soft Assert-The title of the page is same as expected result");
	obj.assertAll();
  }
  
  @Test
  public void driverValue() {
	
	obj.assertNotNull(driver);
	System.out.println("Soft Assert-The driver value is not null");
	obj.assertAll();
  }
  
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get(url);
	  ExpectedResult="Grocerystore";
	  ActualResult=driver.getTitle();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
