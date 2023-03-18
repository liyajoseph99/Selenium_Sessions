package testNGsession;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class IFrames {
	
	WebDriver driver;
	String url="https://www.globalsqa.com/demo-site/frames-and-windows/#iFrame";
	
  @Test
  public void iframes() {
	  //driver.switchTo().frame(2);
	  //driver.switchTo().frame("globalSqa");
	  WebElement iframe=driver.findElement(By.xpath("//iframe[@name='globalSqa']"));
	  driver.switchTo().frame(iframe);
	  
	  WebElement search=driver.findElement(By.xpath("//input[@name='s']"));
	  search.sendKeys("global");
	  
	  //driver.switchTo().defaultContent();
	  driver.switchTo().parentFrame();
	  WebElement searchoutside=driver.findElement(By.xpath("//input[@name='s']"));
	  searchoutside.sendKeys("global");
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
