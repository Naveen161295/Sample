package org.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class DriverManager {
	String browser="chrome";
	public WebDriver driver;
	private static DriverManager driverManager_inst;
	
	private DriverManager() {

	}
	
	public static DriverManager inst() {
		if (driverManager_inst==null) {
			driverManager_inst= new DriverManager();
		}
		return driverManager_inst;
	}
	
	public void driverInitialization() {
		PropertyFileReader.inst().prop_Reader();
		System.out.println(PropertyFileReader.inst().browser_name);
		switch (PropertyFileReader.inst().browser_name.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Sample\\drivers\\chromedriver.exe");
			ChromeOptions opt= new ChromeOptions();
			opt.setBinary("C:\\Users\\HP\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
			driver = new ChromeDriver(opt);
			driver.manage().window().maximize();
			
			break;

		default:
			System.out.println("The browser launch is terminated");
			break;
		}
		/*
		if (browser.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Sample\\drivers\\chromedriver.exe");
			ChromeOptions opt= new ChromeOptions();
			opt.setBinary("C:\\Users\\HP\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
			driver = new ChromeDriver(opt);
			driver.manage().window().maximize();
			
			
		}
		else {
			System.out.println("Teh chrome browser is not executed");
		}
		
		*/
		
	}

}
