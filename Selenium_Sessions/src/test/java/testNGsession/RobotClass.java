package testNGsession;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class RobotClass {
	
	WebDriver driver;
	String url="https://blueimp.github.io/jQuery-File-Upload";
	
  @Test
  public void file_Upload() throws AWTException {
	  	  
	  StringSelection s=new StringSelection(System.getProperty("user.dir")+"\\src\\main\\resources\\uploadFiles\\sampleFile.jpeg"); //selecting the string(path) like ctrl+A
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);    													//passing(copying) the string to clipboard
	  
	  WebElement upload=driver.findElement(By.cssSelector(".btn.btn-success.fileinput-button"));
	  upload.click();

	  Robot robot=new Robot();
	  robot.delay(250);
	  robot.keyPress(KeyEvent.VK_ENTER);			//pasting the path in the textbox using ctrl+V and press enter
	  robot.keyRelease(KeyEvent.VK_ENTER);
	  robot.keyPress(KeyEvent.VK_CONTROL);
	  robot.keyPress(KeyEvent.VK_V);
	  robot.keyRelease(KeyEvent.VK_CONTROL);
	  robot.keyRelease(KeyEvent.VK_V);
	  robot.keyPress(KeyEvent.VK_ENTER);
	  robot.keyRelease(KeyEvent.VK_ENTER);
	  robot.delay(250);
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
  public void tearDown() {
  }

}
