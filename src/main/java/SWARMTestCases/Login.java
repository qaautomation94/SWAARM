
package SWARMTestCases;


import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PageFactoryandTestdata.HelpingFunction;
import PageFactoryandTestdata.SWARMLocatiors;
import PageFactoryandTestdata.SWARMTestData;


public class Login extends HelpingFunction  {

				public static  void login() throws InterruptedException, AWTException, IOException{
						
						
					SWARMLocatiors GetData=PageFactory.initElements(driver, SWARMLocatiors.class);
					test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					driver.get(envirnment);
					WebDriverWait wait=new WebDriverWait(driver, 60);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@name,'username')]")));

					Input("Please Enter UserName", GetData.UserName, SWARMTestData.USER);
					Input("Please Enter Password", GetData.Password, SWARMTestData.PASS);
					Click("Please click login button",GetData.LoginButton);
					Thread.sleep(10000);
					Assert.assertTrue(GetData.Publishers.isDisplayed());

					
				}
				
}

