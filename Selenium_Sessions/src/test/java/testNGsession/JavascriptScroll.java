package testNGsession;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class JavascriptScroll {
	
	WebDriver driver;
	String url="https://demo.guru99.com/test/guru99home";
	
  @Test(enabled = false)
  public void scrollUpAndDown() {
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  //js.executeScript("window.scrollBy(0,6000)");					//vertical scroll down, so x=0,y=6000
	  //js.executeScript("window.scrollBy(0,-6000)");					//vertical scroll up , so x=0,y=-6000
	  
	  //WebElement linux=driver.findElement(By.xpath("//i[@class='icon-linux']")); 
	  //js.executeScript("arguments[0].scrollIntoView()", linux);						//scroll till the element is found 
	  		
	  js.executeScript("window.scrollTo(0,document.body.scrollHeight)");  				//scroll till end of the page
  }
  
  @Test
  public void horizontalScroll() {
	  driver.navigate().to("https://demo.guru99.com/test/guru99home/scrolling.html");
	  
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  //js.executeScript("window.scrollBy(1000,0)");					//horizontal scroll right, so x=1000,y=0
	  //js.executeScript("window.scrollBy(-250,0)");					//horizontal scroll left , so x=-250,y=0
	  
	  WebElement vbScript=driver.findElement(By.xpath("//i[@class='icon-code-fork']"));
	  js.executeScript("arguments[0].scrollIntoView()", vbScript);			//scroll till the element is found
  }
  
  @BeforeTest
  public void setUp() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  driver.get(url);
  }

  @AfterTest
  public void afterTest() {
  }

}
