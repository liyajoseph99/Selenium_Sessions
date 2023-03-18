package testNGsession;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ActionClass {
	
	WebDriver driver;
	String url="https://demo.guru99.com/test/simple_context_menu.html";
	boolean flag=false;
	
  @Test(enabled = false)
  public void contextClick() {
	  driver.get(url);
	  WebElement rightclick=driver.findElement(By.xpath("//span[contains(text(),'right')]"));
	  Actions obj=new Actions(driver);   					//parameterised constructor
	  obj.contextClick(rightclick).build().perform();     //webelement target,passing the webelement , compile and run
	
	  if(rightclick.isEnabled()) {
		flag=true;
	  }
	  Assert.assertTrue(flag);
  }
  
  @Test(enabled = true,priority = 2)
  public void doubleClick() {
	  driver.get(url);
	  WebElement doubleclick=driver.findElement(By.xpath("//button[contains(text(),'Double-Click')]"));
	  Actions obj=new Actions(driver);
	  obj.doubleClick(doubleclick).build().perform();
	  
	  String actualResult=driver.switchTo().alert().getText();
	  String expectedResult="You double clicked me.. Thank You..";
	  driver.switchTo().alert().accept();
	  Assert.assertEquals(actualResult, expectedResult);
  }
  
  @Test(enabled = true,priority=1)
  public void mouseOver() {
	  driver.navigate().to("http://mrbool.com");
	  WebElement content=driver.findElement(By.xpath("//a[@class='menulink']"));
	  WebElement articles=driver.findElement(By.xpath("//a[contains(text(),'Articles')]"));
	  Actions obj=new Actions(driver);
	  obj.moveToElement(content).build().perform();
	  obj.click(articles).build().perform();
	  
	  String actualResult=driver.getTitle();
	  String expectedResult="Search Results - Mr.Bool";
	  Assert.assertEquals(actualResult, expectedResult);
  }
  
  @Test(enabled=false)
  public void draganddrop() {
	driver.navigate().to("https://demoqa.com/droppable/");  
	WebElement drag=driver.findElement(By.xpath("//div[@id='draggable']"));
	WebElement drop=driver.findElement(By.xpath("//div[@id='droppable']"));
	Actions obj=new Actions(driver);
	//obj.dragAndDrop(drag, drop).build().perform();
	obj.clickAndHold(drag).moveToElement(drop).release().build().perform();
	
	String actualResult=drop.getText();
	String expectedResult="Dropped!";
	Assert.assertEquals(actualResult, expectedResult);
  }
  
  @Test(enabled=false)
  public void keyboardHandling() {
	driver.navigate().to("https://www.google.com/");
	WebElement search=driver.findElement(By.xpath("//input[@name='q']"));
	Actions obj=new Actions(driver);
	obj.keyDown(search, Keys.SHIFT).sendKeys(search, "liya").keyUp(search, Keys.SHIFT).keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
 
  }
  
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  //driver.get(url);
  }

  @AfterTest
  public void afterTest() {
  }

}
