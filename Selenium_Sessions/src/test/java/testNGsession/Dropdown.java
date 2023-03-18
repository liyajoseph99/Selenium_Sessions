package testNGsession;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Dropdown {
	
	WebDriver driver;
	String url="https://demo.guru99.com/test/newtours/register.php";
	
  @Test(enabled = true)
  public void dropdown() {
	  
	  WebElement country=driver.findElement(By.xpath("//select[@name='country']"));
	  Select obj=new Select(country); 		//object creation for select class
	  
	  obj.selectByIndex(2); 				//3rd position
	  obj.selectByValue("ANGOLA");			//by value in the tag attribute value="ANGOLA"
	  obj.selectByVisibleText("ANTARCTICA"); //by the value which is visible from UI / black color in attribute
	  	  
  }
  
  @Test
  public void multipleDropdown() {
	  
	  driver.navigate().to("http://jsbin.com/osebed/2");
	  
	  WebElement fruits=driver.findElement(By.xpath("//select[@id='fruits']"));
	  Select obj=new Select(fruits);
	  
	  boolean flag=obj.isMultiple();//true if drop-down element allows multiple selections at a time
	  System.out.println(flag);
	  
	  obj.selectByIndex(2);
	  obj.selectByValue("grape");
	  obj.selectByVisibleText("Banana");
	  
	  obj.deselectByIndex(2);			//deselect the option which is at 2nd position
	  obj.deselectByValue("grape");
	  obj.deselectByVisibleText("Banana");
	  
	  obj.deselectAll();			// clear all selected entries
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
