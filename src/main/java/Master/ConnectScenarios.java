package Master;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.Popup;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


import TestDataandLocators.Locators;
import TestDataandLocators.TestData;
import io.github.bonigarcia.wdm.WebDriverManager;


public class ConnectScenarios extends ConnectExecution
{
		public static String[] dateval;
		public static DateFormat formatdate;
		public static Calendar cal;
		public static String newDate;
		static ExtentHtmlReporter htmlReporter;
		public static String NAcredit;
		public static String NAcreditscore;
		public static String currentcredit;
		public static int intcredit;
		public static String creditscore;
		public static int intcreditscore;
		public static String browser="chrome";
		
		
		@Parameters("Browser")
	  public static void BrowserChrome() throws IOException, InterruptedException, AWTException
	  {
			if(browser.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				  setDriver(new ChromeDriver());
				htmlReporter = new ExtentHtmlReporter (System.getProperty("user.dir")+"/Reports/Connect_Level2Report-10.101.2.20.html");
				extent = new ExtentReports ();
				extent.attachReporter(htmlReporter);
				extent.setSystemInfo("Host Name", "Connect");
				extent.setSystemInfo("Environment", "Connect Automation Testing");
				extent.setSystemInfo("User Name", "Bakhtawar");
				htmlReporter.config().setDocumentTitle("Connect Report");
				htmlReporter.config().setReportName("Connect Report");
				htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
				htmlReporter.config().setTheme(Theme.DARK);
			}
		driver.get(TestData.appurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
	}
	

	public static void Connect_LoginApp() throws IOException, InterruptedException, AWTException
	{
		Locators connect = PageFactory.initElements(driver, Locators.class);
		connect.ASIno.sendKeys(TestData.ASI);
		String val=connect.ASIno.getAttribute("value");
		System.out.println("value:"+val);
		
	if(val.equals(TestData.ASI))
	{
		System.out.println("Value match");
	}
	else 
	{
		System.out.println("Value not match");
	}
		String placeholder1=connect.ASIno.getAttribute("placeholder");
		System.out.println("Placeholder:" +placeholder1);
		String placeholder2=connect.username.getAttribute("placeholder");
		System.out.println("Placeholder2:" +placeholder2);
		String placeholder3=connect.passwrod.getAttribute("placeholder");
		System.out.println("Placeholder3:" +placeholder3);
		connect.username.sendKeys(TestData.username);
		connect.passwrod.sendKeys(TestData.password);
		connect.loginbtn.click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.findElement(By.xpath("//img[contains(@src,'ConnectLogo.png')]")).isDisplayed());
	
		
	}
	
	
	public static void textsearch()throws IOException, InterruptedException, AWTException
	{
		 if (driver.getCurrentUrl().contains("stage")|driver.getCurrentUrl().contains("uat"))
		 {
		Locators connect = PageFactory.initElements(driver, Locators.class);
		if(ExpectedConditions.alertIsPresent() != null)
		{
            driver.findElement(By.xpath("//map[contains(@name,'closeAlert')]/area")).click();
		}
		connect.textsearch.sendKeys(TestData.textsearch);
		 connect.GO.click();
		 if(connect.distsearchtextverification.getText().contains("Advanced Search Results"))
		 {
			 System.out.println("If your search returned more than 2000 records, only the first 2000 will be displayed. ");
			 
		 }
		 else
		 {
			 System.out.println("Dist search result not found");
			 
		 }
		connect.Phunter.click();
	 }
		 
	}
	
	public static  void ProspectHunter()throws IOException, InterruptedException, AWTException
	{
		if (driver.getCurrentUrl().contains("stage")|driver.getCurrentUrl().contains("uat"))
		{
		Locators connect = PageFactory.initElements(driver, Locators.class);
	 if (driver.getCurrentUrl().contains("stage")|driver.getCurrentUrl().contains("uat"))
	 {
	 if(!connect.termscheckbox.isSelected())
	 {
		 
		 connect.termscheckbox.click();
	 }
	 connect.Addnewcard.click();
	 }
	
	 }
		}
	
	public static void PaymentDetailPage_Verification()throws IOException, InterruptedException, AWTException
	{
		if (driver.getCurrentUrl().contains("stage")|driver.getCurrentUrl().contains("uat"))
		{
			Locators connect = PageFactory.initElements(driver, Locators.class);
			Assert.assertTrue(connect.paymentdetailverification.getText().contains("PAYMENT DETAILS"));
			System.out.println("Payment Details page");
			connect.billingaddress_firstname.sendKeys(TestData.billingaddress_firstname);
			connect.billingaddress_lastname.sendKeys(TestData.billingaddress_lastname);
			connect.billingaddress_StreetAdress.sendKeys(TestData.billingaddress_StreetAdress);
			connect.billingaddress_City.sendKeys(TestData.billingAddress_City);
			connect.billingaddress_state.sendKeys(TestData.billingAddress_state);
			connect.billingaddress_postalcode.sendKeys(TestData.billingaddress_postalcode);
			if(driver.getCurrentUrl().contains("uat"))
			 {
				 driver.findElement(By.id(Locators.cardno)).sendKeys(TestData.UATcardnumber);
				 driver.findElement(By.id(Locators.CVV)).sendKeys(TestData.UATCVV);
				 driver.findElement(By.id(Locators.expiredate)).sendKeys(TestData.UATexpiredate);
			 }
			 	connect.submittbtn.click();
		}
}

	public static void Transaction_NewCard()throws IOException, InterruptedException, AWTException
	{
		if (driver.getCurrentUrl().contains("stage")|driver.getCurrentUrl().contains("uat"))
		{
			Locators connect = PageFactory.initElements(driver, Locators.class);
			List<WebElement> transactionmsg=driver.findElements(By.xpath(Locators.paymentverification));
			int Locatorcount=transactionmsg.size();
			if(Locatorcount==1)
				{
					System.out.println("Payment successfully"); 
				}
			else
				{
				System.out.println("Transaction is in Error-Transaction not procced"); 
				connect.cancelbtn.click();
				}
		}
	}
	
	public static void Transaction_savecard()throws IOException, InterruptedException, AWTException
	{
		if (driver.getCurrentUrl().contains("stage")|driver.getCurrentUrl().contains("uat"))
		{
			Locators connect = PageFactory.initElements(driver, Locators.class);
			connect.textsearch.sendKeys(TestData.textsearch);
			connect.GO.click();
			connect.Phunter.click();
			Assert.assertTrue(connect.phunterverification.getText().contains("Download Your Results"));
			System.out.println(" Prospect Hunter - Download Your Results");
		}
}
	
	public static void Transaction_savecardstep2()throws IOException, InterruptedException, AWTException
	{
		if (driver.getCurrentUrl().contains("stage")|driver.getCurrentUrl().contains("uat"))
		{
			Locators connect = PageFactory.initElements(driver, Locators.class);
			connect.Addnewcard.click();
				if(!connect.termscheckbox.isSelected())
					{
						connect.termscheckbox.click();
						connect.Addnewcard.click();
						connect.billingaddress_firstname.clear();
						connect.billingaddress_firstname.sendKeys(TestData.billingaddress_firstname);
						connect.billingaddress_lastname.clear();
						connect.billingaddress_lastname.sendKeys(TestData.billingaddress_lastname);
						System.out.println("frist name last name " +TestData.billingaddress_firstname+TestData.billingaddress_lastname); 
						connect.billingaddress_StreetAdress.clear();
						connect.billingaddress_StreetAdress.sendKeys(TestData.billingaddress_StreetAdress);
						connect.billingaddress_City.clear();
						connect.billingaddress_City.sendKeys(TestData.billingAddress_City);
						connect.billingaddress_state.clear();
						connect.billingaddress_state.sendKeys(TestData.billingAddress_state);
						connect.billingaddress_postalcode.clear();
						connect.billingaddress_postalcode.sendKeys(TestData.billingaddress_postalcode);
						if(driver.getCurrentUrl().contains("uat"))
						{
							driver.findElement(By.id(Locators.cardno)).clear();
							driver.findElement(By.id(Locators.cardno)).sendKeys(TestData.UATcardnumber);
							driver.findElement(By.id(Locators.CVV)).clear();
							driver.findElement(By.id(Locators.CVV)).sendKeys(TestData.UATCVV);
							driver.findElement(By.id(Locators.expiredate)).sendKeys(TestData.UATexpiredate);
						}
						connect.saveforfuture.click();
						connect.submittbtn.click();
	 }
	}
}

	public static void Transaction_savecardverification()throws IOException, InterruptedException, AWTException
	{
		 if (driver.getCurrentUrl().contains("stage")|driver.getCurrentUrl().contains("uat"))
		 {
			 Locators connect = PageFactory.initElements(driver, Locators.class);
			 Assert.assertTrue(driver.findElement(By.xpath(Locators.paymentverification)).getText().contains("Thank you! - Your list has been successfully purchased and your credit card has been charged. Please click the Download List button below to access your list."));
			 System.out.println("Payment with save card successfully"); 
		 }
	}
	
	 public static void RemoveCreditCard()throws IOException, InterruptedException, AWTException
	 {
		 if(driver.getCurrentUrl().contains("stage")|driver.getCurrentUrl().contains("uat"))
				
		
		 {
			 Locators connect = PageFactory.initElements(driver, Locators.class);
			 connect.textsearch.sendKeys(TestData.textsearch);
			 connect.GO.click();
			 connect.Phunter.click();
			 Assert.assertTrue(connect.searchnewcard.getText().contains(TestData.billingaddress_firstname+" "+TestData.billingaddress_lastname));
			 connect.delcard.click();
			 connect.delcontinue.click();
			 System.out.println("Credit card removed from list successfully.");
		 }
	 }

	public static void Transaction_ExistingCard()throws IOException, InterruptedException, AWTException
	{
		 if (driver.getCurrentUrl().contains("stage")|driver.getCurrentUrl().contains("uat"))
		 {
			 Locators connect = PageFactory.initElements(driver, Locators.class);
			 connect.textsearch.sendKeys(TestData.textsearch);
			 connect.GO.click();
			 connect.Phunter.click();
			 ConnectScenarios.Transaction_savecardstep2();
			 connect.textsearch.sendKeys(TestData.textsearch);
			 connect.GO.click();
			 connect.Phunter.click();
			 Assert.assertTrue(connect.searchnewcard.getText().contains(TestData.billingaddress_firstname+" "+TestData.billingaddress_lastname));
			 connect.Placeyourorder.click();
			 System.out.println("Transaction via existing card successfully");
		
		 }
}
	
	public static void ProspectList_validation()throws IOException, InterruptedException, AWTException
	{
		Locators connect = PageFactory.initElements(driver, Locators.class);
		connect.PL.click();
		Assert.assertTrue(connect.PLverification.getText().contains("Prospect List"));
		System.out.println("Prospect List Page");
	
}
	
	public static void AddDistToPL()throws IOException, InterruptedException, AWTException
	{
			Locators connect = PageFactory.initElements(driver, Locators.class);
			if (driver.getCurrentUrl().contains("stage")| driver.getCurrentUrl().contains("uat"))
			{
				connect.SearchDisPL.sendKeys(TestData.AddDisttoPL);
				List<WebElement> LocatorPLvisibility=driver.findElements(By.xpath(Locators.DisfoundPL));
				int Locatorcount=LocatorPLvisibility.size();
				System.out.println(Locatorcount);
				if(Locatorcount>0)
				{
					connect.RemoveDisFromPL.click();
					connect.contideletePL.click();
					connect.SearchDisPL.sendKeys(TestData.AddDisttoPL);
					if(connect.distnotfound.getText().contains("No records to display"))
					{
						System.out.println("109480 is removed from PL");
					}
					else
					{
						System.out.println("109480 is not removed from PL");
					 
					}
				}
				 	connect.EnterDisToPL.sendKeys(TestData.AddDisttoPL);
				 	connect.AddToPL.click();
				 	connect.SearchDisPL.sendKeys(TestData.AddDisttoPL);
				 	if(driver.findElement(By.xpath(Locators.DistfoundML)).getText().contains("asi/109480"))
				 	{
				 		System.out.println("109480 is added to PL");
				 	}
				 else
				 {
					 System.out.println("109480 is not added to PL");
				 }
			 }
		 
	}
	
	public static void RemoveDistFromPL()throws IOException, InterruptedException, AWTException
	{
		Locators connect = PageFactory.initElements(driver, Locators.class);
		connect.SearchDisPL.clear();
		connect.SearchDisPL.sendKeys(TestData.AddDisttoPL);
		connect.RemoveDisFromPL.click();
		connect.contideletePL.click();
		connect.SearchDisPL.sendKeys(TestData.AddDisttoPL);
		Assert.assertTrue(connect.distnotfound.getText().contains("No records to display"),"109480 is not removed from PL");
		/*if(connect.distnotfound.getText().contains("No records to display"))
				{
					System.out.println("109480 is removed from PL");
				}
		else
		{
			System.out.println("109480 is not removed from PL");
		}*/
	}
	
	public static void MonitorList()throws IOException, InterruptedException, AWTException
	{
		Locators connect = PageFactory.initElements(driver, Locators.class);
		connect.ML.click();
		Assert.assertTrue(connect.MLverification.getText().contains("Monitor List"));
		System.out.println("Monitor List Page");
	}

	public static void AddandRemoveDist_ML()throws IOException, InterruptedException, AWTException
	{
		Locators connect = PageFactory.initElements(driver, Locators.class);
		 if (driver.getCurrentUrl().contains("stage")| driver.getCurrentUrl().contains("uat"))
		 {
			 connect.textsearch.sendKeys(TestData.AddDisttoML);
			 connect.GO.click();
			 List<WebElement> Locatorvisibility=driver.findElements(By.xpath(Locators.AddToMonitorList));
			 int Locatorcount=Locatorvisibility.size();
			 System.out.println(Locatorcount);
			 if(Locatorcount==0)
			{
				connect.RemovefromML.click();
				connect.ML.click();
				System.out.println("109480 is removed from PL");
				connect.ML.click();
				connect.searchdisML.sendKeys("109480");
				List<WebElement> SearchML=driver.findElements(By.xpath(Locators.DistfoundML));
				int searchcount=SearchML.size();
				if(searchcount==0)
						{
			
							System.out.println("109480 is removed from monitor list"+'\n');
						}
				
				else
				{
					System.out.println("109480 is not removed from monitor list");
				}	
			}
			else
			{
				driver.findElement(By.xpath(Locators.AddToMonitorList)).click();
				connect.ML.click();
				connect.searchdisML.sendKeys("109480");
				List<WebElement> SearchML=driver.findElements(By.xpath(Locators.DistfoundML));
				int searchcount=SearchML.size();
				if(searchcount==0)
						{
			
							System.out.println("109480 is not added in monitor list"+'\n');
						}
				
				else
				{
					System.out.println("109480 found");
				
				}
			}
		 }
}
	
	
	public static void BasicSearch_Distributor()throws IOException, InterruptedException, AWTException
	{
		Locators connect = PageFactory.initElements(driver, Locators.class);
		 connect.textsearch.sendKeys("109480");
		 connect.GO.click();
		 Assert.assertTrue(connect.Basicsearch.getText().contains("asi/109480"));
		 System.out.print("109480 is filtered out via Basic search"+'\n');
		
	}
	
	public static void BasicSearch_Company()throws IOException, InterruptedException, AWTException
	{
		 Locators connect = PageFactory.initElements(driver, Locators.class);
		 connect.textsearch.sendKeys(TestData.textsearch);
		 connect.GO.click();
		 List<WebElement> basicsearchtable = driver.findElements(By.xpath(Locators.table));
		 System.out.print("No of comapnies:" + basicsearchtable.size()+'\n');
		 int validcompanies=0;
		 int Invalidcompanies=0;
		 int TotalValidCompanies=0;
		 for(int i=1;i<=basicsearchtable.size();i++)
			 
		 {
			 String companyname=driver.findElement(By.xpath(Locators.before_xpath+ i + Locators.after_xpath)).getText();
			 System.out.print("Comapny Name:"+i+":"+companyname+'\n');
			 if(companyname.contains("Test") || companyname.contains("TEST"))
			 {
				 System.out.print("valid company"+'\n');
				 validcompanies=validcompanies+1;
			 }
			 else
			 {
				 System.out.print("Company name does not exist"+'\n');
				 Invalidcompanies=Invalidcompanies+1;
			 }
		 }
		 TotalValidCompanies= basicsearchtable.size()-Invalidcompanies;
		 Assert.assertTrue(validcompanies == TotalValidCompanies);
	}
	
	public static void AdvancedSearchResult()throws IOException, InterruptedException, AWTException
	{
		Locators connect = PageFactory.initElements(driver, Locators.class);
		connect.AdvanceSearch.click();
		connect.Advancesearchdist.sendKeys(TestData.Advancesearch);
		connect.Advancesearchbtn.click();
		Assert.assertTrue(connect.Addistfound.getText().contains("asi/109480"));
	}
	
	public static void AdvancedSearch_StateDropDownResult()throws IOException, InterruptedException, AWTException
	{
		Locators connect = PageFactory.initElements(driver, Locators.class);
		connect.AdvanceSearch.click();
		driver.findElement(By.xpath("//div[@id='s2id_drpState']")).click();
		List<WebElement> dd = driver.findElements(By.xpath("//div[@class='select2-result-label']"));
		 System.out.println("size :"+ dd.size());
		 for(int i=0;i<dd.size();i++)
		 {
		 	
		 	 if(dd.get(i).getText().contains("California"))
		 	 {
		 		 dd.get(i).click();
		 		 break;
		 	 }
		 	else
		 	{
		 		System.out.print("State :" + i+":" + dd.get(i).getText()+'\n');
		 	}
		 }
		 Assert.assertTrue(dd.size()>0);
	}
	
	public static void AdvancedSearch_RangeDropDownResult()throws IOException, InterruptedException, AWTException
	{
		Locators connect = PageFactory.initElements(driver, Locators.class);
		connect.AdvanceSearch.click();
		connect.Range.click();
		List<WebElement> dd = driver.findElements(By.xpath(Locators.Rangedatafetch));
		System.out.println("size :"+ dd.size());
		 for(int i=0;i<dd.size();i++)
		 {
			 String Rangevalues=driver.findElement(By.xpath(Locators.Rangedatafetch)).getText();
			 System.out.print("Range :" + i+":" + dd.get(i).getText()+'\n');
		 }
		 Assert.assertTrue(dd.size()>0);
	}
	
	public static void AdvancedSearch_ProductlineDropDownResult()throws IOException, InterruptedException, AWTException
	{
		Locators connect = PageFactory.initElements(driver, Locators.class);
		connect.AdvanceSearch.click();
		connect.productline.click();
		List<WebElement> dd = driver.findElements(By.xpath(Locators.productlinefetch));
		System.out.println("size :"+ dd.size());
		 for(int i=0;i<=5;i++)
		 {
			 String Rangevalues=driver.findElement(By.xpath(Locators.productlinefetch)).getText();
			 System.out.print("Product Line :" + i+":" + dd.get(i).getText()+'\n');
		 }
		 Assert.assertTrue(dd.size()>0);
	}

	
	public static void AdvancedSearch_CustomerTypeDropDownResult()throws IOException, InterruptedException, AWTException
	{
		Locators connect = PageFactory.initElements(driver, Locators.class);
		connect.AdvanceSearch.click();
		connect.Customertype.click();
		List<WebElement> dd = driver.findElements(By.xpath(Locators.Customertypefetchresult));
		System.out.println("size :"+ dd.size());
		 for(int i=0;i<dd.size();i++)
		 {
			 String Rangevalues=driver.findElement(By.xpath(Locators.Customertypefetchresult)).getText();
			 System.out.print("Customer Type :" + i+":" + dd.get(i).getText()+'\n');
		 }
		 Assert.assertTrue(dd.size()>0);
	}
	
	public static void AdvancedSearch_PayHabitFromDropDownResult()throws IOException, InterruptedException, AWTException
	{
		Locators connect = PageFactory.initElements(driver, Locators.class);
		connect.AdvanceSearch.click();
		connect.payhabitfrom.click();
		List<WebElement> dd = driver.findElements(By.xpath(Locators.payhabitfetchresultfrom));
		System.out.println("size :"+ dd.size());
		 for(int i=0;i<dd.size();i++)
		 {
			 String Rangevalues=driver.findElement(By.xpath(Locators.payhabitfetchresultfrom)).getText();
			 System.out.print("Pay Habit From :" + i+":" + dd.get(i).getText()+'\n');
		 }
		 Assert.assertTrue(dd.size()>0);
	}
	
	public static void AdvancedSearch_PayHabiToDropDownResult()throws IOException, InterruptedException, AWTException
	{
		Locators connect = PageFactory.initElements(driver, Locators.class);
		connect.AdvanceSearch.click();
		connect.payhabitto.click();
		List<WebElement> dd = driver.findElements(By.xpath(Locators.payhabitfetchresultto));
		 System.out.println("size :"+ dd.size());
		 for(int i=0;i<dd.size();i++)
		 {
			 String Rangevalues=driver.findElement(By.xpath(Locators.payhabitfetchresultto)).getText();
			 System.out.print("Pay Habit To :" + i+":" + dd.get(i).getText()+'\n');
		 }
		 Assert.assertTrue(dd.size()>0);
	}
	
	public static void AdvancedSearch_ViewDaysDropDownResult()throws IOException, InterruptedException, AWTException
	{
		Locators connect = PageFactory.initElements(driver, Locators.class);
		connect.AdvanceSearch.click();
		connect.viewdays.click();
		List<WebElement> dd = driver.findElements(By.xpath(Locators.viewdaysfetch));
		System.out.println("size :"+ dd.size());
		 for(int i=0;i<dd.size();i++)
		 {
			 String Rangevalues=driver.findElement(By.xpath(Locators.viewdaysfetch)).getText();
			 System.out.print("View Days :" + i+":" + dd.get(i).getText()+'\n');
		 }
			connect.viewdays.click();
			Assert.assertTrue(dd.size()>0);
	}
	
	public static void DistributorProfile_ESP_Product_Display()throws IOException,InterruptedException, AWTException
	{
		Locators connect = PageFactory.initElements(driver, Locators.class);
		connect.textsearch.sendKeys("109480");
		connect.GO.click();
		Thread.sleep(5000);
		connect.ESPProduct.click();
		Thread.sleep(5000);
		connect.ESPProductmodalwindowtext.getText().contains("POPULAR PRODUCTS SEARCHED BY THIS DISTRIBUTOR");
		Assert.assertTrue(!driver.findElement(By.xpath("//table[contains(@id, 'prodCategories')]/tbody")).getText().contains("Please wait - loading..."));
		connect.CloseProductModalWindow.click();
		
	}

	public static void Dist_CreditScore()throws IOException, InterruptedException, AWTException
	{
		
		Locators connect = PageFactory.initElements(driver, Locators.class);
		List<WebElement> Creditvisibility=driver.findElements(By.xpath(Locators.listCurrentCredit));
		int Locatorcount=Creditvisibility.size();
		System.out.println(Locatorcount);
		if(Locatorcount==1)
		{
			NAcredit=connect.CurrentCredit.getText();
			System.out.println(NAcredit);
			NAcreditscore= connect.creditscore.getText();
			System.out.println(NAcreditscore);
			NAcreditscore=NAcreditscore.replaceAll("[^N/A]","");
			System.out.println(NAcreditscore);
			if(NAcredit.equals(NAcreditscore))
			{
				Assert.assertTrue(false);
				 
			}
		 
		}
		/*else
		{
			 currentcredit=connect.CurrentCredit.getText();
			 System.out.println("CurrentCredit" + currentcredit);
			 intcredit=Integer.parseInt(currentcredit);
			 System.out.println(intcredit);
			 creditscore= connect.creditscore.getText();
			 System.out.println("Current Score" + creditscore);
			 creditscore=creditscore.replaceAll("[^0-9]","");
			 System.out.println("Current Score" + creditscore);
			 intcreditscore=Integer.parseInt(creditscore);
			 System.out.println(intcreditscore);
			
			/* if(intcredit>0 & intcredit==intcreditscore)
			 {
				 System.out.println("Credits of 109480 are showing up"); 
			 }
		}*/
		
			
		//Assert.assertTrue(intcredit>0  & intcredit==intcreditscore  & !NAcredit.equals(NAcreditscore));
	}

	public static void DistCreditHistory_Current6months()throws IOException, InterruptedException, AWTException
	{
			Locators connect = PageFactory.initElements(driver, Locators.class);
			List<WebElement> distcredittable = driver.findElements(By.xpath(Locators.distcredithistory));
			System.out.print("table size" + distcredittable.size()+'\n');
			for(int i=1;i<=distcredittable.size();i++)
			{
				String Credit_Comparision=driver.findElement(By.xpath(Locators.distcreditbefore_xpath+ i + Locators. distcreditcol1after_xpath)).getText();
				String Current_6month=driver.findElement(By.xpath(Locators.distcreditbefore_xpath+ i + Locators.distcreditafter_xpath)).getText();
				Current_6month=Current_6month.replaceAll("[^0-9]", "");
				System.out.print(Credit_Comparision+ ":" +Current_6month+'\n');
				int textcol2int=Integer.parseInt(Current_6month);
				
				if(textcol2int>0)
				{
					
					Assert.assertTrue(true,"Data is not being displayed");
					break;
				}
					
		 }
	}
	
	public static void DistCreditHistory_Pre6months()throws IOException, InterruptedException, AWTException
	{

		Locators connect = PageFactory.initElements(driver, Locators.class);
		List<WebElement> distcredittable = driver.findElements(By.xpath(Locators.distcredithistory));
		System.out.print("table size:" + distcredittable.size()+'\n');
		for(int i=1;i<=distcredittable.size();i++)
		{
			String Credit_Comparision=driver.findElement(By.xpath(Locators.distcreditbefore_xpath+ i + Locators. distcreditcol1after_xpath)).getText();
			String DistributorCreditPrevious6Months=driver.findElement(By.xpath(Locators.distcreditbefore_xpath+ i + Locators.IndusturyAverageafter_xpath)).getText();
			DistributorCreditPrevious6Months=DistributorCreditPrevious6Months.replaceAll("[^0-9]", "");
			System.out.print(Credit_Comparision+ ":" +DistributorCreditPrevious6Months+'\n');
			int textcol3int=Integer.parseInt(DistributorCreditPrevious6Months);
			Assert.assertTrue(textcol3int>0,"Distributor Credits of previous 6 months are not showing");
		}
		
		
	}
	
	public static void DistCreditHistory_IndustryAverage()throws IOException, InterruptedException, AWTException
	{
		Locators connect = PageFactory.initElements(driver, Locators.class);
		List<WebElement> distcredittable = driver.findElements(By.xpath(Locators.distcredithistory));
		System.out.print("table size:" + distcredittable.size()+'\n');
		for(int i=1;i<=distcredittable.size();i++)
		{
			String Credit_Comparision=driver.findElement(By.xpath(Locators.distcreditbefore_xpath+ i + Locators. distcreditcol1after_xpath)).getText();
			String IndustryAverage=driver.findElement(By.xpath(Locators.distcreditbefore_xpath+ i + Locators.pre6monthsafter_xpath)).getText();
			IndustryAverage=IndustryAverage.replaceAll("[^0-9]", "");
			System.out.print(Credit_Comparision+ ":" +IndustryAverage+'\n');
			int textcol3int=Integer.parseInt(IndustryAverage);
			if(textcol3int>0)
			{
				
				Assert.assertTrue(true,"Industry Average Stats are not showing");
				break;
			}
			
	 }
	}
	
	
	public static void DistCreditHistory_GeneralCredit()throws IOException, InterruptedException, AWTException
	{
		Locators connect = PageFactory.initElements(driver, Locators.class);
		List<WebElement> distcredittable = driver.findElements(By.xpath(Locators.distcredithistory));
		System.out.print("table size:" + distcredittable.size()+'\n');
		for(int i=1;i<=distcredittable.size();i++)
		{
			String Credit_Comparision=driver.findElement(By.xpath(Locators.distcreditbefore_xpath+ i + Locators. distcreditcol1after_xpath)).getText();
			String GeneralCredit=driver.findElement(By.xpath(Locators.distcreditbefore_xpath+ i + Locators.GeneralCreditsafter_xpath)).getText();
			GeneralCredit=GeneralCredit.replaceAll("[^0-9]", "");
			System.out.print(Credit_Comparision+ ":" +GeneralCredit+'\n');
			int textcol3int=Integer.parseInt(GeneralCredit);
			if(textcol3int>0)
			{
				
				Assert.assertTrue(true,"General Credits Stats are not showing");
				break;
			}
			
			
	 }
	}
	public static void AveragePayingHabitReportsWithPurchases()throws IOException, InterruptedException, AWTException
	{
			Locators connect = PageFactory.initElements(driver, Locators.class);
			List<WebElement> distcredittable = driver.findElements(By.xpath(Locators.APHtable));
			System.out.print("table size:" + distcredittable.size()+'\n');
			for(int i=1;i<=distcredittable.size();i++)
			{
				String textcol1=driver.findElement(By.xpath(Locators.APHrowbefore_xpath+ i + Locators.APHcol1after_xpath)).getText();
				String textcol2=driver.findElement(By.xpath(Locators.APHrowbefore_xpath+ i + Locators.APHcol2after_xpath)).getText();
				textcol2=textcol2.replaceAll("[^0-9]", "");
				System.out.print(textcol1+ ":" +textcol2+'\n');
				int textcol2int=Integer.parseInt(textcol2);
				if(textcol2int>0)
				{
					
					Assert.assertTrue(true,"Average Paying Habit Reports With Purchases Stats are not showing");
					break;
				}
				
				/*	if (textcol2int>0)
					{
						System.out.println("Data is being displayed");
					}
					else
					{
						System.out.println("Data is not being displayed");
					}*/
		 }
	}
	
	public static void APHTransactionWithPurchases()throws IOException, InterruptedException, AWTException
	{
			Locators connect = PageFactory.initElements(driver, Locators.class);
			List<WebElement> distcredittable = driver.findElements(By.xpath(Locators.APHtable));
			System.out.print("table size:" + distcredittable.size()+'\n');
			for(int i=1;i<=distcredittable.size();i++)
			{
				String textcol1=driver.findElement(By.xpath(Locators.APHrowbefore_xpath+ i + Locators.APHcol1after_xpath)).getText();
				String textcol3=driver.findElement(By.xpath(Locators.APHrowbefore_xpath+ i + Locators.APHcol3after_xpath)).getText();
				textcol3=textcol3.replaceAll("[^0-9]", "");
				System.out.print(textcol1+ ":" +textcol3+'\n');
				int textcol3int=Integer.parseInt(textcol3);
				if(textcol3int>0)
				{
					
					Assert.assertTrue(true,"Average Paying Habits Transaction With Purchases Stats are not showing");
					break;
				}
				//Assert.assertTrue(textcol3int>0,"Stats are not being displayed");
				/*	if (textcol3int>0)
					{
						System.out.println("Stats are  being displayed"+'\n');
					}
					else
					{
						System.out.println("Stats are not being displayed"+'\n');		
					}*/
		 }
	}
	
	public static void AveragePayingHabitsVolumn()throws IOException, InterruptedException, AWTException
	{
			Locators connect = PageFactory.initElements(driver, Locators.class);
			List<WebElement> distcredittable = driver.findElements(By.xpath(Locators.APHtable));
			System.out.print("table size:" + distcredittable.size()+'\n');
			for(int i=1;i<=distcredittable.size();i++)
			{
				String textcol1=driver.findElement(By.xpath(Locators.APHrowbefore_xpath+ i + Locators.APHcol1after_xpath)).getText();
				String textcol3=driver.findElement(By.xpath(Locators.APHrowbefore_xpath+ i + Locators.APHVolumnafter_xpath)).getText();
				textcol3=textcol3.replaceAll("[^0-9]", "");
				System.out.print(textcol1+ ":" +textcol3+'\n');
				int textcol3int=Integer.parseInt(textcol3);
				if(textcol3int>0)
				{
					
					Assert.assertTrue(true,"Average Paying Habits Volumn Stats are not being displayed");
					break;
				}
				//Assert.assertTrue(textcol3int>0,"Average Paying Habits Volumn Stats are not being displayed");
				/*	if (textcol3int>0)
					{
						System.out.println("Stats are  being displayed"+'\n');
					}
					else
					{
						System.out.println("Stats are not being displayed"+'\n');		
					}*/
		 }
	}
	public static void SingleTransaction()throws IOException, InterruptedException, AWTException
	{
	
			Locators connect = PageFactory.initElements(driver, Locators.class);
			
			{
				Thread.sleep(5000);
				driver.findElement(By.xpath(Locators.MyReports)).click();
				driver.findElement(By.xpath(Locators.SingleTransaction)).click();
				driver.findElement(By.id(Locators.ReportCompanyNo)).sendKeys("AIA Corporation");
				driver.findElement(By.xpath(Locators.ReportCompanyNotypeahead)).click();
				WebDriverWait wait = new WebDriverWait(driver,240);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loadingIndicator1']")));
				Thread.sleep(5000);
				driver.findElement(By.id(Locators.invoicedate)).click();
				driver.findElement(By.xpath(Locators.invoiceleftarrow)).click();
				driver.findElement(By.xpath(Locators.invoiceleftarrow)).click();
				driver.findElement(By.xpath(Locators.invoiceselectdate)).click();
				driver.findElement(By.id(Locators.paymentduedate)).click();
				driver.findElement(By.xpath(Locators.paymentleftarrow)).click();
				driver.findElement(By.xpath(Locators.paymentselectdate)).click();
				driver.findElement(By.id(Locators.invoiceamount)).sendKeys("50000");
				driver.findElement(By.id(Locators.amountpaid)).sendKeys("50000");
				driver.findElement(By.id(Locators.extendedcreditamount)).sendKeys("50000");
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
				Date date = new Date();
				String dateFormatted= dateFormat.format(date);
				System.out.println("Date:"+dateFormatted);
				Calendar cal = Calendar.getInstance();
				int day=cal.get(Calendar.DATE);
				System.out.println(day);
				String cday=Integer.toString(day);
				System.out.println(cday);
				driver.findElement(By.id(Locators.datepaid)).click();
				System.out.println("//div[contains(@class,'datepicker datepicker-dropdown dropdown-menu')][7]/div/table/tbody/tr/td[contains(text(),'"+cday+"')]");
				driver.findElement(By.xpath("//div[contains(@class,'datepicker datepicker-dropdown dropdown-menu')][7]/div/table/tbody/tr/td[contains(text(),'"+cday+"')]")).click();
				driver.findElement(By.xpath(Locators.reportsubmit)).click();
				Assert.assertTrue(driver.findElement(By.id(Locators.reportconfirmation)).getText().contains("Your Transaction has been submitted successfully."),"Your Transaction has not been submitted successfully.");
				
		 }
	
	}
	public static void ASIMediaStats()throws IOException, InterruptedException, AWTException
	{
			Locators connect = PageFactory.initElements(driver, Locators.class);
			connect.MyApplications.click();
			Thread.sleep(2000);
			connect.ASIMediaStats.click();
			Thread.sleep(2000);
			Assert.assertTrue(connect.ASIMediaStats_Title.isDisplayed());
			
			
	}
	
}

