package selenium_sessions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverBrowserCommands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.edge.driver", "C:\\Drivers\\New\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver(); 
		driver.get("https://www.google.co.in");
	}

}
