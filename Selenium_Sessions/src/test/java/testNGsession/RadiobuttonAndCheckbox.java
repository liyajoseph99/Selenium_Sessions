package testNGsession;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class RadiobuttonAndCheckbox {
	
	WebDriver driver;
	String url="https://demo.guru99.com/test/radio.html";
		
  @Test
  public void radioButton() {
	  
	  WebElement radiobutton1=driver.findElement(By.xpath("//input[@id='vfb-7-1']"));
	  WebElement radiobutton2=driver.findElement(By.xpath("//input[@id='vfb-7-2']"));
	  WebElement radiobutton3=driver.findElement(By.xpath("//input[@id='vfb-7-3']"));
	  
	  radiobutton1.click();
	  radiobutton2.click();
	  radiobutton3.click();
	  
	  boolean flag1=radiobutton1.isSelected();
	  boolean flag2=radiobutton2.isSelected();
	  boolean flag3=radiobutton3.isSelected();
	  
	  System.out.println("flag1:"+flag1);
	  System.out.println("flag2:"+flag2);
	  System.out.println("flag3:"+flag3);
	  
	  Assert.assertFalse(flag1);
	  Assert.assertFalse(flag2);
	  Assert.assertTrue(flag3);
	  
  }
  
  @Test
  public void checkBoxSelect() {
	 
	  WebElement checkbox1=driver.findElement(By.xpath("//input[@id='vfb-6-0']"));
	  WebElement checkbox2=driver.findElement(By.xpath("//input[@id='vfb-6-1']"));
	  WebElement checkbox3=driver.findElement(By.xpath("//input[@id='vfb-6-2']"));
	  
	  checkbox1.click();
	  checkbox2.click();
	  checkbox3.click();
	  
	  boolean flag1=checkbox1.isSelected();
	  boolean flag2=checkbox2.isSelected();
	  boolean flag3=checkbox3.isSelected();
	  
	  System.out.println("flag1:"+flag1);
	  System.out.println("flag2:"+flag2);
	  System.out.println("flag3:"+flag3);
	  
	  Assert.assertTrue(flag1);
	  Assert.assertTrue(flag2);
	  Assert.assertTrue(flag3);
  }
  
  @Test
  public void checkBoxUnselect() {
	  
	  WebElement checkbox1=driver.findElement(By.xpath("//input[@id='vfb-6-0']"));
	  WebElement checkbox2=driver.findElement(By.xpath("//input[@id='vfb-6-1']"));
	  WebElement checkbox3=driver.findElement(By.xpath("//input[@id='vfb-6-2']"));
	  
	  checkbox1.click();
	  checkbox2.click();
	  checkbox3.click();
	  
	  boolean flag1=checkbox1.isSelected();
	  boolean flag2=checkbox2.isSelected();
	  boolean flag3=checkbox3.isSelected();
	  
	  System.out.println("flag1:"+flag1);
	  System.out.println("flag2:"+flag2);
	  System.out.println("flag3:"+flag3);
	  
	  Assert.assertFalse(flag1);
	  Assert.assertFalse(flag2);
	  Assert.assertFalse(flag3);
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
