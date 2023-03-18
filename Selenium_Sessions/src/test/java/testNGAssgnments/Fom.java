package testNGAssgnments;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Fom {
	
	WebDriver driver;
	String url="https://demo.automationtesting.in/Register.html";
	
  @Test
  public void form() {
	  WebElement firstName=driver.findElement(By.xpath("//input[contains(@ng-model,'FirstName')]"));
	  firstName.sendKeys("Test");
	  WebElement lastName=driver.findElement(By.xpath("//input[contains(@ng-model,'LastName')]"));
	  lastName.sendKeys("Demo");
	  WebElement adrs=driver.findElement(By.xpath("//input[contains(@ng-model,'Adress')]"));
	  adrs.sendKeys("xyz,0005");
	  WebElement emailadrs=driver.findElement(By.xpath("//input[contains(@ng-model,'EmailAdress')]"));
	  emailadrs.sendKeys("test001@gmail.com");
	  WebElement phone=driver.findElement(By.xpath("//input[contains(@ng-model,'Phone')]"));
	  phone.sendKeys("1234567890");
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
