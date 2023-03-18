package testNGsession;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Alert {
	
	WebDriver driver;
	String url="http://demo.automationtesting.in/Alerts.html";

  @Test(priority = 1)
  public void simpleAlert() {  
	  
	  WebElement simpleAlertButton=driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
	  simpleAlertButton.click();
	  driver.switchTo().alert().accept(); // press OK button
  }
  
  @Test(priority=2)
  public void confirmationAlert() {
	  
	  WebElement confirmationAlert=driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel ')]"));
	  confirmationAlert.click();
	  
	  WebElement confirmationAlertButton=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
	  confirmationAlertButton.click();
	  
	  //checking the pop-up message
	  
	  String actual=driver.switchTo().alert().getText();
	  String expected="Press a Button !";
	  Assert.assertEquals(actual, expected);
	  System.out.println("confirmation Alert");
	  
	  //accept the alert and checking the confirmation message (pressed OK)
	  
	  driver.switchTo().alert().accept();
	  
	  WebElement okMessage=driver.findElement(By.xpath("//p[contains(text(),'You pressed Ok')]"));
	  String expectedResult="You pressed Ok";
	  String actualResult = okMessage.getText();
	  System.out.println(actualResult);
	  Assert.assertEquals(expectedResult, actualResult);
	  System.out.println("Pressed OK button");
	  
	  //dismiss the alert and checking the confirmation message (pressed Cancel)
	  
	  confirmationAlertButton.click();
	  
	  driver.switchTo().alert().dismiss();
	  
	  WebElement cancelMessage=driver.findElement(By.xpath("//p[contains(text(),'You Pressed Cancel')]"));
	  String expectedResult1="You Pressed Cancel";
	  String actualResult1=cancelMessage.getText();
	  Assert.assertEquals(actualResult1, expectedResult1);
	  System.out.println("Pressed Cancel button");
  }
  
  @Test(priority = 3)
  public void promptalert() {
	  
	  WebElement promptalert=driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox ')]"));
	  promptalert.click();
	  
	  WebElement promptalertbutton=driver.findElement(By.xpath("//button[@class='btn btn-info']"));
	  promptalertbutton.click();
	  
	  //checking the pop-up message
	  
	  String actual=driver.switchTo().alert().getText();
	  String expected="Please enter your name";
	  Assert.assertEquals(actual, expected);
	  System.out.println("prompt alert");
	  
	  //passing the name to the alert box and press ok
	  
	  String name="Test Demo";
	  driver.switchTo().alert().sendKeys(name);
	  driver.switchTo().alert().accept();
	  
	  WebElement OkMessage=driver.findElement(By.xpath("//p[@id='demo1']"));  
	  String actualResult=OkMessage.getText();
	  String expectedResult="Hello "+name+" How are you today";
	  Assert.assertEquals(actualResult, expectedResult);
	  System.out.println("Pressed Ok button");
	  
	  //click the button again and pressed cancel
	  
	  promptalertbutton.click();
	  driver.switchTo().alert().dismiss();
  }
  
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.edgedriver().setup();
	  driver=new EdgeDriver();
	  driver.manage().window().maximize();
	  driver.get(url);
  }

  @AfterTest
  public void afterTest() {
  }

}
