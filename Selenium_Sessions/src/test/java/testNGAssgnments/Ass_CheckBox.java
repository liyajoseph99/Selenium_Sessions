package testNGAssgnments;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Ass_CheckBox {
	
	WebDriver driver;
	String url="https://demo.anhtester.com/basic-checkbox-demo.html";
	
 //Verify all the check boxes are selected or deselected by default
  @Test
  public void asingleCheckBox() {
	  
	  WebElement singlecheckbox=driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
	  
	  boolean flag=singlecheckbox.isSelected();
	  System.out.println("flag:"+flag);
	  Assert.assertFalse(flag);
	  System.out.println("The checkbox is not selected by default");
	 
  }
  
  //Verify all the check boxes are selected or deselected by default and uncheck all
  @Test
  public void multiCheckBox() {
	  
	  WebElement checkButton=driver.findElement(By.xpath("//input[@value='Check All']"));
	  String actualValue=checkButton.getAttribute("value");
	  System.out.println("buttonvalue:"+actualValue);  
	  String expectedValue="Check All";
	  Assert.assertEquals(actualValue, expectedValue);
	  System.out.println("The checkboxes are not selected by default"); 
	  
	  checkButton.click();
	  WebElement uncheckButton=driver.findElement(By.xpath("//input[@value='Uncheck All']"));
	  uncheckButton.click();
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
	  driver.quit();
  }

}
