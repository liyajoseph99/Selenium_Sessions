package testNGsession;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DynamicWebTable {
	WebDriver driver;
	String url="https://www.w3schools.com/html/html_tables.asp";
	String expectedResult="Ernst Handel";
	Boolean flag=false;
	
  @Test
  public void dynamicWebTable() {
	  
	  List<WebElement> rows=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
	  int rowCount=rows.size();
	  System.out.println(rowCount);
	  
	  List<WebElement> columns2=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td"));
	  int columnCount=columns2.size();
	  System.out.println(columnCount);
	  
	  for(int i=2;i<=rowCount;i++) {
		  for(int j=1;j<=columnCount;j++) {
			  if(j==1) {
				  WebElement element=driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+i+"]/td["+j+"]"));
				  String webData=element.getText();
				  if(webData.equalsIgnoreCase(expectedResult)) {
					  System.out.println("WebData is:"+webData+" expected result is:"+expectedResult);
					  flag=true;
				  }
				  System.out.print(webData+" ");	  
			  }  
		  } 
		  System.out.println();
	  }
	  Assert.assertTrue(flag);
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
