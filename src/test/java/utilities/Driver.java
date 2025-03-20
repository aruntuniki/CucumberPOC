package utilities;

import org.openqa.selenium.WebDriver;
import java.time.Duration; 
import org.openqa.selenium.chrome.ChromeDriver; 
import org.openqa. selenium.chrome.ChromeOptions; 
import org.openqa.selenium.edge.EdgeDriver; 
import org.openqa.selenium. remote.RemoteWebDriver; 
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	
	private static WebDriver driver;
	public static WebDriver getDriver () 
	{
	String browser = Configuration.getProperty("browser") ;
	//String browser = System. getProperty ("browser") ;
	if (driver == null || ( (RemoteWebDriver) driver).getSessionId() == null) { // driver==null
	if (browser. equals ("chrome")) {
	ChromeOptions options = new ChromeOptions () ;
	//options .addArguments ("--headless");
	options. addArguments ("--disable-extensions"); 
	options .addArguments ("--whitelisted-ips=''") ; 
	options .addArguments ("--start-maximized");
	options. setExperimentalOption ("useAutomationExtension", false) ;
	//WebDriverManager. chromedriver () . setup () ;
	//to run chrome browser locally use below code
	WebDriverManager.chromedriver ().cachePath ("C:\\SoftwareDistribution").avoidOutputTree().setup();
	driver = new ChromeDriver(options); //RemoteWebDriver
	} 
	else if 
	(browser. equals ("edge")) {
	WebDriverManager.edgedriver().setup() ;
	driver = new EdgeDriver();
	}
	else {
	return driver;
	}
	}
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage () .window() .maximize ();
	return driver;

}
	}
