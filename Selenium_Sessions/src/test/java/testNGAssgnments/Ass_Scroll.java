package testNGAssgnments;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Ass_Scroll {
	
	WebDriver driver;
	String url="https://demoqa.com/automation-practice-form";
	
  @Test
  public void fillTheformAndVerify() {
	  
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  
	  WebElement firstname=driver.findElement(By.id("firstName"));
	  firstname.sendKeys("Test");
	  
	  WebElement lastname=driver.findElement(By.id("lastName"));
	  lastname.sendKeys("Demo");
	  
	  WebElement useremail=driver.findElement(By.cssSelector("input#userEmail"));
	  useremail.sendKeys("testdemo@gmail.com");
	  
	  WebElement gender=driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
	  gender.click();
	  
	  js.executeScript("window.scrollBy(0,2000)");	
	  
	  WebElement mobile=driver.findElement(By.id("userNumber"));
	  mobile.sendKeys("1234567890");
	  
	  WebElement sub=driver.findElement(By.id("subjectsInput"));
	  sub.sendKeys("Hindi");
	  sub.sendKeys(Keys.TAB);
	  sub.sendKeys("English");
	  sub.sendKeys(Keys.TAB);
	 	  
	  WebElement hobbies=driver.findElement(By.xpath("//label [@for='hobbies-checkbox-1' and @class='custom-control-label']"));
	  hobbies.click();
	  
	  WebElement picture=driver.findElement(By.xpath("//input[@id='uploadPicture']"));
	  picture.sendKeys(System.getProperty("user.dir")+"\\src\\main\\resources\\uploadFiles\\sampleupload.txt");
	  
	  WebElement addr=driver.findElement(By.id("currentAddress"));
	  addr.sendKeys("Test, Sample 01, 007");
	 
	  js.executeScript("window.scrollBy(0,-2000)");	
  }
  
  @BeforeTest
  public void setUp() {
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
