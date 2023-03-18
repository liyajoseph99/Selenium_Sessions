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

public class Ass_RadioButton {
	
	WebDriver driver;
	String url="http://demo.guru99.com/test/ajax.html";
	
  @Test
  public void radioButtonClick() {
	  
	WebElement yesButton= driver.findElement(By.xpath("//input[@name='name' and @value='Yes']"));
	WebElement noButton = driver.findElement(By.xpath("//input[@name='name' and @value='No']"));
	
	boolean yesFlag = yesButton.isSelected();
	boolean noFlag  = noButton.isSelected();
	
	Assert.assertFalse(yesFlag);
	Assert.assertFalse(noFlag);
	System.out.println("The 'Yes' and 'No' radio button is deselected by default");	
	
	noButton.click();
	
	boolean yesFlag1 = yesButton.isSelected();
	boolean noFlag1  = noButton.isSelected();
	
	Assert.assertFalse(yesFlag1);
	Assert.assertTrue(noFlag1);
	System.out.println("the radio button 'No' is clicked");
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
