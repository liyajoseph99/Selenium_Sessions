package testNGAssgnments;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Ass_DropDown {
	WebDriver driver;
	String url="https://demo.anhtester.com/basic-select-dropdown-demo.html";
  @Test
  public void dropdown() {
	  
	  int count=0;
	  WebElement day=driver.findElement(By.xpath("//select[@id='select-demo']"));
	  Select obj=new Select(day);
	  obj.selectByValue("Monday");
	  
	  WebElement selectedDay=driver.findElement(By.xpath("//p[contains(text(),'Day selected :- Monday')]"));
	  String actualResult=selectedDay.getText();
	  String expectedResult="Day selected :- Monday";
	  Assert.assertEquals(actualResult, expectedResult);
	  System.out.println("Day selected :- Monday");
	 
	  System.out.println("all the elements presented in the dropdown are:");  
	  for(int i=1;i<8;i++) {
		  obj.selectByIndex(i);
		  count++;
		  System.out.println(day.getAttribute("value"));
		}
	  System.out.println("total number of elements:"+count);
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
