package testNGsession;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class CrossBrowser {
	
	WebDriver driver;
	
  @Test
  public void closeandquit() {	
	
	  driver.findElement(By.linkText("Click Here")).click();
  }
  
  @BeforeTest
  @Parameters({"browser"})
  public void beforeTest(String browser1) {
	  if(browser1.equalsIgnoreCase("edge")) {
		  WebDriverManager.edgedriver().setup();
		  driver=new EdgeDriver();
		  driver.manage().window().maximize();
	  }
	  
	  else if(browser1.equalsIgnoreCase("chrome")) {
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
	  }	
	  
	  driver.get("http://demo.guru99.com/popup.php");          //login
  }

  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.close();
	  Thread.sleep(1000);
	  driver.quit();
  }

}
