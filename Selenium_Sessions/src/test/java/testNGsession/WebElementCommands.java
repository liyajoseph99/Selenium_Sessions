package testNGsession;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class WebElementCommands {
	
	WebDriver driver;
	String url="https://www.python.org";
	
  @Test
  public void commands() {
	  WebElement donate=driver.findElement(By.xpath("//a[@class='donate-button']"));
	  boolean flag=donate.isDisplayed();
	  System.out.println("iDisplayed:"+flag);
	  
	  boolean flag1=donate.isEnabled();
	  System.out.println("isEnabled:"+flag1);
	  
	  int X=donate.getLocation().getX();
	  int Y=donate.getLocation().getY();
	  System.out.println("location-donate(X,Y):("+X+","+Y+")");
	  System.out.println("location-donate:"+donate.getLocation());
	  
	  String tagname=donate.getTagName();
	  System.out.println("tagname:"+tagname);
	  
	  String cssvalue=donate.getCssValue("background-color");
	  System.out.println("cssvalue:"+cssvalue);
	  
	  String attribute=donate.getAttribute("class");
	  System.out.println("attribute:"+attribute);
	  
	  int h=donate.getSize().getHeight();
	  int w=donate.getSize().getWidth();
	  System.out.println("size-donate(h,w):("+h+","+w+")");
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
