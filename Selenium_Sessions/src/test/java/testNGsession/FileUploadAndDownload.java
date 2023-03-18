package testNGsession;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class FileUploadAndDownload {
	
	WebDriver driver;
	String url="https://demoqa.com/upload-download";	
	
  @Test(enabled = false)
  public void download() {
	  WebElement download=driver.findElement(By.xpath("//a[@id='downloadButton']"));
	  download.click();
  }
  
  @Test
  public void upload() {
	  WebElement upload=driver.findElement(By.xpath("//input[@id='uploadFile']"));
	  //upload.sendKeys("C:\\Users\\ASUS\\eclipse-workspace\\Selenium_Sessions\\src\\main\\resources\\uploadFiles\\sampleupload.txt");
	  upload.sendKeys(System.getProperty("user.dir")+"\\src\\main\\resources\\uploadFiles\\sampleupload.txt");
  }
  
  @BeforeTest
  public void setUp() {
	 WebDriverManager.edgedriver().setup();
	 driver=new EdgeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 driver.get(url);
  }

  @AfterTest
  public void tearDown() {
  }

}
