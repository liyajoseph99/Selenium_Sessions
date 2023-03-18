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
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Ass_Locators {
	
	WebDriver driver;
	String url="https://demoqa.com/automation-practice-form";
	
  @Test
  public void locators() throws InterruptedException {
	  
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
	 
	  WebElement dob=driver.findElement(By.id("dateOfBirthInput"));
	  dob.sendKeys(Keys.CLEAR);
	  for(int i=0;i<10;i++) {
		  dob.sendKeys(Keys.BACK_SPACE);
	  }
	  dob.sendKeys("1 Jan 1990");
	  
	  mobile.click();
	  
	  
	  WebElement sub=driver.findElement(By.id("subjectsInput"));
	  sub.click();
	  sub.sendKeys("Hindi");
	  sub.sendKeys(Keys.TAB);
	  sub.sendKeys("English");
	  sub.sendKeys(Keys.TAB);
	 	  
	  WebElement hobbies=driver.findElement(By.xpath("//label [@for='hobbies-checkbox-1' and @class='custom-control-label']"));
	  hobbies.click();
	  
	  WebElement addr=driver.findElement(By.id("currentAddress"));
	  addr.sendKeys("Test, Sample 01, 007");
	  addr.sendKeys(Keys.PAGE_DOWN);
	  Thread.sleep(1000);
	  
	  WebElement state=driver.findElement(By.xpath("//div[@class=' css-1hwfws3']")) ;
	  state.click();
	  Thread.sleep(1000);
	  //WebElement state=driver.findElement(By.className(" css-tlfecz-indicatorContainer"));
	  //state.click();
	  //state.sendKeys("NCR");
	  //state.sendKeys(Keys.ENTER);
	  	  
	  //WebElement submit=driver.findElement(By.xpath("//button[@id='submit']"));
	  //submit.click();
	  
	  Thread.sleep(1000);
	  
  }
  
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  //driver.manage().window().maximize();
	  driver.get(url);
	  
	  //Resize current window to the set dimension
	  Dimension d = new Dimension(600,900);
   	  driver.manage().window().setSize(d);
  }

  @AfterTest
  public void afterTest() {
	  //driver.quit();
  }

}
