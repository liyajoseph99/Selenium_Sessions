package testNGsession;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class WindowHandling {
	
	WebDriver driver;
	String url="https://demoqa.com/browser-windows";
	
  @Test
  public void windowHandling() {
	  
	  String parentwindowhandleID=driver.getWindowHandle();
	  System.out.println(parentwindowhandleID);
	  
	  WebElement newTab=driver.findElement(By.xpath("//button[@id='tabButton']"));
	  newTab.click();
	  
	  Set<String> allWindows=driver.getWindowHandles();
	  System.out.println(allWindows);
	  
	  Iterator<String> iterator=allWindows.iterator();
	  while(iterator.hasNext()) {
		  String childWindowID=iterator.next();
		  if(!parentwindowhandleID.equalsIgnoreCase(childWindowID)) {
			  driver.switchTo().window(childWindowID);
		  }
	  }
	  
	  WebElement sample=driver.findElement(By.xpath("//h1[contains(text(),'This is a sample page')]"));
	  System.out.println(sample.getText());
  }
  
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get(url);
  }

  @AfterTest
  public void afterTest() {
  }

}
