package testNGAssgnments;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Ass_FileUpload {
	
	WebDriver driver;
	String url="https://demo.guru99.com/test/upload/";
	
  @Test
  public void fieUpload() {
	  
	  WebElement choosefile=driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
	  WebElement terms     =driver.findElement(By.xpath("//input[@id='terms']"));
	  WebElement submit    =driver.findElement(By.xpath("//button[@id='submitbutton']"));
	  WebElement msg	   =driver.findElement(By.xpath("//h3[@id='res']"));  
	  
	  choosefile.sendKeys(System.getProperty("user.dir")+"\\src\\main\\resources\\uploadFiles\\sampleupload.txt");
	  terms.click(); 
	  submit.click(); 
	  
	  //System.out.println(msg.getText());
	  boolean flag=msg.isEnabled();
	  Assert.assertTrue(flag);
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
  public void afterTest() {
  }

}
