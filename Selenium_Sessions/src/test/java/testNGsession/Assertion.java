package testNGsession;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Assertion {
	
	WebDriver driver;
	String url="http://www.opesmount.in/grocerystore1/";
				
  @Test(enabled = false)
  public void hardAssert() {								//hard Assertion
	  try {
		driver.get(url);
		String expectedResult="Grocerystore2";
		String actualResult=driver.getTitle();
		Assert.assertEquals(actualResult, expectedResult); 	// checking the strings
		}
	  catch(AssertionError ae) {							//handling the exception using try-catch
		ae.printStackTrace();  
		System.out.println("Next line code checking");
	  }
	  
	  System.out.println("Next step continues");			// exception is handled, so next line executes
  }
  
  @Test(enabled = false)
  public void hardAssertSample() {							//hard Assertion				
	  driver.get(url);
	String expectdResult="GR";
	String actualResult=driver.getTitle();
	Assert.assertEquals(actualResult, expectdResult);		//Assertion fails		
	System.out.println("hardAssertSample() passes");		//exception is not handled so next step is not executed
  }	
  
  @Test(enabled=false)
  public void hardAssertSample1() {
	  System.out.println("I am running");
  }
  
  @Test(enabled = true)
  public void softAssert() {
	  	SoftAssert saobj=new SoftAssert();					//instantiation of SoftAssert()
	  	driver.get(url);
	  	String expectdResult="GR";
		String actualResult=driver.getTitle();
		saobj.assertEquals(actualResult, expectdResult);	//assertion fails
		System.out.println("next line executes");			//continues the execution of next line of code
		saobj.assertAll();  								// to handle the exception - try catch - should be the last line		
  }
  
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
