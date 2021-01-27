
package SWARMTestCases;


import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import PageFactoryandTestdata.HelpingFunction;
import PageFactoryandTestdata.SWARMLocatiors;


public class VerifyPublisher extends HelpingFunction  {

				public static  void VerifyPublishers() throws InterruptedException, AWTException, IOException{
						
					SWARMLocatiors GetData=PageFactory.initElements(driver, SWARMLocatiors.class);
					test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					Click("Please click login button",GetData.Publishers);
				//	Thread.sleep(20000);
					List<WebElement> PubCount =	GetData.publisherrecords;
					
					WebElement element = driver.findElement(By.xpath("//tbody/tr[1]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					Thread.sleep(5000); 
					
					int recordcount = PubCount.size();
					Assert.assertTrue(recordcount>2);
				}				
}

