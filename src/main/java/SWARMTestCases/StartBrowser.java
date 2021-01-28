package SWARMTestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Master.ExecutionFile;
import io.github.bonigarcia.wdm.WebDriverManager;


public class StartBrowser extends ExecutionFile {


				public static void StartupBrowser(String Suite) throws InterruptedException, AWTException, IOException{
	
					
						if(browser.equals("chrome")){

						     WebDriverManager.chromedriver().setup();
						     ChromeOptions options = new ChromeOptions();

						options.addArguments("-incognito");
						options.addArguments("--remote-debugging-port=54983");
						options.addArguments("--disable-features=ExtensionsToolbarMenu");
						options.addArguments("--disable-blink-features=AutomationControlled");
						options.addArguments("--disable-blink-features-AutomationControlled");
						options.addArguments("enable-automation");
						options.addArguments("disable-automation");
						options.addArguments("enable-automation=false");

						options.setExperimentalOption("useAutomationExtension", false);
						options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));  

					  	options.addArguments("--disable-popup-blocking");
					  	options.addArguments("--disable-extensions");
					  	options.addArguments();
					 	options.addArguments("--start-maximized");
					// 	options.addArguments("--start-fullscreen");

					  	driver = new ChromeDriver(options);

					 	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
						}
					}
			
			}







