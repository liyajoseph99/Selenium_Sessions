package testNGAssgnments;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Ass_WindowHandling {
	
	WebDriver driver;
	WebDriver driver1;
	String url="http://www.newtours.demoaut.com/";
	String url1="https://www.seleniumeasy.com/test/";
	
  @Test
  public void windowHandling() throws AWTException {
	  
	 String parentwindowhandleID=driver.getWindowHandle();
	 System.out.println(parentwindowhandleID);
	 
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.open('https://www.seleniumeasy.com/test/');"); //opens a newtab and launch the url
	  
	 System.out.println(driver.getTitle());				//driver is still in demoaut.com , pass the driver control to the next window
	 
	 Set<String> allWindows=driver.getWindowHandles();
	 System.out.println(allWindows);
	  
	  Iterator<String> iterator=allWindows.iterator();
	  while(iterator.hasNext()) {
		  String childWindowID=iterator.next();
		  if(!parentwindowhandleID.equalsIgnoreCase(childWindowID)) {
			  driver.switchTo().window(childWindowID);
		  }
	  }
	  
	  String actualResult  =driver.getTitle();
	  String expectedResult="Page not found | Selenium Easy";
	  Assert.assertEquals(actualResult, expectedResult);
  }
  
  @BeforeTest
  public void beforeTest() {
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
