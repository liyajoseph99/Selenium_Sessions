package testNGsession;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Wait {
	
	WebDriver driver;
	String url="http://demo.guru99.com/test/guru99home/";
	By agile=By.xpath("//a[contains(text(),'Agile Project')]");	//By - browser inspector
	
  @Test(enabled = false)
  public void explicitwait() {
	  WebElement agileProject=driver.findElement(agile);
	  WebDriverWait explicitwait=new WebDriverWait(driver,Duration.ofSeconds(10)); //object creation for WebDriverWait.parameterised constructor
	  explicitwait.until(ExpectedConditions.presenceOfElementLocated(agile)); //parameter-By Locator.so,agile is defined.
	  agileProject.click();
  }
  
  @Test
  public void fluentWait() {
	  WebElement agileProject=driver.findElement(agile);
	  
	  FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
	  .withTimeout(Duration.ofSeconds(100))				//timeout is 100sec
	  .pollingEvery(Duration.ofSeconds(10)) 			//frequency is 10s.in every 10sec checking with max. timeout=100sec.
	  .ignoring(Exception.class);
	
	  wait.until(ExpectedConditions.elementToBeClickable(agile));
	  agileProject.click();
	  
	  //Wait - interface,FluentWait - class in the interface,parameterised constructor
  }
  
  @BeforeTest
  public void setUp() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get(url);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));   //implicit wait
  }

  @AfterTest
  public void tearDown() {
	  //driver.close();
  }

}
