package base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public Properties prop;
	public WebDriver openBrowserApplicationURL(String browserName) {
		 prop=new Properties();
		File propFile=new File("src\\test\\resources\\data.properties");
		try {
		FileInputStream fis =new FileInputStream(propFile);
		prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		WebDriver driver=null;
		if(browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions opt =new ChromeOptions();
			opt.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(opt);
		}else if(browserName.equalsIgnoreCase("firefox")) {
			FirefoxOptions opt =new FirefoxOptions();
			opt.addArguments("--remote-allow-origins=*");
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver(opt);
		}else if(browserName.equalsIgnoreCase("edge")) {
			EdgeOptions opt =new EdgeOptions();
			opt.addArguments("--remote-allow-origins=*");
			WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver(opt);
		}
			
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
		
		
		return driver;
		}
	}

