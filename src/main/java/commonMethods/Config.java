package commonMethods;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
//import com.gargoylesoftware.htmlunit.javascript.host.URL;

import atu.testng.reports.ATUReports;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Config extends Keywords {
	public WebDriver driver;
	ATUReports atuRep = new ATUReports();

	public WebDriver getDriver() throws MalformedURLException {
		return this.driver;

	}

	public void setDriver(WebDriver paramDriver) throws MalformedURLException {
		this.driver = paramDriver;
	}

	public WebDriver gerWebDriver1(String browser, String buildname, String userflowname) throws Exception {
		String Url = "https://mak.l:oVWll37qqWzqQS1822t7wWYfqH9fpGoj08w4HPStM26Tk0ibu2@hub.lambdatest.com/wd/hub";
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "chrome");
		capabilities.setCapability("version", "latest");
		capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get any available
//		capabilities.setCapability("platform", "macOS Sonoma");
//		capabilities.setCapability("platformName", "macOS Sonoma");	
//		capabilities.setCapability("version", "15.0");
		capabilities.setCapability("build", buildname);
		capabilities.setCapability("name", userflowname);
		capabilities.setCapability("selenium_version", "4.12.0"); // To enable network logs
		capabilities.setCapability("visual", true); // To enable step by step screenshot
		capabilities.setCapability("video", true); // To enable video recording
		capabilities.setCapability("console", true); // To capture console logs
		capabilities.setCapability("terminal", false); // To capture terminal logs
		LoggingPreferences logPrefs = new LoggingPreferences();
	    logPrefs.enable(LogType.BROWSER, Level.ALL);
	    capabilities.setCapability("goog:loggingPrefs", logPrefs);
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("resolution", "1024x768");
		capabilities.setCapability("LT:Options", ltOptions);
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new RemoteWebDriver(new URL(Url), capabilities);
		driver.setFileDetector(new LocalFileDetector());
		driver.manage().window().maximize();
		return driver;

	}
	/*
	 * public WebDriver gerWebDriver1(String browser) throws MalformedURLException {
	 * String Url =
	 * "https://mak.l:oVWll37qqWzqQS1822t7wWYfqH9fpGoj08w4HPStM26Tk0ibu2@hub.lambdatest.com/wd/hub";
	 * DesiredCapabilities capabilities = new DesiredCapabilities();
	 * //capabilities.setCapability("os", "Windows");
	 * 
	 * capabilities.setCapability("platformName", "Windows 10");
	 * capabilities.setCapability("version","latest");
	 * capabilities.setCapability("browserName", "Chrome");
	 * capabilities.setCapability("debug", "true");
	 * capabilities.setCapability("networkLogs", "true");
	 * capabilities.setCapability("local", "false");
	 * capabilities.setCapability("browserstack.debug", "true");
	 * capabilities.setCapability("browserstack.networkLogs", "true");
	 * 
	 * 
	 * 
	 * //DesiredCapabilities capabilities = new DesiredCapabilities();
	 * capabilities.setCapability("browserName", "chrome");
	 * capabilities.setCapability("version", "latest");
	 * capabilities.setCapability("platform", "win10"); // If this cap isn't
	 * specified, it will just get any available one
	 * capabilities.setCapability("build", "Staging_Firstsuite");
	 * capabilities.setCapability("name", "Staging_1");
	 * capabilities.setCapability("network", true); // To enable network logs
	 * capabilities.setCapability("visual", true); // To enable step by step
	 * screenshot capabilities.setCapability("video", true); // To enable video
	 * recording capabilities.setCapability("console", true); // To capture console
	 * logs capabilities.setCapability("terminal", true); // To capture terminal
	 * logs
	 * 
	 * HashMap<String, Object> ltOptions = new HashMap<String, Object>();
	 * ltOptions.put("resolution", "1366x768");
	 * capabilities.setCapability("LT:Options", ltOptions);
	 * 
	 * WebDriverManager.chromedriver().setup(); WebDriver driver = new
	 * RemoteWebDriver(new URL(Url),capabilities);
	 * driver.manage().window().maximize(); return driver;
	 * 
	 * }
	 */
//public WebDriver gerWebDriver1(String browser) throws MalformedURLException {
//	String Url  = "https://santhan_qIkUAy:shMwz3KspfwGMpmxqv8D@hub-cloud.browserstack.com/wd/hub";
//	DesiredCapabilities capabilities = new DesiredCapabilities();
//	capabilities.setCapability("os", "Windows");
//	capabilities.setCapability("os_version", "10");
//	capabilities.setCapability("browser-version", "latest");
//	capabilities.setCapability("browserName", "chrome");
//	capabilities.setCapability("debug", "true");
//	capabilities.setCapability("networkLogs", "true");
//	capabilities.setCapability("local", "false");
//	capabilities.setCapability("browserstack.debug", "true");
//	capabilities.setCapability("browserstack.networkLogs", "true");
//	WebDriverManager.chromedriver().setup();
//	WebDriver driver = new RemoteWebDriver(new URL(Url),capabilities);
//	driver.manage().window().maximize();
//	return driver;
//	
//}

	public WebDriver getWebDriver1(String browserName) throws MalformedURLException {
		if (browserName.equals("Chrome")) {
			// System.setProperty("webdriver.chrome.driver",
			// System.getProperty("user.dir")+"/Comdex/driver/chromedriver.exe");

			ChromeOptions options = new ChromeOptions();

			WebDriverManager.chromedriver().setup();
			options.addArguments("disable-notifications");
			options.addArguments("--disable-extensions"); // to disable extension
			options.addArguments("--disable-notifications"); // to disable notification
			options.addArguments("--disable-application-cache"); // to disable cache
			options.addArguments("--safebrowsing-disable-download-protection");
			options.addArguments("ignore-certificate-errors");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--disable-gpu");
			LoggingPreferences logPrefs = new LoggingPreferences();
			logPrefs.enable(LogType.BROWSER, Level.ALL);
			// options.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
			options.setCapability("goog:loggingPrefs", logPrefs);
			// options.addArguments("--log-level=1");
			options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
			WebDriver driver = new ChromeDriver(options);
			System.out.println("Chrome Browser launched...");
			setDriver(driver);
			driver.manage().window().maximize();

			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 1);
			prefs.put("download.default_directory", System.getProperty("user.dir") + "\\DownloadedFiles");

		} else if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");

			FirefoxOptions option = new FirefoxOptions();
			option.addPreference("dom.webnotifications.enabled", false);
			// option.addPreference("app.update.enabled", false);
			// option.addPreference("geo.enabled", false);
			WebDriver driver = new FirefoxDriver(option);
			System.out.println("Firefox Browser launched...");
			// driver = new FirefoxDriver();
			setDriver(driver);
			driver.manage().window().maximize();

		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			setDriver(driver);
			driver.manage().window().maximize();

		}
		return driver;
	}

	public WebDriver getWebDriver(String browserName) throws Exception {

		WebDriver driver = null;
		if (browserName.equals("Chrome")) {

			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
//			options.addArguments("--headless");
			options.addArguments("disable-notifications");
//			options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
			LoggingPreferences logPrefs = new LoggingPreferences();
		    logPrefs.enable(LogType.BROWSER, Level.ALL);
//		    logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
		    options.setCapability("goog:loggingPrefs", logPrefs);
			 driver = new ChromeDriver(options);
			System.out.println("Chrome Browser launched...");	
			setDriver(driver);
//			Dimension dimension=new Dimension(1200,800);
//			driver.manage().window().setSize(dimension);
			driver.manage().window().maximize();

		}
		return driver;
		
	}

	
}
