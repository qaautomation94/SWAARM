
package SWARMTestCases;


import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import PageFactoryandTestdata.SWARMLocatiors;
import PageFactoryandTestdata.SWARMTestData;
import PageFactoryandTestdata.HelpingFunction;


public class ApprovedBudget extends HelpingFunction  {
public static int counter=0;

				public static  void VerifyApprovedBudget() throws InterruptedException, AWTException, IOException{
						
						
					SWARMLocatiors GetData=PageFactory.initElements(driver, SWARMLocatiors.class);
					test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
				
					Click("Please click login button",GetData.Offers);
					Thread.sleep(20000);
					
					List<WebElement> EyeCount =	GetData.ViewBudget;
					int EyeRecordCount = EyeCount.size();
					
					for(int count=0; count<EyeRecordCount; count++) {
						
						WebElement element = driver.findElement(By.xpath("//button[contains(@data-test, 'inspect')]"));
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
						Thread.sleep(5000); 
					
						EyeCount.get(count).click();
						Thread.sleep(5000);
						List<WebElement> nb =	GetData.nobudget;
						int nb1 = nb.size();

						if(nb1==0) {
							counter=counter+1;
							break;
						}
						else {
							Click("Please click login button",GetData.Offers);
							Thread.sleep(5000);
						}
						
					}
					
					Assert.assertTrue(counter>0);

			
				}
				
}

