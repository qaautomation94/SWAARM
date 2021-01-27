package Master;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import TestDataandLocators.TestData;

public class ConnectExecution extends HelpingFunction {
	
	@BeforeClass
	  public void Browser_Chrome() throws IOException, InterruptedException, AWTException{
		 
		
			ConnectScenarios.BrowserChrome();
		 
	}
	@Test(priority=1)
	  public void ConnectLoginApp() throws IOException, InterruptedException, AWTException
	{
		
		ConnectScenarios.Connect_LoginApp();
		
	}
	
	@Test(priority=2)
	public void TransactionNewCard()throws IOException, InterruptedException, AWTException
	{
		if (driver.getCurrentUrl().contains("connect.asicentral"))
			throw new SkipException("Skipping this exception");
		ConnectScenarios.textsearch();
		ConnectScenarios.ProspectHunter();
		ConnectScenarios.PaymentDetailPage_Verification();
		ConnectScenarios.Transaction_NewCard();
	}
	@Test(priority=3)
	public  void Transactionsavecardverification()throws IOException, InterruptedException, AWTException
	{
		if (driver.getCurrentUrl().contains("connect.asicentral"))
			throw new SkipException("Skipping this exception");
		ConnectScenarios.Transaction_savecard();
		ConnectScenarios.Transaction_savecardstep2();
		ConnectScenarios.Transaction_savecardverification();
	}
	@Test(priority=4)
	 public void Remove_CreditCard()throws IOException, InterruptedException, AWTException
	 {
		if (driver.getCurrentUrl().contains("connect.asicentral"))
			throw new SkipException("Skipping this exception");
		ConnectScenarios.RemoveCreditCard();
	 }
	
	@Test(priority=5)

	public void TransactionExistingCard()throws IOException, InterruptedException, AWTException
	{
		if (driver.getCurrentUrl().contains("connect.asicentral"))
			throw new SkipException("Skipping this exception");
		ConnectScenarios.Transaction_ExistingCard();
	}
	
	@Test(priority=6)
	public void ProspectListvalidation()throws IOException, InterruptedException, AWTException
	{
		
		ConnectScenarios.ProspectList_validation();
	}
	@Test(priority=7)
	public void AddDistFromPL()throws IOException, InterruptedException, AWTException
	{
		ConnectScenarios.AddDistToPL();
	}
	@Test(priority=8)
	public void Remove_DistFromPL()throws IOException, InterruptedException, AWTException
	{
		ConnectScenarios.RemoveDistFromPL();
	}
	@Test(priority=9)
	public void Monitor_List()throws IOException, InterruptedException, AWTException
	{
		
		ConnectScenarios.MonitorList();
	}
	@Test(priority=10)
	public void AddandRemoveDistML()throws IOException, InterruptedException, AWTException
	{
		if (driver.getCurrentUrl().contains("connect.asicentral"))
			throw new SkipException("Skipping this exception");
		ConnectScenarios.AddandRemoveDist_ML();
	}
	@Test(priority=11)
	public void BasicSearchDistributor()throws IOException, InterruptedException, AWTException
	{
		ConnectScenarios.BasicSearch_Distributor();
	}
	@Test(priority=12)
	public void BasicSearchCompany()throws IOException, InterruptedException, AWTException
	{
		ConnectScenarios.BasicSearch_Company();
	}
	@Test(priority=13)
	public void Advanced_SearchResult()throws IOException, InterruptedException, AWTException
	{
		ConnectScenarios.AdvancedSearchResult();
	}
	@Test(priority=14)
	public void AdvancedSearchStateDropDownResult()throws IOException, InterruptedException, AWTException
	{
		ConnectScenarios.AdvancedSearch_StateDropDownResult();
	}
	@Test(priority=15)
	public void AdvancedSearchRangeDropDownResult()throws IOException, InterruptedException, AWTException
	{
		ConnectScenarios.AdvancedSearch_RangeDropDownResult();
	}
	@Test(priority=16)
	public void AdvancedSearchProductlineDropDownResult()throws IOException, InterruptedException, AWTException
	{
		ConnectScenarios.AdvancedSearch_ProductlineDropDownResult();
	}
	@Test(priority=17)
	public void AdvancedSearchCustomerTypeDropDownResult()throws IOException, InterruptedException, AWTException
	{
		ConnectScenarios.AdvancedSearch_CustomerTypeDropDownResult();
	}
	@Test(priority=18)
	public void AdvancedSearchPayHabitFromDropDownResult()throws IOException, InterruptedException, AWTException
	{
		ConnectScenarios.AdvancedSearch_PayHabitFromDropDownResult();
	}
	@Test(priority=19)
	public void AdvancedSearchPayHabiToDropDownResult()throws IOException, InterruptedException, AWTException
	{
		ConnectScenarios.AdvancedSearch_PayHabiToDropDownResult();
	}
	@Test(priority=20)
	public void AdvancedSearchViewDaysDropDownResult()throws IOException, InterruptedException, AWTException
	{
		ConnectScenarios.AdvancedSearch_ViewDaysDropDownResult();
	}
	@Test(priority=21)
	public void Distributor_Profile()throws IOException, InterruptedException, AWTException
	{
		ConnectScenarios.DistributorProfile_ESP_Product_Display();
	}
	@Test(priority=22)
	public void DistCreditScore()throws IOException, InterruptedException, AWTException
	{
		ConnectScenarios.Dist_CreditScore();
	}
	@Test(priority=23)
	public void DistCreditHistoryCurrent6months()throws IOException, InterruptedException, AWTException
	{
		ConnectScenarios.DistCreditHistory_Current6months();
	}
	@Test(priority=24)
	public void DistCreditHistoryPre6months()throws IOException, InterruptedException, AWTException
	{
		ConnectScenarios.DistCreditHistory_Pre6months();
	}
	
	@Test(priority=25)
	public void DistributorCreditHistory_IndustryAverage()throws IOException, InterruptedException, AWTException
	{
		ConnectScenarios.DistCreditHistory_IndustryAverage();
	}
	@Test(priority=26)
	public void DistributorCreditHistory_GeneralCredit()throws IOException, InterruptedException, AWTException
	{
		ConnectScenarios.DistCreditHistory_GeneralCredit();
	}
	@Test(priority=27)
	public void AveragePayingHabit_ReportsWithPurchases()throws IOException, InterruptedException, AWTException
	{
		ConnectScenarios.AveragePayingHabitReportsWithPurchases();
	}
	@Test(priority=28)
	public void AveragePayingHabit_TransactionWithPurchases()throws IOException, InterruptedException, AWTException
	{
		ConnectScenarios.APHTransactionWithPurchases();
	}
	@Test(priority=29)
	public void AveragePayingHabit_Volumn()throws IOException, InterruptedException, AWTException
	{
		ConnectScenarios.AveragePayingHabitsVolumn();
	}
	@Test(priority=30)
	public void Single_Transaction()throws IOException, InterruptedException, AWTException
	{
		if (driver.getCurrentUrl().contains("connect.asicentral"))
			throw new SkipException("Skipping this exception");
			ConnectScenarios.SingleTransaction();
	}
	
	@AfterMethod
	public void getResult(ITestResult result)throws IOException 
	{
	test = extent.createTest(result.getName());
	if(result.getStatus()==ITestResult.SUCCESS)
		{
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Test Case is passed.", ExtentColor.GREEN));
			extent.flush();
		}
		if(result.getStatus()==ITestResult.FAILURE)
		{
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test Case is Failed.", ExtentColor.RED));
			test.fail(result.getThrowable());
			extent.flush();
		}
		if(result.getStatus()==ITestResult.SKIP)
		{
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "Test Case is Skipped.", ExtentColor.BLUE));
			//test.fail(result.getThrowable());
			extent.flush();
		}
	}
	
	@AfterSuite
	public void closebrowser()
	{
		
		driver.close();
		
	}
	public static void setDriver(WebDriver driver) {
		ConnectExecution.driver = driver;
	}

}
