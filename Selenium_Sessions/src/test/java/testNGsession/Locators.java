package testNGsession;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Locators {
	WebDriver driver;
	String url="https://www.python.org";
			
  @Test(priority = 1)
  public void search_Locator() {
	  
	  //WebElement search=driver.findElement(By.id("id-search-field")); //the webelement is 'search' - finding the element using id
	  //search.click();
	  
	  WebElement search=driver.findElement(By.name("q"));				//finding element using name
	  search.click();
  }
  
  @Test(priority=2)
  public void goButton1() {
	 WebElement go=driver.findElement(By.className("search-button")); 
	 go.click();
	 driver.navigate().back();
  }
  
  @Test(priority = 3)
  public void goButton2() {
	WebElement go=driver.findElement(By.tagName("button")); 
	go.click();
	driver.navigate().back();
  }
  
  @Test(priority = 4)
  public void learnMore() {
	  WebElement learnMore=driver.findElement(By.linkText("Learn More"));
	  learnMore.click();
	  driver.navigate().back();
  }
  
  @Test(priority = 5)
  public void learnMore_Partial() {
	  WebElement learnMore=driver.findElement(By.partialLinkText("Learn"));
	  learnMore.click();
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
