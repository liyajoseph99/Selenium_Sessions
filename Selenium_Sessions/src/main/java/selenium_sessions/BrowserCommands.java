package selenium_sessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserCommands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.anhtester.com/");
				
		String title=driver.getTitle();
		System.out.println("Title:"+title);
		
		String url=driver.getCurrentUrl();
		System.out.println("current url:"+url);
		
		//String source=driver.getPageSource();
		//System.out.println(source);
		
		driver.close();
	}
}
