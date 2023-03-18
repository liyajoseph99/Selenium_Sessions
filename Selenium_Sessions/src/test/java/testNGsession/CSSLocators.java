package testNGsession;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class CSSLocators {
	
	WebDriver driver;
	String url="https://www.python.org";
	
  @Test
  public void cssLocator() {
	  
	  WebElement search=driver.findElement(By.cssSelector("input#id-search-field")); //tag-<input> and id value
	  search.sendKeys("python"); 													// passing values to the field search
	  
	  WebElement go=driver.findElement(By.cssSelector("button.search-button")); 	//tag-<button> and class value
	  go.click();
	  
	  driver.navigate().back();
	  
	  WebElement go1=driver.findElement(By.cssSelector("button[name=submit]"));		//tag-<button> and [attribute=value] [name=submit]
	  go1.click();
	  
	  driver.navigate().back();
	  
	  WebElement go2=driver.findElement(By.cssSelector("button.search-button[name=submit]")); // tag-<button>, class = search-button,[attribute=value] 
	  go2.click();
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
	  //driver.close();
  }

}
