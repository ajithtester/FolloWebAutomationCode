package com.follo.module.method;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.follo.baseclass.Baseclass;
import com.follo.excel.read.ReadFrom;

import report.ReportConfig;

public class F_13_CraneCalender extends Baseclass {



	public static void AddCraneCalender() throws Throwable {
		PrintError("Add Crane Calender started");
		ReadFrom.DynamicExcel(ReadFrom.CraneCalendar);

		for(int CraneCalendar =1; CraneCalendar<=ReadFrom.rowcount; CraneCalendar++)		{	

			Wait(4000);
			PrintError("Add Crane Calendar Started");
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(ElementClickInterceptedException.class);


			fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("(//button[@type='button'])[1]"));
				}
			});

			if(IsElementDisplayed("CreateNew", CraneCalenderLocators)){
				JsClick("CreateNew", CraneCalenderLocators);
				Print("Create new button is clicked");
				ReportConfig.PassedLogInfo("User add new crane request","Create new button is clicked");

			}
			else
			{
				PrintError("Create new button is not clicked");
				ReportConfig.FailedLogInfo("User add new crane request","Create new button is not clicked");
				
				String IssueSummary = "Create new button is not clicked" ;
				String Storydescription = "Add crane calender" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
			}


//			Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
//					.withTimeout(Duration.ofSeconds(120))
//					.pollingEvery(Duration.ofSeconds(5))
//					.ignoring(ElementClickInterceptedException.class);
//
//
//			fluentWait1.until(new Function<WebDriver, WebElement>() {
//				public WebElement apply(WebDriver driver) {
//					return driver.findElement(By.xpath("//textarea[@placeholder='Enter Description']"));
//				}
//			});
			
			Wait(7000);

			if(IsElementDisplayed("Description", CraneCalenderLocators)) {
				Print("Delivery popup is opened");
				ReportConfig.PassedLogInfo("User add new crane request","Delivery popup is opened");
			}

			TypeDataInTheField("Description", CraneCalenderLocators, ReadFrom.Excel(CraneCalendar, 0, ReadFrom.CraneCalendar));
			Print("Description is entered as : " + ReadFrom.Excel(CraneCalendar, 0, ReadFrom.CraneCalendar));
			ReportConfig.PassedLogInfo("User add new crane request","Description is entered as : " + ReadFrom.Excel(CraneCalendar, 0, ReadFrom.CraneCalendar));


			Click("Company", CraneCalenderLocators);
			ReportConfig.PassedLogInfo("User add new crane request","Company dropdown is clicked");

			String CompanyInExcel = ReadFrom.Excel(CraneCalendar, 1, ReadFrom.CraneCalendar);

			int countofthelist = 	SizeOfTheList("CompanyAdd", CraneCalenderLocators);

			for(int DropdownValues =1; DropdownValues<=countofthelist; DropdownValues++)		{	

				WebElement Company = 	FindElement("CompanyAddList", CraneCalenderLocators, DropdownValues);
				String CompanyInDropdown = 	GetTextFromTheElement(Company);

				if(IsEqual(CompanyInDropdown, CompanyInExcel)){
					Click(Company);

					ReportConfig.PassedLogInfo("User add new crane request",CompanyInDropdown + " is selected from the dropdown");
					Print(CompanyInDropdown + " is selected from the dropdown");
					break;
				}
			}	
			///////////////////////

			Click("Dfow", CraneCalenderLocators);
			ReportConfig.PassedLogInfo("User add new crane request","Dfow dropdown is clicked");

			String DfowInExcel = ReadFrom.Excel(CraneCalendar, 2,ReadFrom.CraneCalendar);

			int rowcountofthelist = 	SizeOfTheList("DfowAdd", CraneCalenderLocators);

			for(int DropdownValues =1; DropdownValues<=rowcountofthelist; DropdownValues++)		{	
				WebElement Dfow = 	FindElement("DfowAddList", CraneCalenderLocators, DropdownValues);
				String DfowInDropdown = 	GetTextFromTheElement(Dfow);


				if(IsEqual(DfowInDropdown, DfowInExcel)){
					Click(Dfow);
					ReportConfig.PassedLogInfo("User add new crane request",DfowInDropdown + " is selected from the dropdown");
					Print("Dfow is selected as : " + DfowInDropdown );
					break;
				}
			}	

			/////////////////////////////////////

			SelectFromVisibleText("EquipmentDropdown", CraneCalenderLocators, ReadFrom.Excel(CraneCalendar, 10, ReadFrom.CraneCalendar));
			Print("Equipment dropdown is selected as : " + ReadFrom.Excel(CraneCalendar, 10, ReadFrom.CraneCalendar));
			ReportConfig.PassedLogInfo("User add new crane request","Equipment dropdown is selected as : " + ReadFrom.Excel(CraneCalendar, 10, ReadFrom.CraneCalendar));


			Clear("DeliveryDate", CraneCalenderLocators);
			TypeDataInTheField("DeliveryDate", CraneCalenderLocators, ReadFrom.Excel(CraneCalendar, 3, ReadFrom.CraneCalendar));
			Print("Start date is entered as : " + ReadFrom.Excel(CraneCalendar, 3, ReadFrom.CraneCalendar));
			ReportConfig.PassedLogInfo("User add new crane request","Start date is entered as : " + ReadFrom.Excel(CraneCalendar, 3, ReadFrom.CraneCalendar));

			///////

			Wait(2000);
			Clear("FromHrs", CraneCalenderLocators);
			TypeDataInTheField("FromHrs", CraneCalenderLocators, ReadFrom.Excel(CraneCalendar, 4, ReadFrom.CraneCalendar));
			Print("From hrs is entered as : " + ReadFrom.Excel(CraneCalendar, 4, ReadFrom.CraneCalendar));
			ReportConfig.PassedLogInfo("User add new crane request","From hrs is entered as : " + ReadFrom.Excel(CraneCalendar, 4, ReadFrom.CraneCalendar));

			Wait(2000);
			Clear("FromMin", CraneCalenderLocators);
			TypeDataInTheField("FromMin", CraneCalenderLocators, ReadFrom.Excel(CraneCalendar, 5, ReadFrom.CraneCalendar));
			Print("From min is entered as : " + ReadFrom.Excel(CraneCalendar, 5, ReadFrom.CraneCalendar));
			ReportConfig.PassedLogInfo("User add new crane request","From min is entered as : " + ReadFrom.Excel(CraneCalendar, 5, ReadFrom.CraneCalendar));

			Wait(2000);
			String ExcelMeridian = ReadFrom.Excel(CraneCalendar, 6, ReadFrom.CraneCalendar);
			String Meridian = GetText("FromMeridian", CraneCalenderLocators);
			if(IsEqual(Meridian, ExcelMeridian)) {


			}
			else {
				Click("FromMeridian", CraneCalenderLocators);
			}

			Wait(2000);
			Clear("ToHrs", CraneCalenderLocators);
			TypeDataInTheField("ToHrs", CraneCalenderLocators, ReadFrom.Excel(CraneCalendar, 7, ReadFrom.CraneCalendar));
			Print("To hrs is entered as : " + ReadFrom.Excel(CraneCalendar, 7, ReadFrom.CraneCalendar));
			ReportConfig.PassedLogInfo("User add new crane request","To hrs is entered as : " + ReadFrom.Excel(CraneCalendar, 7, ReadFrom.CraneCalendar));

			Wait(2000);
			Clear("ToMin", CraneCalenderLocators);
			TypeDataInTheField("ToMin", CraneCalenderLocators, ReadFrom.Excel(CraneCalendar, 8, ReadFrom.CraneCalendar));
			Print("To min is entered as : " + ReadFrom.Excel(CraneCalendar, 8, ReadFrom.CraneCalendar));
			ReportConfig.PassedLogInfo("User add new crane request","To min is entered as : " + ReadFrom.Excel(CraneCalendar, 8, ReadFrom.CraneCalendar));

			Wait(2000);
			String ExcelMeridian1 = ReadFrom.Excel(CraneCalendar, 9, ReadFrom.CraneCalendar);
			String Meridian1 = GetText("ToMeridian", CraneCalenderLocators);
			if(IsEqual(Meridian1, ExcelMeridian1)) {


			}
			else {
				Click("ToMeridian", CraneCalenderLocators);
			}


			Wait(2000);
			Clear("PickingFrom", CraneCalenderLocators);
			TypeDataInTheField("PickingFrom", CraneCalenderLocators, ReadFrom.Excel(CraneCalendar, 11, ReadFrom.CraneCalendar));
			Print("Picking from is entered as : " + ReadFrom.Excel(CraneCalendar, 11, ReadFrom.CraneCalendar));
			ReportConfig.PassedLogInfo("User add new crane request","Picking from is entered as : " + ReadFrom.Excel(CraneCalendar, 11, ReadFrom.CraneCalendar));

			Wait(2000);
			Clear("PickingTo", CraneCalenderLocators);
			TypeDataInTheField("PickingTo", CraneCalenderLocators, ReadFrom.Excel(CraneCalendar, 12, ReadFrom.CraneCalendar));
			Print("Picking to is entered as : " + ReadFrom.Excel(CraneCalendar, 12, ReadFrom.CraneCalendar));
			ReportConfig.PassedLogInfo("User add new crane request","Picking to is entered as : " + ReadFrom.Excel(CraneCalendar, 12, ReadFrom.CraneCalendar));

			Wait(2000);
			MoveToElement("AdditionalText", CraneCalenderLocators);
			Clear("AdditionalText", CraneCalenderLocators);
			TypeDataInTheField("AdditionalText", CraneCalenderLocators, ReadFrom.Excel(CraneCalendar, 13, ReadFrom.CraneCalendar));
			Print("Additional text is entered as : " + ReadFrom.Excel(CraneCalendar, 13, ReadFrom.CraneCalendar));
			ReportConfig.PassedLogInfo("User add new crane request","Additional text is entered as : " + ReadFrom.Excel(CraneCalendar, 13, ReadFrom.CraneCalendar));

			Wait(4000);	

			MoveToElement("SubmitButton", CraneCalenderLocators);

			Click("SubmitButton", CraneCalenderLocators);

//			Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
//					.withTimeout(Duration.ofSeconds(120))
//					.pollingEvery(Duration.ofSeconds(5))
//					.ignoring(ElementClickInterceptedException.class);
//
//
//			fluentWait11.until(new Function<WebDriver, WebElement>() {
//				public WebElement apply(WebDriver driver) {
//					return driver.findElement(By.xpath("//div[@aria-label='Crane Request Created Successfully.']"));
//				}
//			});
			Wait(7000);
		//	if(IsElementDisplayed("DeliveryAdded", CraneCalenderLocators)) {
			//	Click("DeliveryAdded", CraneCalenderLocators);
				Print("Crane request added");
				ReportConfig.PassedLogInfo("User add new crane request","Crane request added");

		//	}
//			else {
//				PrintError("Delivery not added");
//				ReportConfig.FailedLogInfo("User add new crane request","Delivery not added");
//
//			}
			Wait(3000);
		}
	}


	public static void InValidTime() throws Throwable {
		PrintError("InValidTime Crane Calender started");
		ReadFrom.DynamicExcel(ReadFrom.NegativeCraneCalendar);

		for(int CraneCalendar =1; CraneCalendar<=ReadFrom.rowcount; CraneCalendar++)		{	

			Wait(4000);
			PrintError("Add Crane Calendar Started");
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(ElementClickInterceptedException.class);


			fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("(//button[@type='button'])[1]"));
				}
			});

			if(IsElementDisplayed("CreateNew", CraneCalenderLocators)){
				JsClick("CreateNew", CraneCalenderLocators);
				Print("Create new button is clicked");
				ReportConfig.PassedLogInfo("User gives invalid time in Crane calendar","Create new button is clicked");

			}
			else
			{
				PrintError("Create new button is not clicked");
				ReportConfig.FailedLogInfo("User gives invalid time in Crane calendar","Create new button is not clicked");
			
				String IssueSummary = "Create new button is not clicked" ;
				String Storydescription = "InValid Time Crane Calender" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
				
			}


//			Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
//					.withTimeout(Duration.ofSeconds(120))
//					.pollingEvery(Duration.ofSeconds(5))
//					.ignoring(ElementClickInterceptedException.class);
//
//
//			fluentWait1.until(new Function<WebDriver, WebElement>() {
//				public WebElement apply(WebDriver driver) {
//					return driver.findElement(By.xpath("//textarea[@placeholder='Enter Description']"));
//				}
//			});

			Wait(7000);
			if(IsElementDisplayed("Description", CraneCalenderLocators)) {
				Print("Delivery popup is opened");
				ReportConfig.PassedLogInfo("User gives invalid time in Crane calendar","Delivery popup is opened");
			}

			TypeDataInTheField("Description", CraneCalenderLocators, ReadFrom.Excel(CraneCalendar, 0, ReadFrom.NegativeCraneCalendar));
			Print("Description is entered as : " + ReadFrom.Excel(CraneCalendar, 0, ReadFrom.NegativeCraneCalendar));
			ReportConfig.PassedLogInfo("User gives invalid time in Crane calendar","Description is entered as : " + ReadFrom.Excel(CraneCalendar, 0, ReadFrom.NegativeCraneCalendar));


			///////////////////////

			/////////////////////////////////////

			SelectFromVisibleText("EquipmentDropdown", CraneCalenderLocators, ReadFrom.Excel(CraneCalendar, 10, ReadFrom.NegativeCraneCalendar));
			Print("Equipment dropdown is selected as : " + ReadFrom.Excel(CraneCalendar, 10, ReadFrom.NegativeCraneCalendar));
			ReportConfig.PassedLogInfo("User gives invalid time in Crane calendar","Equipment dropdown is selected as : " + ReadFrom.Excel(CraneCalendar, 10, ReadFrom.NegativeCraneCalendar));

			///////

			Wait(2000);
			Clear("FromHrs", CraneCalenderLocators);
			TypeDataInTheField("FromHrs", CraneCalenderLocators, ReadFrom.Excel(CraneCalendar, 4, ReadFrom.NegativeCraneCalendar));
			Print("From hrs is entered as : " + ReadFrom.Excel(CraneCalendar, 4, ReadFrom.NegativeCraneCalendar));
			ReportConfig.PassedLogInfo("User gives invalid time in Crane calendar","From hrs is entered as : " + ReadFrom.Excel(CraneCalendar, 4, ReadFrom.NegativeCraneCalendar));

			Wait(2000);
			Clear("FromMin", CraneCalenderLocators);
			TypeDataInTheField("FromMin", CraneCalenderLocators, ReadFrom.Excel(CraneCalendar, 5, ReadFrom.NegativeCraneCalendar));
			Print("From min is entered as : " + ReadFrom.Excel(CraneCalendar, 5, ReadFrom.NegativeCraneCalendar));
			ReportConfig.PassedLogInfo("User gives invalid time in Crane calendar","From min is entered as : " + ReadFrom.Excel(CraneCalendar, 5, ReadFrom.NegativeCraneCalendar));

			Wait(2000);
			String ExcelMeridian = ReadFrom.Excel(CraneCalendar, 6, ReadFrom.NegativeCraneCalendar);
			String Meridian = GetText("FromMeridian", CraneCalenderLocators);
			if(IsEqual(Meridian, ExcelMeridian)) {


			}
			else {
				Click("FromMeridian", CraneCalenderLocators);
			}

			Wait(2000);
			Clear("ToHrs", CraneCalenderLocators);
			TypeDataInTheField("ToHrs", CraneCalenderLocators, ReadFrom.Excel(CraneCalendar, 7, ReadFrom.NegativeCraneCalendar));
			Print("To hrs is entered as : " + ReadFrom.Excel(CraneCalendar, 7, ReadFrom.NegativeCraneCalendar));
			ReportConfig.PassedLogInfo("User gives invalid time in Crane calendar","To hrs is entered as : " + ReadFrom.Excel(CraneCalendar, 7, ReadFrom.NegativeCraneCalendar));

			Wait(2000);
			Clear("ToMin", CraneCalenderLocators);
			TypeDataInTheField("ToMin", CraneCalenderLocators, ReadFrom.Excel(CraneCalendar, 8, ReadFrom.NegativeCraneCalendar));
			Print("To min is entered as : " + ReadFrom.Excel(CraneCalendar, 8, ReadFrom.NegativeCraneCalendar));
			ReportConfig.PassedLogInfo("User gives invalid time in Crane calendar","To min is entered as : " + ReadFrom.Excel(CraneCalendar, 8, ReadFrom.NegativeCraneCalendar));

			Wait(2000);
			String ExcelMeridian1 = ReadFrom.Excel(CraneCalendar, 9, ReadFrom.NegativeCraneCalendar);
			String Meridian1 = GetText("ToMeridian", CraneCalenderLocators);
			if(IsEqual(Meridian1, ExcelMeridian1)) {


			}
			else {
				Click("ToMeridian", CraneCalenderLocators);
			}


			Wait(2000);
			Clear("PickingFrom", CraneCalenderLocators);
			TypeDataInTheField("PickingFrom", CraneCalenderLocators, ReadFrom.Excel(CraneCalendar, 11, ReadFrom.NegativeCraneCalendar));
			Print("Picking from is entered as : " + ReadFrom.Excel(CraneCalendar, 11, ReadFrom.NegativeCraneCalendar));
			ReportConfig.PassedLogInfo("User gives invalid time in Crane calendar","Picking from is entered as : " + ReadFrom.Excel(CraneCalendar, 11, ReadFrom.NegativeCraneCalendar));

			Wait(2000);
			Clear("PickingTo", CraneCalenderLocators);
			TypeDataInTheField("PickingTo", CraneCalenderLocators, ReadFrom.Excel(CraneCalendar, 12, ReadFrom.NegativeCraneCalendar));
			Print("Picking to is entered as : " + ReadFrom.Excel(CraneCalendar, 12, ReadFrom.NegativeCraneCalendar));
			ReportConfig.PassedLogInfo("User gives invalid time in Crane calendar","Picking to is entered as : " + ReadFrom.Excel(CraneCalendar, 12, ReadFrom.NegativeCraneCalendar));

			Wait(2000);

			MoveToElement("SubmitButton", CraneCalenderLocators);

			Click("SubmitButton", CraneCalenderLocators);

//			Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
//					.withTimeout(Duration.ofSeconds(120))
//					.pollingEvery(Duration.ofSeconds(5))
//					.ignoring(ElementClickInterceptedException.class);
//
//
//			fluentWait11.until(new Function<WebDriver, WebElement>() {
//				public WebElement apply(WebDriver driver) {
//					return driver.findElement(By.xpath("//div[@aria-label='Please Enter Start time Lesser than End time']"));
//				}
//			});
			Wait(7000);
			//String EnterTime =	GetText("EnterTime", CraneCalenderLocators);
		//	if(IsElementDisplayed("EnterTime", CraneCalenderLocators)) {
			//	Click("EnterTime", CraneCalenderLocators);
				ReportConfig.Givenlogpass("User gives invalid time in Crane calendar","Time error");
				Wait(2000);
				Click("CancelButton", CraneCalenderLocators);
				ReportConfig.PassedLogInfo("User add new crane request","Cancel button is clicked");
				Click("Yes", CraneCalenderLocators);
				ReportConfig.PassedLogInfo("User add new crane request","Yes button is clicked");

		//	}
//			else {
//				PrintError("Delivery not added");
//				ReportConfig.FailedLogInfo("User gives invalid time in Crane calendar","Error message didn't displayes");
//
//			}
			Wait(3000);
		}

	}
	public static void NegativeMandatory() throws Throwable {

		PrintError("NegativeMandatory Crane Calender started");
		Wait(2000);
		ReportConfig.PassedLogInfo("User add new crane request","Create new button is clicked");
		JsClick("CreateNew", CraneCalenderLocators);
		Wait(2000);
		MoveToElement("SubmitButton", CraneCalenderLocators);
		JsClick("SubmitButton", CraneCalenderLocators);
		ReportConfig.PassedLogInfo("User add new crane request","Submit button is clicked");

		String DescriptionRequired = 	GetText("DescriptionRequired", CraneCalenderLocators);
		String EquipmentRequired = 		GetText("EquipmentRequired", CraneCalenderLocators);
		String PickingFromRequired = 	GetText("PickingFromRequired", CraneCalenderLocators);
		String PickingToRequired = 		GetText("PickingToRequired", CraneCalenderLocators);

		ReportConfig.Givenlogpass("Description required Error :", DescriptionRequired);
		ReportConfig.Givenlogpass("Equipment required Error :", EquipmentRequired);
		ReportConfig.Givenlogpass("Picking from Error :", PickingFromRequired);
		ReportConfig.Givenlogpass("Picking to Error :", PickingToRequired);

		Wait(2000);
		Click("CancelButton", CraneCalenderLocators);
		ReportConfig.PassedLogInfo("User add new crane request","Cancel button is clicked");
		Click("Yes", CraneCalenderLocators);
		ReportConfig.PassedLogInfo("User add new crane request","Yes button is clicked");
	}

	public static void SearchMonth(int Row , String Excel) throws Throwable {

		Wait(6000);
		String Date = "False";
		while(Date=="False") {
			WebElement CalendarYear = getElement("CalendarYear", CraneCalenderLocators);	
			explicitwaitclickable(CalendarYear);
			String CalendarMonth =  GetText("CalendarYear", CraneCalenderLocators);		
			String	MonthValue = CalendarMonth.split(" ")[0];

			String Month = ReadFrom.Excel(Row, 0, Excel);

			if(IsEqual(MonthValue, Month) ) {
				Print("Month selected is : " + MonthValue);
				ReportConfig.PassedLogInfo("Month selected is : " , MonthValue);

				Date = "True"; 

			}
			else {
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//div[1]/div[2]/div/button[3]/span"));
					}
				});
				JsClick("NextMonthCalendar", CraneCalenderLocators);



				Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait1.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//div[1]/div[2]/div/button[3]/span"));
					}
				});
			}
		}
	} 



	public static void SearchYear(int Row , String Excel) throws Throwable {

		Wait(6000);


		String Date = "False";
		while(Date=="False") {

			String CalendarYear =  GetText("CalendarYear", CraneCalenderLocators);		

			String	YearValue = CalendarYear.split(" ", 2)[1];
			String Year = ReadFrom.Excel(Row, 1, Excel);

			int i=Integer.parseInt(YearValue);  
			int k=Integer.parseInt(Year);  

			if(IsEqual(Year, YearValue) ) {
				Print("Year selected is : " + YearValue);
				ReportConfig.PassedLogInfo("Year selected is : " , YearValue);
				Date = "True"; 
			}

			else if(i>k) {
				Wait(3000);
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//span[@class='fc-icon fc-icon-chevrons-left']"));
					}
				});

				JsClick("PreviousYearCalendar", CraneCalenderLocators);


				Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait1.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//*[@id=\"calendar\"]/div[1]/div[2]/div/h2"));
					}
				});

			}
			else {
				Wait(3000);
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//span[@class='fc-icon fc-icon-chevrons-right']"));
					}
				});
				//Waitfortheelement("NextYearCalendar", CraneCalenderLocators);
				JsClick("NextYearCalendar", CraneCalenderLocators);

				Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait1.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//*[@id=\"calendar\"]/div[1]/div[2]/div/h2"));
					}
				});
			}
		}
	}


	public static void ViewCraneRequestInfo() throws Throwable {
		PrintError("View Crane Calender Info started");

		ReadFrom.DynamicExcel(ReadFrom.ViewCraneCalendar);

		for(int ViewCraneCalendar =1; ViewCraneCalendar<=ReadFrom.rowcount; ViewCraneCalendar++)	{


			SearchMonth(ViewCraneCalendar, ReadFrom.ViewCraneCalendar);
			SearchYear(ViewCraneCalendar, ReadFrom.ViewCraneCalendar);

			Wait(3000);
			Click("SearchIcon", CraneCalenderLocators);
			Wait(2000);
			TypeDataInTheField("Search", CraneCalenderLocators, ReadFrom.Excel(ViewCraneCalendar, 2, ReadFrom.ViewCraneCalendar));
			Wait(7000);

			Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(ElementClickInterceptedException.class);


			fluentWait11.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
				}
			});

			for(int DeliveryLists =1; DeliveryLists<=1; DeliveryLists++)		{

				Wait<WebDriver> fluentWait111 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(10))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait111.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
					}
				});

				WebElement Delivery =	FindElement("CraneRequestList", CraneCalenderLocators, DeliveryLists);

				String DeliveryName = 	GetTextFromTheElement(Delivery);

				String ViewInfo =	ReadFrom.Excel(ViewCraneCalendar, 2, ReadFrom.ViewCraneCalendar);


				if(IsEqual(DeliveryName, ViewInfo)) {

					JsClick(Delivery);
					ReportConfig.PassedLogInfo("User view Crane request information" ,DeliveryName + " : is clicked");
					Print(DeliveryName + " : is clicked");


					Wait<WebDriver> CompanyInFilter = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(120))
							.pollingEvery(Duration.ofSeconds(10))
							.ignoring(ElementClickInterceptedException.class);


					CompanyInFilter.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("//div[3]/div[1]/span/span/em")); 
						}
					});

					JsClick("Expand", CraneCalenderLocators);

					ReportConfig.PassedLogInfo("User view Crane request information" ,"Expand button is clicked");
					Print("Expand button is clicked");

//					Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
//							.withTimeout(Duration.ofSeconds(120))
//							.pollingEvery(Duration.ofSeconds(5))
//							.ignoring(ElementClickInterceptedException.class);
//
//
//					fluentWait1.until(new Function<WebDriver, WebElement>() {
//						public WebElement apply(WebDriver driver) {
//							return driver.findElement(By.xpath("//h4[normalize-space()='Responsible Person']"));
//						}
//					});
					Wait(7000);
					//if(IsElementDisplayed("ViewDetails", CraneCalenderLocators)) {
						Print(DeliveryName + " : request info is viewed");
						ReportConfig.PassedLogInfo("User view Crane request information" ,DeliveryName + " : request info is viewed");

						JsClick("ClosePopup", CraneCalenderLocators);

						ReportConfig.PassedLogInfo("User view Crane request information" ,"Close popup button is clicked");
						Print("Close popup button is clicked");
						Wait(2000);
						Clear("Search", CraneCalenderLocators);
						Wait(3000);
						JsClick("CloseSearch", CraneCalenderLocators);
					//}
				}
			}
		}
	}


	public static void EditCraneCalendar() throws Throwable {

		PrintError("Edit crane Calender started");
		ReadFrom.DynamicExcel(ReadFrom.EditCraneCalendar);

		for(int EditCraneCalendar =1; EditCraneCalendar<=ReadFrom.rowcount; EditCraneCalendar++)	{

			SearchMonth(EditCraneCalendar, ReadFrom.EditCraneCalendar);
			SearchYear(EditCraneCalendar, ReadFrom.EditCraneCalendar);

			Wait(3000);
			Click("SearchIcon", CraneCalenderLocators);
			Wait(2000);
			TypeDataInTheField("Search", CraneCalenderLocators, ReadFrom.Excel(EditCraneCalendar, 2, ReadFrom.EditCraneCalendar));
			Wait(7000);

			Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(ElementClickInterceptedException.class);


			fluentWait11.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
				}
			});

			for(int DeliveryLists =1; DeliveryLists<=1; DeliveryLists++)		{

				Wait<WebDriver> fluentWait111 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(10))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait111.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
					}
				});

				WebElement Delivery =	FindElement("CraneRequestList", CraneCalenderLocators, DeliveryLists);

				String DeliveryName = 	GetTextFromTheElement(Delivery);

				String EditIt =	ReadFrom.Excel(EditCraneCalendar, 2, ReadFrom.EditCraneCalendar);


				if(IsEqual(DeliveryName, EditIt)) {

					JsClick(Delivery);
					ReportConfig.PassedLogInfo("User edit a Crane request from the list",DeliveryName + " : is clicked");
					Print(DeliveryName + " : is clicked");

//					Wait<WebDriver> CompanyInFilter = new FluentWait<WebDriver>(driver)
//							.withTimeout(Duration.ofSeconds(120))
//							.pollingEvery(Duration.ofSeconds(10))
//							.ignoring(ElementClickInterceptedException.class);
//
//
//					CompanyInFilter.until(new Function<WebDriver, WebElement>() {
//						public WebElement apply(WebDriver driver) {
//							return driver.findElement(By.xpath("//button[normalize-space()='Edit']"));
//						}
//					});

					Wait(7000);
					JsClick("EditButton", CraneCalenderLocators);
					ReportConfig.PassedLogInfo("User edit a Crane request from the list","Edit button is clicked");
					Print("Edit button is clicked");

//					Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
//							.withTimeout(Duration.ofSeconds(120))
//							.pollingEvery(Duration.ofSeconds(5))
//							.ignoring(ElementClickInterceptedException.class);
//
//					fluentWait1.until(new Function<WebDriver, WebElement>() {
//						public WebElement apply(WebDriver driver) {
//							return driver.findElement(By.xpath("//textarea[@placeholder='Enter Description']"));
//						}
//					});

					Wait(7000);
					if(IsElementDisplayed("Description", CraneCalenderLocators)) {
						Print("Delivery popup is opened");
						ReportConfig.PassedLogInfo("User edit a Crane request from the list","Delivery popup is opened");
					}

					Clear("Description", CraneCalenderLocators);
					TypeDataInTheField("Description", CraneCalenderLocators, ReadFrom.Excel(EditCraneCalendar, 3, ReadFrom.EditCraneCalendar));
					Print("Description is entered as : " + ReadFrom.Excel(EditCraneCalendar, 3, ReadFrom.EditCraneCalendar));
					ReportConfig.PassedLogInfo("User edit a Crane request from the list","Description is entered as : " + ReadFrom.Excel(EditCraneCalendar, 3, ReadFrom.EditCraneCalendar));

					Wait(2000);
					Click("CompanyEdit", CraneCalenderLocators);
					Print("company");
					Wait(2000);
					Click("CompanySelectAll", CraneCalenderLocators);
					Wait(2000);
					Click("UnselectAll", CraneCalenderLocators);
					ReportConfig.PassedLogInfo("User edit a Crane request from the list","Company dropdown is clicked");

					Wait(3000);
					String CompanyInExcel = ReadFrom.Excel(EditCraneCalendar, 4, ReadFrom.EditCraneCalendar);
					Print(CompanyInExcel);

					int countofthelist = 	SizeOfTheList("CompanyDropdown", CraneCalenderLocators);

					for(int DropdownValues =1; DropdownValues<=countofthelist; DropdownValues++)		{	

						WebElement Company = 	FindElement("CompanyList", CraneCalenderLocators, DropdownValues);
						String CompanyInDropdown = 	GetTextFromTheElement(Company);
						Print(CompanyInDropdown);

						if(IsEqual(CompanyInDropdown, CompanyInExcel)){
							Click(Company);

							ReportConfig.PassedLogInfo("User edit a Crane request from the list",CompanyInDropdown + " is selected from the dropdown");
							Print(CompanyInDropdown + " is selected from the dropdown");
							break;
						}
					}	
					///////////////////////

					Wait(2000);
					Click("DfowEdit", CraneCalenderLocators);
					Wait(2000);
					Click("DfowSelectAll", CraneCalenderLocators);
					Wait(2000);
					Click("UnselectAll", CraneCalenderLocators);

					Wait(3000);
					String DfowInExcel = ReadFrom.Excel(EditCraneCalendar, 5,ReadFrom.EditCraneCalendar);

					int rowcountofthelist = 	SizeOfTheList("DfowDropdown", CraneCalenderLocators);

					for(int DropdownValues =1; DropdownValues<=rowcountofthelist; DropdownValues++)		{	
						WebElement Dfow = 	FindElement("DfowList", CraneCalenderLocators, DropdownValues);
						String DfowInDropdown = 	GetTextFromTheElement(Dfow);


						if(IsEqual(DfowInDropdown, DfowInExcel)){
							Click(Dfow);
							ReportConfig.PassedLogInfo("User edit a Crane request from the list",DfowInDropdown + " is selected from the dropdown");
							Print("Dfow is selected as : " + DfowInDropdown );
							break;
						}
					}	

					/////////////////////////////////////

					SelectFromVisibleText("EquipmentDropdown", CraneCalenderLocators, ReadFrom.Excel(EditCraneCalendar, 13, ReadFrom.EditCraneCalendar));
					Print("Equipment dropdown is selected as : " + ReadFrom.Excel(EditCraneCalendar, 13, ReadFrom.EditCraneCalendar));
					ReportConfig.PassedLogInfo("User edit a Crane request from the list","Equipment dropdown is selected as : " + ReadFrom.Excel(EditCraneCalendar, 13, ReadFrom.EditCraneCalendar));


					Clear("DeliveryDate", CraneCalenderLocators);
					TypeDataInTheField("DeliveryDate", CraneCalenderLocators, ReadFrom.Excel(EditCraneCalendar, 6, ReadFrom.EditCraneCalendar));
					Print("Start date is entered as : " + ReadFrom.Excel(EditCraneCalendar, 6, ReadFrom.EditCraneCalendar));
					ReportConfig.PassedLogInfo("User edit a Crane request from the list","Start date is entered as : " + ReadFrom.Excel(EditCraneCalendar, 6, ReadFrom.EditCraneCalendar));

					///////

					Wait(2000);
					Clear("FromHrs", CraneCalenderLocators);
					TypeDataInTheField("FromHrs", CraneCalenderLocators, ReadFrom.Excel(EditCraneCalendar, 7, ReadFrom.EditCraneCalendar));
					Print("From hrs is entered as : " + ReadFrom.Excel(EditCraneCalendar, 7, ReadFrom.EditCraneCalendar));
					ReportConfig.PassedLogInfo("User edit a Crane request from the list","From hrs is entered as : " + ReadFrom.Excel(EditCraneCalendar, 7, ReadFrom.EditCraneCalendar));

					Wait(2000);
					Clear("FromMin", CraneCalenderLocators);
					TypeDataInTheField("FromMin", CraneCalenderLocators, ReadFrom.Excel(EditCraneCalendar, 8, ReadFrom.EditCraneCalendar));
					Print("From min is entered as : " + ReadFrom.Excel(EditCraneCalendar, 8, ReadFrom.EditCraneCalendar));
					ReportConfig.PassedLogInfo("User edit a Crane request from the list","From min is entered as : " + ReadFrom.Excel(EditCraneCalendar, 8, ReadFrom.EditCraneCalendar));

					Wait(2000);
					String ExcelMeridian = ReadFrom.Excel(EditCraneCalendar, 9, ReadFrom.EditCraneCalendar);
					String Meridian = GetText("FromMeridian", CraneCalenderLocators);
					if(IsEqual(Meridian, ExcelMeridian)) {


					}
					else {
						Click("FromMeridian", CraneCalenderLocators);
					}

					Wait(2000);
					Clear("ToHrs", CraneCalenderLocators);
					TypeDataInTheField("ToHrs", CraneCalenderLocators, ReadFrom.Excel(EditCraneCalendar, 10, ReadFrom.EditCraneCalendar));
					Print("To hrs is entered as : " + ReadFrom.Excel(EditCraneCalendar, 10, ReadFrom.EditCraneCalendar));
					ReportConfig.PassedLogInfo("User edit a Crane request from the list","To hrs is entered as : " + ReadFrom.Excel(EditCraneCalendar, 10, ReadFrom.EditCraneCalendar));

					Wait(2000);
					Clear("ToMin", CraneCalenderLocators);
					TypeDataInTheField("ToMin", CraneCalenderLocators, ReadFrom.Excel(EditCraneCalendar, 11, ReadFrom.EditCraneCalendar));
					Print("To min is entered as : " + ReadFrom.Excel(EditCraneCalendar, 11, ReadFrom.EditCraneCalendar));
					ReportConfig.PassedLogInfo("User edit a Crane request from the list","To min is entered as : " + ReadFrom.Excel(EditCraneCalendar, 11, ReadFrom.EditCraneCalendar));

					Wait(2000);
					String ExcelMeridian1 = ReadFrom.Excel(EditCraneCalendar, 12, ReadFrom.EditCraneCalendar);
					String Meridian1 = GetText("ToMeridian", CraneCalenderLocators);
					if(IsEqual(Meridian1, ExcelMeridian1)) {


					}
					else {
						Click("ToMeridian", CraneCalenderLocators);
					}


					Wait(2000);
					Clear("PickingFrom", CraneCalenderLocators);

					TypeDataInTheField("PickingFrom", CraneCalenderLocators, ReadFrom.Excel(EditCraneCalendar, 14, ReadFrom.EditCraneCalendar));
					Print("Picking from is entered as : " + ReadFrom.Excel(EditCraneCalendar, 14, ReadFrom.EditCraneCalendar));
					ReportConfig.PassedLogInfo("User edit a Crane request from the list","Picking from is entered as : " + ReadFrom.Excel(EditCraneCalendar, 14, ReadFrom.EditCraneCalendar));

					Wait(2000);
					Clear("PickingTo", CraneCalenderLocators);

					TypeDataInTheField("PickingTo", CraneCalenderLocators, ReadFrom.Excel(EditCraneCalendar, 15, ReadFrom.EditCraneCalendar));
					Print("Picking to is entered as : " + ReadFrom.Excel(EditCraneCalendar, 15, ReadFrom.EditCraneCalendar));
					ReportConfig.PassedLogInfo("User edit a Crane request from the list","Picking to is entered as : " + ReadFrom.Excel(EditCraneCalendar, 15, ReadFrom.EditCraneCalendar));

					Wait(2000);
					MoveToElement("AdditionalText", CraneCalenderLocators);
					Clear("AdditionalText", CraneCalenderLocators);

					TypeDataInTheField("AdditionalText", CraneCalenderLocators, ReadFrom.Excel(EditCraneCalendar, 16, ReadFrom.EditCraneCalendar));
					Print("Additional text is entered as : " + ReadFrom.Excel(EditCraneCalendar, 16, ReadFrom.EditCraneCalendar));
					ReportConfig.PassedLogInfo("User edit a Crane request from the list","Additional text is entered as : " + ReadFrom.Excel(EditCraneCalendar, 16, ReadFrom.EditCraneCalendar));

					Wait(4000);	

					MoveToElement("SubmitButton", CraneCalenderLocators);

					Click("SubmitButton", CraneCalenderLocators);

					Print("Crane request updated");
					ReportConfig.PassedLogInfo("User edit a crane request from the list","Crane request updated");
					Wait(3000);
					Wait(2000);
					Clear("Search", CraneCalenderLocators);
					Wait(3000);
					JsClick("CloseSearch", CraneCalenderLocators);
				}
			}}
	}

	public static void EditWithoutCompany_Negative() throws Throwable {

		PrintError("EditWithoutCompany_Negative crane Calender started");
		ReadFrom.DynamicExcel(ReadFrom.NegativeCraneCalendar);

		for(int EditCraneCalendar =1; EditCraneCalendar<=ReadFrom.rowcount; EditCraneCalendar++)	{

			SearchMonth(EditCraneCalendar, ReadFrom.EditCraneCalendar);
			SearchYear(EditCraneCalendar, ReadFrom.EditCraneCalendar);

			Wait(3000);
			Click("SearchIcon", CraneCalenderLocators);
			Wait(2000);
			TypeDataInTheField("Search", CraneCalenderLocators, ReadFrom.Excel(EditCraneCalendar, 2, ReadFrom.EditCraneCalendar));
			Wait(7000);

			Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(ElementClickInterceptedException.class);


			fluentWait11.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
				}
			});

			for(int DeliveryLists =1; DeliveryLists<=1; DeliveryLists++)		{

				Wait<WebDriver> fluentWait111 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(10))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait111.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
					}
				});

				WebElement Delivery =	FindElement("CraneRequestList", CraneCalenderLocators, DeliveryLists);

				String DeliveryName = 	GetTextFromTheElement(Delivery);

				String EditIt =	ReadFrom.Excel(EditCraneCalendar, 2, ReadFrom.EditCraneCalendar);


				if(IsEqual(DeliveryName, EditIt)) {

					JsClick(Delivery);
					ReportConfig.PassedLogInfo("User edit and save a crane request without company in Crane Calendar",DeliveryName + " : is clicked");
					Print(DeliveryName + " : is clicked");

//					Wait<WebDriver> CompanyInFilter = new FluentWait<WebDriver>(driver)
//							.withTimeout(Duration.ofSeconds(120))
//							.pollingEvery(Duration.ofSeconds(10))
//							.ignoring(ElementClickInterceptedException.class);
//
//
//					CompanyInFilter.until(new Function<WebDriver, WebElement>() {
//						public WebElement apply(WebDriver driver) {
//							return driver.findElement(By.xpath("//button[normalize-space()='Edit']"));
//						}
//					});
					
					Wait(7000);

					JsClick("EditButton", CraneCalenderLocators);
					ReportConfig.PassedLogInfo("User edit and save a crane request without company in Crane Calendar","Edit button is clicked");
					Print("Edit button is clicked");

//					Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
//							.withTimeout(Duration.ofSeconds(120))
//							.pollingEvery(Duration.ofSeconds(5))
//							.ignoring(ElementClickInterceptedException.class);
//
//					fluentWait1.until(new Function<WebDriver, WebElement>() {
//						public WebElement apply(WebDriver driver) {
//							return driver.findElement(By.xpath("//textarea[@placeholder='Enter Description']"));
//						}
//					});
					
					Wait(7000);

					if(IsElementDisplayed("Description", CraneCalenderLocators)) {
						Print("Delivery popup is opened");
						ReportConfig.PassedLogInfo("User edit and save a crane request without company in Crane Calendar","Delivery popup is opened");
					}

					Wait(2000);
					Click("CompanyEdit", CraneCalenderLocators);
					Wait(2000);
					Click("CompanySelectAll", CraneCalenderLocators);
					Wait(2000);
					Click("UnselectAll", CraneCalenderLocators);
					ReportConfig.PassedLogInfo("User edit and save a crane request without company in Crane Calendar","Company dropdown is clicked");
					///////////////////////

					Wait(4000);	

					MoveToElement("SubmitButton", CraneCalenderLocators);

					Click("SubmitButton", CraneCalenderLocators);

//					Wait<WebDriver> Responsible = new FluentWait<WebDriver>(driver)
//							.withTimeout(Duration.ofSeconds(120))
//							.pollingEvery(Duration.ofSeconds(5))
//							.ignoring(ElementClickInterceptedException.class);
//
//
//					Responsible.until(new Function<WebDriver, WebElement>() {
//						public WebElement apply(WebDriver driver) {
//							return driver.findElement(By.xpath("//div[@aria-label='Responsible Company is required']"));
//						}
//					});
					
					Wait(7000);

				//	String CompanyRequired =	GetText("CompanyRequired", CraneCalenderLocators);
				//	if(IsElementDisplayed("CompanyRequired", CraneCalenderLocators)) {
					//	Click("CompanyRequired", CraneCalenderLocators);
						ReportConfig.Givenlogpass("User edit and save a crane request without company in Crane Calendar","Error" );
						Wait(2000);
						Click("CancelButton", CraneCalenderLocators);
						ReportConfig.PassedLogInfo("User edit and save a crane request without company in Crane Calendar","Cancel button is clicked");
						Click("Yes", CraneCalenderLocators);
						ReportConfig.PassedLogInfo("User edit and save a crane request without company in Crane Calendar","Yes button is clicked");

						ReportConfig.PassedLogInfo("User edit and save a crane request without company in Crane Calendar","Crane request updated");

						Wait(3000);
						Wait(2000);
						Clear("Search", CraneCalenderLocators);
						Wait(3000);
						JsClick("CloseSearch", CraneCalenderLocators);
				//	}
				}

			}}
	}

	public static void EditWithoutDFOW_Negative() throws Throwable {

		PrintError("EditWithoutDFOW_Negative crane Calender started");
		ReadFrom.DynamicExcel(ReadFrom.NegativeCraneCalendar);

		for(int EditCraneCalendar =1; EditCraneCalendar<=1; EditCraneCalendar++)	{

			SearchMonth(EditCraneCalendar, ReadFrom.EditCraneCalendar);
			SearchYear(EditCraneCalendar, ReadFrom.EditCraneCalendar);

			Wait(3000);
			Click("SearchIcon", CraneCalenderLocators);
			Wait(2000);
			TypeDataInTheField("Search", CraneCalenderLocators, ReadFrom.Excel(EditCraneCalendar, 2, ReadFrom.EditCraneCalendar));
			Wait(7000);

			Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(ElementClickInterceptedException.class);


			fluentWait11.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
				}
			});

			for(int DeliveryLists =1; DeliveryLists<=1; DeliveryLists++)		{

				Wait<WebDriver> fluentWait111 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(10))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait111.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
					}
				});

				WebElement Delivery =	FindElement("CraneRequestList", CraneCalenderLocators, DeliveryLists);

				String DeliveryName = 	GetTextFromTheElement(Delivery);

				String EditIt =	ReadFrom.Excel(EditCraneCalendar, 2, ReadFrom.EditCraneCalendar);


				if(IsEqual(DeliveryName, EditIt)) {

					JsClick(Delivery);
					ReportConfig.PassedLogInfo("User edit and save a crane request without dfow in Crane Calendar",DeliveryName + " : is clicked");
					Print(DeliveryName + " : is clicked");

//					Wait<WebDriver> CompanyInFilter = new FluentWait<WebDriver>(driver)
//							.withTimeout(Duration.ofSeconds(120))
//							.pollingEvery(Duration.ofSeconds(10))
//							.ignoring(ElementClickInterceptedException.class);
//
//
//					CompanyInFilter.until(new Function<WebDriver, WebElement>() {
//						public WebElement apply(WebDriver driver) {
//							return driver.findElement(By.xpath("//button[normalize-space()='Edit']"));
//						}
//					});
					
					Wait(7000);

					JsClick("EditButton", CraneCalenderLocators);
					ReportConfig.PassedLogInfo("User edit and save a crane request without dfow in Crane Calendar","Edit button is clicked");
					Print("Edit button is clicked");

//					Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
//							.withTimeout(Duration.ofSeconds(120))
//							.pollingEvery(Duration.ofSeconds(5))
//							.ignoring(ElementClickInterceptedException.class);
//
//					fluentWait1.until(new Function<WebDriver, WebElement>() {
//						public WebElement apply(WebDriver driver) {
//							return driver.findElement(By.xpath("//textarea[@placeholder='Enter Description']"));
//						}
//					});
					
					Wait(7000);

					if(IsElementDisplayed("Description", CraneCalenderLocators)) {
						Print("Delivery popup is opened");
						ReportConfig.PassedLogInfo("User edit and save a crane request without dfow in Crane Calendar","Delivery popup is opened");
					}

					Wait(2000);
					Click("DfowEdit", CraneCalenderLocators);
					Wait(2000);
					Click("DfowSelectAll", CraneCalenderLocators);
					Wait(2000);
					Click("UnselectAll", CraneCalenderLocators);
					ReportConfig.PassedLogInfo("User edit and save a crane request without dfow in Crane Calendar","Company dropdown is clicked");
					///////////////////////

					Wait(4000);	

					MoveToElement("SubmitButton", CraneCalenderLocators);

					Click("SubmitButton", CraneCalenderLocators);

//					Wait<WebDriver> Responsible = new FluentWait<WebDriver>(driver)
//							.withTimeout(Duration.ofSeconds(120))
//							.pollingEvery(Duration.ofSeconds(5))
//							.ignoring(ElementClickInterceptedException.class);
//
//
//					Responsible.until(new Function<WebDriver, WebElement>() {
//						public WebElement apply(WebDriver driver) {
//							return driver.findElement(By.xpath("//div[@aria-label='Definable Feature Of Work is required']"));
//						}
//					});

					
					Wait(7000);
					//String DFOWRequired =	GetText("DFOWRequired", CraneCalenderLocators);
				//	if(IsElementDisplayed("DFOWRequired", CraneCalenderLocators)) {
					//	Click("DFOWRequired", CraneCalenderLocators);
						ReportConfig.Givenlogpass("User edit and save a crane request without dfow in Crane Calendar","DFOW Error");
						Wait(2000);
						Click("CancelButton", CraneCalenderLocators);
						ReportConfig.PassedLogInfo("User edit and save a crane request without dfow in Crane Calendar","Cancel button is clicked");
						Click("Yes", CraneCalenderLocators);
						ReportConfig.PassedLogInfo("User edit and save a crane request without dfow in Crane Calendar","Yes button is clicked");

						ReportConfig.PassedLogInfo("User edit and save a crane request without dfow in Crane Calendar","Crane request updated");

						Wait(3000);
						Clear("Search", CraneCalenderLocators);
						Wait(3000);
						JsClick("CloseSearch", CraneCalenderLocators);
					//}
				}

			}}


	}



	public static void FilterCraneCalendar() throws Throwable {

		PrintError("Filter crane Calender started");
		ReadFrom.DynamicExcel(ReadFrom.FilterCraneCalendar);

		for(int FilterCraneCalendar =1; FilterCraneCalendar<=ReadFrom.rowcount; FilterCraneCalendar++)	{

			SearchMonth(FilterCraneCalendar, ReadFrom.FilterCraneCalendar);
			SearchYear(FilterCraneCalendar, ReadFrom.FilterCraneCalendar);


			Wait(4000);
			try {

				JsClick("FilterIcon", CraneCalenderLocators);
				ReportConfig.PassedLogInfo("User filter the Crane request from the list","Filter icon is clicked");
				Print("Filter icon is clicked");


				Wait<WebDriver> CompanyInFilter = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(10))
						.ignoring(ElementClickInterceptedException.class);


				CompanyInFilter.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//select[@id='equipmentFilter1'])[1]"));
					}
				});
				Wait(7000);

				SelectFromVisibleText("EquipmentInFilter", CraneCalenderLocators, ReadFrom.Excel(FilterCraneCalendar, 2, ReadFrom.FilterCraneCalendar));

				ReportConfig.PassedLogInfo("User filter the Crane request from the list",ReadFrom.Excel(FilterCraneCalendar, 2, ReadFrom.FilterCraneCalendar) + " is selected from the dropdown");
				Print(ReadFrom.Excel(FilterCraneCalendar, 2, ReadFrom.FilterCraneCalendar) + " is selected from the dropdown");

				Wait(2000);

				JsClick("ApplyButton", CraneCalenderLocators);
				ReportConfig.PassedLogInfo("User filter the Crane request from the list","Apply button is clicked");
				Print("Apply button is clicked");

			}
			catch (Exception e) {
				Print(e.getMessage());
			}


			Wait(2000);
			JsClick("FilterIcon", CraneCalenderLocators);
			Wait(2000);
			JsClick("ResetButton", CraneCalenderLocators);
			ReportConfig.PassedLogInfo("User filter the Crane request from the list","Reset button is clicked");
			Print("Reset button is clicked");


		}
	}

	public static void AddComment() throws Throwable {

		PrintError("Add comment in crane Calender started");
		ReadFrom.DynamicExcel(ReadFrom.AddCommentCraneCalendar);

		for(int Comments =1; Comments<=ReadFrom.rowcount; Comments++)	{


			SearchMonth(Comments, ReadFrom.AddCommentCraneCalendar);
			SearchYear(Comments, ReadFrom.AddCommentCraneCalendar);

			Wait(3000);
			Click("SearchIcon", CraneCalenderLocators);
			Wait(2000);
			TypeDataInTheField("Search", CraneCalenderLocators, ReadFrom.Excel(Comments, 2, ReadFrom.AddCommentCraneCalendar));
			Wait(7000);

			Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(ElementClickInterceptedException.class);


			fluentWait11.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
				}
			});

			for(int DeliveryLists =1; DeliveryLists<=1; DeliveryLists++)		{

				Wait<WebDriver> fluentWait111 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(10))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait111.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
					}
				});

				WebElement Delivery =	FindElement("CraneRequestList", CraneCalenderLocators, DeliveryLists);

				String DeliveryName = 	GetTextFromTheElement(Delivery);

				String ViewInfo =	ReadFrom.Excel(Comments, 2, ReadFrom.AddCommentCraneCalendar);


				if(IsEqual(DeliveryName, ViewInfo)) {

					JsClick(Delivery);
					ReportConfig.PassedLogInfo("User add a comment to a crane request in calendar settings",DeliveryName + " : is clicked");
					Print(DeliveryName + " : is clicked");

//					Wait<WebDriver> CompanyInFilter = new FluentWait<WebDriver>(driver)
//							.withTimeout(Duration.ofSeconds(120))
//							.pollingEvery(Duration.ofSeconds(10))
//							.ignoring(ElementClickInterceptedException.class);
//
//
//					CompanyInFilter.until(new Function<WebDriver, WebElement>() {
//						public WebElement apply(WebDriver driver) {
//							return driver.findElement(By.xpath("//em[@class='fas fa-expand-alt c-pointer color-grey8']"));
//						}
//					});

					Wait(7000);
					JsClick("ExpandRequest", CraneCalenderLocators);
					ReportConfig.PassedLogInfo("User add a comment to a crane request in calendar settings","Expand button is clicked");
					Print("Expand button is clicked");

//					Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
//							.withTimeout(Duration.ofSeconds(120))
//							.pollingEvery(Duration.ofSeconds(5))
//							.ignoring(ElementClickInterceptedException.class);
//
//
//					fluentWait1.until(new Function<WebDriver, WebElement>() {
//						public WebElement apply(WebDriver driver) {
//							return driver.findElement(By.xpath("//h4[normalize-space()='Responsible Person']"));
//						}
//					});

					Wait(7000);
				//	if(IsElementDisplayed("ViewDetails", CraneCalenderLocators)) {
						JsClick("Comments", CraneCalenderLocators);
						ReportConfig.PassedLogInfo("User add a comment to a crane request in calendar settings","Comment button is clicked");
						Print("Comment button is clicked");

						TypeDataInTheField("AddComment", CraneCalenderLocators, ReadFrom.Excel(Comments, 3, ReadFrom.AddCommentCraneCalendar));
						Print("Comment is entered as : " + ReadFrom.Excel(Comments, 3, ReadFrom.AddCommentCraneCalendar));
						ReportConfig.PassedLogInfo("User add a comment to a crane request in calendar settings","Description is entered as : " + ReadFrom.Excel(Comments, 3, ReadFrom.AddCommentCraneCalendar));

						JsClick("SubmitButton", CraneCalenderLocators);
						ReportConfig.PassedLogInfo("User add a comment to a crane request in calendar settings","Submit button is clicked");
						Print("Submit button is clicked");

//						Wait<WebDriver> fluentWait1111 = new FluentWait<WebDriver>(driver)
//								.withTimeout(Duration.ofSeconds(120))
//								.pollingEvery(Duration.ofSeconds(5))
//								.ignoring(ElementClickInterceptedException.class);
//
//
//						fluentWait1111.until(new Function<WebDriver, WebElement>() {
//							public WebElement apply(WebDriver driver) {
//								return driver.findElement(By.xpath("//div[@aria-label='Crane Request Comment added successfully.']"));
//							}
//						});

					//}
						Wait(7000);
				//	if(IsElementDisplayed("CommentaddedSuccessfully", CraneCalenderLocators)) {
						//JsClick("CommentaddedSuccessfully", CraneCalenderLocators);
						Print("Comment added Successfully");
						ReportConfig.PassedLogInfo("User add a comment to a crane request in calendar settings","Comment added Successfully");

						JsClick("ClosePopup", CraneCalenderLocators);
						ReportConfig.PassedLogInfo("User add a comment to a crane request in calendar settings","Close popup is clicked");
						Print("Close popup is clicked");

						Wait(2000);
						Clear("Search", CraneCalenderLocators);
						Wait(3000);
						JsClick("CloseSearch", CraneCalenderLocators);
					//}
				}
			}
		}
	}

	public static void AddAttcahment() throws Throwable {

		PrintError("Add attcahment in crane Calender started");
		ReadFrom.DynamicExcel(ReadFrom.CraneCalendarAddAttcahment);

		for(int AddAttcahment =1; AddAttcahment<=ReadFrom.rowcount; AddAttcahment++)	{


			SearchMonth(AddAttcahment, ReadFrom.CraneCalendarAddAttcahment);
			SearchYear(AddAttcahment, ReadFrom.CraneCalendarAddAttcahment);

			Wait(3000);
			Click("SearchIcon", CraneCalenderLocators);
			Wait(2000);
			TypeDataInTheField("Search", CraneCalenderLocators, ReadFrom.Excel(AddAttcahment, 2, ReadFrom.CraneCalendarAddAttcahment));
			Wait(7000);

			Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(ElementClickInterceptedException.class);


			fluentWait11.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
				}
			});

			for(int DeliveryLists =1; DeliveryLists<=1; DeliveryLists++)		{

				Wait<WebDriver> fluentWait111 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(10))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait111.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
					}
				});

				WebElement Delivery =	FindElement("CraneRequestList", CraneCalenderLocators, DeliveryLists);

				String DeliveryName = 	GetTextFromTheElement(Delivery);

				String ViewInfo =	ReadFrom.Excel(AddAttcahment, 2, ReadFrom.CraneCalendarAddAttcahment);


				if(IsEqual(DeliveryName, ViewInfo)) {

					JsClick(Delivery);
					ReportConfig.PassedLogInfo("User add attachment to the crane calendar request",DeliveryName + " : is clicked");
					Print(DeliveryName + " : is clicked");

//					Wait<WebDriver> CompanyInFilter = new FluentWait<WebDriver>(driver)
//							.withTimeout(Duration.ofSeconds(120))
//							.pollingEvery(Duration.ofSeconds(10))
//							.ignoring(ElementClickInterceptedException.class);
//
//
//					CompanyInFilter.until(new Function<WebDriver, WebElement>() {
//						public WebElement apply(WebDriver driver) {
//							return driver.findElement(By.xpath("//em[@class='fas fa-expand-alt c-pointer color-grey8']"));
//						}
//					});

					Wait(7000);
					JsClick("ExpandRequest", CraneCalenderLocators);
					ReportConfig.PassedLogInfo("User add attachment to the crane calendar request","Expand button is clicked");
					Print("Expand button is clicked");

//					Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
//							.withTimeout(Duration.ofSeconds(120))
//							.pollingEvery(Duration.ofSeconds(5))
//							.ignoring(ElementClickInterceptedException.class);
//
//
//					fluentWait1.until(new Function<WebDriver, WebElement>() {
//						public WebElement apply(WebDriver driver) {
//							return driver.findElement(By.xpath("//h4[normalize-space()='Responsible Person']"));
//						}
//					});
					Wait(7000);
				//	if(IsElementDisplayed("ViewDetails", CraneCalenderLocators)) {
						JsClick("Attachments", CraneCalenderLocators);
						ReportConfig.PassedLogInfo("User add attachment to the crane calendar request","Attachments button is clicked");
						Print("Attachments button is clicked");

						String upload = ReadFrom.SampleAttachmentjpg;
						String filePath = System.getProperty("user.dir")+ upload;

						WebElement file = driver.findElement(By.xpath("//input[@type='file']"));
						Wait(3000);
						file.sendKeys(filePath);						

//						Wait<WebDriver> Done = new FluentWait<WebDriver>(driver)
//								.withTimeout(Duration.ofSeconds(120))
//								.pollingEvery(Duration.ofSeconds(5))
//								.ignoring(ElementClickInterceptedException.class);
//
//
//						Done.until(new Function<WebDriver, WebElement>() {
//							public WebElement apply(WebDriver driver) {
//								return driver.findElement(By.xpath("//button[normalize-space()='Done']"));
//							}
//						});
Wait(7000);
						JsClick("DoneButton", CraneCalenderLocators);								
						ReportConfig.PassedLogInfo("User add attachment to the crane calendar request","Done button is clicked");
						Print("Done button is clicked");
						Wait(10000);

						//JsClick("DoneButton", CraneCalenderLocators);

//						Wait<WebDriver> Uploaded = new FluentWait<WebDriver>(driver)
//								.withTimeout(Duration.ofSeconds(120))
//								.pollingEvery(Duration.ofSeconds(5))
//								.ignoring(ElementClickInterceptedException.class);
//
//
//						Uploaded.until(new Function<WebDriver, WebElement>() {
//							public WebElement apply(WebDriver driver) {
//								return driver.findElement(By.xpath("//div[@aria-label='Uploaded Successfully.']"));
//							}
//						});


					//	if(IsElementDisplayed("UploadedSuccessfully", CraneCalenderLocators)) {
							Print("Attachment is added");
							ReportConfig.PassedLogInfo("User add attachment to the crane request", "Attachment added successfully to the " + DeliveryName);

							JsClick("ClosePopup", CraneCalenderLocators);
							ReportConfig.PassedLogInfo("User add attachment to the crane request","Close popup button is clicked");
							Print("Close popup button is clicked");

							Wait(2000);
							Clear("Search", CraneCalenderLocators);
							Wait(10000);
							JsClick("CloseSearch", CraneCalenderLocators);

						//}

					//}
				}
			}
		}
	}

	public static void NegativeAttachment() throws Throwable {

		PrintError("Add NegativeAttachment in crane Calender started");

		ReadFrom.DynamicExcel(ReadFrom.NegativeCraneCalendar);

		for(int AddAttcahment =1; AddAttcahment<=ReadFrom.rowcount; AddAttcahment++)	{

			SearchMonth(AddAttcahment, ReadFrom.CraneCalendarAddAttcahment);
			SearchYear(AddAttcahment, ReadFrom.CraneCalendarAddAttcahment);

			Wait(3000);
			Click("SearchIcon", CraneCalenderLocators);
			Wait(2000);
			TypeDataInTheField("Search", CraneCalenderLocators, ReadFrom.Excel(AddAttcahment, 2, ReadFrom.CraneCalendarAddAttcahment));
			Wait(7000);

			Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(ElementClickInterceptedException.class);


			fluentWait11.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
				}
			});




			for(int DeliveryLists =1; DeliveryLists<=1; DeliveryLists++)		{

				Wait<WebDriver> fluentWait111 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(10))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait111.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
					}
				});

				WebElement Delivery =	FindElement("CraneRequestList", CraneCalenderLocators, DeliveryLists);

				String DeliveryName = 	GetTextFromTheElement(Delivery);

				String ViewInfo =	ReadFrom.Excel(AddAttcahment, 2, ReadFrom.CraneCalendarAddAttcahment);


				if(IsEqual(DeliveryName, ViewInfo)) {

					JsClick(Delivery);
					ReportConfig.PassedLogInfo("User upload a invalid file in attachment in Crane Calendar",DeliveryName + " : is clicked");
					Print(DeliveryName + " : is clicked");

//					Wait<WebDriver> CompanyInFilter = new FluentWait<WebDriver>(driver)
//							.withTimeout(Duration.ofSeconds(120))
//							.pollingEvery(Duration.ofSeconds(10))
//							.ignoring(ElementClickInterceptedException.class);
//
//
//					CompanyInFilter.until(new Function<WebDriver, WebElement>() {
//						public WebElement apply(WebDriver driver) {
//							return driver.findElement(By.xpath("//em[@class='fas fa-expand-alt c-pointer color-grey8']"));
//						}
//					});
					Wait(7000);
					JsClick("ExpandRequest", CraneCalenderLocators);
					ReportConfig.PassedLogInfo("User upload a invalid file in attachment in Crane Calendar","Expand button is clicked");
					Print("Expand button is clicked");

//					Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
//							.withTimeout(Duration.ofSeconds(120))
//							.pollingEvery(Duration.ofSeconds(5))
//							.ignoring(ElementClickInterceptedException.class);
//
//
//					fluentWait1.until(new Function<WebDriver, WebElement>() {
//						public WebElement apply(WebDriver driver) {
//							return driver.findElement(By.xpath("//h4[normalize-space()='Responsible Person']"));
//						}
//					});
					Wait(7000);
				//	if(IsElementDisplayed("ViewDetails", CraneCalenderLocators)) {
						JsClick("Attachments", CraneCalenderLocators);
						ReportConfig.PassedLogInfo("User upload a invalid file in attachment in Crane Calendar","Attachments button is clicked");
						Print("Attachments button is clicked");

						String upload = ReadFrom.SampleAttachmentjpg;
						String filePath = System.getProperty("user.dir")+ upload;

						WebElement file = driver.findElement(By.xpath("//input[@type='file']"));
						Wait(3000);
						file.sendKeys(filePath);						

//						Wait<WebDriver> Uploaded = new FluentWait<WebDriver>(driver)
//								.withTimeout(Duration.ofSeconds(120))
//								.pollingEvery(Duration.ofSeconds(5))
//								.ignoring(ElementClickInterceptedException.class);
//
//
//						Uploaded.until(new Function<WebDriver, WebElement>() {
//							public WebElement apply(WebDriver driver) {
//								return driver.findElement(By.xpath("//div[@aria-label='Please select a valid file. Supported file format (.jpg,.jpeg,.png,.pdf,.doc)']"));
//							}
//						});
					//	String InvalidFile =	GetText("InvalidFile", CraneRequestLocators);

					//	if(IsElementDisplayed("InvalidFile", CraneRequestLocators)) {
							ReportConfig.Givenlogpass("User upload a invalid file in attachment in Crane Calendar", "Error " );

							JsClick("ClosePopup", CraneRequestLocators);
							ReportConfig.PassedLogInfo("User upload a invalid file in attachment in Crane Calendar","Close popup button is clicked");
							Print("Close popup button is clicked");

							Wait(2000);
							Clear("Search", CraneCalenderLocators);
							Wait(3000);
							JsClick("CloseSearch", CraneCalenderLocators);

					//	}

					//}
				}
			}
		}

	}
	public static void Search() throws Throwable {



		PrintError("Search crane calendar started");
		ReadFrom.DynamicExcel(ReadFrom.SearchCraneCalendar);


		Refresh();
		JsClick("SearchIcon", CraneCalenderLocators);
		for(int SearchCraneCalendar =1; SearchCraneCalendar<=ReadFrom.rowcount; SearchCraneCalendar++)	{

			SearchMonth(SearchCraneCalendar, ReadFrom.SearchCraneCalendar);
			SearchYear(SearchCraneCalendar, ReadFrom.SearchCraneCalendar);


			Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(ElementClickInterceptedException.class);


			fluentWait1.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//input[@placeholder='What you are looking for?']"));
				}
			});


			try {

				Wait(5000);


				TypeDataInTheField("Search", CraneCalenderLocators, ReadFrom.Excel(SearchCraneCalendar, 2, ReadFrom.SearchCraneCalendar));
				ReportConfig.PassedLogInfo("User search and view the crane request in calendar settings",ReadFrom.Excel(SearchCraneCalendar, 2, ReadFrom.SearchCraneCalendar) + " is entered in the search bar");
				Print(ReadFrom.Excel(SearchCraneCalendar, 2, ReadFrom.SearchCraneCalendar) + " is entered in the search bar");
				Wait(7000);

				Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(10))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait11.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
					}
				});


				String delivery = ReadFrom.Excel(SearchCraneCalendar, 2, ReadFrom.SearchCraneCalendar);
				FindElement(delivery);
				int rowcount = 	SizeOfTheList("CraneRequestLists", CraneCalenderLocators);
				Print("No of Delivery request displayed : " + rowcount);

				List<WebElement> c = 		getElements("CraneRequestLists", CraneCalenderLocators);
				for (WebElement webElement : c) {
					String DeliveryRequestName = 	GetTextFromTheElement(webElement);

					String Excelvalue = 	ReadFrom.Excel(SearchCraneCalendar, 2, ReadFrom.SearchCraneCalendar);
					if(IsEqual(Excelvalue, DeliveryRequestName)) {
						Print("Displayed value is : " + DeliveryRequestName);
						ReportConfig.PassedLogInfo("User search and view the crane request in calendar settings","Displayed value is : " + DeliveryRequestName);
					}
					else
					{
						PrintError("Displayed value is : " + DeliveryRequestName);
						ReportConfig.FailedLogInfo("User search and view the crane request in calendar settings","Displayed value is : " + DeliveryRequestName);
					}

				}

			}
			catch (Exception e) {
				Print(e.getMessage());
			}
			Wait(5000);
			Clear("Search", CraneCalenderLocators);
			Wait(3000);
			JsClick("CloseSearch", CraneCalenderLocators);
			ReportConfig.PassedLogInfo("User search and view the crane request in calendar settings","Clear search button is clicked");
			Print("Clear search button is clicked");


		}
	}

	public static void PushToVoid() throws Throwable {

		PrintError("Push to void crane Calender started");
		ReadFrom.DynamicExcel(ReadFrom.VoidCraneCalendar);

		for(int Void =1; Void<=ReadFrom.rowcount; Void++)	{
			SearchMonth(Void, ReadFrom.VoidCraneCalendar);
			SearchYear(Void, ReadFrom.VoidCraneCalendar);



			Wait(3000);
			Click("SearchIcon", CraneCalenderLocators);
			Wait(2000);
			TypeDataInTheField("Search", CraneCalenderLocators, ReadFrom.Excel(Void, 2, ReadFrom.VoidCraneCalendar));
			Wait(7000);

			Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(ElementClickInterceptedException.class);
			fluentWait11.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
				}
			});

			for(int DeliveryLists =1; DeliveryLists<=1; DeliveryLists++)		{

				Wait<WebDriver> fluentWait111 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(10))
						.ignoring(ElementClickInterceptedException.class);

				fluentWait111.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
					}
				});

				WebElement Delivery =	FindElement("CraneRequestList", CraneCalenderLocators, DeliveryLists);

				String DeliveryName = 	GetTextFromTheElement(Delivery);

				String EditIt =	ReadFrom.Excel(Void, 2, ReadFrom.VoidCraneCalendar);


				if(IsEqual(DeliveryName, EditIt)) {

					JsClick(Delivery);
					ReportConfig.PassedLogInfo("Push a crane request in calendar settings to void" ,DeliveryName + " : is clicked");
					Print(DeliveryName + " : is clicked");

//					Wait<WebDriver> CompanyInFilter = new FluentWait<WebDriver>(driver)
//							.withTimeout(Duration.ofSeconds(120))
//							.pollingEvery(Duration.ofSeconds(10))
//							.ignoring(ElementClickInterceptedException.class);
//
//
//					CompanyInFilter.until(new Function<WebDriver, WebElement>() {
//						public WebElement apply(WebDriver driver) {
//							return driver.findElement(By.xpath("//button[normalize-space()='Edit']"));
//						}
//					});
					Wait(7000);
					JsClick("VoidButton", CraneCalenderLocators);
					ReportConfig.PassedLogInfo("Push a crane request in calendar settings to void","Void button is clicked");
					Print("Void button is clicked");

					Wait(2000);
					Click("VoidYes", CraneCalenderLocators);
					ReportConfig.PassedLogInfo("Push a crane request in calendar settings to void", "Yes button is clicked");
					Print("Yes button is clicked");

//					Wait<WebDriver> fluentWait1111 = new FluentWait<WebDriver>(driver)
//							.withTimeout(Duration.ofSeconds(120))
//							.pollingEvery(Duration.ofSeconds(5))
//							.ignoring(ElementClickInterceptedException.class);
//
//
//					fluentWait1111.until(new Function<WebDriver, WebElement>() {
//						public WebElement apply(WebDriver driver) {
//							return driver.findElement(By.xpath("//div[@aria-label='Crane Request Marked as Void Successfully.']"));
//						}
//					});
					Wait(7000);
				//	if(IsElementDisplayed("VoidSuccessfull", CraneCalenderLocators)) {
						//Click("VoidSuccessfull", CraneCalenderLocators);
						Print(DeliveryName + " : is pushed to void");
						ReportConfig.PassedLogInfo("Push a crane request in calendar settings to void",DeliveryName + " : is pushed to void");

						Wait(3000);
						JsClick("CraneCalendar", CraneCalenderLocators);
						ReportConfig.PassedLogInfo("Push a crane request in calendar settings to void","Delivery calendar button is clicked");
						Print("Crane calendar button is clicked");

						break;

					//}
//					else {
//						PrintError("Void push is failed");
//						ReportConfig.FailedLogInfo("Push a crane request in calendar settings to void", "Void push is failed");
//					}	
				}
			}
		}
	}

	public static void ApproveOrRejectCraneCalendar() throws Throwable {


		PrintError("Approve Or Reject crane Calender started");
		ReadFrom.DynamicExcel(ReadFrom.ApproveOrRejectCraneCalendar);
		for(int ApproveOrRejectCraneCalendar =1; ApproveOrRejectCraneCalendar<=ReadFrom.rowcount; ApproveOrRejectCraneCalendar++)	{


			SearchMonth(ApproveOrRejectCraneCalendar, ReadFrom.ApproveOrRejectCraneCalendar);
			SearchYear(ApproveOrRejectCraneCalendar, ReadFrom.ApproveOrRejectCraneCalendar);


			Wait(2000);
			Click("SearchIcon", CraneCalenderLocators);
			Wait(2000);
			TypeDataInTheField("Search", CraneCalenderLocators, 	ReadFrom.Excel(ApproveOrRejectCraneCalendar, 2, ReadFrom.ApproveOrRejectCraneCalendar));
			Wait(7000);

			Wait<WebDriver> d2 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(ElementClickInterceptedException.class);


			d2.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
				}
			});

			List<WebElement> Texts =		GetTextFromElements("CraneRequestLists", CraneCalenderLocators);

			for (WebElement webElement : Texts) {

				String secName = GetTextFromTheElement(webElement);
				Print(secName);
				String EditIt =	ReadFrom.Excel(ApproveOrRejectCraneCalendar, 2, ReadFrom.ApproveOrRejectCraneCalendar);

				Wait(2000);

				if(IsEqual(secName, EditIt)) {

					JsClick(webElement);	
					ReportConfig.PassedLogInfo("User view and approve or reject the crane request",secName + " : is clicked");
					Print(secName + " : is clicked");
				}

			}

//			Wait<WebDriver> CompanyInFilter = new FluentWait<WebDriver>(driver)
//					.withTimeout(Duration.ofSeconds(120))
//					.pollingEvery(Duration.ofSeconds(10))
//					.ignoring(ElementClickInterceptedException.class);
//
//
//			CompanyInFilter.until(new Function<WebDriver, WebElement>() {
//				public WebElement apply(WebDriver driver) {
//					return driver.findElement(By.xpath("//button[normalize-space()='Edit']"));
//				}
//			});
			Wait(7000);
			JsClick("EditButton", CraneCalenderLocators);
			ReportConfig.PassedLogInfo("User view and approve or reject the crane request","Edit button is clicked");
			Print("Edit button is clicked");

//			Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
//					.withTimeout(Duration.ofSeconds(120))
//					.pollingEvery(Duration.ofSeconds(5))
//					.ignoring(ElementClickInterceptedException.class);
//
//
//			fluentWait1.until(new Function<WebDriver, WebElement>() {
//				public WebElement apply(WebDriver driver) {
//					return driver.findElement(By.xpath("//textarea[@placeholder='Enter Description']"));
//				}
//			});
			Wait(7000);
			if(IsElementDisplayed("Description", CraneCalenderLocators)) {
				Print("Delivery popup is opened");
				ReportConfig.PassedLogInfo("User view and approve or reject the crane request","Delivery popup is opened");
			}

			Clear("Description", CraneCalenderLocators);
			TypeDataInTheField("Description", CraneCalenderLocators, ReadFrom.Excel(ApproveOrRejectCraneCalendar, 2, ReadFrom.ApproveOrRejectCraneCalendar));
			Print("Description is entered as : " + ReadFrom.Excel(ApproveOrRejectCraneCalendar, 2, ReadFrom.ApproveOrRejectCraneCalendar));
			ReportConfig.PassedLogInfo("User view and approve or reject the crane request","Description is entered as : " + ReadFrom.Excel(ApproveOrRejectCraneCalendar, 2, ReadFrom.ApproveOrRejectCraneCalendar));


			MoveToElement("SubmitButton", CraneCalenderLocators);

			Click("SubmitButton", CraneCalenderLocators);
			ReportConfig.PassedLogInfo("User view and approve or reject the crane request","Submit button is clicked");
			Print("Submit button is clicked");

//			Wait<WebDriver> fluentWait1111 = new FluentWait<WebDriver>(driver)
//					.withTimeout(Duration.ofSeconds(120))
//					.pollingEvery(Duration.ofSeconds(5))
//					.ignoring(ElementClickInterceptedException.class);
//
//
//			fluentWait1111.until(new Function<WebDriver, WebElement>() {
//				public WebElement apply(WebDriver driver) {
//					return driver.findElement(By.xpath("//div[@aria-label='Crane Request Updated Successfully.']"));
//				}
//			});
			Wait(7000);

			Refresh();
			Wait<WebDriver> Calendar = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(ElementClickInterceptedException.class);


			Calendar.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//*[@id=\"calendar\"]/div[1]/div[2]/div/h2"));
				}
			});

			Wait(2000);

			SearchMonth(ApproveOrRejectCraneCalendar, ReadFrom.ApproveOrRejectCraneCalendar);
			SearchYear(ApproveOrRejectCraneCalendar, ReadFrom.ApproveOrRejectCraneCalendar);

			Wait(3000);
			Click("SearchIcon", CraneCalenderLocators);
			Wait(2000);
			TypeDataInTheField("Search", CraneCalenderLocators, 	ReadFrom.Excel(ApproveOrRejectCraneCalendar, 2, ReadFrom.ApproveOrRejectCraneCalendar));
			Wait(7000);

//			Wait<WebDriver> Req = new FluentWait<WebDriver>(driver)
//					.withTimeout(Duration.ofSeconds(120))
//					.pollingEvery(Duration.ofSeconds(10))
//					.ignoring(ElementClickInterceptedException.class);
//
//
//			Req.until(new Function<WebDriver, WebElement>() {
//				public WebElement apply(WebDriver driver) {
//					return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
//				}
//			});
			Wait(7000);

			List<WebElement> Text =		GetTextFromElements("CraneRequestLists", CraneCalenderLocators);
			for (WebElement webElement : Text) {
				String Name = GetTextFromTheElement(webElement);
				String EditName =	ReadFrom.Excel(ApproveOrRejectCraneCalendar, 2, ReadFrom.ApproveOrRejectCraneCalendar);

				Wait(2000);

				if(IsEqual(Name, EditName)) {		
					JsClick(webElement);
					ReportConfig.PassedLogInfo("User view and approve or reject the crane request",Name + " : is clicked");
					Print(Name + " : is clicked");
				}

			}

//			new FluentWait<WebDriver>(driver)
//			.withTimeout(Duration.ofSeconds(120))
//			.pollingEvery(Duration.ofSeconds(10))
//			.ignoring(ElementClickInterceptedException.class);
//
//
//			CompanyInFilter.until(new Function<WebDriver, WebElement>() {
//				public WebElement apply(WebDriver driver) {
//					return driver.findElement(By.xpath("//em[@class='fas fa-expand-alt c-pointer color-grey8']"));
//				}
//			});
			Wait(7000);
			JsClick("ExpandRequest", CraneCalenderLocators);
			ReportConfig.PassedLogInfo("User view and approve or reject the crane request","Expand button is clicked");
			Print("Expand button is clicked");


//			new FluentWait<WebDriver>(driver)
//			.withTimeout(Duration.ofSeconds(120))
//			.pollingEvery(Duration.ofSeconds(5))
//			.ignoring(ElementClickInterceptedException.class);
//
//
//			fluentWait1.until(new Function<WebDriver, WebElement>() {
//				public WebElement apply(WebDriver driver) {
//					return driver.findElement(By.xpath("//h4[normalize-space()='Responsible Person']"));
//				}
//			});
			Wait(7000);
		//	if(IsElementDisplayed("ViewDetails", CraneCalenderLocators)) {
//				Wait(2000);	new FluentWait<WebDriver>(driver)
//				.withTimeout(Duration.ofSeconds(120))
//				.pollingEvery(Duration.ofSeconds(5))
//				.ignoring(ElementClickInterceptedException.class);
//
//
//				fluentWait1.until(new Function<WebDriver, WebElement>() {
//					public WebElement apply(WebDriver driver) {
//						return driver.findElement(By.xpath("//div[@class='form-group mb-0']//select[@class='form-control fs12 material-input pr-5']"));
//					}
//				});

				SelectFromVisibleText("SelectStatus", CraneCalenderLocators, ReadFrom.Excel(ApproveOrRejectCraneCalendar, 3, ReadFrom.ApproveOrRejectCraneCalendar));
				Print("Status is selected as : " + ReadFrom.Excel(ApproveOrRejectCraneCalendar, 3, ReadFrom.ApproveOrRejectCraneCalendar));
				ReportConfig.PassedLogInfo("User view and approve or reject the crane request","Status is selected as : " + ReadFrom.Excel(ApproveOrRejectCraneCalendar, 3, ReadFrom.ApproveOrRejectCraneCalendar));

				Wait(2000);
				JsClick("Save", CraneCalenderLocators);
				ReportConfig.PassedLogInfo("User view and approve or reject the crane request","Save button is clicked");
				Print("Save button is clicked");


				String Status = ReadFrom.Excel(ApproveOrRejectCraneCalendar, 3, ReadFrom.ApproveOrRejectCraneCalendar);

				if (IsEqual(Status, "Approved")) {
//					Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
//							.withTimeout(Duration.ofSeconds(120))
//							.pollingEvery(Duration.ofSeconds(5))
//							.ignoring(ElementClickInterceptedException.class);
//
//
//					fluentWait.until(new Function<WebDriver, WebElement>() {
//						public WebElement apply(WebDriver driver) {
//							return driver.findElement(By.xpath("//div[@aria-label='Approved Successfully.']"));
//						}
//					});
//
//					JsClick("Approved", CraneCalenderLocators);
					ReportConfig.PassedLogInfo("User view and approve or reject the crane request","Delivery request is approved");
					Print("Delivery request is approved");
					Wait(3000);
					JsClick("ClosePopup", CraneCalenderLocators);
					ReportConfig.PassedLogInfo("User view and approve or reject the crane request","Close popup button is clicked");
					Print("Close popup button is clicked");

					Wait(2000);
					Clear("Search", CraneCalenderLocators);
					Wait(3000);
					JsClick("CloseSearch", CraneCalenderLocators);

				}
				else if(IsEqual(Status, "Declined")) {
//					Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
//							.withTimeout(Duration.ofSeconds(120))
//							.pollingEvery(Duration.ofSeconds(5))
//							.ignoring(ElementClickInterceptedException.class);
//
//
//					fluentWait.until(new Function<WebDriver, WebElement>() {
//						public WebElement apply(WebDriver driver) {
//							return driver.findElement(By.xpath("//div[@aria-label='Declined Successfully.']"));
//						}
//					});
//					JsClick("Declined", CraneCalenderLocators);
					ReportConfig.PassedLogInfo("User view and approve or reject the crane request","Delivery request is declined");
					Print("Delivery request is declined");
					Wait(3000);
					JsClick("ClosePopup", CraneCalenderLocators);
					ReportConfig.PassedLogInfo("User view and approve or reject the crane request","Close popup button is clicked");
					Print("Close popup button is clicked");

					Wait(2000);
					Clear("Search", CraneCalenderLocators);
					Wait(3000);
					JsClick("CloseSearch", CraneCalenderLocators);
				}
		//	}

		}
	}

	public static void Complete() throws Throwable {


		PrintError("Complete crane Calender started");
		ReadFrom.DynamicExcel(ReadFrom.CompleteCraneCalendar);
		for(int CompleteCraneCalendar =1; CompleteCraneCalendar<=ReadFrom.rowcount; CompleteCraneCalendar++)	{


			SearchMonth(CompleteCraneCalendar, ReadFrom.CompleteCraneCalendar);
			SearchYear(CompleteCraneCalendar, ReadFrom.CompleteCraneCalendar);



			Wait(2000);
			Click("SearchIcon", CraneCalenderLocators);
			Wait(2000);
			TypeDataInTheField("Search", CraneCalenderLocators, ReadFrom.Excel(CompleteCraneCalendar, 2, ReadFrom.CompleteCraneCalendar));
			Wait(7000);

			Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(ElementClickInterceptedException.class);


			fluentWait11.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
				}
			});


			for(int Deliver =1; Deliver<=1; Deliver++)		{

				Wait<WebDriver> fluentWait111 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(10))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait111.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
					}
				});

				WebElement Delivery =	FindElement("CraneRequestList", CraneCalenderLocators, Deliver);

				String DeliveryName = 	GetTextFromTheElement(Delivery);

				String ViewInfo =	ReadFrom.Excel(CompleteCraneCalendar, 2, ReadFrom.CompleteCraneCalendar);


				if(IsEqual(DeliveryName, ViewInfo)) {

					JsClick(Delivery);
					ReportConfig.PassedLogInfo("User complete the crane request",DeliveryName + " : is clicked");
					Print(DeliveryName + " : is clicked");

//					Wait<WebDriver> CompanyInFilter = new FluentWait<WebDriver>(driver)
//							.withTimeout(Duration.ofSeconds(120))
//							.pollingEvery(Duration.ofSeconds(10))
//							.ignoring(ElementClickInterceptedException.class);
//
//
//					CompanyInFilter.until(new Function<WebDriver, WebElement>() {
//						public WebElement apply(WebDriver driver) {
//							return driver.findElement(By.xpath("//em[@class='fas fa-expand-alt c-pointer color-grey8']"));
//						}
//					});
					Wait(7000);
					JsClick("ExpandRequest", CraneCalenderLocators);
					ReportConfig.PassedLogInfo("User complete the crane request","Expand button is clicked");
					Print("Expand button is clicked");

//					Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
//							.withTimeout(Duration.ofSeconds(120))
//							.pollingEvery(Duration.ofSeconds(5))
//							.ignoring(ElementClickInterceptedException.class);
//
//
//					fluentWait1.until(new Function<WebDriver, WebElement>() {
//						public WebElement apply(WebDriver driver) {
//							return driver.findElement(By.xpath("//h4[normalize-space()='Responsible Person']"));
//						}
//					});
					Wait(7000);
				//	if(IsElementDisplayed("ViewDetails", CraneCalenderLocators)) {

						JsClick("CompletedButton", CraneCalenderLocators);
						ReportConfig.PassedLogInfo("User complete the crane request","Deliver button is clicked");
						Print("Deliver button is clicked");
						Wait(2000);
						JsClick("Save", CraneCalenderLocators);
						ReportConfig.PassedLogInfo("User complete the crane request","Save button is clicked");
						Print("Save button is clicked");
						Wait(2000);
						JsClick("YesButton", CraneCalenderLocators);
						ReportConfig.PassedLogInfo("User complete the crane request","Yes button is clicked");
						Print("Yes button is clicked");

//						Wait<WebDriver> s = new FluentWait<WebDriver>(driver)
//								.withTimeout(Duration.ofSeconds(120))
//								.pollingEvery(Duration.ofSeconds(5))
//								.ignoring(ElementClickInterceptedException.class);
//
//
//						s.until(new Function<WebDriver, WebElement>() {
//							public WebElement apply(WebDriver driver) {
//								return driver.findElement(By.xpath("//div[@aria-label='Completed Successfully.']"));
//							}
//						});
					//}
						Wait(7000);
				//	if(IsElementDisplayed("CompletedSuccessfully", CraneCalenderLocators)) {
					//	Click("CompletedSuccessfully", CraneCalenderLocators);
						Print(DeliveryName + " : is completed successfully");
						ReportConfig.PassedLogInfo("User complete the crane request",DeliveryName + " : is delivered successfully");

						JsClick("ClosePopup", CraneCalenderLocators);
						ReportConfig.PassedLogInfo("User complete the crane request","Close popup button is clicked");
						Print("Close popup button is clicked");

						Wait(2000);
						Clear("Search", CraneCalenderLocators);
						Wait(3000);
						JsClick("CloseSearch", CraneCalenderLocators);
				//	}


				}
			}
		}

	}

}
