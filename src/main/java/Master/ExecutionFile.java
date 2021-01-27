package Master;
import static SWARMTestCases.StartBrowser.StartupBrowser;

import java.awt.AWTException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.google.common.base.Predicate;

import PageFactoryandTestdata.SWARMTestData;
import PageFactoryandTestdata.HelpingFunction;
import SWARMTestCases.*;
public class ExecutionFile {
	
	protected static WebDriver driver;
	protected static ExtentReports extent;
	protected static ExtentTest test;
	public static String browser="chrome";
	static String Suite="SWAARM.html";
	
	protected static String envirnment=SWARMTestData.stage;
		
	@BeforeSuite
			public static void SystmProperties() throws InterruptedException, AWTException, IOException{


				
			Systemroperties.Property();
	
		}

	
	@BeforeTest
			public void Startup() throws InterruptedException, AWTException, IOException{

					StartupBrowser(Suite);
			} 
	

	@Test(priority=1)
	 		public   void Login_to_SWAARM() throws InterruptedException, AWTException, IOException{
				 	Login.login();
				 	
			 	}
	
	
	@Test(priority=2)
	public static  void At_least_2_publishers_defined() throws InterruptedException, AWTException, IOException{
					VerifyPublisher.VerifyPublishers();
 				}

	@Test(priority=3)
	public static  void At_least_1_offer_with_a_budget_defined() throws InterruptedException, AWTException, IOException{
					ApprovedBudget.VerifyApprovedBudget();
 				}





			 @AfterMethod

			public void getResult(ITestResult result) throws IOException, InterruptedException{
				 //System.out.println(result.getStatus());
				if(result.getStatus()==ITestResult.SUCCESS){
	 				test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case is Passed", ExtentColor.GREEN));
	 				extent.flush();

		 			
	 				}

	 			
	 			if(result.getStatus()==ITestResult.FAILURE){
				 	test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test Case is Failed due to Below Issue", ExtentColor.RED));
				 	test.fail(result.getThrowable());
			 		extent.flush();
			 		}
				
	 			
	 			if(result.getStatus()==ITestResult.SKIP){
	 				System.out.print(result.getStatus());
	 				System.out.print("Test cases is skipped");
					test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "Test Case is SKIPPED", ExtentColor.YELLOW));
					test.skip(result.getThrowable());
					extent.flush();
				    }				 		
	 			
			 }
			 
			@AfterTest
			public void endReport(){
			
			//	driver.get(System.getProperty("user.dir")+"/Reports/CRMReport.html");
			}
			@AfterSuite
			 public void CloseBrowser() throws IOException {
				
				driver.quit();
			}
			 
			  	
}
