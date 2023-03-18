package testNGAssgnments;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Ass_Locators1 {
	
	WebDriver driver;
	String url="https://demoqa.com/automation-practice-form";
	
  @Test
  public void applicationFormFilling() throws InterruptedException {
	  
	  WebElement firstname=driver.findElement(By.id("firstName"));
	  firstname.clear();
	  firstname.sendKeys("Liya");
	  
	  WebElement lastname=driver.findElement(By.id("lastName"));
	  lastname.clear();
	  lastname.sendKeys("Joseph");
	  
	  WebElement useremail=driver.findElement(By.cssSelector("input#userEmail"));
	  useremail.clear();
	  useremail.sendKeys("liyajoseph99@gmail.com");
	  
	  useremail.sendKeys(Keys.PAGE_DOWN);
	  Thread.sleep(1000);
	  
	  WebElement gender=driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
	  gender.click();
	  
	  WebElement mobile=driver.findElement(By.id("userNumber"));
	  mobile.clear();
	  mobile.sendKeys("1234567890");
	  
	  WebElement addr=driver.findElement(By.id("currentAddress"));
	  addr.sendKeys("Test, Sample 01, 007");
	  
	  addr.sendKeys(Keys.PAGE_DOWN);
	  Thread.sleep(1000);
	  
	  WebElement submit=driver.findElement(By.xpath("//button[@id='submit']"));
	  submit.click();
	  
	  Thread.sleep(1000);
  }
  
  @BeforeTest
  public void beforeTest() {
	  
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get(url);
	  
	  //Resize current window to the set dimension
	  Dimension d = new Dimension(600,900);
   	  driver.manage().window().setSize(d);
  }

  @AfterTest
  public void afterTest() {
	  
	  driver.quit();
  }

}
