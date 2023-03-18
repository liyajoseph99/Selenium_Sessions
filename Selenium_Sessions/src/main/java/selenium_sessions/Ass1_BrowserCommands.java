package selenium_sessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ass1_BrowserCommands {

	public static void main(String[] args) {
		
		String url="http://www.opesmount.in/grocerystore1/";
		String title_url="Grocerystore";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://www.opesmount.in/grocerystore1/");
		
		String title=driver.getTitle();
		System.out.println("Title:"+title);
		
		String cur_url=driver.getCurrentUrl();
		
		if(title_url.equals(title)) {
			System.out.println("title of the page is correct");			
		}
		else {
			System.out.println("title of the page is incorrect");
		}
		
		if(url.equals(cur_url)) {
			System.out.println("url of the page is correct");
		}
		else {
			System.out.println("url of the page is incorrect");
		}		
		driver.close();
	}
}
