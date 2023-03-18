package testNGsession;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class XpathLocators {
	
	WebDriver driver;
	String url="https://www.python.org";
	
  @Test
  public void xpathLocator() {
	  
	  WebElement search=driver.findElement(By.xpath("//input[@id='id-search-field']")); // basic xpath - //tagname[@attribute='value']
	  search.sendKeys("python");
	  
	  WebElement learnmore=driver.findElement(By.xpath("//a[text()='Learn More']")); //tagname[text()='text value']
	  System.out.println(learnmore.getLocation());
	  learnmore.click();
	  
	  driver.navigate().back();
	  
	  WebElement learn=driver.findElement(By.xpath("//a[contains(text(),'Learn More')]"));
	  System.out.println(learn.getText());
	  
	  WebElement search1=driver.findElement(By.xpath("//input[contains(@id,'search')]"));
	  search1.clear();
	  
	  WebElement search2=driver.findElement(By.xpath("//input[starts-with(@id,'id-search')]"));
	  search2.sendKeys("java");
	  
	  WebElement search3=driver.findElement(By.xpath("//input[@id='id-search-field' or @name='q']"));
	  search3.clear();
	  
	  WebElement search4=driver.findElement(By.xpath("//input[@id='id-search-field' and @name='q']"));
	  search4.sendKeys("selenium");
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
